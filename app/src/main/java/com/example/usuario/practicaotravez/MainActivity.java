package com.example.usuario.practicaotravez;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler .Callback{

    Handler h;
    Worker w;
    List<Producto> p;
    RecyclerView rv;
    MyAdapter adapter;
    Thread hilo;
    List<Producto> j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Hola","act");
        h= new Handler(this);
        w= new Worker(h,"Conec");
        hilo = new Thread(w);
        hilo.start();

        p = new ArrayList<>();
        p.add(new Producto("a",10.00,"c",2));
        p.add(new Producto("a",10.00,"c",3));
        p.add(new Producto("a",10.50,"c",4));
        p.add(new Producto("a",10.60,"a",5));

        rv=(RecyclerView) findViewById(R.id.listaRV);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(p,this);
        rv.setAdapter(adapter);
        Log.d("Hola","act");

    }

    @Override
    public boolean handleMessage(Message msg) {


        j = new ArrayList<>();
        j.add(new Producto("a",100.00,"c",2));
        j.add(new Producto("a",100.00,"c",3));
        j.add(new Producto("a",100.50,"c",4));
        j.add(new Producto("a",100.60,"a",5));

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(j,this);
        rv.setAdapter(adapter);

        return false;
    }

    public void controlStock(int id, int position)
    {

        if (id==1)
        {
            j.get(position).setCantidad(j.get(position).getCantidad() + 1);
            adapter.notifyItemChanged(position);
        }

        if (id==2)
        {
            j.get(position).setCantidad(j.get(position).getCantidad() - 1);
            adapter.notifyItemChanged(position);
        }

    }
}
