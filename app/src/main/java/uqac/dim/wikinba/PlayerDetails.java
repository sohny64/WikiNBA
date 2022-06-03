package uqac.dim.wikinba;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlayerDetails extends AppCompatActivity {

    private RecyclerView PlayerRV;
    public static ArrayList<Players> PlayersArrayList;
    private PlayerRVAdapter PlayerRVAdapter;
    private FirebaseFirestore db;
    ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);


        // initializing our variables.
        PlayerRV = findViewById(R.id.idRVPlayers);
        loadingPB = findViewById(R.id.idProgressBar);

        // initializing our variable for firebase
        // firestore and getting its instance.
        db = FirebaseFirestore.getInstance();

        // creating our new array list
        PlayersArrayList =new ArrayList<>();
            PlayerRV.setHasFixedSize(true);
            PlayerRV.setLayoutManager(new

                    LinearLayoutManager(this));

        // adding our array list to our recycler view adapter class.
        PlayerRVAdapter = new PlayerRVAdapter(PlayersArrayList, this);

        // setting adapter to our recycler view.
            PlayerRV.setAdapter(PlayerRVAdapter);

        // below line is use to get the data from Firebase Firestore.
        // previously we were saving data on a reference of Teams
        // now we will be getting the data from the same reference.
            db.collection("Players").

        get()


        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess (QuerySnapshot queryDocumentSnapshots){
                // after getting the data we are calling on success method
                // and inside this method we are checking if the received
                // query snapshot is empty or not.
                if (!queryDocumentSnapshots.isEmpty()) {
                    // if the snapshot is not empty we are
                    // hiding our progress bar and adding
                    // our data in a list.
                    loadingPB.setVisibility(View.GONE);
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        // after getting this list we are passing
                        // that list to our object class.
                        Players c = d.toObject(Players.class);

                        // and we will pass this object class
                        // inside our arraylist which we have
                        // created for recycler view.
                        PlayersArrayList.add(c);
                    }
                    // after adding the data to recycler view.
                    // we are calling recycler view notifyDataSetChanged
                    // method to notify that data has been changed in recycler view.
                    PlayerRVAdapter.notifyDataSetChanged();
                } else {
                    // if the snapshot is empty we are displaying a toast message.
                    Toast.makeText(PlayerDetails.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                }
            }
        }).

        addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure (@NonNull Exception e){
                // if we do not get any data or any error we are displaying
                // a toast message that we do not get any data
                Toast.makeText(PlayerDetails.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });
        return true;
    }

    private void filter(String text){
        // creation d'une nouvelle liste pour filtrer les données
        ArrayList<Players> filteredList = new ArrayList<>();

        // boucle for pour comparer les éléments
        for (Players player : PlayersArrayList) {
            // vérifie si il ya un match
            if (player.getName().toLowerCase().contains(text.toLowerCase())){
                //si on a un match entre la recherche et les éléments
                //l'élément est rajouté à la liste
                filteredList.add(player);
            }
        }
        if(filteredList.isEmpty()){
            // On avise grâce à un toast si il n'ya pas de correspondance
            Toast.makeText(this, "No Player Found..", Toast.LENGTH_SHORT).show();
        } else {
            // on envoie la liste filtrée à l'adaptateur
            PlayerRVAdapter.filterList(filteredList);
        }
    }
}