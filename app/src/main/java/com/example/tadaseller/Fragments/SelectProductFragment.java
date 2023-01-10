package com.example.tadaseller.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaseller.GoLiveActivity;
import com.example.tadaseller.R;
import com.example.tadaseller.databinding.FragmentSelectProductBinding;


public class SelectProductFragment extends Fragment {
    FragmentSelectProductBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectProductBinding.inflate(inflater, container, false);

        binding.txtRecordedVideo.setOnClickListener(v -> {

            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.MainHome, new RecordedVideoFragment()).commit();
        });
        binding.txtGoLive.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), GoLiveActivity.class));

        });

        return binding.getRoot();
    }
}