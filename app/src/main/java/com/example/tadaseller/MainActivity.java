package com.example.tadaseller;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.tadaseller.Fragments.HomeFragment;
import com.example.tadaseller.Fragments.MyProfileFragment;
import com.example.tadaseller.Fragments.OrdersFragment;
import com.example.tadaseller.Fragments.StoreFragment;
import com.example.tadaseller.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        binding.toolbar.setTitleTextColor(getResources().getColor(R.color.appPink));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.recyclerview, new HomeFragment()).commit();

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        FragmentTransaction transactionH = getSupportFragmentManager().beginTransaction();
                        transactionH.replace(R.id.recyclerview, new HomeFragment()).commit();
                        break;
                    case R.id.store:
                        FragmentTransaction transactionS = getSupportFragmentManager().beginTransaction();
                        transactionS.replace(R.id.recyclerview, new StoreFragment()).commit();
                        break;
                    case R.id.orders:
                        FragmentTransaction transactionO = getSupportFragmentManager().beginTransaction();
                        transactionO.replace(R.id.recyclerview, new OrdersFragment()).commit();
                        break;
                    case R.id.profile:
                        FragmentTransaction transactionP = getSupportFragmentManager().beginTransaction();
                        transactionP.replace(R.id.recyclerview, new MyProfileFragment()).commit();
                        break;
                }
                return true;
            }
        });


        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable ().setColor (getResources ().getColor (R.color.white));
        toggle.syncState();


        // opening navigation drawer
       binding.drawernavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               return false;
           }
       });


//                case R.id.share:
//                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                    sharingIntent.setType("text/plain");
//                    String shareBody = "http://play.google.com/store/apps/detail?id=" + getPackageName();
//                    String shareSub = "Try now";
//                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
//                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
//                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
//                    break;

    }
}
