package com.example.darshan.foodude.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darshan.foodude.Interface.itemClickListener;
import com.example.darshan.foodude.R;

/**
 * Created by darshan on 28/3/18.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView food_name;
    public ImageView food_image;

    private com.example.darshan.foodude.Interface.itemClickListener itemClickListener;

    public void setItemClickListener(com.example.darshan.foodude.Interface.itemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(View itemView) {
        super(itemView);
        food_name = (TextView) itemView.findViewById(R.id.food_name);
        food_image = (ImageView) itemView.findViewById(R.id.food_image); // they used imageView instead of menu_image
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
