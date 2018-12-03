package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Durins Bane
 */
public class FileManager {
    private String texto;
    private Scanner file;

    public FileManager(String nomFile) throws FileNotFoundException{
        file = new Scanner(new FileReader(nomFile));
    }
    
    public String dominio(){
        return file.nextLine();
    }
    
    public File folder(String nomFolder){
        File dirFolder= new File("C:"+File.separator+"Users"+File.separator+"César"+File.separator+"Desktop"+File.separator+nomFolder);
        if (dirFolder.exists()) {
            return dirFolder;  
        }
        dirFolder.mkdir();
        return dirFolder;     
    }
    
    public String[] nomFiles(String nomFolder){
        String[] names=folder(nomFolder).list();
        return names;
    }
    
    public void mover(String origen,String nombre){
        File oldHtml = new File(origen, nombre);
        File newHtml= new File(folder("Analizado").getAbsoluteFile(), nombre);
        try{
            newHtml.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(oldHtml));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newHtml));
            String texto;
            while((texto=br.readLine())!=null){
                bw.write(texto);
                oldHtml.deleteOnExit();
                bw.close();
                br.close();  
            }
        }catch(IOException ie){}
    }
    
    public void close(){
        file.close();
    }
}