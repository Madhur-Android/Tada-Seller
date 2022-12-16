package com.example.tadaseller.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tadaseller.Fragments.AcceptedOrdersFragment;
import com.example.tadaseller.Fragments.AllOrdersFragment;
import com.example.tadaseller.Fragments.RejectedOrdersFragment;

public class OrdersOrdersVpAdapter extends FragmentStateAdapter {

    private final String[] titles = new String[]{"all", "accepted", "rejected"};

    public OrdersOrdersVpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new AllOrdersFragment();
            case 1:
                return new AcceptedOrdersFragment();
            case 2:
            return new RejectedOrdersFragment();
        }
        return new AllOrdersFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
