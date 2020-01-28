package com.example.coffeegrab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Coffee> cartItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
//        Bundle args = intent.getBundleExtra("bundle");
//        cartItems = (ArrayList<Coffee>) args.getSerializable("list");
        cartItems = (ArrayList<Coffee>) intent.getSerializableExtra("list");
        ListView listView = findViewById(R.id.itemsList);
        CartListAdapter adapter = new CartListAdapter(this, R.layout.cart_item, cartItems);
        listView.setAdapter(adapter);

    }

    public void prevActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void confirmOrder(View view) {
        Log.d("COFFEE", "Order confirmed");

    }
}
