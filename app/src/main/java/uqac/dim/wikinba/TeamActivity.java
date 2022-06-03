package uqac.dim.wikinba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import uqac.dim.wikinba.ui.AboutTeamFragment;
import uqac.dim.wikinba.ui.AllTimeLeadersFragment;
import uqac.dim.wikinba.ui.RosterTeamFragment;

public class TeamActivity extends AppCompatActivity {

    private String[] data = {"About", "Roster", "Player Highs"};
    ViewPager2 teamViewPager;
    TeamAdapter teamAdapter;
    public int index = TeamRVAdapter.index;
    ImageView teamLogo;
    TextView teamName;
    private ArrayList<Teams> TeamsArrayList = TeamDetails.TeamsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        teamLogo = findViewById(R.id.teamLogo);
        teamName = findViewById(R.id.teamName);

        teamViewPager = findViewById(R.id.teamViewPager);
        teamAdapter = new TeamAdapter(getSupportFragmentManager(), getLifecycle());

        teamAdapter.addFragment(new AboutTeamFragment());
        teamAdapter.addFragment(new RosterTeamFragment());
        teamAdapter.addFragment(new AllTimeLeadersFragment());


        teamViewPager.setAdapter(teamAdapter);

        Teams teams = TeamsArrayList.get(index);
        teamName.setText(teams.getName());

        switch (index){
            case 0:
                teamLogo.setImageResource(R.drawable.boston_celtics);
                break;
            case 1:
                teamLogo.setImageResource(R.drawable.brooklyn_nets);
                break;
        }

        TabLayout teamTab = findViewById(R.id.teamTabLayout);
        new TabLayoutMediator(teamTab, teamViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(data[position]);
            }
        }).attach();
    }

    class TeamAdapter extends FragmentStateAdapter{

        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public TeamAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        public void addFragment(Fragment fragment){
            fragmentList.add(fragment);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }
}