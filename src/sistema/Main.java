package sistema;

import Modelo.Manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = null;
        String publicidad= null;
        try{
            url = args[0];
            publicidad = args[1];
            Manager manager= new Manager(url, publicidad);
            manager.run();
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Argumentos Necesarios:\n C:\\direccion_de_archivo_con_dominios         C:\\direccion_de_archivo_con_dominios_de_publicidad");
        }
    }
}
