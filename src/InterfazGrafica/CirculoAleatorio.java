package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.digester.xmlrules.CircularIncludeException;

import Clases.Circulo;
import Clases.Validaciones;
 
 public class CirculoAleatorio extends Circulo{
     private Circulo circulo;
     private Panel miPanel;
     private Container contenedor;
    private JTextArea calculos;
     private JButton bDibujar;
     private JPanel panelInferior;
     private JButton btnSalir;
     private MoverFigura figura;
    
     private JFrame frame;
		private  Statement sentencias;
		private ResultSet resultado;
		Validaciones validacion= new Validaciones();
	//	private int x1= 0;
     //  private 	int y1=0;
       private double radioDibujado;
     /** 
        * Si actualmente se está arrastrando o no el rectángulo.
        */
       private boolean arrastrando = false;
       /** 
        * x en la que estaba anteriormente el ratón.
        */
       private int xAnteriorRaton;

       /** 
        * y en la que estaba anteriormente el ratón
        */
       private int yAnteriorRaton;
       
       /**
        * serial uid
        */
       private static final long serialVersionUID = -4273648398171436938L;

     
   
   public CirculoAleatorio(){
	   
	   
        frame=  new JFrame("Dibujar Circulo Aleatoriamente");
        try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         contenedor = frame.getContentPane();
         frame.setSize(500, 600);
         contenedor.setBackground(Color.WHITE);
         frame.setResizable(false);
         frame.setLocationRelativeTo(null);
         panelInferior= new JPanel();
         panelInferior.setLayout(new GridLayout(1,2,0,3));
         btnSalir= new JButton("Regresar al Menú");
         figura= new MoverFigura();
        
         
         addComponentes();
         addEventos();
        
         
         frame.setVisible(true);
    }
        public void addComponentes(){
         miPanel = new Panel();
         calculos = new JTextArea("Calculos");
         bDibujar = new JButton("Dibujar una circuferencia aleatoriamente");
         panelInferior.add(calculos);
         panelInferior.add(btnSalir);
        
        //muestra normal el JTextArea pero no permite escribir desde el teclado
         calculos.setEditable(false);        
         miPanel.setBackground(new Color(2,115,83));
         contenedor.add(bDibujar, BorderLayout.NORTH);
         contenedor.add(miPanel, BorderLayout.CENTER);
         contenedor.add(panelInferior, BorderLayout.SOUTH);
        }
         
        public void addEventos(){
         bDibujar.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
                 dibujarCirculo();
                 frame.addMouseMotionListener(figura);
                
             }
         });
         
         btnSalir.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
            	 frame.dispose();
               VentanaBienvenida ventana= new VentanaBienvenida();
             }
         });
      }
        
        public void dibujarCirculo(){
       
        	
            double radio = (Math.floor(Math.random()*(220-1+1))+1);
            x1=0;
            y1=0;
           
         
         circulo = new Circulo(x1, y1, radio);
         radioDibujado= circulo.calcularDiametro(radio);
         miPanel.dibujar(circulo);
         mostrarCalculos(radio);
      
     }
     
     public void mostrarCalculos(double radio){
         String radio2;
         String diametro;
         String area;
         String circunferencia;
        
       
         radio2 = "Radio: \t" + (circulo.calcularDiametro(radio) / 2);
         diametro = "Diametro: \t" + circulo.calcularDiametro(radio);
         area = "Area: \t" + circulo.calcularArea(radio);
         circunferencia = "Circunferencia: \t" + circulo.calcularCircunferencia(radio);
         
         calculos.setText(": : Calculos : :" + "\n" + radio2 + "\n" + diametro + 
                "\n" + area + "\n" + circunferencia);
         
         if(Login.esAdmin)  // si es admin
         {
        	  //no guardo nada en el sistema :p
         }
         else
         {
        	 double r= circulo.calcularDiametro(radio) / 2;
             double d= circulo.calcularDiametro(radio);
             double a= circulo.calcularArea(radio);
             double c= circulo.calcularCircunferencia(radio);
        	String codigo= validacion.codigoAleatorio(8);
        	fechaCirculo = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
            
            
            
              try {
             	 
             	 sentencias.executeUpdate("INSERT INTO circulo VALUES ('"+Login.usuarioAlumno+"',"+"'"+r+"',"+"'"+d+"',"+"'"+a+"',"+"'"+c+"',"+"'"+codigo+"',"+"'"+date.format(fechaCirculo)+"',"+"'"+hour.format(fechaCirculo)+"')");
                 
              }
               catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Insertar el Registro");
                   System.out.println(ex);
               }
        	 
         }
        
         
         
     }
     
     public class MoverFigura  implements  MouseMotionListener {

    	 /**
    	     * Método al que se llama cuando se arrastra el ratón.
    	     * Se comprueba con el atributo arrastrando si está empezando el arrastre o
    	     * ya se esta en medio del mismo.
    	     * Si se comienza el arrastre, se guardan las coordenadas del ratón que
    	     * vienen en el evento MouseEvent y se cambia el valor del atributo arrastrando.
    	     * Si se está en medio de un arrastre, se calcula la nueva posición del
    	     * rectángulo y se llama al método repaint() para que se pinte.
    	     *
    	     * @param e Evento del ratón
    	     */
		public void mouseDragged(MouseEvent e) {
			
			// Si comienza el arrastre ...
	        if (!arrastrando)
	        {
	          // ... y el ratón está dentro del rectángulo
	            if (estaDentro(e))
	            {
	              // Se guardan las posiciones del ratón
	                xAnteriorRaton = e.getX();
	                yAnteriorRaton = e.getY();
	                System.out.println("imprimir xAnterio " + xAnteriorRaton + " " + "imprimir yAnterior " + yAnteriorRaton);
	                // y se marca que ha comenzado el arrastre.
	                arrastrando = true;
	            }
	        }
	        else
	        {
	          // Si ya había empezado el arrastre, se calculan las nuevas
	          // coordenadas del circulo
	            x1 = (x1 + e.getX()) - xAnteriorRaton;
	            y1 = (y1 + e.getY()) - yAnteriorRaton;
	           
	        //    circulo.setRadio(radioDibujado);
	            
	            // Se guarda la posición del ratón para el siguiente cálculo
	            xAnteriorRaton = e.getX();
	            yAnteriorRaton = e.getY();
	            
	            // y se manda repintar el Canvas
	            if(x1 > 0 && x1 <500)
	           {
	            	circulo.setX1(x1);
		            circulo.setY1(y1);
		            miPanel.repaint();
	           }
	            
	        }
			
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
	
			arrastrando = false;
			System.out.println("se movio");
		}
		
		
	
    	 
     }
     
     /**
	     * Para ver si el ratón está dentro del rectángulo.
	     * Si está dentro, puede comenzar el arrastre.
	     *
	     * @param e El evento de ratón
	     *
	     * @return true si el ratón está dentro del rectángulo
	     */
 	
	    private boolean estaDentro(MouseEvent e)
	    {
	        if (
	            (e.getX() > x1) &&
	                (e.getX() < (x1 + radioDibujado)) &&
	                (e.getY() > y1) &&
	                (e.getY() < (y1 + radioDibujado)))
	        {
	        	System.out.println("esta dentro");
	        	return true;
	            
	        }
	        System.out.println("esta fuera");
	        return false;
	    }
     
   
  }