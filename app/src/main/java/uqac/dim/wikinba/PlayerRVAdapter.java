package uqac.dim.wikinba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlayerRVAdapter extends RecyclerView.Adapter<PlayerRVAdapter.ViewHolder> {

    private ArrayList<Players> PlayersArrayList;
    private Context context;

    public static int index;

    public PlayerRVAdapter(ArrayList<Players> PlayersArrayList, Context context) {
        this.PlayersArrayList = PlayersArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<Players> filterList){
        PlayersArrayList = filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new PlayerRVAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.player_item, parent, false));
    }

    public void onBindViewHolder(@NonNull PlayerRVAdapter.ViewHolder holder, int position) {

        // setting data to our text views from our modal class.
        Players Players = PlayersArrayList.get(position);
        holder.nameTV.setText(Players.getName());
        switch(Players.getName()){
            case "Jaylen Brown":
                holder.photoIV.setImageResource(R.drawable.jaylen);
                break;
            case "Jayson Tatum":
                holder.photoIV.setImageResource(R.drawable.jayson);
                break;
            case "Al Horford":
                holder.photoIV.setImageResource(R.drawable.al);
                break;
            case "Kevin Durant":
                holder.photoIV.setImageResource(R.drawable.kevin);
                break;
            case "Kyrie Irving":
                holder.photoIV.setImageResource(R.drawable.kyrie);
                break;
            case "Ben Simmons":
                holder.photoIV.setImageResource(R.drawable.ben);
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), PlayerActivity.class);
                holder.itemView.getContext().startActivity(intent);
                index = holder.getAdapterPosition();
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return PlayersArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView nameTV;
        private final ImageView photoIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            nameTV = itemView.findViewById(R.id.idTVPlayerName);
            photoIV = itemView.findViewById(R.id.idIVPlayerPhoto);
        }
    }
}
