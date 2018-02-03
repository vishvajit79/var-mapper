package io.qhacks.var_mapper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.qhacks.var_mapper.database.DatabaseHelper;

public class SecondActivity extends Activity {
    private ListView listView;
    private TextView textView;
    private Button button;
    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;
    private ListView searchList;
    private ArrayList<String> arrayList;
    private ArrayList<Integer> idList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        searchList = findViewById(R.id.second_searchresult_lv);
        button = findViewById(R.id.second_search_btn);
        textView = findViewById(R.id.second_search_txt);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);

        idList = new ArrayList<Integer>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = null ;
                cursor = sqLiteDatabase.rawQuery("select * from map where name LIKE '" + textView.getText()
                        + "'", null);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                searchList.setAdapter(adapter);
                adapter.clear();
                if (cursor.getCount() != 0) {
                    while (cursor.moveToNext()) {
                        // adds data to listview
                        idList.add(cursor.getInt(0));
                        arrayList.add(cursor.getString(1) + " - " + cursor.getString(2));
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(SecondActivity.this, "No results for given data", Toast.LENGTH_LONG).show();

                }

                searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                        intent.putExtra("mallId", idList.get(i));
                        startActivity(intent);
                    }
                });
            }
        });


    }
}
