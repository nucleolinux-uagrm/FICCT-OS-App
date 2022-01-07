package ficctos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;


public class Description {
    
   public static String getDescripcion(URI url){
         File archivo = null;
         FileReader fr = null;
         BufferedReader br = null;
         String x="";

      try {

         archivo = new File (url);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         String linea;
         while((linea=br.readLine())!=null)
            x=x+linea+"\n";
      }
      catch(Exception e){
         x="No se encontro descripcion";
      }finally{

         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   
      return x;
     
   }
    
    
}
