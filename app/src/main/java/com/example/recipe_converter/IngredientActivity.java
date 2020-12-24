package com.example.recipe_converter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class IngredientActivity extends AppCompatActivity {

    private IngredientAdapter mAdapter;
    private double[] amounts = new double[] {1, 1, .5, 2, 1, 1, 2, 2, 2.5, 1.5};
    private String[] units = new String[] {"cup(s)", "cups(s)", "cup(s)", "teaspoon(s)", "teaspoon(s)", "teaspoon(s)", "extra large", "tablespoons", "cups(s)", "cups(s)"};
    private String[] ingredients = new String[] { "oil", "brown sugar", "white sugar", "vanilla", "baking soda", "salt", "eggs", "corn starch", "flour", "chocolate chips"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        double factor = getFactor();
        setupRV(factor);
    }

    private double getFactor() {
        Bundle incomingData = getIntent().getExtras();
        return incomingData == null ? 1 : incomingData.getDouble("FACTOR");
    }

    private void setupRV(double factor) {
        RecyclerView recyclerView = findViewById(R.id.ingredientsView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        IngredientAdapter ingredientAdapter = new IngredientAdapter(factor, amounts, units, ingredients);
        recyclerView.setAdapter(ingredientAdapter);
    }
}