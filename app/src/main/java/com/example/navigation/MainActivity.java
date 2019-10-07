package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerid);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=findViewById(R.id.navigationid);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        if(menuItem.getItemId()==R.id.Accelerometer_id)
        {
            intent=new Intent(this,Accelerometer.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.Gyroscope_id)
        {
            intent=new Intent(this,Gyroscope.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.Gyrofetch_id)
        {
            intent=new Intent(this,Gyrofetch.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.Map_id)
        {
            intent=new Intent(this,MapsActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.Proximity_id)
        {
            intent=new Intent(this,Proximity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.Shaker_id)
        {
            intent=new Intent(this,Shake.class);
            startActivity(intent);
        }


        return false;
    }
}
