package com.example.tadaseller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

import com.example.tadaseller.databinding.ActivityMainBinding;
import com.example.tadaseller.databinding.ActivityNotificationBinding;

public class PaymentMethodsActivity extends AppCompatActivity {

    AppCompatButton back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_methods);
        back_btn = findViewById (R.id.btn_Back);

        back_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent (TermsAndConditionsActivity.this, DashboardActivity.class);
//                startActivity (i);
                onBackPressed ();            }
        });

    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            super.onBackPressed(); //replaced
        }
    }
}