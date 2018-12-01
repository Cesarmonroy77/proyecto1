/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import Modelo.Manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author César
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = null;
        File archivourl = new File ("paginas.txt");
        File archivopub = new File ("publicidad.txt");
        String publicidad= null;
        try{
            url = archivourl.getName();
            publicidad = archivopub.getName();
        }catch(ArrayIndexOutOfBoundsException ex){
            System.err.println("documento.txt requerido");    
        }
        Manager manager= new Manager(url, publicidad);
        try {
            manager.run();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
