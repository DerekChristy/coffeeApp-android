package com.example.coffeegrab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Coffee> coffeeList = new ArrayList<>();
       // cartItems = new ArrayList<>();

        //TODO:: Add something in coffeeList...

        coffeeList.add(new Coffee(R.drawable.coffee, "Cafe Latte", "129", 0));
        coffeeList.add(new Coffee(R.drawable.coffee, "Cafe Frappe", "149", 0));
        coffeeList.add(new Coffee(R.drawable.coffee, "Cafe Mocha", "179",0));
        coffeeList.add(new Coffee(R.drawable.coffee, "Cappuccino", "129",0));

        ListView listView = findViewById(R.id.listView);
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.my_list_item, coffeeList);
        listView.setAdapter(adapter);
    }
}
