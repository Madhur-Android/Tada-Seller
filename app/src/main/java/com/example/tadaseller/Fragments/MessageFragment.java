package com.example.tadaseller.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tadaseller.databinding.FragmentMessageBinding;

public class MessageFragment extends Fragment {

    FragmentMessageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   binding = FragmentMessageBinding.inflate(inflater,container,false);


   return binding.getRoot();
    }
}