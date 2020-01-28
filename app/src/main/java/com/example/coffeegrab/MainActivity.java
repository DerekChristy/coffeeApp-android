package com.example.coffeegrab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Coffee> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Coffee> coffeeList = new ArrayList<>();

        //TODO:: Add something in coffeeList...

        coffeeList.add(new Coffee(R.drawable.latte, "Cafe Latte", "129", 0));
        coffeeList.add(new Coffee(R.drawable.frappe, "Cafe Frappe", "149", 0));
        coffeeList.add(new Coffee(R.drawable.mocha, "Cafe Mocha", "179",0));
        coffeeList.add(new Coffee(R.drawable.mocha, "cappuccino", "129",0));
        coffeeList.add(new Coffee(R.drawable.latte, "Cafe Latte", "129", 0));
        coffeeList.add(new Coffee(R.drawable.frappe, "Cafe Frappe", "149", 0));
        coffeeList.add(new Coffee(R.drawable.mocha, "Cafe Mocha", "179",0));
        coffeeList.add(new Coffee(R.drawable.mocha, "cappuccino", "129",0));

        ListView listView = findViewById(R.id.listView);
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.my_list_item, coffeeList);
        listView.setAdapter(adapter);

        items = adapter.cartItems;
    }

    public void openCart(View view) {

        if(items.isEmpty()) {
            Toast.makeText(this,"Cart Empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("COFFEE" ,"COFFEE CART ITEMS: " + items);
        Intent intent = new Intent(this, CartActivity.class);
//        Bundle args = new Bundle();
//        args.putSerializable("list", items);
//        intent.putExtra("bundle", args);
        intent.putExtra("list", (ArrayList<Coffee>) items);
        startActivity(intent);
    }
}
