package uqac.dim.wikinba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import uqac.dim.wikinba.ui.AboutPlayerFragment;
import uqac.dim.wikinba.ui.CareerHighFragment;
import uqac.dim.wikinba.ui.PlayerTeamsFragment;


public class PlayerActivity extends AppCompatActivity {

    private String[] data = {"About", "Career Highs", "Teams"};
    ViewPager2 playerViewPager;
    PlayerAdapter playerAdapter;
    public int index = PlayerRVAdapter.index;
    ImageView playerLogo;
    TextView playerName;
    private ArrayList<Players> PlayerArrayList = PlayerDetails.PlayersArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        playerLogo = findViewById(R.id.playerLogo);
        playerName = findViewById(R.id.playerName);

        playerViewPager = findViewById(R.id.playerViewPager);
        playerAdapter = new PlayerActivity.PlayerAdapter(getSupportFragmentManager(), getLifecycle());

        playerAdapter.addFragment(new AboutPlayerFragment());
        playerAdapter.addFragment(new CareerHighFragment());
        playerAdapter.addFragment(new PlayerTeamsFragment());


        playerViewPager.setAdapter(playerAdapter);

        Players players = PlayerArrayList.get(index);
        playerName.setText(players.getName());

        switch (index){
            case 0:
                playerLogo.setImageResource(R.drawable.jaylen);
                break;
            case 1:
                playerLogo.setImageResource(R.drawable.jayson);
                break;
            case 2:
                playerLogo.setImageResource(R.drawable.al);
                break;
            case 3:
                playerLogo.setImageResource(R.drawable.kevin);
                break;
            case 4:
                playerLogo.setImageResource(R.drawable.kyrie);
                break;
            case 5:
                playerLogo.setImageResource(R.drawable.ben);
                break;
        }

        TabLayout playerTab = findViewById(R.id.playerTabLayout);
        new TabLayoutMediator(playerTab, playerViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(data[position]);
            }
        }).attach();
    }

    class PlayerAdapter extends FragmentStateAdapter {

        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public PlayerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
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