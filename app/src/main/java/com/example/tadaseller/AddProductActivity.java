package com.example.tadaseller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Toast;

import com.example.tadaseller.databinding.ActivityAddProductBinding;

import java.io.ByteArrayOutputStream;

public class AddProductActivity extends AppCompatActivity {
    ActivityAddProductBinding binding;
    public static final int GALLERY_REQUEST_CODE=1000;

    public static final String EXTRA_NAME="com.example.tadaseller.EXTRA_NAME";
    public static final String EXTRA_DESCRIPTION="com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_COLOR="com.example.tadaseller.EXTRA_COLOR";
    public static final String EXTRA_PRICE="com.example.tadaseller.EXTRA_PRICE";
    public static final String EXTRA_SIZE="com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_QUANTITY="com.example.tadaseller.EXTRA_QUANTITY";
    public static final String EXTRA_CATEGORY="com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_TYPE="com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_SWITCH="com.example.tadaseller.EXTRA_SWITCH";
    public static final String EXTRA_STATUS="com.example.tadaseller.EXTRA_STATUS";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveBtn.setOnClickListener(v -> {
            saveProduct();
        });

        binding.backBtn.setOnClickListener(v -> {
            finish();
        });

        binding.upi.setOnClickListener(v -> {
            Intent imgIntent=new Intent(Intent.ACTION_PICK);
            imgIntent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(imgIntent,GALLERY_REQUEST_CODE);
        });

        binding.img1.setOnClickListener(v -> {
            if(binding.first.getTag().equals("filled") && binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("filled"))
            {
                binding.first.setImageDrawable(binding.second.getDrawable());
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setImageDrawable(binding.fourth.getDrawable());
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            }
            else if(binding.first.getTag().equals("filled") && binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("empty"))
            {
                binding.first.setImageDrawable(binding.second.getDrawable());
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setTag("empty");
                binding.third.setImageDrawable(null);
            }
            else if(binding.first.getTag().equals("filled") && binding.second.getTag().equals("filled") && binding.third.getTag().equals("empty") && binding.fourth.getTag().equals("empty"))
            {
                binding.first.setImageDrawable(binding.second.getDrawable());
                binding.second.setTag("empty");
                binding.second.setImageDrawable(null);
            }
            else if(binding.first.getTag().equals("filled") && binding.second.getTag().equals("empty") && binding.third.getTag().equals("empty") && binding.fourth.getTag().equals("empty"))
            {
                binding.first.setTag("empty");
                binding.first.setImageDrawable(null);
            }
        });

        binding.img2.setOnClickListener(v -> {
            if(binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("filled"))
            {
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setImageDrawable(binding.fourth.getDrawable());
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            }
            else if(binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("empty"))
            {
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setTag("empty");
                binding.third.setImageDrawable(null);
            }
            else if(binding.second.getTag().equals("filled") && binding.third.getTag().equals("empty") && binding.fourth.getTag().equals("empty"))
            {
                binding.second.setTag("empty");
                binding.second.setImageDrawable(null);
            }
        });

        binding.img3.setOnClickListener(v -> {
            if(binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("filled"))
            {
                binding.third.setImageDrawable(binding.fourth.getDrawable());
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            }
            else if(binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("empty"))
            {
                binding.third.setTag("empty");
                binding.third.setImageDrawable(null);
            }
        });

        binding.img4.setOnClickListener(v -> {
            if (binding.fourth.getTag().equals("filled"))
            {
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            }
        });
    }

    private void saveProduct() {
        String pro_name=binding.nameEt.getText().toString();
        String pro_desc=binding.priceEt.getText().toString();
        String pro_color=binding.colorEt.getText().toString();
        int pro_price=Integer.parseInt (binding.priceEt.getText().toString());
        String pro_size=binding.sizeEt.getText().toString();
        int pro_quantity=Integer.parseInt (binding.quantityEt.getText().toString());
        String pro_category=binding.categoryEt.getText().toString();
        String pro_type=binding.typeEt.getText().toString();
        boolean pro_switch=binding.switcher.isSelected();
        String pro_status=(pro_switch) ? "public" : "draft";


        if (binding.nameEt.getText().toString().isEmpty()) {
            binding.nameEt.setError ("Please Enter Product Name");
            binding.nameEt.requestFocus ();
        }
        else if (binding.descriptionEt.getText().toString().isEmpty()) {
            binding.descriptionEt.setError ("Please Enter Description");
            binding.descriptionEt.requestFocus ();
        }
        else if (binding.priceEt.getText().toString().isEmpty()) {
            binding.priceEt.setError ("Please Enter Price");
            binding.priceEt.requestFocus ();
        }
        else if (binding.colorEt.getText().toString().isEmpty()) {
            binding.colorEt.setError ("Please Enter Color");
            binding.colorEt.requestFocus ();
        }
        else if (binding.sizeEt.getText().toString().isEmpty()) {
            binding.sizeEt.setError ("Please Enter Size");
            binding.sizeEt.requestFocus ();
        }
        else if (binding.quantityEt.getText().toString().isEmpty()) {
            binding.quantityEt.setError ("Please Enter Quantity");
            binding.quantityEt.requestFocus ();
        }
        else if (binding.categoryEt.getText().toString().isEmpty()) {
            binding.categoryEt.setError ("Please Enter Category");
            binding.categoryEt.requestFocus ();
        }
        else if (binding.typeEt.getText().toString().isEmpty()) {
            binding.typeEt.setError ("Please Enter Type");
            binding.typeEt.requestFocus ();
        }
        else if (binding.first.getDrawable()==null)
        {
            Toast.makeText(this, "please upload product image", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent data=new Intent();
            data.putExtra(EXTRA_NAME,pro_name);
            data.putExtra(EXTRA_DESCRIPTION,pro_desc);
            data.putExtra(EXTRA_COLOR,pro_color);
            data.putExtra(EXTRA_PRICE,pro_price);
            data.putExtra(EXTRA_SIZE,pro_size);
            data.putExtra(EXTRA_QUANTITY,pro_quantity);
            data.putExtra(EXTRA_CATEGORY,pro_category);
            data.putExtra(EXTRA_TYPE,pro_type);
            data.putExtra(EXTRA_SWITCH,pro_switch);
            data.putExtra(EXTRA_STATUS,pro_status);

            setResult(RESULT_OK,data);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK  && requestCode==GALLERY_REQUEST_CODE)
        {
            if(binding.first.getTag().equals("empty"))
            {
                binding.first.setImageURI(data.getData());
                binding.first.setTag("filled");
            }
            else if(binding.second.getTag().equals("empty"))
            {
                binding.second.setImageURI(data.getData());
                binding.second.setTag("filled");
            }
            else if(binding.third.getTag().equals("empty"))
            {
                binding.third.setImageURI(data.getData());
                binding.third.setTag("filled");
            }
            else if(binding.fourth.getTag().equals("empty"))
            {
                binding.fourth.setImageURI(data.getData());
                binding.fourth.setTag("filled");
            }
        }
    }
}