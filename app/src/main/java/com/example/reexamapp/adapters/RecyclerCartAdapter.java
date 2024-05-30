package com.example.reexamapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reexamapp.R;
import com.example.reexamapp.models.ShoesModel;

import java.util.List;

public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerCartAdapter.RecyclerViewHolder> {
    Context context;
    List<ShoesModel> shoesModelList;

    public RecyclerCartAdapter(Context context, List<ShoesModel> shoesModelList) {
        this.context = context;
        this.shoesModelList = shoesModelList;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_sample, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
