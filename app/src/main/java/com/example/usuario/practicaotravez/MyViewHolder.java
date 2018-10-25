package com.example.usuario.practicaotravez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nombre;
    TextView cantidad;
    TextView precio;
    MainActivity activity;
    ImageButton mas;
    ImageButton menos;
    int pos;



    public MyViewHolder(@NonNull View itemView,MainActivity activity) {
        super(itemView);
        this.nombre=(TextView) itemView.findViewById(R.id.txtNombre);
        this.cantidad=(TextView) itemView.findViewById(R.id.txtCantidad);
        this.precio =(TextView) itemView.findViewById(R.id.txtPrecio);
        this.mas = (ImageButton) itemView.findViewById(R.id.btnMas);
        this.menos = (ImageButton) itemView.findViewById(R.id.btnMenos);
        this.activity=activity;
        this.mas.setOnClickListener(this);
        this.menos.setOnClickListener(this);
        Log.d("Hola","holder");
    }

    @Override
    public void onClick(View v) {

        int x =0;
        if (v.getId() == this.mas.getId())
        {
            x=1;
        }

        if (v.getId() == this.menos.getId())
        {
            x=2;
        }
        this.activity.controlStock(x,pos);

    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
