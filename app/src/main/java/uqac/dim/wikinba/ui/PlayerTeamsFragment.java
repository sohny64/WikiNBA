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
import uqac.dim.wikinba.PlayerRVAdapter;
import uqac.dim.wikinba.Players;
import uqac.dim.wikinba.R;

public class PlayerTeamsFragment extends Fragment {

    public int index = PlayerRVAdapter.index;
    private ArrayList<Players> PlayersArrayList = PlayerDetails.PlayersArrayList;
    private TextView teams;

    public PlayerTeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teams = view.findViewById(R.id.teamsPlayer);

        Players players = PlayersArrayList.get(index);

        teams.setText(players.getTeamsPlayer().toString()
                .replace("[", "")
                .replace("]","")
                .replace(",","\n"));
    }
}