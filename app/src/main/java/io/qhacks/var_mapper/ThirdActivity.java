package io.qhacks.var_mapper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.qhacks.var_mapper.database.DatabaseHelper;

public class ThirdActivity extends Activity {
    private TextView name;
    private TextView description;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    int mallId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        name = findViewById(R.id.third_mallname_txt);
        description = findViewById(R.id.third_description_txt);
        Intent intent  = getIntent();
        mallId = intent.getIntExtra("mallId", 0);
        databaseHelper = new DatabaseHelper(ThirdActivity.this);
        sqLiteDatabase = databaseHelper.getWritableDatabase();

        //retrieves data from database
        Cursor cursor = null ;
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM map WHERE _id = '" + mallId + "'", null);

        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                name.setText(cursor.getString(1));
                description.setText("\n\n\n\n " +
                        "Description : " + cursor.getString(2) + "\n\n\n" +
                        " Location : " + cursor.getString(3) + "\n\n\n" +
                        " Store Count : " + cursor.getString(4) + "\n\n\n");
            }
        }
    }
}
