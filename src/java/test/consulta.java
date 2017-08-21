/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabriel
 */
public class consulta {

    
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String cons="insert into estudiante(ci, ru, nombre_completo) values('";
            cadena=cadena.replaceAll("\t", " ");
            String arr[]=cadena.split(" ");
            cons+=arr[0]+"','";
            cons+=arr[1]+"','";
            //System.out.println("CI: "+arr[0]);
            //System.out.println("RU: "+arr[1]);
            String nombre="";
            for (int i = 2; i < arr.length; i++) {
                nombre+=" "+arr[i];
            }
            //System.out.println("nombre: "+nombre);
            cons+=nombre+"');";
            System.out.println(cons);
        }
        b.close();
    }

    public static void main(String[] args) throws IOException {
        muestraContenido("/home/gabriel/NetBeansProjects/appsorteo/src/java/test/datos.txt");
    }
}
