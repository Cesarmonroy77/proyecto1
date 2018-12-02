package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Durins Bane
 */
public class Read {
    private String texto;
    private Scanner file;

    public Read(String nomFile) {
        try{
            file = new Scanner(new FileReader(nomFile));
        }catch(FileNotFoundException ne){
            JOptionPane.showMessageDialog(null, "Una de las direcciones es incorrecta");
        }
    }
    
    public String dominio(){
        return file.nextLine();
    }
}