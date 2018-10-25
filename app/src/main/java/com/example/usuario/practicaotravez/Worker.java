package com.example.usuario.practicaotravez;

import android.app.Notification;
import android.os.Message;
import android.os.Handler;
import android.util.Log;


public class Worker extends Thread {

    Handler h;
    String conex;

    public Worker(Handler h,String conex)
    {
        this.h = h;
        this.conex=conex;
    }

    @Override
    public void run()
    {
            try
            {
                Log.d("Hola","Worker");
                HttpConection c = new HttpConection("GET");
                Thread.sleep(4000);
                Message m = new Message();
                m.arg1=1;
                //xmlParser
                h.sendMessage(m);
            }

            catch(Exception ex)
            {ex.printStackTrace();}
    }
}
