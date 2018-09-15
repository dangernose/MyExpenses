package com.suresh.expensesapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderCategory extends RecyclerView.ViewHolder {

    public ImageView getCategoryImage() {
        return categoryImage;
    }

    public TextView getCategoryName() {
        return categoryName;
    }

    public TextView getCategoryNoofExpenses() {
        return categoryNoofExpenses;
    }

    ImageView categoryImage;
    TextView categoryName;
    TextView categoryNoofExpenses;

    public ViewHolderCategory(@NonNull View itemView) {
        super(itemView);

        categoryImage = itemView.findViewById(R.id.viewholder_category_image);
        categoryName = itemView.findViewById(R.id.viewholder_category_name);
        categoryNoofExpenses = itemView.findViewById(R.id.viewholder_no_of_expenses);
    }
}
