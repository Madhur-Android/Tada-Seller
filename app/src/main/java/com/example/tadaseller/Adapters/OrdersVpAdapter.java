package com.example.tadaseller.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tadaseller.Fragments.OrdersManageOrdersFragment;
import com.example.tadaseller.Fragments.OrdersOrdersFragment;

public class OrdersVpAdapter extends FragmentStateAdapter
{
    private final String[] titles=new String[]{"orders","manage orders"};

    public OrdersVpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new OrdersOrdersFragment();
            case 1:
                return new OrdersManageOrdersFragment();
        }
        return new OrdersOrdersFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}