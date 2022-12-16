package com.example.tadaseller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.Adapters.AllOrdersAdapter;
import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentAllManageOrdersBinding;
import com.example.tadaseller.databinding.FragmentAllOrdersBinding;

public class AllOrdersFragment extends Fragment {

    FragmentAllOrdersBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAllOrdersBinding.inflate(inflater,container,false);

        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        String[] names=new String[]{"yogesh","shubham sir","madhur sir","yogesh","shubham sir","madhur sir","yogesh","shubham sir","madhur sir","yogesh","shubham sir","madhur sir"};

        binding.recycler.setAdapter(new AllOrdersAdapter(names,getContext()));

        return binding.getRoot();
    }
}