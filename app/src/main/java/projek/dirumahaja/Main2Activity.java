package projek.dirumahaja;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import projek.dirumahaja.util.PrefUtil;

public class Main2Activity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;

    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    Fragment fragment;
    FragmentTransaction transaction;
    public static void start(Context context) {
        Intent intent = new Intent(context, Main2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        int idKelas = getIntent().getIntExtra("idKelas",0);
        if(idKelas != 0){
            fragment = null;
            fragment = new KelasDetailFragment();
        }
        navigationView.getMenu().getItem(0).setChecked(true);
        firstFragmentDisplay(R.id.nav_home);
}

    private void firstFragmentDisplay(int itemId) {
        fragment = null;

        switch (itemId) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_profil:
                fragment = new ProfilFragment();
                break;
            case R.id.nav_berita:
                fragment = new BeritaFragment();
                break;
            case R.id.nav_obrolan:
                fragment = new ObrolanFragment();
                break;
            case R.id.nav_pr:
                fragment = new PekeraanFragment();
                break;
            case R.id.nav_kelas:
                fragment = new KelasFragment();
                break;
            case R.id.signout:
                logoutAct();
                //back to login
                LoginActivity.start(Main2Activity.this);
                Main2Activity.this.finish();
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
        firstFragmentDisplay(menuItem.getItemId());
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
    void logoutAct() {
        PrefUtil.clear(Main2Activity.this);
    }
}