package com.example.coffeegrab;

public class Coffee {

    int image;
    String name;
    float price;
    int quantity;

    public Coffee(int image, String name, float price){
        this.image = image;
        this.name = name;
        this.price = price;
        quantity = 0;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public void addItem(){
        quantity++;
    }

    public void removeItem(){
        if(quantity < 0){
            return;
        }
        quantity--;
    }
}
