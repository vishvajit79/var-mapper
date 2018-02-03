package io.qhacks.var_mapper.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishv on 2/3/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int sqLiteDatabase_VERSION = 1;
    private static final String DATABASE_NAME = "database";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, sqLiteDatabase_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MAP");
        updateMyDatabase(sqLiteDatabase);
    }

    private void updateMyDatabase(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE map (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT," +
                " description TEXT," +
                " location TEXT," +
                " storecount TEXT," +
                " file TEXT);");
        addNewMap(sqLiteDatabase, "QHacks", "Queen's University at Kingston", "99 University Ave, Kingston, ON K7L 3N6", "10","sponsor_bay.csv");
//        sqLiteDatabase.execSQL("INSERT INTO map ('name','description','location','storeCount','file') VALUES ('QHacks', 'Queen University at Kingston', '99 University Ave, Kingston, ON K7L 3N6', '10','sponsor_bay.csv');");
    }

    private void addNewMap(SQLiteDatabase sqLiteDatabase, String name, String description, String location, String storecount, String file){
        ContentValues insert = new ContentValues();
        insert.put("name", name);
        insert.put("description", description);
        insert.put("location", location);
        insert.put("storecount", storecount);
        insert.put("file", file);
        sqLiteDatabase.insert("map", null, insert);
    }

    public List<String> getAllMaps(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT * FROM MAP" ;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        sqLiteDatabase.close();

        // returning lables
        return labels;
    }
}
