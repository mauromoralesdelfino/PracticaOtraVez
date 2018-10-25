package com.example.usuario.practicaotravez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public List<Producto> productoList;
    public MainActivity activity;

    public MyAdapter(List<Producto> productoList, MainActivity activity) {
        this.productoList = productoList;
        this.activity =activity;
        Log.d("Hola","adapter");
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item,viewGroup,false);
        MyViewHolder h = new MyViewHolder(v,this.activity);
        return  h;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {


        Producto p = this.productoList.get(i);
        holder.nombre.setText(p.getNombre());
        holder.precio.setText(p.getPrecio().toString());
        holder.cantidad.setText(p.getCantidad().toString());
        holder.setPos(i);



    }

    @Override
    public int getItemCount() {
        return this.productoList.size();
    }
}
