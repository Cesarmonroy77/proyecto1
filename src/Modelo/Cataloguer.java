
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author César y Yaír
 */
public class Cataloguer {
    private String nomPub;
    private Read filepub;
    private int imgC;
    private int vidC;
    private int linkC;
    private int pubC;
    private int otrC;
    
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
                IL(etiqueta,linkC);
                VL(etiqueta,linkC);
                Otros(etiqueta,otrC);
                System.out.println("Numero de Imagenes:"+imgC);
                System.out.println("Numero de Videos:"+vidC);
                System.out.println("Numero de Links:"+linkC);
                System.out.println("Numero de Otros elementos:"+otrC);
                String domPub;
                while((domPub=filepub.dominio())!=null){
                    ad(etiqueta,domPub, pubC);
                    System.out.println("Numero de Publicidad:"+pubC);
                }    
            }
        }catch(ArrayIndexOutOfBoundsException ex){
        }catch(NoSuchElementException e){
        }catch(FileNotFoundException nf){}   
    }
    
    public void Imagenes(String cadena, int contador){
        Pattern pattern1 = Pattern.compile("(<img[^>]*>)");
        Matcher matcher1 = pattern1.matcher(cadena);
            while (matcher1.find()) {
                contador ++;
                setImgC(contador);
           }
    }
    
    public void Otros(String cadena, int contador){
        Pattern pattern1 = Pattern.compile("(<script[^>]*>)");
        Matcher matcher1 = pattern1.matcher(cadena);
            while (matcher1.find()) {
                contador ++;
                setOtrC(contador);
           }
    }

    public void Videos(String cadena, int contador){
        Pattern pattern1 = Pattern.compile("(<video[^>]*>)");
        Matcher matcher1 = pattern1.matcher(cadena);
           while (matcher1.find()) {
              contador ++; 
              setVidC(contador);
        }
    }
    
    public void Links(String cadena, int contador){
        Pattern pattern2 = Pattern.compile("<link[^>]*href=\\\"(.*?)\"");
        Pattern pattern3 = Pattern.compile("<a[^>]*href=\\\"(.*?)\"");
        Matcher matcher1 = pattern2.matcher(cadena);
        Matcher matcher2 = pattern3.matcher(cadena);
           while (matcher1.find()) {
              contador ++;
              setLinkC(contador);
              //System.out.println("link : "+matcher1.group(1));
           }
           while (matcher2.find()) {
              contador ++;
              setLinkC(contador);
              //System.out.println("link : "+matcher2.group(1));
           }
    }
    
    public void IL(String cadena, int linkC){
        Pattern pattern2 = Pattern.compile("<img[^>]*src=\"(.*?)\"");
        Matcher matcher1 = pattern2.matcher(cadena);
           while (matcher1.find()) {
              linkC = getLinkC();
              linkC ++;
              setLinkC(linkC);
              //System.out.println("link : "+matcher1.group(1));
           }
    }
    
    public void VL(String cadena, int linkC){
        Pattern pattern2 = Pattern.compile("<video[^>]*src=\"(.*?)\"");
        Matcher matcher1 = pattern2.matcher(cadena);
           while (matcher1.find()) {
              linkC = getLinkC();
              linkC ++;
              setLinkC(linkC);
              //System.out.println("link : "+matcher1.group(1));
           }
    }
    
    public void ad(String cadena, String domPub, int contador){
        String liga;
        Pattern pattern2 = Pattern.compile("<link[^>]*href=\\\"(.*?)\"");
        Pattern pattern3 = Pattern.compile("<a[^>]*href=\\\"(.*?)\"");
        Matcher matcher1 = pattern2.matcher(cadena);
        Matcher matcher2 = pattern3.matcher(cadena);
           while (matcher1.find()) {
              liga = matcher1.group(1);
              String publi[] = liga.split("/");
               for (int j = 0; j < publi.length; j++) {
                 if (publi[j].equals(domPub)) {
                       contador ++;
                       setPubC(contador);
                   }
               }
           }
           while (matcher2.find()) {
              liga = matcher2.group(1);
              String publi[] = liga.split("/");
               for (int j = 0; j < publi.length; j++) {
                    if (publi[j].equals(domPub)) {
                       contador ++;
                       setPubC(contador);
                   }
               }
           }
    }

    public int getImgC() {
        return imgC;
    }

    public void setImgC(int imgC) {
        this.imgC = imgC;
    }

    public int getVidC() {
        return vidC;
    }

    public void setVidC(int vidC) {
        this.vidC = vidC;
    }

    public int getLinkC() {
        return linkC;
    }

    public void setLinkC(int linkC) {
        this.linkC = linkC;
    }
    
    public void setPubC(int pubC) {
        this.pubC = pubC;
    }

    public int getPubC() {
        return pubC;
    }

    public int getOtrC() {
        return otrC;
    }

    public void setOtrC(int otrC) {
        this.otrC = otrC;
    }
    
    
    
}

