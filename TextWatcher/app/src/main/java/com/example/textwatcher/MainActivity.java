package com.example.textwatcher;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.text.TextWatcher;
import android.text.Editable;

import android.graphics.Color;
//import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private final static int NBMAXCHAR = 20;
    private int nbCar_Restants = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // On affecte les différents widgets
        final TextView msgWriter = findViewById(R.id.input);
        final TextView msgInfo = findViewById(R.id.textViewInfo);
        final Button btnSend = findViewById(R.id.btnSend);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        msgWriter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This is where we'll check the user input
            }

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
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), msgWriter.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
