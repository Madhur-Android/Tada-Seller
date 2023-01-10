package com.example.tadaseller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tadaseller.databinding.ActivityAddProductBinding;

import java.util.ArrayList;
import java.util.Collections;

public class AddProductActivity extends AppCompatActivity {
    ActivityAddProductBinding binding;
    public static final int GALLERY_REQUEST_CODE = 1000;

    public static final String EXTRA_NAME = "com.example.tadaseller.EXTRA_NAME";
    public static final String EXTRA_DESCRIPTION = "com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_COLOR = "com.example.tadaseller.EXTRA_COLOR";
    public static final String EXTRA_PRICE = "com.example.tadaseller.EXTRA_PRICE";
    public static final String EXTRA_SIZE = "com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_QUANTITY = "com.example.tadaseller.EXTRA_QUANTITY";
    public static final String EXTRA_CATEGORY = "com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_TYPE = "com.example.tadaseller.EXTRA_DESCRIPTION";
    public static final String EXTRA_SWITCH = "com.example.tadaseller.EXTRA_SWITCH";
    public static final String EXTRA_STATUS = "com.example.tadaseller.EXTRA_STATUS";

    boolean[] selectedColor;
    ArrayList<Integer> colorList = new ArrayList<>();
    String[] colorArray = {"red", "orange", "yellow", "green", "blue", "indigo", "purple", "pink", "brown", "black", "white"};

    boolean[] selectedSize;
    ArrayList<Integer> sizeList = new ArrayList<>();
    String[] sizeArray = {"XS", "S", "M", "L", "XL", "XXL", "XXXL"};

