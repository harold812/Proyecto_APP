package com.example.proyecto_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityResultado extends AppCompatActivity {

    String[] lista;
    TextView tvNombres,tvApellidos,tvTelefono,tvDireccion,tvCorreo,tvGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvNombres = findViewById(R.id.nombres);
        tvApellidos = findViewById(R.id.apellidos);
        tvTelefono = findViewById(R.id.telefono);
        tvDireccion = findViewById(R.id.direccion);
        tvCorreo = findViewById(R.id.correo);
        tvGenero = findViewById(R.id.genero);

        Bundle parametros = new Bundle();
        parametros = getIntent().getBundleExtra("ltdatos");

        lista = (String[]) parametros.getSerializable("lista");

        tvNombres.setText("Nombres:" + "/n" + lista[0]);
        tvApellidos.setText("Apellidos:" + "/n" + lista[1]);
        tvTelefono.setText("Telefono:" + "/n" + lista[2]);
        tvDireccion.setText("Direccion:" + "/n" + lista[3]);
        tvCorreo.setText("Correo:" + "/n" + lista[4]);
        tvGenero.setText("Genero:" + "/n" + lista[5]);
    }
}