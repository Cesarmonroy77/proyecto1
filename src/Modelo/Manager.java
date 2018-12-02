/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileNotFoundException;

/**
 *
 * @author César y Yaír
 */
public class Manager {
    private UrlManager url;
    private Cataloguer analisis;
    private Histograma histograma;

    public Manager(String arg1, String arg2) {
        this.url = new UrlManager(arg1);
        this.analisis = new Cataloguer(arg2);
        this.histograma = new Histograma();
    }
    
    public void run() {
        url.descargar();
        analisis.check("pagina1.html");
    } 
}

