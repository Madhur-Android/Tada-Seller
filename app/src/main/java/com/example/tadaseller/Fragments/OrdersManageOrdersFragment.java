package com.example.tadaseller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.Adapters.OrdersManageOrdersVpAdapter;
import com.example.tadaseller.Adapters.OrdersVpAdapter;
import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentOpenManageOrdersBinding;
import com.example.tadaseller.databinding.FragmentOrdersManageOrdersBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class OrdersManageOrdersFragment extends Fragment {

    FragmentOrdersManageOrdersBinding binding;
    OrdersManageOrdersVpAdapter ordersManageOrdersVpAdapter;

    private final String[] titles = new String[]{"all", "unpaid", "open","closed"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOrdersManageOrdersBinding.inflate(inflater,container,false);

        ordersManageOrdersVpAdapter=new OrdersManageOrdersVpAdapter(requireActivity());

        binding.viewpager.setAdapter(ordersManageOrdersVpAdapter);

        new TabLayoutMediator(binding.tablayout,binding.viewpager,((tab, position) -> tab.setText(titles[position]))).attach();

        return binding.getRoot();
    }
}