package com.example.tadaseller;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
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
import com.example.tadaseller.Fragments.SelectProductFragment;
import com.example.tadaseller.Fragments.StoreFragment;
import com.example.tadaseller.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        TextPaint paint = binding.tvTada.getPaint();
        float width = paint.measureText("Tada");
        Shader textShader = new LinearGradient(0, 0, width, binding.tvTada.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.tvTada.getPaint().setShader(textShader);


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
                    case R.id.goLive:
                        FragmentTransaction transactionL = getSupportFragmentManager().beginTransaction();
                        transactionL.replace(R.id.recyclerview, new SelectProductFragment()).commit();
                        break;
                }
                return true;
            }
        });


        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();


        // opening navigation drawer
        binding.drawernavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_payment_methods:
                        Intent intent = new Intent(MainActivity.this, PaymentMethodsActivity.class);
                        startActivity(intent);
                        //  Toast.makeText (MainActivity.this, "Payment button clicked", Toast.LENGTH_SHORT).show ();
                        break;
                    case R.id.nav_terms_and_conditions:
                        Intent intent1 = new Intent(MainActivity.this, TermsAndConditionsActivity.class);
                        startActivity(intent1);
                        //   Toast.makeText (MainActivity.this, "terms and condition button clicked", Toast.LENGTH_SHORT).show ();
                        break;

                    case R.id.nav_privacy_policy:
                        Intent intent2 = new Intent(MainActivity.this, PrivacyPolicyActivity.class);
                        startActivity(intent2);
                        //  Toast.makeText (MainActivity.this, "privacy policy button clicked", Toast.LENGTH_SHORT).show ();
                        break;

                    case R.id.nav_settings:
                        Intent intent3 = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent3);
                        // Toast.makeText (MainActivity.this, "setting button clicked", Toast.LENGTH_SHORT).show ();
                        break;
                }

                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
