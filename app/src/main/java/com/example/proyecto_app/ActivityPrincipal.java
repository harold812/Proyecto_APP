package com.example.proyecto_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivityPrincipal extends AppCompatActivity {

    EditText etNombres,etApellidos,etTelefono,etDireccion,etCorreo;
    RadioButton rdMasculino,rdFemenino;
    Button btnContinuar;
    String genero;
    List<EditText> ltTexto = new ArrayList<EditText>();
    String[] ltDatos = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etTelefono = findViewById(R.id.etTelefono);
        etDireccion = findViewById(R.id.etDireccion);
        etCorreo = findViewById(R.id.etCorreo);
        rdMasculino = findViewById(R.id.rdMasculino);
        rdFemenino = findViewById(R.id.rdFemenino);
        btnContinuar = findViewById(R.id.btnContinuar);

        ltTexto.add(etNombres);
        ltTexto.add(etApellidos);
        ltTexto.add(etTelefono);
        ltTexto.add(etDireccion);
        ltTexto.add(etCorreo);

        rdFemenino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdFemenino.isChecked()){
                    genero = "Femenino";
                }else {
                    genero = "Masculino";
                }
            }
        });
        rdMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdMasculino.isChecked()){
                    genero = "Masculino";
                }else {
                    genero = "Femenino";
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean continuar = ValidarDatos();

                if (continuar){
                    Toast.makeText(ActivityPrincipal.this,"Datos Completos",Toast.LENGTH_LONG).show();
                    ltDatos[5] = (genero);
                    Bundle parametros = new Bundle();
                    parametros.putStringArray("lista", ltDatos);
                    Intent intent = new Intent(ActivityPrincipal.this,ActivityResultado.class);
                    intent.putExtra("ltdatos",parametros);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ActivityPrincipal.this,"Datos Incompletos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private Boolean ValidarDatos(){
        EditText texto;
        Boolean Respuesta = true;
        for (int i =0; i < ltTexto.size();i++) {
            texto = ltTexto.get(i);
            if(texto.getText().toString().isEmpty()){
                Respuesta = false;
                break;
            }else{
                ltDatos[i] = texto.getText().toString();
                Respuesta= true;
                continue;
            }
        }
        return Respuesta;
    }
}