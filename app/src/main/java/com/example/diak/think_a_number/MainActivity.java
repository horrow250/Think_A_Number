package com.example.diak.think_a_number;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_plus, btn_minus, btn_send;
    private TextView number;
    private ImageView imgV_health1, imgV_health2, imgV_health3, imgV_health4, imgV_health5;
    private int szam = 0;
    private int kitalalando_szam = 0;

    private AlertDialog.Builder alert_vege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        alert_vege = new AlertDialog.Builder(MainActivity.this);

        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(20)+1;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (szam < 20) {
                    szam++;
                }
                number.setText(""+szam);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(szam >0) {
                    szam--;
                }
                number.setText("" + szam);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (szam == kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Nyertél!", Toast.LENGTH_SHORT).show();
                    alert_vege.setTitle("Gratulálok nyertél!")
                            .setMessage("Szeretnél újra játszani?")
                            .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    new_game();
                                }
                            })
                            .setCancelable(false)
                            .create();
                    alert_vege.show();

                } else if (szam > kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Lejjebb!", Toast.LENGTH_SHORT).show();
                    if (imgV_health1.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {  //imgV_health1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.heart2).getConstantState()
                        imgV_health1.setImageResource(R.drawable.heart1);
                    } else if (imgV_health2.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {
                        imgV_health2.setImageResource(R.drawable.heart1);
                    } else if (imgV_health3.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {
                        imgV_health3.setImageResource(R.drawable.heart1);
                    } else if (imgV_health4.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {
                        imgV_health4.setImageResource(R.drawable.heart1);
                    } else {
                        imgV_health5.setImageResource(R.drawable.heart1);
                    }
                } else if (szam < kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Feljebb!", Toast.LENGTH_SHORT).show();
                    if (imgV_health1.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {  //imgV_health1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.heart2).getConstantState()
                        imgV_health1.setImageResource(R.drawable.heart1);
                    } else if (imgV_health2.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {
                        imgV_health2.setImageResource(R.drawable.heart1);
                    } else if (imgV_health3.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {
                        imgV_health3.setImageResource(R.drawable.heart1);
                    } else if (imgV_health4.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.heart1).getConstantState()) {
                        imgV_health4.setImageResource(R.drawable.heart1);
                    } else {
                        imgV_health5.setImageResource(R.drawable.heart1);
                    }

                    /*if (imgV_health1 == (ImageView) findViewById(R.id.imageView_heart1)) {
                        imgV_health1.setImageResource(R.drawable.heart1);
                    } else if (imgV_health2 == (ImageView) findViewById(R.id.imageView_heart2)) {
                        imgV_health2.setImageResource(R.drawable.heart1);
                    } else if (imgV_health3 == (ImageView) findViewById(R.id.imageView_heart3)) {
                        imgV_health3.setImageResource(R.drawable.heart1);
                    } else if (imgV_health4 == (ImageView) findViewById(R.id.imageView_heart4)) {
                        imgV_health4.setImageResource(R.drawable.heart1);
                    } else {
                        imgV_health5.setImageResource(R.drawable.heart1);
                    }*/
                }
            }
        });
    }
    public void init(){
        btn_plus = (Button)findViewById(R.id.button_plus);
        btn_minus = (Button)findViewById(R.id.button_minus);
        btn_send = (Button)findViewById(R.id.button_send);

        number = (TextView) findViewById(R.id.textView_szam);
        imgV_health1 = (ImageView) findViewById(R.id.imageView_heart1);
        imgV_health2 = (ImageView) findViewById(R.id.imageView_heart2);
        imgV_health3 = (ImageView) findViewById(R.id.imageView_heart3);
        imgV_health4 = (ImageView) findViewById(R.id.imageView_heart4);
        imgV_health5 = (ImageView) findViewById(R.id.imageView_heart5);
    }

    public void new_game(){
        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(20)+1;
        szam = 0;
        number.setText("" + szam);
    }

}
