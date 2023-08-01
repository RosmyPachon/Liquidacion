package com.example.liquidacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Liquidacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidacion);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String nombres = extras.getString("nombres");
            String apellidos = extras.getString("apellidos");
            String cargo = extras.getString("cargo");

            int sueldoBase = extras.getInt("sueldoBase", 0);
            int diasLaborados = extras.getInt("diasLaborados", 0);

            boolean tieneDescuento = extras.getBoolean("tieneDescuento");
            boolean tieneSalud = extras.getBoolean("tieneSalud");
            boolean tienePension = extras.getBoolean("tienePension");

            double descuentoSueldo = 0.0;
            if (tieneDescuento) {
                descuentoSueldo += sueldoBase * 0.03;
            }
            if (tieneSalud) {
                descuentoSueldo += sueldoBase * 0.04;
            }
            if (tienePension) {
                descuentoSueldo += sueldoBase * 0.04;
            }

            double salarioNeto = sueldoBase - descuentoSueldo;

            String resultado = "Nombres: " + nombres +
                    "\nApellidos: " + apellidos +
                    "\nCargo: " + cargo +
                    "\nSueldo Base: " + sueldoBase +
                    "\nDías Laborados: " + diasLaborados +
                    "\nTiene Descuento: " + tieneDescuento +
                    "\nTiene Salud: " + tieneSalud +
                    "\nTiene Pensión: " + tienePension +
                    "\nDescuento Total: " + descuentoSueldo +
                    "\nSalario Neto: " + salarioNeto;

            TextView resultTextView = findViewById(R.id.textView14);
            resultTextView.setText(resultado);
        }
    }
}