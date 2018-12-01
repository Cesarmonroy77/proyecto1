package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Durins Bane
 */
public class Read {
    private String texto;
    private Scanner file;

    public Read(String nomFile) {
        System.out.println("read");
        try{
            file = new Scanner(new FileReader(nomFile));
        }catch(FileNotFoundException ne){
            System.exit(0);
        }
    }
    
    public String dominio(){
        return file.nextLine();
    }
}