/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author César y Yaír
 */
public class UrlManager {
    private Read url;
    private BufferedReader server;
    private BufferedWriter html;
    

    public UrlManager(String nomFileDom) {
        try{
            this.url= new Read(nomFileDom);
        }catch(FileNotFoundException ne){
            JOptionPane.showMessageDialog(null, "Verifique la direccion: "+nomFileDom);
            System.exit(0);
        }
    }
    
    public void descargar(){
        try{
            int numPagina=1;
            String direccion;
            System.out.println("direcciones");
            while((direccion=url.dominio())!=null){
                System.out.println(direccion);
                readUrl(direccion);
                writeHtml(numPagina);
                String cadena;
                while((cadena = server.readLine())!=null){
                    html.write(cadena);
                }
                server.close();
                html.close();
                numPagina++;
            }
        }catch(NoSuchElementException ter){
            JOptionPane.showMessageDialog(null, "Todas las direcciones url del archivo fueron descargadas exitosamente");
        }catch(Exception ex){
            System.exit(0);
        }
    }
    
    
    public void readUrl(String direccion) throws MalformedURLException, IOException {
        URL url= new URL(direccion);
        server= new BufferedReader(new InputStreamReader(url.openStream()));   
    }
    public void writeHtml(int numPagina) throws IOException{
        File fileHtml= new File("pagina"+numPagina+".html");
        html = new BufferedWriter(new FileWriter(fileHtml));
    }
    
    public void folder(){
    
    }
}