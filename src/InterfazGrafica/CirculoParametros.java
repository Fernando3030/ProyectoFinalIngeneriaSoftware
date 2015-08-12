package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Clases.Circulo;
import Clases.Validaciones;





import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
 public class CirculoParametros extends Circulo{
     private Circulo circulo;
     private Panel miPanel;
     private Container contenedor;
    private JTextArea calculos;
     private JButton btnCalcular;
     private JPanel panelInferior;
     private JPanel panelInferiorDerecho;
     private JPanel panelInferiorCentro;
     private JButton btnSalir;
     private JLabel lblIngreso;
     private JTextField txtIngreso;
 	private  Statement sentencias;
	private ResultSet resultado;
	Validaciones validacion= new Validaciones();
	private JFrame frame;
	
	private double radioDibujado;
    private int xLimite=0;
    private int yLimite=0;
    
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
    
    private MoverFigura figura;
   
    private int xAux;
    private int yAux;
   
   public CirculoParametros(){
       
	   frame= new JFrame("Circulo con parámetros");
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
         lblIngreso= new JLabel("Ingrese el Radio");
         txtIngreso= new JTextField();
         
         panelInferior= new JPanel();
         panelInferior.setLayout(new GridLayout(1,3,0,2));
         
         panelInferiorDerecho= new JPanel();
         panelInferiorDerecho.setLayout(new GridLayout(2,0,2,0));
         
         panelInferiorCentro= new JPanel();
         panelInferiorCentro.setLayout(new GridLayout(2,0,2,0));
         btnSalir= new JButton("Regresar al Menú");
         miPanel = new Panel();
         calculos = new JTextArea("Calculos");
         btnCalcular = new JButton("Calcular");
         figura= new MoverFigura();
        
         
         addComponentes();
         addEventos();
         
         frame.setVisible(true);
    }
        public void addComponentes(){
        
         panelInferior.add(calculos);
         panelInferior.add(panelInferiorCentro);
         panelInferior.add(panelInferiorDerecho);
         panelInferiorCentro.add(lblIngreso);
         panelInferiorCentro.add(txtIngreso);
         panelInferiorDerecho.add(btnCalcular);
         panelInferiorDerecho.add(btnSalir);
         
         
         
        
        //muestra normal el JTextArea pero no permite escribir desde el teclado
         calculos.setEditable(false);        
         miPanel.setBackground(new Color(2,115,83));
        // contenedor.add(bDibujar, BorderLayout.NORTH);
         contenedor.add(miPanel, BorderLayout.CENTER);
         contenedor.add(panelInferior, BorderLayout.SOUTH);
        }
         
        public void addEventos(){
        	btnCalcular.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
            	 if(txtIngreso.getText().length() != 0)
            	 {
            		 double radio= Double.parseDouble(txtIngreso.getText());
            		 if(radio >= 1 & radio <=220)
            		 {
            			 xAux=0;
                    	 yAux=0;
                         dibujarCirculo(radio);
                       
                         frame.addMouseMotionListener(figura);
                       
		                 
            		 }
            		 else
            		 {
            			 JOptionPane.showMessageDialog(null, "Error, número no permitido");
            		 }
            	 }
            	 else
            	 {
            		  JOptionPane.showMessageDialog(null, "No puede Ingresar Campos vacíos");
            	 }
             }
         });
         
         btnSalir.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
               frame.dispose();
               VentanaBienvenida ventana= new VentanaBienvenida();
             }
         });
         
         txtIngreso.addKeyListener(new KeyAdapter() {
          	@Override
          	public void keyTyped(KeyEvent ke) {
          		
          		char c=ke.getKeyChar();
          		String cod= txtIngreso.getText();
          		int punto = cod.indexOf(".")+1;
          		if(punto == 0)
          		{
          			if(!Character.isDigit(c)&& c!= KeyEvent.VK_BACK_SPACE&& c!= KeyEvent.VK_PERIOD)
          			{
          				ke.consume();
          				frame.getToolkit().beep();
          				JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
          			}
          		}
          		else
          		{
          			if(!Character.isDigit(c)&& c!= KeyEvent.VK_BACK_SPACE)
          			{
          				ke.consume();
          				frame.getToolkit().beep();
          				JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
          			}
          		}
                 
                 
                
          }});
      }
        
        public void dibujarCirculo(double radio){
      
        	x1=0;
            y1=0;
         
         
         circulo = new Circulo(x1, y1, radio);
         radioDibujado= circulo.calcularCircunferencia(radio);
         mostrarCalculos(radio);
        
         miPanel.dibujar(circulo);
     }
     
     public void mostrarCalculos(double radio){
         String radio2;
         String diametro;
         String area;
         String circunferencia;
         DecimalFormat areaDecimal = new DecimalFormat("0.00"); 
         DecimalFormat circuDecimal = new DecimalFormat("0.00"); 
         
         if(radio <= 50)
         {
         	xLimite= 380;
         	yLimite=380;
         }
         else
         	if(radio > 50 && radio <=100)
         {
         		xLimite= 300;
             	yLimite=300;
         }
         	  else
               	if(radio > 100 && radio <=150)
               {
               		xLimite= 200;
                   	yLimite=190;
               }
               	 else
                    	if(radio > 150 && radio <=200)
                    {
                    		xLimite= 90;
                        	yLimite=90;
                    }
                     else
                        	if(radio > 200 && radio <=220)
                        {
                        		xLimite= 50;
                            	yLimite=50;
                        }
         
         radio2 = "Radio: \t" + String.valueOf(radio);
         diametro = "Diametro: \t" + circulo.calcularDiametro(radio);
         area = "Area: \t" + areaDecimal.format(circulo.calcularArea(radio));
         circunferencia = "Circunferencia: \t" + circuDecimal.format(circulo.calcularCircunferencia(radio));
         
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
       	Date now = new Date(System.currentTimeMillis());
           SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
           SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
           
           
             try {
            	 
            	 sentencias.executeUpdate("INSERT INTO circulo VALUES ('"+Login.usuarioAlumno+"',"+"'"+r+"',"+"'"+d+"',"+"'"+a+"',"+"'"+c+"',"+"'"+codigo+"',"+"'"+date.format(now)+"',"+"'"+hour.format(now)+"')");
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
    	     * circulo y se llama al método repaint() para que se pinte.
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
	           // System.out.println("imprimir nuevas coordenadas x " + x1 + " y " + y1);
	           
	        //    circulo.setRadio(radioDibujado);
	            
	            // Se guarda la posición del ratón para el siguiente cálculo
	            xAnteriorRaton = e.getX();
	            yAnteriorRaton = e.getY();
	            
	            // y se manda repintar el Canvas
	            if(x1>0 && y1>0 && x1 <= xLimite && y1 <= yLimite)
	            {
	            	circulo.setX1(x1);
		            circulo.setY1(y1);
		            miPanel.repaint();
		            xAux= x1;
		            yAux= y1;
	            }
	            else
	            {
	            	x1= xAux;
	            	y1= yAux;
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
	     * Para ver si el ratón está dentro del circulo.
	     * Si está dentro, puede comenzar el arrastre.
	     *
	     * @param e El evento de ratón
	     *
	     * @return true si el ratón está dentro del circulo
	     */
 	
	    private boolean estaDentro(MouseEvent e)
	    {
	    	System.out.println("imprimir ");
	        if (
	            (e.getX() > x1) &&
	                (e.getX() < (x1 + radioDibujado)) &&
	                (e.getY() > y1) &&
	                (e.getY() < (y1 + radioDibujado)))
	        {
	        	System.out.println("esta dentro");
	        //	System.out.println("imprimir x1 " + e.getX() + " imprimir y1 " + e.getY());
	        	return true;
	            
	        }
	        System.out.println("esta fuera");
	        return false;
	    }
	    
	
  }