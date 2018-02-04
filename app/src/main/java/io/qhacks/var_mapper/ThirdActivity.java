package io.qhacks.var_mapper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.qhacks.var_mapper.database.DatabaseHelper;

public class ThirdActivity extends Activity {
    private TextView name;
    private TextView description;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    private Button button;
    int mallId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button = findViewById(R.id.download_btn);

        name = findViewById(R.id.third_mallname_txt);
        description = findViewById(R.id.third_description_txt);
        Intent intent  = getIntent();
        mallId = intent.getIntExtra("mallId", 0);
        databaseHelper = new DatabaseHelper(ThirdActivity.this);
        sqLiteDatabase = databaseHelper.getWritableDatabase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this, "Map is now added to the database", Toast.LENGTH_SHORT).show();
            }
        });
        //retrieves data from database
        Cursor cursor = null ;
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM map WHERE _id = '" + mallId + "'", null);

        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                name.setText(cursor.getString(1));
                description.setText("\n " +
                        "Description : " + cursor.getString(2) + "\n" +
                        " Location : " + cursor.getString(3) + "\n" +
                        " Store Count : " + cursor.getString(4) + "\n");
            }
        }
    }
}
