package uqac.dim.wikinba;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edit text

    // creating variable for button
    private Button viewTeamsBtn, viewPlayersBtn;
    private ImageView logo;

    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons
        viewTeamsBtn = findViewById(R.id.idBtnViewTeams);
        viewPlayersBtn = findViewById(R.id.idBtnViewPlayers);
        logo = findViewById(R.id.nbaLogo);

        logo.setImageResource(R.drawable.nba);

        // adding onclick listener to view data in new activity
        viewTeamsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity on button click
                Intent i = new Intent(MainActivity.this, TeamDetails.class);
                startActivity(i);
            }
        });

        viewPlayersBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, PlayerDetails.class);
                startActivity(i);
            }
        });

    }
}