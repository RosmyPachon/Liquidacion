
package com.example.liquidacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText nombres = findViewById(R.id.nombresbox);
        EditText apellidos = findViewById(R.id.apellidobox);
        EditText cargo = findViewById(R.id.cargobox);
        EditText sueldoBase = findViewById(R.id.sueldobasebox);
        EditText diasLab = findViewById(R.id.diaslabbox);

        CheckBox descuento = findViewById(R.id.descuento);
        CheckBox salud = findViewById(R.id.salud);
        CheckBox pension = findViewById(R.id.pension);

        Button Liquidar = findViewById(R.id.Liquidar);
        Liquidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos ingresados en los EditText y CheckBox
                String nombresText = nombres.getText().toString();
                String apellidosText = apellidos.getText().toString();
                String cargoText = cargo.getText().toString();
                String sueldoBaseText = sueldoBase.getText().toString();
                String diasLabText = diasLab.getText().toString();

                boolean tieneDescuento = descuento.isChecked();
                boolean tieneSalud = salud.isChecked();
                boolean tienePension = pension.isChecked();


                int sueldoBase = Integer.parseInt(sueldoBaseText);
                int diasLaborados = Integer.parseInt(diasLabText);

                Intent intent = new Intent(Login.this, Liquidacion.class);

                intent.putExtra("nombres", nombresText);
                intent.putExtra("apellidos", apellidosText);
                intent.putExtra("cargo", cargoText);
                intent.putExtra("sueldoBase", sueldoBase);
                intent.putExtra("diasLaborados", diasLaborados);
                intent.putExtra("tieneDescuento", tieneDescuento);
                intent.putExtra("tieneSalud", tieneSalud);
                intent.putExtra("tienePension", tienePension);

                startActivity(intent);
            }
        });

        Button regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}