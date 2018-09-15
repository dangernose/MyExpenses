package com.suresh.expensesapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ViewPager expensesViewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Object layouts;
    private ImageButton buttonaddexpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        buttonaddexpenses = (ImageButton) findViewById(R.id.btn_addexpenses);

        navigationView.inflateMenu(R.menu.nav_menu);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        buttonaddexpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddExpenseActivity.class));
            }
        });

        expensesViewPager = (ViewPager) findViewById(R.id.viewpager_expenses);

        expensesViewPager.setAdapter(viewPagerAdapter);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navemenuitem_customize_categories:
                startActivity(new Intent(MainActivity.this,CategoriesActivity.class));
                break;

        }
        return false;
    }

    private class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return false;
        }
    }
}
