package com.example.tadaseller.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tadaseller.Fragments.AllManageOrdersFragment;
import com.example.tadaseller.Fragments.ClosedManageOrdersFragment;
import com.example.tadaseller.Fragments.OpenManageOrdersFragment;
import com.example.tadaseller.Fragments.UnpaidManageOrdersFragment;

public class OrdersManageOrdersVpAdapter extends FragmentStateAdapter
{
    private final String[] titles = new String[]{"all", "unpaid", "open","closed"};

    public OrdersManageOrdersVpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new AllManageOrdersFragment();
            case 1:
                return new UnpaidManageOrdersFragment();
            case 2:
                return new OpenManageOrdersFragment();
            case 3:
                return new ClosedManageOrdersFragment();
        }
        return new AllManageOrdersFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
