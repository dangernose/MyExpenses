package com.suresh.expensesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.math.BigDecimal;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class DatabaseAdapter extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseAdpater";

    private static final String DATABASE_NAME = "expenses.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_CATEGORY = "table_category";
    private static final String CATEGORY_COL_1 = "categoryid";
    private static final String CATEGORY_COL_2 = "categoryname";
    private static final String CATEGORY_COL_3 = "categoryicon";

    private  static final String TABLE_EXPENSE = "table_expense";
    private  static final String EXPENSE_COL_1 = "expenseid";
    private  static final String EXPENSE_COL_2 = "expensename";
    private  static final String EXPENSE_COL_3 = "categoryid";
    private  static final String EXPENSE_COL_4 = "amount";

    private  static final String CREATE_TABLE_CATEGORY = "CREATE TABLE "+
            TABLE_CATEGORY + " (" +
            CATEGORY_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CATEGORY_COL_2 + " TEXT NOT NULL, " +
            CATEGORY_COL_3 + " TEXT NOT NULL " +
            " );";

    private  static final String CREATE_TABLE_EXPENSE = "CREATE TABLE "+
            TABLE_EXPENSE + " (" +
            EXPENSE_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            EXPENSE_COL_2 + " TEXT, " +
            EXPENSE_COL_3 + " LONG NOT NULL, " +
            EXPENSE_COL_4 + " LONG NOT NULL " +
            " );";

    public DatabaseAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_EXPENSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_EXPENSE);
        onCreate(db);

    }

    public long insertCategory(String categoryName, int categoryImage){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CATEGORY_COL_2,categoryName);
        values.put(CATEGORY_COL_3,categoryImage);
        long id = db.insert(TABLE_CATEGORY,null,values);
        db.close();
        return id;
    }

    public Category getCategory(long categoryid){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY + " WHERE "
                + CATEGORY_COL_1 + " = " + categoryid;

        Log.e(LOG, selectQuery);

//        Cursor c = db.query(TABLE_CATEGORY,)

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Category category = new Category(
                c.getInt(c.getColumnIndex(CATEGORY_COL_1)),
                c.getString(c.getColumnIndex(CATEGORY_COL_2)),
                c.getInt(c.getColumnIndex(CATEGORY_COL_3))
        );
//        category.setCategoryId(c.getInt(c.getColumnIndex(CATEGORY_COL_1)));
//        category.setCategoryName(c.getString(c.getColumnIndex(CATEGORY_COL_2)));
//        category.setCategoryicon(c.getInt(c.getColumnIndex(CATEGORY_COL_3)));
        return category;
    }

    public int updateCategory(int categoryid, String categoryname, String categoryicon ){
        SQLiteDatabase db = this.getWritableDatabase();
        //add values
        ContentValues values = new ContentValues();
        int result = db.update(
                TABLE_CATEGORY,
                values,
                CATEGORY_COL_1 + " = ?",
                new String[]{String.valueOf(categoryid)}
                );


        return result;
    }

    public int deleteCategory(int categoryid){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(
                TABLE_CATEGORY,
                CATEGORY_COL_1 + " = ?",
                new String[] {String.valueOf(categoryid)}
                );
    }

    public long insertExpenses(String expenseName, long categoryid, long amount ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXPENSE_COL_2,expenseName);
        values.put(EXPENSE_COL_3,categoryid);
        values.put(EXPENSE_COL_4,amount);
        long id = db.insert(TABLE_EXPENSE,null, values);
        return id;
    }

    public Expense getExpenses(long expensesid){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSE + " WHERE "
                + EXPENSE_COL_1 + " = " + expensesid;

        Log.e(LOG, selectQuery);

//        Cursor c = db.query(TABLE_CATEGORY,)

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Expense expense = new Expense(
                c.getLong(c.getColumnIndex(EXPENSE_COL_1)),
                c.getString(c.getColumnIndex(EXPENSE_COL_2)),
                c.getInt(c.getColumnIndex(EXPENSE_COL_3)),
                new BigDecimal(c.getLong(c.getColumnIndex(EXPENSE_COL_4)))
        );
//        category.setCategoryId(c.getInt(c.getColumnIndex(CATEGORY_COL_1)));
//        category.setCategoryName(c.getString(c.getColumnIndex(CATEGORY_COL_2)));
//        category.setCategoryicon(c.getInt(c.getColumnIndex(CATEGORY_COL_3)));
        return expense;
    }

    public int updageExpense(int categoryid, String categoryname, String categoryicon ){
        SQLiteDatabase db = this.getWritableDatabase();
        //add values
        ContentValues values = new ContentValues();
        int result = db.update(
                TABLE_CATEGORY,
                values,
                CATEGORY_COL_1 + " = ?",
                new String[]{String.valueOf(categoryid)}
        );


        return result;
    }

    public int deleteExpense(int categoryid){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(
                TABLE_CATEGORY,
                CATEGORY_COL_1 + " = ?",
                new String[] {String.valueOf(categoryid)}
        );
    }
}
