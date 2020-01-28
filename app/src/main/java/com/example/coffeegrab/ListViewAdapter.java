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
import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Coffee> {

    private Context context;
    private int resource;
    ArrayList<Coffee> cartItems;

    static class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
        TextView quantity;
        Button add;
        Button sub;
    }

    ListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Coffee> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        cartItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // get coffee item information

            String name = getItem(position).getName();
            String price = getItem(position).getPrice();
            int image = getItem(position).getImage();
            int quantity = getItem(position).getQuantity();

        // Create coffee object with the information
        final Coffee coffee = new Coffee(image, name, price, quantity);


        // ViewHolder object
        final ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.nameCoffee);
            holder.image = convertView.findViewById(R.id.imageCoffee);
            holder.price = convertView.findViewById(R.id.priceCoffee);
            holder.quantity = convertView.findViewById(R.id.quanCoffee);
            holder.add = convertView.findViewById(R.id.btnAdd);
            holder.sub = convertView.findViewById(R.id.btnRemove);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String amount = "Rs. " + coffee.getPrice();
        holder.name.setText(coffee.getName());
        holder.quantity.setText(String.valueOf(coffee.getQuantity()));
        holder.price.setText(amount);
        holder.image.setImageDrawable(context.getDrawable(coffee.image));

        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee.removeItem();
                if(coffee.getQuantity() == 0) {
                    if(cartItems.size() > 0)
                        cartItems.remove(coffee);
                }
                Log.d("COFFEE", "CART ITEMS: " + cartItems.size());
                holder.quantity.setText(String.valueOf(coffee.getQuantity()));
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee.addItem();
                if(coffee.getQuantity() == 1) {
                    cartItems.add(coffee);
                }
                holder.quantity.setText(String.valueOf(coffee.getQuantity()));
                Log.d("COFFEE", "CART ITEMS: " + cartItems.size());

            }
        });
//        ImageView imageCoffee = view.findViewById(R.id.imageCoffee);
//        TextView nameCoffee = view.findViewById(R.id.nameCoffee);
//        TextView priceCoffee = view.findViewById(R.id.priceCoffee);
//        Button btnAdd = view.findViewById(R.id.btnAdd);
//        Button btnSub = view.findViewById(R.id.btnRemove);
//        final TextView quantityTxt = view.findViewById(R.id.quanCoffee);



//        for(Coffee coffeeItem : cartItems){
//            if(coffee.getName().equals(coffeeItem.getName())){
//                quantityTxt.setText(String.valueOf(coffeeItem.getQuantity()));
//            }
//        }
//
//        imageCoffee.setImageDrawable(context.getResources().getDrawable(coffee.getImage()));
//        nameCoffee.setText(coffee.getName());
//        String price = "$ " + coffee.getPrice();
//        priceCoffee.setText(price);


//        final int finalIndex = position;
//
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                addItems();
//                String quantity = quantityTxt.getText().toString();
//                int quan = Integer.parseInt(quantity) + 1;
//                quantityTxt.setText(quan+"");
//
//
//                for(int i = 0; i< cartItems.size(); i++){
//                    Log.d("Tag", cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity());
//                }
//            }
//
//            public void addItems() {
//                Coffee addedCoffee = coffeeList.get(finalIndex);
//                for(Coffee coffeeCart : cartItems){
//                    if(coffeeCart.getName().equals(coffee.getName())){
//                        coffeeCart.addItem();
//                        //quantity.setText(coffeeCart.getQuantity());
//                        return;
//                    }
//                }
//                addedCoffee.addItem();
//                //quantity.setText(addedCoffee.getQuantity());
//                cartItems.add(addedCoffee);
//
//            }
//        });
//
//        btnSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                removeItems();
//
//                String quantity = quantityTxt.getText().toString();
//                int quan = Integer.parseInt(quantity);
//                if(quan > 0){
//                    quan--;
//                }
//                quantityTxt.setText(quan+"");
//
//                for(int i = 0; i< cartItems.size(); i++){
//                    Log.d("Tag", cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity());
//                }
//            }
//
//            public void removeItems() {
//                Coffee addedCoffee = coffeeList.get(finalIndex);
//                for(Coffee coffeeCart : cartItems){
//                    if(coffeeCart.getName().equals(coffee.getName())){
//                        coffeeCart.removeItem();
//                        //quantity.setText(coffeeCart.getQuantity());
//                        return;
//                    }
//                }
//                addedCoffee.removeItem();
//                //quantity.setText(addedCoffee.getQuantity());
//                cartItems.add(addedCoffee);
//
//            }
//        });

        return convertView;
    }
}