    boolean[] selectedCategory;
    ArrayList<Integer> categoryList = new ArrayList<>();
    String[] categoryArray = {"Women", "Men", "Clothing", "Child", "Girl", "Boy", "Winter wear", "Summer wear"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        selectedColor = new boolean[colorArray.length];
        selectedCategory = new boolean[categoryArray.length];
        selectedSize = new boolean[sizeArray.length];

        binding.categoryTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
                builder.setTitle("Select Category");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(categoryArray, selectedCategory, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            categoryList.add(which);
                            // Sort array list
                            Collections.sort(categoryList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            categoryList.remove(Integer.valueOf(which));
                        }
                    }
                });
                builder.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < categoryList.size(); i++) {
                            stringBuilder.append(categoryArray[categoryList.get(i)]);
                            // check condition
                            if (i != categoryList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(" , ");
                            }
                        }
                        binding.categoryTv.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        binding.sizeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
                builder.setTitle("Select Size");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(sizeArray, selectedSize, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            sizeList.add(which);
                            // Sort array list
                            Collections.sort(sizeList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            sizeList.remove(Integer.valueOf(which));
                        }
                    }
                });
                builder.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < sizeList.size(); i++) {
                            stringBuilder.append(sizeArray[sizeList.get(i)]);
                            // check condition
                            if (i != sizeList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(" , ");
                            }
                        }
                        binding.sizeTv.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        binding.colorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
                builder.setTitle("Select Colour");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(colorArray, selectedColor, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            colorList.add(which);
                            // Sort array list
                            Collections.sort(colorList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            colorList.remove(Integer.valueOf(which));
                        }
                    }
                });
                builder.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < colorList.size(); i++) {
                            stringBuilder.append(colorArray[colorList.get(i)]);
                            // check condition
                            if (i != colorList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(" , ");
                            }
                        }
                        binding.colorTv.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });


        binding.saveBtn.setOnClickListener(v -> {
            saveProduct();
        });

        binding.backBtn.setOnClickListener(v -> {
            finish();
        });

        binding.upi.setOnClickListener(v -> {
            Intent imgIntent = new Intent(Intent.ACTION_PICK);
            imgIntent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(imgIntent, GALLERY_REQUEST_CODE);
        });

        binding.img1.setOnClickListener(v -> {
            if (binding.first.getTag().equals("filled") && binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("filled")) {
                binding.first.setImageDrawable(binding.second.getDrawable());
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setImageDrawable(binding.fourth.getDrawable());
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            } else if (binding.first.getTag().equals("filled") && binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("empty")) {
                binding.first.setImageDrawable(binding.second.getDrawable());
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setTag("empty");
                binding.third.setImageDrawable(null);
            } else if (binding.first.getTag().equals("filled") && binding.second.getTag().equals("filled") && binding.third.getTag().equals("empty") && binding.fourth.getTag().equals("empty")) {
                binding.first.setImageDrawable(binding.second.getDrawable());
                binding.second.setTag("empty");
                binding.second.setImageDrawable(null);
            } else if (binding.first.getTag().equals("filled") && binding.second.getTag().equals("empty") && binding.third.getTag().equals("empty") && binding.fourth.getTag().equals("empty")) {
                binding.first.setTag("empty");
                binding.first.setImageDrawable(null);
            }
        });

        binding.img2.setOnClickListener(v -> {
            if (binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("filled")) {
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setImageDrawable(binding.fourth.getDrawable());
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            } else if (binding.second.getTag().equals("filled") && binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("empty")) {
                binding.second.setImageDrawable(binding.third.getDrawable());
                binding.third.setTag("empty");
                binding.third.setImageDrawable(null);
            } else if (binding.second.getTag().equals("filled") && binding.third.getTag().equals("empty") && binding.fourth.getTag().equals("empty")) {
                binding.second.setTag("empty");
                binding.second.setImageDrawable(null);
            }
        });

        binding.img3.setOnClickListener(v -> {
            if (binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("filled")) {
                binding.third.setImageDrawable(binding.fourth.getDrawable());
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            } else if (binding.third.getTag().equals("filled") && binding.fourth.getTag().equals("empty")) {
                binding.third.setTag("empty");
                binding.third.setImageDrawable(null);
            }
        });

        binding.img4.setOnClickListener(v -> {
            if (binding.fourth.getTag().equals("filled")) {
                binding.fourth.setTag("empty");
                binding.fourth.setImageDrawable(null);
            }
        });


    }

    private void saveProduct() {


        // name
        String pro_name = binding.nameEt.getText().toString();
        if (!pro_name.isEmpty()) {
            Log.i("TAG", pro_name);
        } else {

            binding.nameEt.setError("Please Enter Product Name");
            binding.nameEt.requestFocus();
        }

        // desc
        String pro_desc = binding.descriptionEt.getText().toString();
        if (!pro_desc.isEmpty()) {
            Log.i("TAG", pro_desc);

        } else {
            binding.descriptionEt.setError("Please Enter Product Description");
            binding.descriptionEt.requestFocus();
        }

        // color
        String pro_color = binding.colorTv.getText().toString();
        if (!pro_color.isEmpty()) {
            Log.i("TAG", pro_desc);

        } else {
            binding.colorTv.setError("Please Enter Color");
            binding.colorTv.requestFocus();
        }

        // price
        String pro_price = binding.priceEt.getText().toString();
        if (!pro_price.isEmpty()) {
            Log.i("TAG", String.valueOf(pro_price));

        } else {
            binding.priceEt.setError("Please Enter Price");
            binding.priceEt.requestFocus();
        }

        //size
        String pro_size = binding.sizeTv.getText().toString();
        if (!pro_size.isEmpty()) {
            Log.i("TAG", pro_size);

        } else {
            binding.sizeTv.setError("Please Enter Size");
            binding.sizeTv.requestFocus();
        }

        // quantity
        String pro_quantity =binding.quantityEt.getText().toString();
        if (!pro_quantity.isEmpty()) {
            Log.i("TAG", String.valueOf(pro_quantity));

        } else {
            binding.quantityEt.setError("Please Enter Quantity");
            binding.quantityEt.requestFocus();
        }

        // category
        String pro_category = binding.categoryTv.getText().toString();
        if (!pro_category.isEmpty()) {
            Log.i("TAG", pro_category);

        } else {
            binding.categoryTv.setError("Please Enter Category");
            binding.categoryTv.requestFocus();
        }

        // type
        String pro_type = binding.typeEt.getText().toString();
        if (!pro_type.isEmpty()) {
            Log.i("TAG", pro_type);

        } else {
            binding.typeEt.setError("Please Enter Type");
            binding.typeEt.requestFocus();

        }

        // switch
        boolean pro_switch = binding.switcher.isSelected();

        // status
        String pro_status = (pro_switch) ? "public" : "draft";

        if (binding.first.getDrawable() == null) {
            Toast.makeText(this, "please upload product image", Toast.LENGTH_SHORT).show();
        }


        if(!pro_name.isEmpty() && !pro_desc.isEmpty() && !pro_price.isEmpty() && !pro_color.isEmpty() && !pro_size.isEmpty() && !pro_quantity.isEmpty() && !pro_category.isEmpty() && !pro_type.isEmpty() && binding.first.getDrawable() != null)
        {
            Intent data = new Intent();
            data.putExtra(EXTRA_NAME, pro_name);
            data.putExtra(EXTRA_DESCRIPTION, pro_desc);
            data.putExtra(EXTRA_COLOR, pro_color);
            data.putExtra(EXTRA_PRICE, pro_price);
            data.putExtra(EXTRA_SIZE, pro_size);
            data.putExtra(EXTRA_QUANTITY, pro_quantity);
            data.putExtra(EXTRA_CATEGORY, pro_category);
            data.putExtra(EXTRA_TYPE, pro_type);
            data.putExtra(EXTRA_SWITCH, pro_switch);
            data.putExtra(EXTRA_STATUS, pro_status);

            setResult(RESULT_OK, data);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == GALLERY_REQUEST_CODE) {
            if (binding.first.getTag().equals("empty")) {
                binding.first.setImageURI(data.getData());
                binding.first.setTag("filled");
            } else if (binding.second.getTag().equals("empty")) {
                binding.second.setImageURI(data.getData());
                binding.second.setTag("filled");
            } else if (binding.third.getTag().equals("empty")) {
                binding.third.setImageURI(data.getData());
                binding.third.setTag("filled");
            } else if (binding.fourth.getTag().equals("empty")) {
                binding.fourth.setImageURI(data.getData());
                binding.fourth.setTag("filled");
            }
        }
    }
}