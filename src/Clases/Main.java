package Clases;

import javax.swing.JFrame;
import javax.swing.UIManager;

import InterfazGrafica.Login;
import InterfazGrafica.VentanaBienvenida;
import InterfazGrafica.CirculoAleatorio;
 
 public class Main {
     public static void main(String[] args) {
    	 
    	 try {
 			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
     
    	// Login login= new Login();
    	VentanaBienvenida ventana = new VentanaBienvenida();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
     }
 }