package com.example.tadaseller.AppModals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tadaseller.Repository.ProductRepo;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepo repo;
    private LiveData<List<Product>> allProducts;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repo=new ProductRepo(application);
        allProducts=repo.getAllProducts();
    }

    public void insert(Product product)
    {
        repo.insert(product);
    }
    public void update(Product product)
    {
        repo.update(product);
    }
    public void delete(Product product)
    {
        repo.delete(product);
    }
    public LiveData<List<Product>> getAllProducts()
    {
        return allProducts;
    }
}
