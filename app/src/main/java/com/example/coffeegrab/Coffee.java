package com.example.coffeegrab;

class Coffee {

    int image;
    private String name;
    private String price;
    private int quantity;

    Coffee(int image, String name, String price, int quantity){
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    int getImage() {
        return image;
    }

    String getName() {
        return name;
    }

    String getPrice() {
        return price;
    }

    int getQuantity(){ return quantity; }

    void addItem(){
        quantity++;
    }

    void removeItem(){
        if(quantity > 0) {
            quantity--;
        }
    }
}
