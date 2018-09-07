package com.example.gmg.personaapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Persona> personaList= new ArrayList<>();

    private ListView lvPersona;
private int posicion=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPersona=(ListView) findViewById(R.id.lvPersona);
        PersonaAdapter adapter= new PersonaAdapter(this,R.layout.layout_item_persona, personaList);

       // PersonaAdapter (new Persona("888-250898-0000S", "Keyra","20","50.9", "o+"));


        lvPersona.setAdapter(adapter);
    registerForContextMenu(lvPersona);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcion,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextual,menu);
        menu.setHeaderTitle("opciones");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,PersonaActivity.class);
        startActivityForResult(intent,1234);
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.borrar)
        {
            personaList.remove(info.position);
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, PersonaActivity.class);
            intent.putExtra("nombre", personaList.get(info.position).getNombre());
            intent.putExtra("apellido", personaList.get(info.position).getApellido());
            intent.putExtra("cedula", personaList.get(info.position).getCedula());
            intent.putExtra("telefono", personaList.get(info.position).getTelefono());
            intent.putExtra("edad", personaList.get(info.position).getEdad());
            intent.putExtra("peso", personaList.get(info.position).getPeso());
            intent.putExtra("tiposangre", personaList.get(info.position).getTipoSangre());
            startActivityForResult(intent,5678);

        }
        posicion=info.position;
        actualizarListView();
        return super.onContextItemSelected(item);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK)
        {
            Persona p= (Persona) data.getExtras().get("persona");
            personaList.add(p);
        }
        else if(requestCode==5678 && resultCode==RESULT_OK)
        {
            Persona p= (Persona) data.getExtras().get("persona");
            personaList.set(posicion,p);
            posicion=-1;
        }
        else if (requestCode==9012 && resultCode==RESULT_CANCELED)
        {
            onBackPressed();
        }

        actualizarListView();
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void actualizarListView()
    {
        ((PersonaAdapter)lvPersona.getAdapter()).notifyDataSetChanged();

    }


}
