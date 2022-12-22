package com.example.tadaseller.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaseller.AppModals.Product;
import com.example.tadaseller.R;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AddProductAdapter extends RecyclerView.Adapter<AddProductAdapter.ProductViewHolder> {

    private List<Product> products=new ArrayList<>();

    public void setProducts(List<Product> productList)
    {
        this.products=productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.add_product_layout,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct=products.get(position);

        holder.img_product.setImageResource(R.drawable.img_product);
        holder.tv.setText(currentProduct.getName());
        holder.priceTV.setText("₹ " + String.valueOf(currentProduct.getPrice()));
        holder.quantityTV.setText("Qua: " + String.valueOf(currentProduct.getQuantity()));
        holder.switcher.setChecked(currentProduct.isStatus());
        holder.switchTv.setText((currentProduct.isStatus()==true) ? "public" : "draft");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img_product;
        private TextView switchTv,tv,priceTV,quantityTV;
        Switch switcher;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            img_product=itemView.findViewById(R.id.img_product);
            tv=itemView.findViewById(R.id.tv);
            priceTV=itemView.findViewById(R.id.priceTV);
            quantityTV=itemView.findViewById(R.id.quantityTV);
            switcher=itemView.findViewById(R.id.switcher);
            switchTv=itemView.findViewById(R.id.switchTv);
        }
    }
}
