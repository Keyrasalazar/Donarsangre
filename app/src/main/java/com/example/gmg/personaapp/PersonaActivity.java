package com.example.gmg.personaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PersonaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText apellido = (EditText) findViewById(R.id.apellido);
        EditText cedula= (EditText) findViewById(R.id.cedula);
        EditText telefono= (EditText) findViewById(R.id.telefono);
        EditText edad= (EditText) findViewById(R.id.edad);
        EditText peso= (EditText) findViewById(R.id.peso);
        EditText tiposangre=(EditText) findViewById(R.id.tiposangre);


       Bundle bundle= getIntent().getExtras();
       if(bundle!=null) {
           nombre.setText(bundle.getString("nombre","vacio"));
           apellido.setText(bundle.getString("apellido","vacio"));
           cedula.setText(bundle.getString("cedula","vacio"));
           telefono.setText(String.valueOf(bundle.getInt("telefono",0)));
           edad.setText(String.valueOf(bundle.getInt("edad",0)));
           peso.setText(String.valueOf(bundle.getFloat("peso",0)));
           tiposangre.setText(bundle.getString("tiposangre","vacio"));
       }
    }

    public void onClick(View view)
    {
        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText apellido = (EditText) findViewById(R.id.apellido);
        EditText cedula= (EditText) findViewById(R.id.cedula);
        EditText telefono= (EditText) findViewById(R.id.telefono);
        EditText edad= (EditText) findViewById(R.id.edad);
        EditText peso= (EditText) findViewById(R.id.peso);
        EditText tiposangre=(EditText) findViewById(R.id.tiposangre);

        Persona persona = new Persona(
                nombre.getText().toString(),
                apellido.getText().toString(),
                cedula.getText().toString(),
                Integer.valueOf(telefono.getText().toString()),
                Integer.valueOf(edad.getText().toString()),
                Float.valueOf(peso.getText().toString()),
                tiposangre.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("persona",persona);
        setResult(RESULT_OK,intent);
        finish();
    }
}
