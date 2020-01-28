package com.example.coffeegrab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartListAdapter extends ArrayAdapter<Coffee> {

    private Context context;
    private int resource;

    static class CartViewHolder {
        TextView name;
        TextView price;
        TextView quantity;
    }


    CartListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Coffee> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        String name = getItem(position).getName();
        String price = getItem(position).getPrice();
        int image = getItem(position).getImage();
        int quantity = getItem(position).getQuantity();

        // Create coffee object with the information
        final Coffee coffee = new Coffee(image, name, price, quantity);

        final CartViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, container, false);
            holder = new CartViewHolder();
            holder.name = convertView.findViewById(R.id.nameTxt);
            holder.price = convertView.findViewById(R.id.priceTxt);
            holder.quantity = convertView.findViewById(R.id.quantityTxt);

            convertView.setTag(holder);
        } else {
            holder = (CartViewHolder) convertView.getTag();
        }

        holder.name.setText(coffee.getName());
        holder.quantity.setText(coffee.getQuantity());
        float total = Float.valueOf(coffee.getPrice()) * coffee.getQuantity();
        holder.price.setText(String.valueOf(total));

        return convertView;
    }
}
