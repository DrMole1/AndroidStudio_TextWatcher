package com.example.newbasicapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

// Ne pas oublier d'implémenter cette importation pour les boutons, obligatoire pour chaque
// widget que l'on souhaite implémenté
import android.widget.Button;
// Importation des toasts, tout frais tout chauds
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On attribue notre view au layout de la activity_main
        setContentView(R.layout.activity_main);

        //On affecte la variable button grâce à l'id
        mButton = (Button) findViewById(R.id.myButton);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Pour écrire dans le logcat
        Log.d("activity_main","Hello World");

        //Affichage de courte durée
        Toast.makeText(getApplicationContext(), "ceci est un court message", Toast.LENGTH_SHORT).show();
        //Affichage de longue durée
        Toast.makeText(getApplicationContext(), "ceci est un long message", Toast.LENGTH_LONG).show();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Lorsqu'on clique sur le bouton, affichage dans le logcat
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("activity_main","clic");
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
