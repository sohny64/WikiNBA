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

import uqac.dim.wikinba.PlayerDetails;
import uqac.dim.wikinba.Players;
import uqac.dim.wikinba.R;
import uqac.dim.wikinba.TeamDetails;
import uqac.dim.wikinba.TeamRVAdapter;
import uqac.dim.wikinba.Teams;

public class RosterTeamFragment extends Fragment {

    public int index = TeamRVAdapter.index;
    private ArrayList<Teams> TeamsArrayList = TeamDetails.TeamsArrayList;
    private TextView name1, age1, number1, position1;
    private TextView name2, age2, number2, position2;
    private TextView name3, age3, number3, position3;


    public RosterTeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_roster_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name1 = view.findViewById(R.id.name1);
        age1 = view.findViewById(R.id.age1);
        number1 = view.findViewById(R.id.number1);
        position1 = view.findViewById(R.id.position1);
        name2 = view.findViewById(R.id.name2);
        age2 = view.findViewById(R.id.age2);
        number2 = view.findViewById(R.id.number2);
        position2 = view.findViewById(R.id.position2);
        name3 = view.findViewById(R.id.name3);
        age3 = view.findViewById(R.id.age3);
        number3 = view.findViewById(R.id.number3);
        position3 = view.findViewById(R.id.position3);

        Teams teams = TeamsArrayList.get(index);

        name1.setText(teams.getPlayers().get(0));
        age1.setText(teams.getAges().get(0));
        number1.setText(teams.getNumbers().get(0));
        position1.setText(teams.getPositions().get(0));
        name2.setText(teams.getPlayers().get(1));
        age2.setText(teams.getAges().get(1));
        number2.setText(teams.getNumbers().get(1));
        position2.setText(teams.getPositions().get(1));
        name3.setText(teams.getPlayers().get(2));
        age3.setText(teams.getAges().get(2));
        number3.setText(teams.getNumbers().get(2));
        position3.setText(teams.getPositions().get(2));

    }
}