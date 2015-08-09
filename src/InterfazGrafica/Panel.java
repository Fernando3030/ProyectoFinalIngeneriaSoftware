package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Clases.Circulo;
 
 public class Panel extends JPanel{
        private Circulo circulo;
  

       


    
    public Panel(){
        circulo = new Circulo(0, 0, 0);
        setBorder(BorderFactory.createLineBorder(Color.RED));
     }
    

     public void paint(Graphics g){
         super.paintComponent(g);
         
         circulo.dibujar(g, circulo.getRadio());
         //updateScrollPane();//refresh the pane after every paint
        
     }
     
  
    
     public void dibujar(Circulo circulo){
        this.circulo = circulo;
        repaint();
     }
     
     public void vaciar()
     {
    	 circulo = new Circulo(0, 0, 0);
    	 dibujar(circulo);
    	// repaint();
     }
     

     
   

    
 }