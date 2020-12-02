package com.example.formulariofi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.formulariofi.model.Alumno;
import com.example.formulariofi.model.DatePickerFragment;

import java.text.DateFormat;
import java.time.chrono.ChronoPeriod;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Alumno alumno;
    EditText nombresText, apellidosText, numCuenta;
    TextView fechaText;
    Spinner carrera;
    Calendar fecha;
    Resources res;
    String[] carreras;
    int dia = 0, mes = 0, anio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton) findViewById(R.id.datePicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DialogFragment datePick = new DatePickerFragment();
                datePick.show(getSupportFragmentManager(), "date picker");
            }
        });

        nombresText = findViewById(R.id.nombresText);
        apellidosText = findViewById(R.id.apellidoText);
        numCuenta = findViewById(R.id.numCuenta);
        fechaText = findViewById(R.id.dateView);
        carrera = (Spinner) findViewById(R.id.carrerasSpinner);
        res = getResources();
        carreras = res.getStringArray(R.array.carrerasNames);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, year);
        fecha.set(Calendar.MONTH, month);
        fecha.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(fecha.getTime());

        fechaText.setText(currentDateString);
    }

    public void clic(View view) {

        if (validacion() == true){
            String nombre = nombresText.getText().toString();
            String apellidos = apellidosText.getText().toString();
            String nCuenta = numCuenta.getText().toString();
            String ingenieria = carrera.getSelectedItem().toString();
            alumno = new Alumno(nombre, apellidos, nCuenta, ingenieria, edadCalculo(fecha));

            Intent intent = new Intent(this, FormAccept.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("alumno", alumno);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        }


    }

    public int edadCalculo(Calendar fechaNacimiento){
        Calendar hoy = Calendar.getInstance();
        int diaHoy = hoy.get(Calendar.DAY_OF_MONTH), diaNacimiento = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        int mesHoy = hoy.get(Calendar.MONTH), mesNacimiento = fechaNacimiento.get(Calendar.MONTH);
        int anioHoy = hoy.get(Calendar.YEAR), anioNacimiento = fechaNacimiento.get(Calendar.YEAR);

        if ( (diaNacimiento > diaHoy && mesNacimiento == mesHoy) || (mesNacimiento > mesHoy)) {
            return anioHoy - anioNacimiento - 1;
        }else
            return anioHoy - anioNacimiento;


    }

    public boolean validacion(){
        boolean ok = true;
        if (nombresText.getText().toString().equals("")){
            nombresText.setError(getString(R.string.nombreError));
            ok = false;
        }

        if (apellidosText.getText().toString().equals("")){
            apellidosText.setError(getString(R.string.apellidoError));
            ok = false;
        }

        if (numCuenta.getText().toString().equals("") || numCuenta.getText().toString().length()!=9){
            numCuenta.setError(getString(R.string.numCuentaError));
            ok = false;
        }



        if (carrera.getSelectedItem().toString().equals(carreras[0])){
            Toast.makeText(this, getString(R.string.carreraError), Toast.LENGTH_SHORT).show();
            ok = false;
        }

        if (fecha == null) {
            Toast.makeText(this, getString(R.string.fechaError), Toast.LENGTH_SHORT).show();
            ok = false;
        }else{
            Calendar hoy = Calendar.getInstance();
            int diaHoy = hoy.get(Calendar.DAY_OF_MONTH), diaNacimiento = fecha.get(Calendar.DAY_OF_MONTH);
            int mesHoy = hoy.get(Calendar.MONTH), mesNacimiento = fecha.get(Calendar.MONTH);
            int anioHoy = hoy.get(Calendar.YEAR), anioNacimiento = fecha.get(Calendar.YEAR);
            if ( (anioHoy - anioNacimiento < 10) || (anioHoy - anioNacimiento > 100) || (((diaNacimiento > diaHoy && mesNacimiento == mesHoy) || mesNacimiento > mesHoy) && (anioHoy - anioNacimiento) == 10)){
                Toast.makeText(this, getString(R.string.fechaError), Toast.LENGTH_LONG).show();
                ok = false;
            }
        }
        if (ok) return true;
        else return false;
    }

}