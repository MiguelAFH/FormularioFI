package com.example.formulariofi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.formulariofi.model.Alumno;

public class FormAccept extends AppCompatActivity {

    TextView nombreTV, cuentaTV, edadTV, carreraTV;
    ImageView carreraImg;

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

            carreraImg = findViewById(R.id.imgCarrera);

            if (alumno.getCarrera().equals(getString(R.string.aeroespacial))){
                carreraImg.setImageResource(R.drawable.aeroespacial_img);
            }else if (alumno.getCarrera().equals(getString(R.string.ambiental))){
                carreraImg.setImageResource(R.drawable.ambiental_img);
            }else if (alumno.getCarrera().equals(getString(R.string.civil))){
                carreraImg.setImageResource(R.drawable.civil_img);
            }else if (alumno.getCarrera().equals(getString(R.string.computacion))){
                carreraImg.setImageResource(R.drawable.computacion_img);
            }else if (alumno.getCarrera().equals(getString(R.string.electrica))){
                carreraImg.setImageResource(R.drawable.electrica_img);
            }else if (alumno.getCarrera().equals(getString(R.string.geofrisica))){
                carreraImg.setImageResource(R.drawable.geofisica_img);
            }else if (alumno.getCarrera().equals(getString(R.string.geologica))){
                carreraImg.setImageResource(R.drawable.geologica_img);
            }else if (alumno.getCarrera().equals(getString(R.string.geomatica))){
                carreraImg.setImageResource(R.drawable.geomatica_img);
            }else if (alumno.getCarrera().equals(getString(R.string.industrial))){
                carreraImg.setImageResource(R.drawable.industrial_img);
            }else if (alumno.getCarrera().equals(getString(R.string.mecanica))){
                carreraImg.setImageResource(R.drawable.mecanica_img);
            }else if (alumno.getCarrera().equals(getString(R.string.mecatronica))){
                carreraImg.setImageResource(R.drawable.mecatronica_img);
            }else if (alumno.getCarrera().equals(getString(R.string.minas))){
                carreraImg.setImageResource(R.drawable.minas_img);
            }else if (alumno.getCarrera().equals(getString(R.string.petrolera))){
                carreraImg.setImageResource(R.drawable.petrolera_img);
            }else if (alumno.getCarrera().equals(getString(R.string.biomedica))){
                carreraImg.setImageResource(R.drawable.biomedicos_img);
            }else if (alumno.getCarrera().equals(getString(R.string.telecom))){
                carreraImg.setImageResource(R.drawable.telecomunicaciones_img);
            }



        }


    }
}