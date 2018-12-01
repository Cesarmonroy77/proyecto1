
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author César
 */
public class Cataloguer {
    private String nomPub;
    private Read filepub;
    private int imgC;
    private int vidC;
    private int linkC;
    private int pubC;
    
    public Cataloguer(String nomPub) {
        this.nomPub = nomPub; 
        this.filepub= new Read(nomPub);
    }
    
    public void check(String nomHtml) {
        try{
            Scanner html = new Scanner(new FileReader(nomHtml));
            String etiqueta;
            while((etiqueta=html.nextLine())!=null){
                Imagenes(etiqueta, imgC);
                Videos(etiqueta,vidC);
                Links(etiqueta, linkC);
                String domPub;
                System.out.println("dominios de publicidad");
                while((domPub=filepub.dominio())!=null){
                    System.out.println("--"+domPub+"--");
                    int a = getPubC();
                    pubC = a;
                    ad(etiqueta,domPub, pubC);
                    pubC = pubC+pubC;
                }
                
            }
        }catch(ArrayIndexOutOfBoundsException ex){
        }catch(NoSuchElementException e){
        }catch(FileNotFoundException nf){}   
    }
    
    public void Imagenes(String cadena, int contador){
        Pattern pattern1 = Pattern.compile("(<img[^>]*/>)");
        Matcher matcher1 = pattern1.matcher(cadena);
        for (int i = 0; i < 1; i++) {
            while (matcher1.find()) {
                contador ++; 
                System.out.println("Imagen: "+matcher1.group(1));
           }
            System.out.println("ImgCount : "+contador);
        }
    }

    public void Videos(String cadena, int contador){
        Pattern pattern1 = Pattern.compile("(<video[^>]*>)");
        Matcher matcher1 = pattern1.matcher(cadena);
        for (int i = 0; i < 1; i++) {
           while (matcher1.find()) {
              contador ++; 
              System.out.println("video: "+matcher1.group(1));
           }
        }
        System.out.println("VideoCount :"+contador);
    }
    
    public void Links(String cadena, int contador){
        Pattern pattern2 = Pattern.compile("<link[^>]*href=\\\"(.*?)\"");
        Pattern pattern3 = Pattern.compile("<a[^>]*href=\\\"(.*?)\"");
        Matcher matcher1 = pattern2.matcher(cadena);
        Matcher matcher2 = pattern3.matcher(cadena);
        for (int i = 0; i < 1; i++) {
           while (matcher1.find()) {
              contador ++; 
              System.out.println("link : "+matcher1.group(1));
           }
        }
        for (int i = 0; i < 1; i++) {
           while (matcher2.find()) {
              contador ++; 
              System.out.println("link : "+matcher2.group(1));
           }
        }
        System.out.println("LinkCount: "+contador);
    }
    
    public void ad(String cadena,String domPub, int contador){
        String liga;
        Pattern pattern2 = Pattern.compile("<link[^>]*href=\\\"(.*?)\"");
        Pattern pattern3 = Pattern.compile("<a[^>]*href=\\\"(.*?)\"");
        Matcher matcher1 = pattern2.matcher(cadena);
        Matcher matcher2 = pattern3.matcher(cadena);
        for (int i = 0; i < 1; i++) {
           while (matcher1.find()) {
              liga = matcher1.group(1);
              String publi[] = liga.split("/");
               for (int j = 0; j < publi.length; j++) {
                   if (publi[j].compareToIgnoreCase(domPub) == 0) {
                       System.out.println(publi[j]);
                       contador ++;
                   }
               }
           }
        }
        for (int i = 0; i < 1; i++) {
           while (matcher2.find()) {
              liga = matcher2.group(1);
              String publi[] = liga.split("/");
               for (int j = 0; j < publi.length; j++) {
                   if (publi[j].compareToIgnoreCase(domPub) == 0) {
                       System.out.println(publi[j]);
                       contador ++;
                   }
               }
           }
        }
        System.out.println("pubCount: "+contador);
    }

    public int getPubC() {
        return pubC;
    }
    
}

