package com.example.tadaseller.AppModals;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "products")
public class Product
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name,description,color,size,category,type,publicOrDraft;
    private int price,quantity;
    private boolean status;


    public Product(String name, String description, String color, String size, String category, String type, String publicOrDraft, int price, int quantity, boolean status) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.size = size;
        this.category = category;
        this.type = type;
        this.publicOrDraft = publicOrDraft;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getPublicOrDraft() {
        return publicOrDraft;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isStatus() {
        return status;
    }
}
