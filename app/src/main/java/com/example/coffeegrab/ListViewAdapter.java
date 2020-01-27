package com.example.coffeegrab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.coffeegrab.MainActivity.cartItems;

public class ListViewAdapter extends ArrayAdapter<Coffee> {

    Context context;
    int resource;
    List<Coffee> coffeeList;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Coffee> coffeeList) {
        super(context, resource, coffeeList);

        this.context = context;
        this.resource = resource;
        this.coffeeList = coffeeList;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_list_item, null);

        ImageView imageCoffee = view.findViewById(R.id.imageCoffee);
        TextView nameCoffee = view.findViewById(R.id.nameCoffee);
        TextView priceCoffee = view.findViewById(R.id.priceCoffee);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        Button btnSub = view.findViewById(R.id.btnRemove);
        final TextView quanCoffee = view.findViewById(R.id.quanCoffee);

        final Coffee coffee = coffeeList.get(position);

        for(Coffee coffeeItem : cartItems){
            if(coffee.getName().equals(coffeeItem.getName())){
                quanCoffee.setText(String.valueOf(coffeeItem.getQuantity()));
            }
        }

        imageCoffee.setImageDrawable(context.getResources().getDrawable(coffee.getImage()));
        nameCoffee.setText(coffee.getName());
        String price = "$ " + coffee.getPrice();
        priceCoffee.setText(price);


        final int finalIndex = position;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItems();
                String quantity = quanCoffee.getText().toString();
                int quan = Integer.parseInt(quantity) + 1;
                quanCoffee.setText(quan+"");


                for(int i = 0; i< cartItems.size(); i++){
                    Log.d("Tag", cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity());
                }
            }

            public void addItems() {
                Coffee addedCoffee = coffeeList.get(finalIndex);
                for(Coffee coffeeCart : cartItems){
                    if(coffeeCart.getName().equals(coffee.getName())){
                        coffeeCart.addItem();
                        //quantity.setText(coffeeCart.getQuantity());
                        return;
                    }
                }
                addedCoffee.addItem();
                //quantity.setText(addedCoffee.getQuantity());
                cartItems.add(addedCoffee);

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItems();

                String quantity = quanCoffee.getText().toString();
                int quan = Integer.parseInt(quantity);
                if(quan > 0){
                    quan--;
                }
                quanCoffee.setText(quan+"");

                for(int i = 0; i< cartItems.size(); i++){
                    Log.d("Tag", cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity());
                }
            }

            public void removeItems() {
                Coffee addedCoffee = coffeeList.get(finalIndex);
                for(Coffee coffeeCart : cartItems){
                    if(coffeeCart.getName().equals(coffee.getName())){
                        coffeeCart.removeItem();
                        //quantity.setText(coffeeCart.getQuantity());
                        return;
                    }
                }
                addedCoffee.removeItem();
                //quantity.setText(addedCoffee.getQuantity());
                cartItems.add(addedCoffee);

            }
        });

        return view;

    }
}
