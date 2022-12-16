package com.example.tadaseller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.Adapters.OrdersOrdersVpAdapter;
import com.example.tadaseller.Adapters.OrdersVpAdapter;
import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentOrdersOrdersBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class OrdersOrdersFragment extends Fragment {

   FragmentOrdersOrdersBinding binding;
   OrdersOrdersVpAdapter ordersOrdersVpAdapter;

    private final String[] titles = new String[]{"all", "accepted", "rejected"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOrdersOrdersBinding.inflate(inflater,container,false);

        ordersOrdersVpAdapter=new OrdersOrdersVpAdapter(requireActivity());

        binding.viewpager.setAdapter(ordersOrdersVpAdapter);

        new TabLayoutMediator(binding.tablayout,binding.viewpager,((tab, position) -> tab.setText(titles[position]))).attach();

        return binding.getRoot();
    }
}