package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class InicioActivity extends AppCompatActivity {
    private Button play;
    private  Button Cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        play = (Button) findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onClick = new Intent(InicioActivity.this, PreguntasActivity.class);
                startActivity(onClick);
            }
        });

        Cerrar = (Button) findViewById(R.id.btnSalir1);
        Cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent volver = new Intent(InicioActivity.this, MainActivity.class);
                // limpia la pila: si no, BACK recorre pantallas muertas y el
                // AuthStateListener de la MainActivity vieja rebota a Inicio otra vez
                volver.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(volver);
            }
        });
    }
}
