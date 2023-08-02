package com.example.liquidacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Liquidacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidacion);

        Button terminar = findViewById(R.id.terminar);
        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Liquidacion.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String nombres = extras.getString("nombres");
            String apellidos = extras.getString("apellidos");
            String cargo = extras.getString("cargo");
            String nombreCompleto = nombres + " " + apellidos;
            int sueldoBase = extras.getInt("sueldoBase", 0);
            int diasLaborados = extras.getInt("diasLaborados", 0);
            boolean tieneDescuento = extras.getBoolean("tieneDescuento");
            boolean tieneSalud = extras.getBoolean("tieneSalud");
            boolean tienePension = extras.getBoolean("tienePension");


            TextView nombresApellidosTextView = findViewById(R.id.nombresApellidosTextView);
            TextView cargoTextView = findViewById(R.id.cargotextView);
            TextView sueldoBaseTextView = findViewById(R.id.sueldobasetextView);
            TextView diasLaboradosTextView = findViewById(R.id.diaslabtextView);
            TextView salarioNetoTextView = findViewById(R.id.sueldonetotextView);


            nombresApellidosTextView.setText(nombreCompleto);
            cargoTextView.setText(cargo);
            sueldoBaseTextView.setText("Sueldo Base: " + sueldoBase);
            diasLaboradosTextView.setText("Días Laborados: " + diasLaborados);

            int valordia = sueldoBase/30;
            int valorbruto = valordia * diasLaborados;

            double descuentoSueldo = 0.0;
            if (tieneDescuento) {
                descuentoSueldo += valorbruto * 0.03;
            }
            if (tieneSalud) {
                descuentoSueldo += valorbruto * 0.04;
            }
            if (tienePension) {
                descuentoSueldo += valorbruto * 0.04;
            }
            double salarioNeto = valorbruto - descuentoSueldo;

            salarioNetoTextView.setText("Salario Neto: " + salarioNeto);
        }
    }
}