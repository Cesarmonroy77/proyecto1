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
 * @author César y Yaír
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = null;
        String publicidad= null;
        try{
            //url = args[0];
            //publicidad = args[1];
            url = "paginas.txt";
            publicidad = "publicidad.txt";
        }catch(ArrayIndexOutOfBoundsException ex){
            System.err.println("documento.txt requerido");    
        }
        Manager manager= new Manager(url, publicidad);
            manager.run();
    }
}
