package com.local.pani.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ImageButton mCert, mFals;
    int punt = 0;
    int PETICIO_PISTA=0;
    TextView tv_punt;
    TextView ultim;
    TextView pre;
    private ImageButton mPista;
    int num_pregunta=0;

    private Test [] canvi = new Test[] {
            new Test(R.string.P1, true,R.string.pista1,R.drawable.pistabcn),
            new Test(R.string.P2, false,R.string.pista2,R.drawable.pistasevilla),
            new Test(R.string.P3, true,R.string.pista3,R.drawable.pistamadrid),
            new Test(R.string.P4, true,R.string.pista4,R.drawable.pistagasol),
            new Test(R.string.P5, false,R.string.pista5,R.drawable.pistabetis),
    };

    //mPregunta



    private void ComprovarResposta(boolean Boto) {
        if (Boto == canvi[num_pregunta].getResposta()) {
            Toast.makeText(MainActivity.this, "Has encertat", Toast.LENGTH_SHORT).show();
            punt = punt + 5;
            tv_punt.setText(Integer.toString(punt));
            num_pregunta++;
            if (num_pregunta>=canvi.length){
                Intent val = new Intent(MainActivity.this,Rating.class);
                startActivity(val);            }else{
                ActualitzarPregunta(num_pregunta);
            }
        } else {
            Toast.makeText(MainActivity.this, "Has fallat", Toast.LENGTH_SHORT).show();
            punt = punt - 3;
            tv_punt.setText(Integer.toString(punt));
            num_pregunta++;
            if (num_pregunta>=canvi.length){
                Intent val = new Intent(MainActivity.this,Rating.class);
                startActivity(val);
            }else{
                ActualitzarPregunta(num_pregunta);
            }
        }
    }
    private void ActualitzarPregunta(int num_pregunta){

        pre.setText(canvi[num_pregunta].getId_pregunta());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PETICIO_PISTA){
            if (resultCode == RESULT_OK){
                punt = punt-2;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Associo la "vista" amb el "java"
        "li explico a la classe java quin nom té cada botó*/

        mCert = (ImageButton) findViewById(R.id.B_cert);
        mFals = (ImageButton) findViewById(R.id.B_fals);
        tv_punt = (TextView) findViewById(R.id.puntnum);
        pre = (TextView) findViewById(R.id.pregunta);
        ultim = (TextView) findViewById(R.id.ultima);
        mPista = (ImageButton) findViewById(R.id.B_pista);

        if (savedInstanceState!=null){
            num_pregunta=savedInstanceState.getInt("nPregunta",0);
            punt=savedInstanceState.getInt("Puntuacio",0);
        }

        ActualitzarPregunta(num_pregunta);
        //Metodes pels botons
        mCert.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComprovarResposta(true);
                //PuntuarResposta(true,punt);
                /*if(pregunta1.getResposta() == true){
                    Toast.makeText(MainActivity.this,"Has encertat",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Has fallat",Toast.LENGTH_SHORT).show();
                }*/
                //Aqui hi va la resposta quan s'apreta el boto
                //Toast.makeText(MainActivity.this, "Has premut CERT", Toast.LENGTH_SHORT).show();
            }
        }));
        mFals.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComprovarResposta(false);
                //PuntuarResposta(false,punt);
               /*if(pregunta1.getResposta() == false){
                    Toast.makeText(MainActivity.this,"Has encertat",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Has fallat",Toast.LENGTH_SHORT).show();
                }*/
                //Aqui hi va la resposta quan s'apreta el boto
                //Toast.makeText(MainActivity.this, "Has premut FALS", Toast.LENGTH_SHORT).show();
            }
        }));
        mPista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PISTA = new Intent(MainActivity.this,pistaActivity.class);
                PISTA.putExtra("num_pista",canvi[num_pregunta].getId_pista());
                PISTA.putExtra("nFoto",canvi[num_pregunta].getId_fpista());
                startActivityForResult(PISTA,PETICIO_PISTA);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("nPregunta",num_pregunta);
        outState.putInt("Puntuacio",punt);
    }
    //public  void onSaveInstanceState(Bundle savedInstanceState){

}
