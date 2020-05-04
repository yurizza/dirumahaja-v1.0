package projek.dirumahaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class AdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;

    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    Fragment fragment;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            navigationView = findViewById(R.id.nav_view);
            drawer = findViewById(R.id.drawer_layout);

            toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);

            navigationView.getMenu().getItem(0).setChecked(true);
            firstFragmentDisplay(R.id.nav_home_admin);
        }

        private void firstFragmentDisplay(int itemId) {
            fragment = null;

            switch (itemId) {
                case R.id.nav_home_admin:
                    fragment = new AdminHomeFragment();
                    break;
                case R.id.nav_profil:
                    fragment = new ProfilFragment();
                    break;
                case R.id.nav_buat_tugas:
                    fragment = new AdminBuatTugasFragment();
                    break;
                case R.id.nav_cek_tugas:
                    fragment = new AdminTugasFragment();
                    break;
            }

            if (fragment != null) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fLayout, fragment);
                transaction.commit();
            }

            drawer.closeDrawers();

        }
        

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
