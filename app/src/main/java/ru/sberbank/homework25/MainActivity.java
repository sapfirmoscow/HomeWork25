package ru.sberbank.homework25;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initNavigation();
        initDrawer();
    }

    private void initDrawer() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.drawerActivity);
            return true;
        });
    }

    private void initViews() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    private void initNavigation() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.action_navigation1:
                    mNavController.navigate(R.id.action_global_firstBottomNavFragment);
                    return true;
                case R.id.action_navigation2:
                    mNavController.navigate(R.id.action_global_secondBottomNavFragment);
                    return true;
                case R.id.action_navigation3:
                    mNavController.navigate(R.id.action_global_thirdBottomNavFragment);
                    return true;
            }
            return false;
        });
    }
}
