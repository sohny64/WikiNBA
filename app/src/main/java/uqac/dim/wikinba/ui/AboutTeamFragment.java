package uqac.dim.wikinba.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import uqac.dim.wikinba.R;
import uqac.dim.wikinba.TeamDetails;
import uqac.dim.wikinba.TeamRVAdapter;
import uqac.dim.wikinba.Teams;

public class AboutTeamFragment extends Fragment {

    public int index = TeamRVAdapter.index;
    private ArrayList<Teams> TeamsArrayList = TeamDetails.TeamsArrayList;
    TextView foundation, city, arena, coach, titles, gLeague, jerseys, notables;


    public AboutTeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foundation = view.findViewById(R.id.foundation);
        city = view.findViewById(R.id.city);
        arena = view.findViewById(R.id.arena);
        coach = view.findViewById(R.id.coach);
        titles = view.findViewById(R.id.titles);
        gLeague = view.findViewById(R.id.gLeague);
        jerseys = view.findViewById(R.id.jerseys);
        notables = view.findViewById(R.id.notables);

        Teams teams = TeamsArrayList.get(index);

        foundation.setText(teams.getFoundation() + "");
        city.setText(teams.getCity());
        arena.setText(teams.getArena());
        coach.setText(teams.getHeadCoach());
        titles.setText(teams.getChampionships() + "");
        gLeague.setText(teams.getgLeague());
        jerseys.setText(teams.getNbRetiredJerseys() + "");
        notables.setText(teams.getNotablePlayers().toString()
                .replace("[", "")
                .replace("]","")
                .replace(",","\n"));
    }
}