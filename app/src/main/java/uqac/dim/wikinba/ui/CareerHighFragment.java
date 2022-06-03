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

public class CareerHighFragment extends Fragment {

    public int index = PlayerRVAdapter.index;
    private ArrayList<Players> PlayersArrayList = PlayerDetails.PlayersArrayList;
    private TextView points, assists, rebounds, blocks, steals;

    public CareerHighFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_career_high, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        points = view.findViewById(R.id.points);
        assists = view.findViewById(R.id.assists);
        rebounds = view.findViewById(R.id.rebounds);
        blocks = view.findViewById(R.id.blocks);
        steals = view.findViewById(R.id.steals);

        Players players = PlayersArrayList.get(index);

        points.setText(players.getPtsHigh());
        assists.setText(players.getAstHigh());
        rebounds.setText(players.getRebHigh());
        blocks.setText(players.getBlkHigh());
        steals.setText(players.getStlHigh());
    }
}