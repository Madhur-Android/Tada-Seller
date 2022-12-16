package com.example.tadaseller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.Adapters.OrdersVpAdapter;
import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentOrdersBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class OrdersFragment extends Fragment {

    FragmentOrdersBinding binding;
    OrdersVpAdapter ordersVpAdapter;

    private String[] titles=new String[]{"orders","manage orders"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentOrdersBinding.inflate(inflater,container,false);

        ordersVpAdapter=new OrdersVpAdapter(requireActivity());

        binding.container.setAdapter(ordersVpAdapter);

        new TabLayoutMediator(binding.tablayout,binding.container,((tab, position) -> tab.setText(titles[position]))).attach();

       return binding.getRoot();
    }
}