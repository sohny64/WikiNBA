package uqac.dim.wikinba.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import uqac.dim.wikinba.R;
import uqac.dim.wikinba.TeamDetails;
import uqac.dim.wikinba.TeamRVAdapter;
import uqac.dim.wikinba.Teams;

public class AllTimeLeadersFragment extends Fragment {

    public int index = TeamRVAdapter.index;
    TextView allTimePoints, allTimeAssists, allTimeRebounds, allTimeBlocks, allTimeSteals;
    private ArrayList<Teams> TeamsArrayList = TeamDetails.TeamsArrayList;

    public AllTimeLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_time_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        allTimePoints = view.findViewById(R.id.allTimePoints);
        allTimeAssists = view.findViewById(R.id.allTimeAssists);
        allTimeRebounds = view.findViewById(R.id.allTimeRebounds);
        allTimeBlocks = view.findViewById(R.id.allTimeBlocks);
        allTimeSteals = view.findViewById(R.id.allTimeSteals);

        Teams teams = TeamsArrayList.get(index);
        allTimePoints.setText(teams.getAllTimePoints());
        allTimeAssists.setText(teams.getAllTimeAssists());
        allTimeRebounds.setText(teams.getAllTimeRebounds());
        allTimeBlocks.setText(teams.getAllTimeBlocks());
        allTimeSteals.setText(teams.getAllTimeSteals());
    }
}