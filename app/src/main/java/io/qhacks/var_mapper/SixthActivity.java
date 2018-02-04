package io.qhacks.var_mapper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SixthActivity extends Activity {
    private String[] names = {"Avanade", "Deloitte", "eSight", "IBM", "iGAN", "Microsoft", "MLH", "RL", "stdlib", "TD", "Telus", "you.i", "xesto"};
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Button button = findViewById(R.id.sixth_find_btn);
        textView = findViewById(R.id.sixth_storename_txt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FourthActivity.class);
                intent.putExtra("searchId", textView.getText().toString());
                startActivity(intent);
//                if (!checkNames()){
//                    Intent intent = new Intent(view.getContext(), FourthActivity.class);
//                    intent.putExtra("searchId", textView.getText().toString());
//                    startActivity(intent);
//                }
//                else {
//                    Toast.makeText(SixthActivity.this, "Store not found. Please try again.", Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }

    private boolean checkNames(){
        for(String item : names){
            if(item.equals(((TextView) textView.getText()).toString())){
                Log.d("array--------------------", item);
                Log.d("text-------------------", textView.getText().toString().toLowerCase());
                return false;
            }
        }
        return true;
    }
}
