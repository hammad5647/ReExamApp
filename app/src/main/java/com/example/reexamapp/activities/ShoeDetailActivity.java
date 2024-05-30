package com.example.reexamapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reexamapp.MainActivity;
import com.example.reexamapp.R;
import com.example.reexamapp.databinding.ActivityShoeDetailBinding;
import com.example.reexamapp.models.ShoesModel;

public class ShoeDetailActivity extends AppCompatActivity {
    ActivityShoeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int shoe_image = getIntent().getIntExtra("shoe_image",0);
        String shoe_name = getIntent().getStringExtra("shoe_name");
        String shoe_price = getIntent().getStringExtra("shoe_price");

        String shoe_size = getIntent().getStringExtra("shoe_size");

        binding.detailShoeImage.setImageResource(shoe_image);
        binding.detailShoeName.setText(shoe_name);
        binding.detailShoeSize.setText(shoe_size);
        binding.detailShoePrice.setText(shoe_price);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.shoesList1.add(new ShoesModel(shoe_image, shoe_name, shoe_price, shoe_size));
                Toast.makeText(ShoeDetailActivity.this,"Added To Cart",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}