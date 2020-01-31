package com.example.textwatcher;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import android.text.TextWatcher;
import android.text.Editable;

import android.graphics.Color;

import android.app.Activity;


public class MainActivity extends Activity implements TextWatcher{

    // Déclaration des variables
    // ==========================================
    private static int NBMAXCHAR = 20;
    private int nbCar_Restants = 20;

    private Button btnSend;
    private TextView msgInfo;
    private EditText msgWriter;
    // ==========================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        // On affecte les différents widgets
        msgWriter = (EditText) findViewById(R.id.input);
        msgInfo = (TextView) findViewById(R.id.textViewInfo);
        btnSend = (Button) findViewById(R.id.btnSend);
        msgWriter.addTextChangedListener(this);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), msgWriter.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    @Override
    public void afterTextChanged(Editable s) {
        if(msgWriter.getText().toString().length() <= NBMAXCHAR)
        {
            nbCar_Restants = (NBMAXCHAR - msgWriter.getText().toString().length());
            msgInfo.setText("Caractères restants : " + nbCar_Restants);
            //Utiliser les values ici est impossible
            msgInfo.setTextColor(Color.GREEN);
            btnSend.setEnabled(true);
        }
        else
        {
            nbCar_Restants = (NBMAXCHAR - msgWriter.getText().toString().length()) * -1;
            msgInfo.setText("Caractères en trop : " + nbCar_Restants);
            msgInfo.setTextColor(Color.RED);
            btnSend.setEnabled(false);
        }
    }
}
