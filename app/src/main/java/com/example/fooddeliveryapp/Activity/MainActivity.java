package com.example.fooddeliveryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.fooddeliveryapp.Adapter.FoodListAdapter;
import com.example.fooddeliveryapp.Domain.FoodDomain;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Cheese Burger","Satisfaça seus desejos com nosso suculento Cheese Burger. \n" +
                "Feito com hambúrguer 100% Angus e coberto com\n" +
                " queijo cheddar derretido, alface fresca, tomate e\n" +
                " nosso molho secreto, esse hambúrguer clássico vai deixar você\n" +
                " querendo mais. Servido com fritas crocantes e uma bebida,\n" +
                " é a refeição perfeita para qualquer ocasião.","fast_1",15,20,120,4));
        items.add(new FoodDomain("Pizza Peperoni","Experimente a Itália com nossa deliciosa Pizza de Calabresa. Feita com massa recém-enrolada, molho de tomate picante, queijo mussarela e coberta com fatias de calabresa picante, esta pizza certamente agradará a todos. Perfeitamente assada em forno a lenha forno, é a escolha perfeita para um almoço rápido ou um jantar em família."
                ,"fast_2",10,25,200,5));
        items.add(new FoodDomain("Pizza Vegetal","Procurando uma opção mais saudável? Experimente nossa Pizza de Legumes, feita com uma variedade de vegetais frescos, como pimentões, cebolas, cogumelos, azeitonas e tomates. Coberta com queijo mussarela e molho de tomate picante, esta pizza é cheia de sabor e bondade. Perfeito para vegetarianos e qualquer pessoa que queira adicionar mais verduras à sua dieta."
                ,"fast_3",13,30,100,4.5));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }
}