package com.example.winzip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.winzip.fragmen.My_files;
import com.example.winzip.fragmen.fragment_recent;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        setToolbar();
       setFragmetDefault();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                navigationView.getMenu().findItem(R.id.menu_myfiles).setChecked(false);
                navigationView.getMenu().getItem(0).setChecked(false);
                navigationView.getMenu().getItem(1).setChecked(false);
                boolean Transaccion=false;
                Fragment fragment=null;
                switch (menuItem.getItemId())
                {
                    case R.id.menu_myfiles:
                        fragment= new My_files();
                        Transaccion=true;
                        break;
                    case R.id.menu_music:
                        menuItem.setChecked(false);
                        break;
                    case R.id.menu_favorites:
                        menuItem.setChecked(false);
                        break;
                    case R.id.menu_dropbox:
                        menuItem.setChecked(false);
                        break;
                    case R.id.menu_photos:
                        menuItem.setChecked(false);
                        break;
                    case R.id.menu_recientes:
                        fragment= new fragment_recent();
                        Transaccion=true;
                        break;
                    case R.id.menu_storages:
                        menuItem.setChecked(false);
                        break;
                }
                if(Transaccion)
                {
                  cambiarfradmento(fragment,menuItem);
                    drawerLayout.closeDrawer(GravityCompat.START);

                }
                return true;
            }
        });
    }
    public void setFragmetDefault(){
        cambiarfradmento(new My_files(),navigationView.getMenu().findItem(R.id.menu_myfiles));
    }
    public void cambiarfradmento(Fragment fragment,MenuItem item){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    public void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}