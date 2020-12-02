package com.example.formulariofi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.formulariofi.model.Alumno;

public class FormAccept extends AppCompatActivity {

    TextView nombreTV, cuentaTV, edadTV, carreraTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_accept);

        Bundle bundle = getIntent().getExtras();
        Alumno alumno;

        if (bundle != null){
            alumno = (Alumno) bundle.getSerializable("alumno");
            nombreTV = findViewById(R.id.nombreTV);
            cuentaTV = findViewById(R.id.cuentaTV);
            edadTV = findViewById(R.id.edadTV);
            carreraTV = findViewById(R.id.carreraTV);

            nombreTV.setText(alumno.getNombre() + " " + alumno.getApellidos());
            cuentaTV.setText(alumno.getNumCuenta());
            edadTV.setText(alumno.getEdad() + getString(R.string.anios));
            carreraTV.setText(alumno.getCarrera());

        }


    }
}