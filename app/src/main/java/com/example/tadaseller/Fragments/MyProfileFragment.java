package com.example.tadaseller.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.EditProfileActivity;
import com.example.tadaseller.R;
import com.example.tadaseller.databinding.ActivityEditProductBinding;
import com.example.tadaseller.databinding.FragmentMyProfileBinding;

public class MyProfileFragment extends Fragment {
    FragmentMyProfileBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyProfileBinding.inflate(inflater, container, false);

        binding.icEdit.setOnClickListener(v -> {
            startActivity(new Intent(getActivity().getApplication(), EditProfileActivity.class));

        });

        return binding.getRoot();
    }
}