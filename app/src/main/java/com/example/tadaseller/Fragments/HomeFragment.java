package com.example.tadaseller.Fragments;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentHomeBinding;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public void init() {
        TableRow tbrow0 = new TableRow(getContext());

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

        int i = 0;
        while (i < 50) {
            TableRow tbrow = new TableRow(getContext());

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
            if (i % 2 == 0) {
                t5v.setText("paid");
                t5v.setBackgroundResource(R.drawable.paid_layout);
            } else {
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
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // function to fill data in dynamic table layout
        init();

        // code for gradient textView ( TADA )
//        TextPaint paint = binding.tadaTV.getPaint();
//        float width = paint.measureText("Tada");
//        Shader textShader = new LinearGradient(0, 0, width, binding.tadaTV.getTextSize(),
//                new int[]{
//                        Color.parseColor("#FE0187"),
//                        Color.parseColor("#FF5A3A"),
//                }, null, Shader.TileMode.CLAMP);
//        binding.tadaTV.getPaint().setShader(textShader);

        TextPaint paint = binding.sellerNameTv.getPaint();
        float width = paint.measureText(binding.sellerNameTv.getText().toString());
        Shader textShader = new LinearGradient(0, 0, width, binding.sellerNameTv.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.sellerNameTv.getPaint().setShader(textShader);


        // working of bar graph
        ArrayList<Double> valuesList = new ArrayList<Double>();
        valuesList.add((double) 300);
        valuesList.add((double) 200);
        valuesList.add((double) 150);
        valuesList.add((double) 260);
        valuesList.add((double) 40);
        valuesList.add((double) 169);
        valuesList.add((double) 47);
        valuesList.add((double) 124);
        valuesList.add((double) 350);
        valuesList.add((double) 280);
        valuesList.add((double) 420);
        valuesList.add((double) 360);

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valuesList.size(); i++) {
            BarEntry barEntry = new BarEntry(i + 1, valuesList.get(i).floatValue()); //start always from x=1 for the first bar
            entries.add(barEntry);
        }

//        ArrayList<BarEntry> entries = new ArrayList<>();
//        entries.add(new BarEntry(2010, 420));
//        entries.add(new BarEntry(2011, 640));
//        entries.add(new BarEntry(2012, 401));
//        entries.add(new BarEntry(2013, 40));
//        entries.add(new BarEntry(2014, 800));
//        entries.add(new BarEntry(2015, 460));
//        entries.add(new BarEntry(2016, 320));
//        entries.add(new BarEntry(2017, 102));
//        entries.add(new BarEntry(2018, 440));
//        entries.add(new BarEntry(2019, 500));
//        entries.add(new BarEntry(2020, 390));
//        entries.add(new BarEntry(2021, 230));

        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Jan"); //this label will be mapped to the 1st index of the valuesList
        xAxisLabel.add("Feb");
        xAxisLabel.add("Mar");
        xAxisLabel.add("Apr");
        xAxisLabel.add("May");
        xAxisLabel.add("Jun");
        xAxisLabel.add("Jul");
        xAxisLabel.add("Aug");
        xAxisLabel.add("Sep");
        xAxisLabel.add("Oct");
        xAxisLabel.add("Nov");
        xAxisLabel.add("Dec");
        xAxisLabel.add(""); //empty label for the last vertical grid line on Y-Right Axis


        //initialize xAxis
        XAxis xAxis = binding.barChart.getXAxis();
        xAxis.setTextColor(Color.BLACK);
        xAxis.setTextSize(10);
        xAxis.setAxisMinimum(0 + 0.5f); //to center the bars inside the vertical grid lines we need + 0.5 step
        xAxis.setAxisMaximum(entries.size() + 0.5f); //to center the bars inside the vertical grid lines we need + 0.5 step
        xAxis.setLabelCount(xAxisLabel.size(), true); //draw x labels for 13 vertical grid lines
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setXOffset(0f); //labels x offset in dps
        xAxis.setYOffset(0f); //labels y offset in dps
        xAxis.setCenterAxisLabels(true);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xAxisLabel.get((int) value);
            }
        });

        //initialize Y-Left-Axis
        YAxis leftAxis = binding.barChart.getAxisLeft();
        leftAxis.setTextColor(Color.BLACK);
        leftAxis.setTextSize(12);
        leftAxis.setAxisMinimum(0);
        leftAxis.setAxisMaximum(600f);
        leftAxis.setLabelCount(6, true); //draw y labels (Y-Values) for 4 horizontal grid lines starting from 0 to 6000f (step=2000)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        //initialize Y-Right-Axis
        YAxis rightAxis = binding.barChart.getAxisRight();
        rightAxis.setAxisMinimum(0);
        rightAxis.setDrawAxisLine(true);
        rightAxis.setLabelCount(0, true);
        rightAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "";
            }
        });

        binding.barChart.getXAxis().setDrawGridLines(false);

//        binding.barChart.setVisibleXRangeMaximum(10);
//        binding.barChart.enableScroll();
//        binding.barChart.moveViewToX(1);

        //set the BarDataSet
        BarDataSet barDataSet = new BarDataSet(entries, "Months");
        barDataSet.setFormSize(100f);
        barDataSet.setDrawValues(false);
        barDataSet.setValueTextSize(12f);

        //set the BarData to chart
        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.5f);
        binding.barChart.setData(data);
        binding.barChart.setScaleEnabled(false);
        binding.barChart.getLegend().setEnabled(false);
        binding.barChart.setDrawBarShadow(false);
        binding.barChart.getDescription().setEnabled(false);
        binding.barChart.setPinchZoom(false);
        binding.barChart.animateY(1500);
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);


        binding.barChart.invalidate();

        return binding.getRoot();
    }
}