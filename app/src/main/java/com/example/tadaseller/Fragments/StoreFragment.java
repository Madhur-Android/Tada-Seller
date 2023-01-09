package com.example.tadaseller.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tadaseller.Adapters.AddProductAdapter;
import com.example.tadaseller.AddProductActivity;
import com.example.tadaseller.AppModals.Product;
import com.example.tadaseller.AppModals.ProductViewModel;
import com.example.tadaseller.databinding.FragmentStoreBinding;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class StoreFragment extends Fragment {
    public static final int ADD_NOTE_REQUEST = 1;
    FragmentStoreBinding binding;
    private ProductViewModel productViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStoreBinding.inflate(inflater, container, false);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        final AddProductAdapter adapter = new AddProductAdapter();
        binding.recyclerview.setAdapter(adapter);

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(getViewLifecycleOwner(), products -> {
            // update recyclerview here
            adapter.setProducts(products);
        });

        binding.addProductTv.setOnClickListener(v -> {
            startActivityForResult(new Intent(getActivity(), AddProductActivity.class), ADD_NOTE_REQUEST);
        });


        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setProducts(products);
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == -1) {

            String name = data.getStringExtra(AddProductActivity.EXTRA_NAME);
            String desc = data.getStringExtra(AddProductActivity.EXTRA_DESCRIPTION);
            String color = data.getStringExtra(AddProductActivity.EXTRA_COLOR);
            int price = data.getIntExtra(AddProductActivity.EXTRA_PRICE,0);
            String size = data.getStringExtra(AddProductActivity.EXTRA_SIZE);
            int quantity = data.getIntExtra(AddProductActivity.EXTRA_QUANTITY,0);
            String category = data.getStringExtra(AddProductActivity.EXTRA_CATEGORY);
            String type = data.getStringExtra(AddProductActivity.EXTRA_TYPE);
            boolean switcher = Boolean.parseBoolean(data.getStringExtra(AddProductActivity.EXTRA_SWITCH));
            String status = data.getStringExtra(AddProductActivity.EXTRA_STATUS);


            Product product = new Product(name,desc,color,size,category,type,status,price,quantity,switcher);
            productViewModel.insert(product);

            Toast.makeText(getContext(), "New Product Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Product Not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}