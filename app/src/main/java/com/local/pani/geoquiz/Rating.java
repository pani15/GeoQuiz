package com.local.pani.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends AppCompatActivity {
    RatingBar valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        valor=(RatingBar) findViewById(R.id.rating);

        valor.setOnTouchListener(new View.OnTouchListener(){
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 Toast.makeText(Rating.this,"Has posat "+valor.getRating()+" punts al joc. Moltes gràcies",Toast.LENGTH_LONG).show();
                 return false;
             }
        });
    }
}
