package br.com.redewsouza.qrcodeteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Pega codigo
        String result = this.getIntent().getStringExtra("result");

        //Insere no txt
        txtResult = (TextView) findViewById(R.id.txt_result);
        txtResult.setText(result);

    }
}
