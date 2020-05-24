package com.example.coffeegrab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Coffee> cartItems;
    TextView priceTxt;
    private float amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        cartItems = (ArrayList<Coffee>) intent.getSerializableExtra("list");
        ListView listView = findViewById(R.id.itemsList);
        amount = 0;
        for (Coffee item : cartItems) {
            amount += Float.valueOf(item.getPrice()) * item.getQuantity();
        }
        priceTxt = findViewById(R.id.priceTxt);
        priceTxt.setText(String.valueOf(amount));

        CartListAdapter adapter = new CartListAdapter(this, R.layout.cart_item, cartItems);
        listView.setAdapter(adapter);
    }

    public void prevActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }

    public void confirmOrder(View view) {
        Log.d("COFFEE", "Order confirmed");
        Intent intent = new Intent(getApplicationContext(), OrderConfirmed.class);
        startActivity(intent);
    }
}
