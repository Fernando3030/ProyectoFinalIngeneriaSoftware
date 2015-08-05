package Clases;


import java.io.IOException;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class Validaciones {
	
	 public String codigoAleatorio (int longitud){
	        String cadenaAleatoria = "";
	        long milis = new java.util.GregorianCalendar().getTimeInMillis();
	        Random r = new Random(milis);
	        int i = 0;
	        while ( i < longitud){
	        char c = (char)r.nextInt(255);
	        if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
	        cadenaAleatoria += c;
	        i ++;
	        }
	        }
	        return cadenaAleatoria;
	      }
	 
	 /**
		 * Validación de las palabras
		 * sirve para saber si son solo letras nada de números
		 * @param palabra la palabra a validar
		 * @return valido
		 */
		public static boolean ValidacionString(String palabra){
			char letra;
			//boolean valido = true;
			int i=0;
		if(palabra != null)
		{
			if(palabra.length()<1)
				return false;
			if (palabra.matches("([a-z]|[A-Z]|\\s)+"))
				return true;
		}
			return false;
		}
		
		 /**
		  * metodo para validar si una fecha tiene el formato dd/mm/yyyy
		  * @param fecha la fecha a validar
		  * @return true/false
		  */
		 public static boolean isFechaValida(String fecha) {
		        try {
		            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		            formatoFecha.setLenient(false);
		            formatoFecha.parse(fecha);
		        } catch (ParseException e) {
		            return false;
		        }
		        return true;
		    }
		 
		  public void copyFile(File s, File t)
		    {
		        try{
		              FileChannel in = (new FileInputStream(s)).getChannel();
		              FileChannel out = (new FileOutputStream(t)).getChannel();
		              in.transferTo(0, s.length(), out);
		              in.close();
		              out.close();
		        }
		        catch(Exception e)
		        {
		            System.out.println(e);
		        }
		    }

}
