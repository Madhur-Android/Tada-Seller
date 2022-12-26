package com.example.tadaseller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentRecordedVideoBinding;

import javax.security.auth.callback.Callback;


public class RecordedVideoFragment extends Fragment {

    FragmentRecordedVideoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecordedVideoBinding.inflate(inflater, container, false);

        binding.btnBack.setOnClickListener(v -> {

            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.MainHome, new SelectProductFragment()).commit();
        });

        return binding.getRoot();
    }

}