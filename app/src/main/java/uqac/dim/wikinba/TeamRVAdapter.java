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

public class TeamRVAdapter extends RecyclerView.Adapter<TeamRVAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<Teams> TeamsArrayList;
    private Context context;

    public static int index;

    // creating constructor for our adapter class
    public TeamRVAdapter(ArrayList<Teams> TeamsArrayList, Context context) {
        this.TeamsArrayList = TeamsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // setting data to our text views from our modal class.
        Teams Teams = TeamsArrayList.get(position);
        holder.nameTV.setText(Teams.getName());
        switch (Teams.getName()){
            case "Boston Celtics":
                holder.logoIV.setImageResource(R.drawable.boston_celtics);
                break;
            case "Brooklyn Nets":
                holder.logoIV.setImageResource(R.drawable.brooklyn_nets);
                break;
            case "Atlanta Hawks":
                holder.logoIV.setImageResource(R.drawable.atlanta_hawks);
                break;
            case "Charlotte Hornets":
                holder.logoIV.setImageResource(R.drawable.charlotte_hornets);
                break;
            case "Miami Heat":
                holder.logoIV.setImageResource(R.drawable.miami_heat);
                break;
            case "Orlando Magic":
                holder.logoIV.setImageResource(R.drawable.orlando_magic);
                break;
            case "Washington Wizards":
                holder.logoIV.setImageResource(R.drawable.washington_wizards);
                break;
            case "Denver Nuggets":
                holder.logoIV.setImageResource(R.drawable.nuggets);
                break;
            case "Minnesota Timberwolves":
                holder.logoIV.setImageResource(R.drawable.twolves);
                break;
            case "Oklahoma City Thunder":
                holder.logoIV.setImageResource(R.drawable.thunder);
                break;
            case "Portland Trail Blazers":
                holder.logoIV.setImageResource(R.drawable.blazers);
                break;
            case "Utah Jazz":
                holder.logoIV.setImageResource(R.drawable.jazz);
                break;
            case "New York Knicks":
                holder.logoIV.setImageResource(R.drawable.knicks);
                break;
            case "Golden State Warriors":
                holder.logoIV.setImageResource(R.drawable.warriors);
                break;
            case "Los Angeles Clippers":
                holder.logoIV.setImageResource(R.drawable.clippers);
                break;
            case "Los Angeles Lakers":
                holder.logoIV.setImageResource(R.drawable.lakers);
                break;
            case "Phoenix Suns":
                holder.logoIV.setImageResource(R.drawable.suns);
                break;
            case "Sacramento Kings":
                holder.logoIV.setImageResource(R.drawable.kings);
                break;
            case "Dallas Mavericks":
                holder.logoIV.setImageResource(R.drawable.mavs);
                break;
            case "Houston Rockets":
                holder.logoIV.setImageResource(R.drawable.rockets);
                break;
            case "Memphis Grizzlies":
                holder.logoIV.setImageResource(R.drawable.grizzlies);
                break;
            case "New Orleans Pelicans":
                holder.logoIV.setImageResource(R.drawable.pelicans);
                break;
            case "San Antonio Spurs":
                holder.logoIV.setImageResource(R.drawable.spurs);
                break;
            case "Philadelphia 76ers":
                holder.logoIV.setImageResource(R.drawable.sixers);
                break;
            case "Toronto Raptors":
                holder.logoIV.setImageResource(R.drawable.raptors);
                break;
            case "Chicago Bulls":
                holder.logoIV.setImageResource(R.drawable.bulls);
                break;
            case "Cleveland Cavaliers":
                holder.logoIV.setImageResource(R.drawable.cavs);
                break;
            case "Detroit Pistons":
                holder.logoIV.setImageResource(R.drawable.pistons);
                break;
            case "Indiana Pacers":
                holder.logoIV.setImageResource(R.drawable.pacers);
                break;
            case "Milwaukee Bucks":
                holder.logoIV.setImageResource(R.drawable.bucks);
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), TeamActivity.class);
                holder.itemView.getContext().startActivity(intent);
                index = holder.getAdapterPosition();
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return TeamsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView nameTV;
        private final ImageView logoIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            nameTV = itemView.findViewById(R.id.idTVTeamName);
            logoIV = itemView.findViewById(R.id.idIVTeamLogo);
        }
    }
}
