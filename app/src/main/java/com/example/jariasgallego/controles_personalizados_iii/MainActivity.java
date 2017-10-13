package com.example.jariasgallego.controles_personalizados_iii;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Canvas;


public class MainActivity extends AppCompatActivity {

    private Button btnFicha;
    private TresEnRaya terTablero;
    private TextView txtCasilla;
    private Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        terTablero = (TresEnRaya) findViewById(R.id.tablero);
        btnFicha = (Button) findViewById(R.id.btnFicha);
        txtCasilla = (TextView) findViewById(R.id.txtCasilla);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btnFicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terTablero.alternarFichaActiva();
            }
        });

        terTablero.setOnCasillaSeleccionadaListener(new onCasillaSeleccionadaListener() {
            @Override
            public void onCasillaSeleccionada(int fila, int columna) {
                txtCasilla.setText("Última casilla seleccionada: " + fila + "." + columna);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terTablero.limpiar();
                terTablero.invalidate();
            }
        });
    }

}









