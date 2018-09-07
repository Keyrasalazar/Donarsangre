package com.example.gmg.personaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonaAdapter extends ArrayAdapter {
   private List<Persona> list;
   private int resource;
   private Context context;
    public PersonaAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.list=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(this.context).inflate(this.resource,parent,false);

        TextView nombre=(TextView) convertView.findViewById(R.id.nombre);
        TextView apellido=(TextView) convertView.findViewById(R.id.apellido);
        TextView cedula= (TextView) convertView.findViewById(R.id.cedula);
        TextView telefono= (TextView) convertView.findViewById(R.id.telefono);
        TextView edad= (TextView) convertView.findViewById(R.id.edad);
        TextView peso= (TextView) convertView.findViewById(R.id.peso);
        TextView tiposangre=(TextView) convertView.findViewById(R.id.tiposangre);

        nombre.setText(list.get(position).getNombre());
        apellido.setText(list.get(position).getApellido());
        cedula.setText(list.get(position).getCedula());
        telefono.setText(String.valueOf(list.get(position).getTelefono()));
        edad.setText(String.valueOf(list.get(position).getEdad()));
        peso.setText(String.valueOf(list.get(position).getPeso()));
        tiposangre.setText(list.get(position).getTipoSangre());

        return convertView;
    }
}
