package com.local.pani.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class pistaActivity extends AppCompatActivity {
    TextView mPista;
    ImageView mFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista);

        mPista = (TextView) findViewById(R.id.pista);
        mFoto = (ImageView) findViewById(R.id.fotoPista);


        mPista.setText(R.string.vigila);

        //mPista.setOnClickListener fa que es pugui premer a sobre del TextView, ja que és del mateix tipus(View)
        mPista.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPista.setText(getIntent().getIntExtra("num_pista",0));
                mFoto.setImageResource(getIntent().getIntExtra("nFoto",0));
            }
        }));
        setResult(RESULT_OK);
    }
}
