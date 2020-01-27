package com.example.coffeegrab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Coffee> cartItems;
    List<Coffee> coffeeList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeeList = new ArrayList<>();
        cartItems = new ArrayList<>();

        //TODO:: Add something in coffeeList...
        coffeeList.add(new Coffee(R.drawable.coffee, "Coffee 1", 30));
        coffeeList.add(new Coffee(R.drawable.coffee, "Coffee 2", 30));
        coffeeList.add(new Coffee(R.drawable.coffee, "Coffee 3", 30));
        coffeeList.add(new Coffee(R.drawable.coffee, "Coffee 4", 30));



        listView = findViewById(R.id.listView);

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.my_list_item, coffeeList);

        listView.setAdapter(adapter);
    }
}
