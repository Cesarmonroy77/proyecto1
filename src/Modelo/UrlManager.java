/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author César
 */
public class UrlManager {
    private String nombre;
    private Read url;

    public UrlManager(String nombre) {
        this.nombre = nombre;
        this.url= new Read(nombre);
    }
    
    public void descargar(){
        try{
            System.out.println("download");
            int numPagina=1;
            String direccion;
            System.out.println("direcciones");
            while((direccion=url.dominio())!=null){
                System.out.println(direccion);
                URL url= new URL(direccion);
                BufferedReader bf= new BufferedReader(new InputStreamReader(url.openStream()));
                File fileHtml= new File("pagina"+numPagina+".html");
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileHtml));
                String cadena;
                while((cadena = bf.readLine())!=null){
                    bw.write(cadena);
                }
                bf.close();
                bw.close();
                numPagina++;
            }
        }catch(NoSuchElementException ter){
            JOptionPane.showMessageDialog(null, "Todas las direcciones url del archivo fueron descargadas exitosamente");
        }catch(Exception ex){
            System.exit(0);
        }
    }
}