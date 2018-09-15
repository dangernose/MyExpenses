package com.suresh.expensesapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExpensesListActivity extends AppCompatActivity {
    List<Category> categoriesList;
    private RecyclerView recyclerView;
    CategoryListAdapter categoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_categories_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        categoryListAdapter = new CategoryListAdapter(getApplicationContext(), categoriesList);
        recyclerView.setAdapter(categoryListAdapter);
    }

    private class CategoryListAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
        List<Category> categories;
        public CategoryListAdapter(Context context, List<Category> categories) {
        }

        @NonNull
        @Override
        public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.viewholder_category,viewGroup,false);
            CategoryViewHolder viewHolder = new CategoryViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryViewHolder holder, int i) {
            holder.category_image.setImageResource(categories.get(i).getCategoryicon());
            holder.category_name.setText(categories.get(i).getCategoryName());
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView category_image;
        TextView category_name;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.category_image = (ImageView) itemView.findViewById(R.id.viewholder_category_image);
            this.category_name = (TextView) itemView.findViewById(R.id.viewholder_category_name);
        }
    }
}
