package com.example.recipe_converter;

import android.os.Build;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private double[] amounts;
    private String[] units;
    private String[] ingredients;

    public IngredientAdapter(double factor, double[] amounts, String[] units, String[] ingredients) {
        this.amounts = amounts;
        this.ingredients = ingredients;
        this.units = units;
        for (int i = 0; i < amounts.length; i++) {
            this.amounts[i] = amounts[i] * factor;
        }
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Make one "tile"; this will be called once per number of visible tiles on screen
        View itemView = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.rv_item, parent, false);

        return new IngredientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.tv_amount.setText(""+amounts[position]);
        holder.tv_unit.setText(units[position]);
        holder.tv_description.setText(ingredients[position]);
    }

    @Override
    public int getItemCount() {
        return amounts.length;
    }

}
