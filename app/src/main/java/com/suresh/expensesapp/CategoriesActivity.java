package com.suresh.expensesapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    CategoryRecyclerAdapter categoryRecyclerAdapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        toolbar = (Toolbar) findViewById(R.id.toolbar_categories);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_categories_list);

        List<Category> categories = new ArrayList<>();
//        categories.add(new Category("General","9",""));
//        categories.add(new Category("Food","8",""));

        layoutManager =  new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);

        categoryRecyclerAdapter = new CategoryRecyclerAdapter(getApplicationContext(),categories);

        recyclerView.setAdapter(categoryRecyclerAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_category_add,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_category_add:
                startActivity(new Intent(CategoriesActivity.this,AddCategoryActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class CategoryRecyclerAdapter extends RecyclerView.Adapter<ViewHolderCategory> {
        Context context;
        List<Category> categories;

        public CategoryRecyclerAdapter(Context context, List<Category> categories) {
            this.context = context;
            this.categories = categories;
        }

        @NonNull
        @Override
        public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.viewholder_category,viewGroup,false);
            ViewHolderCategory viewHolder = new ViewHolderCategory(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderCategory viewHolderCategory, int i) {
            viewHolderCategory.getCategoryName().setText(categories.get(i).getCategoryName());
//            viewHolderCategory.getCategoryNoofExpenses().setText(categories.get(i).getCategoryNoofExpenses()+" Expenses");

        }

        @Override
        public int getItemCount() {
            return categories.size();
        }
    }
}
