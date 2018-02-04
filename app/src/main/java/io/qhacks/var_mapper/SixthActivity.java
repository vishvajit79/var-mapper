package io.qhacks.var_mapper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SixthActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Button button = findViewById(R.id.sixth_find_btn);
        final TextView textView = findViewById(R.id.sixth_storename_txt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FourthActivity.class);
                intent.putExtra("searchId", textView.getText().toString());
                startActivity(intent);
            }
        });
    }
}
