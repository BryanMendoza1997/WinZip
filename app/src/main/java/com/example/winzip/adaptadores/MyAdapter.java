package com.example.winzip.adaptadores;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.winzip.R;
import com.example.winzip.clases.Archivos;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Archivos> names;
    public MyAdapter(ArrayList<Archivos> names)
    {
        this.names=names;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recicler_view_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(names.get(position).getNombre());
        holder.descripcion.setText(names.get(position).getDescripcion());
        holder.imagen.setImageResource(names.get(position).getImagenId());
    }
    public int getItemCount() {
        return names.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView descripcion;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.txtnombre);
            descripcion=(TextView) itemView.findViewById(R.id.txtdescripcion);
            imagen=(ImageView) itemView.findViewById(R.id.imageView);
        }

    }


}
