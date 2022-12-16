package com.example.tadaseller.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentAllManageOrdersBinding;

public class AllManageOrdersFragment extends Fragment {

    FragmentAllManageOrdersBinding binding;

    public void init() {
        TableRow tbrow0 = new TableRow(getContext());

        CheckBox checkBox=new CheckBox(getContext());
        tbrow0.addView(checkBox);

        TextView tv0 = new TextView(getContext());
        tv0.setText(" Order No. ");
        tv0.setTextColor(Color.WHITE);
        tv0.setBackgroundColor(getResources().getColor(R.color.black));
        tv0.setTextSize(22.5f);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(getContext());
        tv1.setText(" Date ");
        tv1.setTextColor(Color.WHITE);
        tv1.setBackgroundColor(getResources().getColor(R.color.black));
        tv1.setTextSize(22.5f);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(getContext());
        tv2.setText(" Customer ");
        tv2.setTextColor(Color.WHITE);
        tv2.setBackgroundColor(getResources().getColor(R.color.black));
        tv2.setTextSize(22.5f);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(getContext());
        tv3.setText(" Total ");
        tv3.setTextColor(Color.WHITE);
        tv3.setBackgroundColor(getResources().getColor(R.color.black));
        tv3.setTextSize(22.5f);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(getContext());
        tv4.setText(" Payment Status ");
        tv4.setTextColor(Color.WHITE);
        tv4.setBackgroundColor(getResources().getColor(R.color.black));
        tv4.setTextSize(22.5f);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(getContext());
        tv5.setText(" Items ");
        tv5.setTextColor(Color.WHITE);
        tv5.setBackgroundColor(getResources().getColor(R.color.black));
        tv5.setTextSize(22.5f);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(getContext());
        tv6.setText(" Delivery Method ");
        tv6.setTextColor(Color.WHITE);
        tv6.setBackgroundColor(getResources().getColor(R.color.black));
        tv6.setTextSize(22.5f);
        tbrow0.addView(tv6);

        binding.tableLayout.addView(tbrow0);

        int i=0;
        while(i<50) {
            TableRow tbrow = new TableRow(getContext());

            CheckBox cb=new CheckBox(getContext());
            tbrow.addView(cb);
            TextView t1v = new TextView(getContext());
            t1v.setText("" + i);
            t1v.setTextColor(getResources().getColor(R.color.purple));
            t1v.setGravity(Gravity.CENTER);
            t1v.setTextSize(20f);
            tbrow.addView(t1v);
            TextView t2v = new TextView(getContext());
            t2v.setText("Product " + i);
            t2v.setTextColor(getResources().getColor(R.color.black));
            t2v.setTextSize(20f);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(getContext());
            t3v.setText("Rs." + i);
            t3v.setTextColor(getResources().getColor(R.color.black));
            t3v.setTextSize(20f);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(getContext());
            t4v.setText("" + i * 15 / 32 * 10);
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            t4v.setTextSize(20f);
            t4v.setTextColor(getResources().getColor(R.color.black));
            tbrow.addView(t4v);
            TextView t5v = new TextView(getContext());
            t5v.setTextColor(Color.WHITE);
            t5v.setGravity(Gravity.CENTER);
            t5v.setTextSize(20f);
            if(i%2==0)
            {
                t5v.setText("paid");
                t5v.setBackgroundResource(R.drawable.paid_layout);
            }
            else
            {
                t5v.setText("unpaid");
                t5v.setBackgroundResource(R.drawable.unpaid_layout);
            }
            /////////////////////
            t5v.setTextColor(getResources().getColor(R.color.black));
            tbrow.addView(t5v);
            TextView t6v = new TextView(getContext());
            t6v.setText("" + i * 15 / 32 * 10);
            t6v.setTextColor(Color.WHITE);
            t6v.setGravity(Gravity.CENTER);
            t6v.setTextSize(20f);
            t6v.setTextColor(getResources().getColor(R.color.black));
            tbrow.addView(t6v);
            TextView t7v = new TextView(getContext());
            t7v.setText("" + i * 15 / 32 * 10);
            t7v.setTextColor(Color.WHITE);
            t7v.setGravity(Gravity.CENTER);
            t7v.setTextSize(20f);
            t7v.setTextColor(getResources().getColor(R.color.black));
            tbrow.addView(t7v);
            i++;
            binding.tableLayout.addView(tbrow);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAllManageOrdersBinding.inflate(inflater,container,false);

        // dynamic table layout
        init();


        return binding.getRoot();
    }
}