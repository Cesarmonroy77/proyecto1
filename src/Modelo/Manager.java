/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;

/**
 *
 * @author César y Yaír
 */
public class Manager {
    private UrlManager url;
    private Cataloguer analisis;
    private Histograma histograma;

    public Manager(String nomFileDom, String nomFilePub) {
        this.url = new UrlManager(nomFileDom);
        this.analisis = new Cataloguer(nomFilePub);
        //this.histograma = new Histograma(int[contadores]);
    }
    public void run() {
        url.descargar();
        String[] nomFiles = url.nomFiles();
        for (int i = 0; i < nomFiles.length; i++) {
            File dirFile= new File(url.folder(), nomFiles[i]);
            System.out.println("\n"+nomFiles[i]+": "+dirFile.getAbsolutePath());
            //System.out.println("pagina");
            analisis.check(dirFile.getAbsolutePath());
        }
    } 
}

