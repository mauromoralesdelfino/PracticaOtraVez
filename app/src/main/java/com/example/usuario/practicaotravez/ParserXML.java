package com.example.usuario.practicaotravez;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {

    public static List<Producto> Listar(String miXml)
    {
        List<Producto> lista = new ArrayList<>();
        Producto p = null;

        try
        {
            XmlPullParser xml = Xml.newPullParser();
            xml.setInput(new StringReader(miXml));

            int event = xml.getEventType();
            while (event==XmlPullParser.END_DOCUMENT)
            {
                switch (event)
                {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        if ("productos".equals(xml.getName())){
                            p = new Producto();
                        }else if ("id".equals(xml.getName())) {
                            p.setId(xml.nextText());
                        }else if ("nombre".equals(xml.getName())){
                            p.setNombre(xml.nextText());
                        }else if ("precio".equals(xml.getName())){
                            p.setPrecio(Double.parseDouble(xml.nextText()));
                        }else if ("cantidad".equals(xml.getName())){
                            p.setCantidad(Integer.parseInt(xml.nextText()));
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if ("productos".equals(xml.getName()))
                        {
                            lista.add(p);
                        }
                        break;

                }
            event = xml.next();
            }


        }
        catch(Exception ex)
        {ex.printStackTrace();}

        return lista;
    }
}
