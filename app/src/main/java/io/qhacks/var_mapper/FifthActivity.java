package io.qhacks.var_mapper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FifthActivity extends Activity {

    private Button liveBtn;
    private Button stillBtn;
    private TextView mallNameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        final Intent intent  = getIntent();

        liveBtn = findViewById(R.id.fifth_live_btn);
        stillBtn = findViewById(R.id.fifth_still_btn);

        liveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(), SixthActivity.class);
                startActivity(intent1);
            }
        });

        stillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(), SixthActivity.class);
                startActivity(intent1);
            }
        });
    }
}
