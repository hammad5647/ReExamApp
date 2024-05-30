package com.example.reexamapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reexamapp.R;
import com.example.reexamapp.databinding.ShoesSampleBinding;
import com.example.reexamapp.interfaces.ShoeInterface;
import com.example.reexamapp.models.ShoesModel;

import java.util.List;

public class RecyclerShoesAdapter extends RecyclerView.Adapter<RecyclerShoesAdapter.ShoesViewHolder> {
    Context context;
    List<ShoesModel> shoeList;
    ShoeInterface shoeInterface;
    public RecyclerShoesAdapter(Context context, List<ShoesModel> shoeList, ShoeInterface shoeInterface){
        this.context = context;
        this.shoeList = shoeList;
        this.shoeInterface = shoeInterface;
    }
    @NonNull
    @Override
    public ShoesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.shoes_sample,parent,false);
        return new ShoesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoesViewHolder holder, int position) {
        holder.binding.shoeName.setText(shoeList.get(position).shoeName);
        holder.binding.shoePrice.setText(shoeList.get(position).shoePrice);
        holder.binding.shoeImage.setImageResource(shoeList.get(position).shoeImage);
        holder.binding.shoePrice.setText(shoeList.get(position).shoePrice);

        holder.binding.viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoeInterface.onClick(shoeList.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoeList.size();
    }

    public class ShoesViewHolder extends RecyclerView.ViewHolder {

        ShoesSampleBinding binding;
        public ShoesViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ShoesSampleBinding.bind(itemView);
        }
    }
}
