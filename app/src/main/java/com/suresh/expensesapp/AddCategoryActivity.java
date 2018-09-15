package com.suresh.expensesapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

public class AddCategoryActivity extends AppCompatActivity {

    DatabaseAdapter dbAdapter;
    EditText category_name;
    private int category_image;



    private Toolbar toolbar;
    private GridView gridView_icons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        dbAdapter = new DatabaseAdapter(getApplicationContext());
        TypedArray images_array;
        images_array = getResources().obtainTypedArray(R.array.category_icons);

        final int[] images = {
                R.drawable.icon01,
                R.drawable.icon02,
                R.drawable.icon03,
                R.drawable.icon04,
                R.drawable.icon05,
                R.drawable.icon06,
                R.drawable.icon07,
                R.drawable.icon08,
                R.drawable.icon09,
                R.drawable.icon10,
                R.drawable.icon11,
                R.drawable.icon12,
                R.drawable.icon13,
                R.drawable.icon14,
                R.drawable.icon15,
                R.drawable.icon16,
                R.drawable.icon17,
                R.drawable.icon19,
                R.drawable.icon20,
                R.drawable.icon21,
                R.drawable.icon22,
                R.drawable.icon23,
                R.drawable.icon24,
                R.drawable.icon25,
                R.drawable.icon26,
                R.drawable.icon27,
                R.drawable.icon28,
                R.drawable.icon29,
                R.drawable.icon30,
                R.drawable.icon31,
                R.drawable.icon32,
                R.drawable.icon33,
                R.drawable.icon34,
                R.drawable.icon35,
                R.drawable.icon36,
                R.drawable.icon37,
                R.drawable.icon38,
                R.drawable.icon39,
                R.drawable.icon40,
                R.drawable.icon41,
                R.drawable.icon42,
                R.drawable.icon43,
                R.drawable.icon44,
                R.drawable.icon45,
                R.drawable.icon46,
                R.drawable.icon47,
                R.drawable.icon48,
                R.drawable.icon49,
                R.drawable.icon50,
                R.drawable.icon51,
                R.drawable.icon52,
                R.drawable.icon53,
                R.drawable.icon54,
                R.drawable.icon55,
                R.drawable.icon56
        };

        toolbar = (Toolbar) findViewById(R.id.toolbar_add_category);

        category_name = (EditText) findViewById(R.id.edittext_category_name);
        gridView_icons = (GridView) findViewById(R.id.addcategory_gridview_imagelist);
        category_image = R.drawable.icon01;
        setSupportActionBar(toolbar);

        gridView_icons.setAdapter(new ImageAdapter(this,images));
        gridView_icons.setChoiceMode(GridView.CHOICE_MODE_SINGLE);
        gridView_icons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
                ImageView imageView = (ImageView) gridView_icons.getAdapter().getItem(position);
                imageView.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

            }
        });

        category_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(category_name.getText())){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_addcategory_save,menu);
//        menu.findItem(R.menu.menu_addcategory_save).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_addcategory_save:
                long x = dbAdapter.insertCategory(category_name.getText().toString(),category_image);
                Toast.makeText(getApplicationContext(),String.valueOf(x),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ImageAdapter extends BaseAdapter {
        ImageView imageView;
        Context context;
        int[] icons;
        public ImageAdapter(Context context, int[] icons) {
            this.context = context;
            this.icons = icons;
        }

        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int position) {
//            imageView
            return imageView;
        }

        @Override
        public long getItemId(int position) {
            return icons[position];
        }

        @Override
        public View getView(final int position, View parentview, ViewGroup parent) {
            imageView = new ImageView(context);
            if(parentview == null){
                imageView.setLayoutParams(new GridView.LayoutParams(120,120));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(4,4,4,4);
            }else {
                imageView = (ImageView) parentview;
            }
            imageView.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
            imageView.setImageResource(icons[position]);
            return imageView;

        }
    }
}
