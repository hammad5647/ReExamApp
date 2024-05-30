package com.example.reexamapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reexamapp.activities.ShoeDetailActivity;
import com.example.reexamapp.adapters.RecyclerShoesAdapter;
import com.example.reexamapp.databinding.ActivityMainBinding;
import com.example.reexamapp.interfaces.ShoeInterface;
import com.example.reexamapp.models.ShoesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<ShoesModel> shoesList = new ArrayList<>();
    ShoeInterface shoeInterface;

    public  static List<ShoesModel> shoesList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shoesList.add(new ShoesModel(R.drawable.shoe1,"Armani  Formal","Price: $120.00","Size : UK 43 "));
        shoesList.add(new ShoesModel(R.drawable.shoe2,"Chelsea  Formal","Price: $403.00","Size : UK 42 "));
        shoesList.add(new ShoesModel(R.drawable.shoe10,"ActionMan Formal","Price: $1288.00","Size : UK 42 "));
        shoesList.add(new ShoesModel(R.drawable.shoe8,"Levis  Formal","Price: $2610.00","Size : UK 44 "));
        shoesList.add(new ShoesModel(R.drawable.shoe9,"Cazzi Formal","Price: $4560.00","Size : UK 42 "));
        shoesList.add(new ShoesModel(R.drawable.shoe6,"Menestal  Formal","Price: $150.00","Size : UK 41 "));
        shoesList.add(new ShoesModel(R.drawable.shoe7,"RedCarp  Formal","Price: $146.00","Size : UK 44 "));
        shoesList.add(new ShoesModel(R.drawable.shoe3,"Elizea Formal","Price: $1561.00","Size : UK 41 "));
        shoesList.add(new ShoesModel(R.drawable.shoe4,"Casual Formal","Price : $465.00","Size : UK 44 "));
        shoesList.add(new ShoesModel(R.drawable.shoe5,"Gamelle Formal","Price : $3510.00","Size : UK 45 "));

        shoeInterface =  new ShoeInterface() {
            @Override
            public void onClick(ShoesModel s1, int position) {
                Intent intent =  new Intent(MainActivity.this, ShoeDetailActivity.class);
                intent.putExtra("shoe_image",s1.shoeImage);
                intent.putExtra("shoe_name",s1.shoeName);
                intent.putExtra("shoe_price",s1.shoePrice);
                intent.putExtra("shoe_size",s1.shoeSize);
                startActivity(intent);

            }
        };
        RecyclerShoesAdapter adapter = new RecyclerShoesAdapter(this, shoesList,shoeInterface);
        binding.shoesRecyclerView.setAdapter(adapter);
    }
}