package uqac.dim.wikinba.ui;

import android.annotation.SuppressLint;
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

public class AboutPlayerFragment extends Fragment {

    public int index = PlayerRVAdapter.index;
    private ArrayList<Players> PlayersArrayList = PlayerDetails.PlayersArrayList;
    TextView birth, nationality, height, weight, mvp, championships, position, draft, experience;

    public AboutPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        birth = view.findViewById(R.id.birth);
        nationality = view.findViewById(R.id.nationality);
        height = view.findViewById(R.id.height);
        weight = view.findViewById(R.id.weight);
        mvp = view.findViewById(R.id.mvp);
        championships = view.findViewById(R.id.championships);
        position = view.findViewById(R.id.position);
        draft = view.findViewById(R.id.draft);
        experience = view.findViewById(R.id.experience);

        Players players = PlayersArrayList.get(index);

        birth.setText(players.getBirth());
        nationality.setText(players.getNationality());
        height.setText(players.getHeight());
        weight.setText(players.getWeight());
        mvp.setText(players.getMvp() + "");
        championships.setText(players.getRings() + "");
        position.setText(players.getPosition());
        draft.setText(players.getDraft());
        experience.setText(players.getExperience() + " years");
    }
}