package com.example.recipe_converter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class IngredientViewHolder extends RecyclerView.ViewHolder {

    TextView tv_amount;
    TextView tv_unit;
    TextView tv_description;

    public IngredientViewHolder(View itemView){
        super(itemView);
        tv_amount = itemView.findViewById(R.id.ingredient_amount);
        tv_unit = itemView.findViewById(R.id.ingredient_unit);
        tv_description = itemView.findViewById(R.id.ingredient_description);
    }
}
