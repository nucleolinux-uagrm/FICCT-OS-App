package ficctos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;


public class Description {
   
   public static String darDescripcion(InputStream archivo){
       String x="";
       
    try {
        Scanner sc = new Scanner(archivo);
        while (sc.hasNextLine()) {
            x=x+sc.nextLine()+"\n";
        }
        sc.close();
    } 
    catch (Exception e) {
        x="archivo no encontrado";
    }
       return x;
   }
    
    
}
