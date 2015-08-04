package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;









import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import javax.swing.SwingConstants;

import java.awt.Font;
 
 public class CirculoMouse extends JFrame{
     private Circulo circulo;
     private Panel miPanel;
     private Container contenedor;
     private JTextArea calculos;
     private JButton btnImprimir;
     private JPanel panelInferior;
     private JPanel panelContenedor;
     private JPanel panelInferiorCentro;
     private JPanel panelInferiorDerecho;
    // private  JScrollPane scrollpane;
    
     private MouseClick controlador1;
     private MouseAlzado controlador2;
     private MouseClick2 controlador3;
   
    private JLabel lblOcultar, lblZoom, lblOculto2;
     
     private JButton btnManoAlzada, btnDibujoClick, btnBorrarDibujo, btnZoomMas, btnZoomMenos;
     private JButton btnSalir;
     private int contador=0;
     private final int radioPuntero = 3;
     private  int ejex1=0;
     private  int ejex2=0;
     private  int ejey1=0;
     private  int ejey2=0;
     private int auxEjex1=0;
     private int auxEjey1=0;
     private int puntoNuevox1=0;
     private int puntoNuevoy2=0;
  
     private int anchoPanel= 1000;
     private int largoPanel= 500;
     public double factor = 100;
     public   double auxFactor;
     double AuxRadio;
     double radio;
     private  boolean banderaClick= true;
     private boolean banderaManoA= true; 
     private boolean banderaDibujo= true;
     private boolean banderaCancelar= true;
     
  	private  Statement sentencias;
 	private ResultSet resultado;
 	Validaciones validacion= new Validaciones();




   
   public CirculoMouse(){
        super("Dibujar Circulo con el Mouse");
        
        try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         contenedor = getContentPane();
         controlador1= new MouseClick();
         controlador2 = new MouseAlzado();
         controlador3= new MouseClick2();
        
         
         setSize(1000, 600);
       
         setResizable(false);
         setLocationRelativeTo(null);
         panelContenedor= new JPanel();
         panelContenedor.setLayout(new BorderLayout());
        
         miPanel = new Panel();
   
         //scrollpane = new JScrollPane();
     
        
         panelInferior= new JPanel();
         panelInferior.setLayout(new GridLayout(1,4,2,2));
         
         panelInferiorCentro= new JPanel();
         panelInferiorCentro.setLayout(new GridLayout(2,0,2,0));
         
         panelInferiorDerecho= new JPanel();
         panelInferiorDerecho.setLayout(new GridLayout(3,3,2,2));
         
         
         
        
         btnSalir= new JButton("Regresar al Menú");
         
         calculos = new JTextArea("Calculos");
         btnImprimir = new JButton("Imprimir Trabajo");
         btnManoAlzada= new JButton("Mano Alzada");
         btnZoomMas= new JButton("+");

    
         btnZoomMenos= new JButton("-");
    
       
       
         btnDibujoClick= new JButton("Click Mouse");
        
         btnBorrarDibujo= new JButton("Borrar Dibujo");
         
         lblOcultar= new JLabel();
         lblOcultar.setHorizontalAlignment(SwingConstants.CENTER);
         lblOculto2= new JLabel();
         lblOculto2.setFont(new Font("Tahoma", Font.BOLD, 14));
         lblOculto2.setForeground(Color.GREEN);
         lblOculto2.setHorizontalAlignment(SwingConstants.CENTER);
         lblZoom= new JLabel("100 %");
         lblZoom.setForeground(new Color(0, 100, 0));
         lblZoom.setFont(new Font("Tahoma", Font.BOLD, 14));
         lblZoom.setHorizontalAlignment(SwingConstants.CENTER);
      
         
         addComponentes();
         addEventos();
         desahabilitar();
         
         setVisible(true);
    }
   
   public void habilitar()
   {
	   btnZoomMas.setEnabled(true);
	   btnZoomMenos.setEnabled(true);
   }
   
   public void desahabilitar()
   {
	   btnZoomMas.setEnabled(false);
	   btnZoomMenos.setEnabled(false);
   }
   
        public void addComponentes()
        {
        
        	//scrollpane.setViewportView(miPanel);
        	//miPanel.setScrollPane(scrollpane);
        	
         panelInferior.add(calculos);
         panelInferior.add(panelInferiorCentro);
         panelInferior.add(panelInferiorDerecho);
        
         panelInferiorCentro.add(btnImprimir);
         panelInferiorCentro.add(btnSalir);
         panelInferiorDerecho.add(btnManoAlzada);
         panelInferiorDerecho.add(btnZoomMas);
         panelInferiorDerecho.add(lblOculto2);
         panelInferiorDerecho.add(btnDibujoClick);
         panelInferiorDerecho.add(btnZoomMenos);
         panelInferiorDerecho.add(lblZoom);
         panelInferiorDerecho.add(btnBorrarDibujo);
         panelInferiorDerecho.add(lblOcultar);
        
         panelContenedor.add(miPanel, BorderLayout.CENTER);
         panelContenedor.add(panelInferior, BorderLayout.SOUTH);
        // contenedor.add(bDibujar, BorderLayout.NORTH);
       //  contenedor.add(miPanel, BorderLayout.CENTER);
         contenedor.add(panelContenedor);

        // scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                 
        
        //muestra normal el JTextArea pero no permite escribir desde el teclado
         calculos.setEditable(false);        
         miPanel.setBackground(new Color(1,36,38));
       
        }
         
        public void addEventos(){
        	
        	
        	btnImprimir.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
            	
            	 
            	 
             }
         });
         
         btnSalir.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
               dispose();
               VentanaBienvenida ventana= new VentanaBienvenida();
             }
         });
         
         btnManoAlzada.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          	
          		if(banderaManoA)
          		{
          			addMouseMotionListener(controlador2);
              		addMouseListener(controlador3);
          		}
          		  
          		banderaManoA= false;
          		
          		contador=0;
          		banderaClick=true;
          		desahabilitar();
          		 calculos.setText("");
                removeMouseListener(controlador1);
                miPanel.repaint();
          		miPanel.vaciar();
          		banderaCancelar= true;
          		btnDibujoClick.setEnabled(true);
          		btnManoAlzada.setEnabled(false);
          		btnManoAlzada.setBackground(Color.YELLOW);
          		btnDibujoClick.setBackground(Color.LIGHT_GRAY);
          	}
          });
         
         
         btnDibujoClick.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		
          		
          		
          		contador=0;
          		if(banderaClick)
          		{
          		addMouseListener(controlador1);
          		}
          		banderaClick=false;
          		banderaManoA= true;
          		 desahabilitar();
          		 calculos.setText("");
          	    removeMouseMotionListener(controlador2);
          	    removeMouseListener(controlador3);
          	    miPanel.repaint();
        		miPanel.vaciar();
        		banderaCancelar= true;
        		btnDibujoClick.setEnabled(false);
          		btnManoAlzada.setEnabled(true);
          		btnDibujoClick.setBackground(Color.YELLOW);
          		btnManoAlzada.setBackground(Color.LIGHT_GRAY);
          	}
          });
         
         
         btnBorrarDibujo.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		desahabilitar();
          		contador=0;
          		banderaClick=true;
          		banderaManoA= true;
          		banderaCancelar= true;
          		calculos.setText("");
          		miPanel.repaint();
          		miPanel.vaciar();
          	}
          });
         
         
         btnZoomMas.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          	  auxFactor= factor;
          	  factor += 25;
          	  
          	  if(factor > auxFactor)
          	  {
          		  if(factor <= 200)
          		  {
          		     radio= escala(AuxRadio , factor);
          		  }
          		  else
          		  {
          			  factor=200;
          		  }
          	  }

  	        btnZoomMenos.setEnabled(factor > 5);
  	        btnZoomMas.setEnabled(factor < 200);
  	        lblZoom.setText(factor + " %");
  	        System.out.println("max " + factor);
  	  	 
  	        miPanel.vaciar();
  	      miPanel.repaint();
  	      //radio= reglaTres(radio, base, factor);
  	      System.out.println("radio aplicado la regla de tres 3: "+ radio);
  	       
  	        dibujarCirculo(ejex1, ejey1, radio);
  	       
          		
          	}
          });
         
         
         btnZoomMenos.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          	auxFactor= factor;
          	  factor -= 25;
          	  if(factor < auxFactor)
          	  {
          		  if(factor > 0)
          		  {
          			   radio= reglaTres(radio, auxFactor, factor);
          			  if(radio <= 0)
          			  {
          				 JOptionPane.showMessageDialog(null, "Error, La circuferencia ya no puede ser mas pequeña");
           				btnZoomMenos.setEnabled(false);
          			  } 
          			 
          		  
          		     
          		  }
          		  else
          		  {
          			  System.out.println("factor llego a cero");
          			  factor= 25;
          			  btnZoomMenos.setEnabled(false);
          		  }
          	  }
          	  
          	
          	    lblZoom.setText(factor + " %");
    	        btnZoomMas.setEnabled(factor < 200);
    	    	miPanel.repaint();
    	        miPanel.vaciar();
    	        System.out.println("min " + factor);
    	       
    	        System.out.println("radio aplicado la regla de tres 2: "+ radio);
    	        dibujarCirculo(ejex1, ejey1, radio);
    	        
          	}
          });
      
         

      }
        
        public double reglaTres(double radio, double auxFactor, double factor)
        {
        	double resultado= (radio * factor ) / auxFactor;
        	
        	return resultado;
        }
        
        public double escala(double AuxRadio, double factor)
        {
        	double resultado= (AuxRadio * factor ) / 100;
        	
        	return resultado;
        }
        
        public void dibujarCirculo(int x1, int y1, double radio){
        	  circulo = new Circulo(x1, y1, radio);
        	  
        	 miPanel.dibujar(circulo);
       	     
      
   
     }
     
     public void mostrarCalculos(double radio){
         String radio2;
         String diametro;
         String area;
         String circunferencia;
         DecimalFormat areaDecimal = new DecimalFormat("0.00"); 
         DecimalFormat circuDecimal = new DecimalFormat("0.00"); 
         
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
            	 
            	 sentencias.executeUpdate("INSERT INTO circulomouse VALUES ('"+codigo+"',"+"'"+r+"',"+"'"+d+"',"+"'"+a+"',"+"'"+c+"',"+"'"+date.format(now)+"',"+"'"+hour.format(now)+"',"+"'"+Login.usuarioAlumno+"')");
              }
              catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Insertar el Registro");
                  System.out.println(ex);
              }
       	 
        }
     }
     
     public double distanciaEntreDosPuntos(int x1, int y1, int x2, int y2)
     {
    	 double resul1= (x2-x1);
    	 resul1= Math.pow(resul1, 2);
    	 
         double resul2=(y2-y1);
         resul2= Math.pow(resul2, 2);
         
         double suma= resul1 + resul2;
        
    	 double resultado=  Math.sqrt(suma);
    	 return resultado;
     }
     

	
	

	
	
	
	public class MouseClick  implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent ev) {
	
			
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent ev) {
			 if(contador < 2)
		      {
		          if(contador == 1)
		          {
		        	  ejex2= ev.getX();
		  	          ejey2=ev.getY();
		  	          if(ejey2 < 499)
		  	          {
		  	        	 habilitar();
				        	
			              repaint();
			              contador=0;
			              radio= distanciaEntreDosPuntos(ejex1, ejey1, ejex2, ejey2);
			              System.out.println("radio original: "+ radio);
			              AuxRadio= radio;
			              radio= escala(radio, factor);
			              System.out.println("radio aplicado la regla de tres 1: "+ radio);
			            
			              System.out.println("x1= " + ejex1 + " " + "y1 " + ejey1 + " " + " x2 " + ejex2 + " " + " y2 " + ejey2);
			              dibujarCirculo(ejex1, ejey1, radio);
			              mostrarCalculos(AuxRadio);
		  	          }
		  	          else
		  	          {
		  	        	 miPanel.repaint();
	 	    	         miPanel.vaciar();
	 		        	 JOptionPane.showMessageDialog(null, "Error, No puede dibujar fuera del panel :)");
	 		        	 contador=0;
	 		        	 desahabilitar();
	 		        	 calculos.setText("");
		  	          }
		        	 
		             
		              
		             
		     
		        }
		        else
		        {
		                 contador++;
		                 ejex1= ev.getX();
		 		         ejey1=ev.getY();
		 		         if(ejey1 < 499)
		 		         {
		 		            Graphics g = miPanel.getGraphics();
		 			        g.setColor(Color.red);
		 			        g.fillOval(ev.getX()-radioPuntero, ev.getY()-radioPuntero, 2*radioPuntero, 2*radioPuntero);
		 			        g.dispose();
		 		         }
		 		         else
		 		         {
		 		        	 miPanel.repaint();
		 	    	         miPanel.vaciar();
		 		        	 JOptionPane.showMessageDialog(null, "Error, No puede dibujar fuera del panel :)");
		 		        	 contador=0;
		 		        	 desahabilitar();
		 		        	 calculos.setText("");
		 		        	 
		 		         }
		    
		    }
		   }
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
public class MouseAlzado  implements  MouseMotionListener {
		
		@Override
		public void mouseDragged(MouseEvent ev) {
			int a = ev.getX();
	        int b = ev.getY();
	        if(banderaDibujo)
	        {
		        	Graphics g= miPanel.getGraphics();
		    		
		   		 g.setColor(new Color(2,115,83));
		   		 g.drawLine(ejex1, ejey1, a, b);
		   		 
		   	     ejex1=a;   ejey1=b;
		   		 g.dispose();
	        }
		
			
		}
		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public class MouseClick2  implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent ev) {
	
			
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent ev) {
			
   
		        ejex1= ev.getX();
		        ejey1=ev.getY();
		        
		      if(banderaCancelar)
		      {
		    	   auxEjex1= ejex1;
			        auxEjey1 = ejey1;
		        if(auxEjey1 <= 490)
		        {
		        	    miPanel.vaciar();
		        	    Graphics g = miPanel.getGraphics();
				        g.setColor(Color.red);
				        ejex2= ev.getX();
				        ejey2=ev.getY();
				        g.fillOval(ejex2-radioPuntero,ejey2 -radioPuntero, 2*radioPuntero, 2*radioPuntero);
				        
				        System.out.println(ejex1 + " " + ejey1);
				        g.dispose();
				        banderaDibujo= true;
				   
		        }
		        else
		        {
		        	 banderaDibujo= false;
		        	 JOptionPane.showMessageDialog(null, "Error, No puede dibujar fuera del panel");
		        	 desahabilitar();
 		        	 calculos.setText("");
		        	
		        }
		      }
		      else
		      {
		    	   
			        Graphics g = miPanel.getGraphics();
			        g.setColor(Color.blue);
					  
			
			      
			     //   g.fillOval(auxEjex1-radioPuntero, auxEjey1-radioPuntero, 2*radioPuntero, 2*radioPuntero);
			        g.fillOval(ejex1-radioPuntero, ejey1-radioPuntero, 2*radioPuntero, 2*radioPuntero);
			        g.drawLine(ejex1, ejey1, ejex2, ejey2);
			        g.dispose();
			        
		      }
		      
			   
		   
			
		}
		
		public void paint(Graphics g, MouseEvent ev) {
			    g.setColor(Color.red);
			  
			    ejex2= ev.getX();
		        ejey2=ev.getY();
		        
		        System.out.println(auxEjex1 + " " + auxEjey1+ " " +ejex2 + " " + ejey2);
		     //   g.fillOval(auxEjex1-radioPuntero, auxEjey1-radioPuntero, 2*radioPuntero, 2*radioPuntero);
		        g.fillOval(ejex2-radioPuntero, ejey2-radioPuntero, 2*radioPuntero, 2*radioPuntero);
		        g.drawLine(auxEjex1, auxEjey1, ejex2, ejey2);
		        g.dispose();
		}
		
		public void paint (Graphics g1, int x1, int y1, int x2, int y2)
		{
			 
			
		        miPanel.update(g1);
		     	g1.setColor(Color.BLUE);
		        g1.fillOval(x1-radioPuntero, y1-radioPuntero, 2*radioPuntero, 2*radioPuntero);
		        g1.fillOval(x2-radioPuntero, y2-radioPuntero, 2*radioPuntero, 2*radioPuntero);
		        g1.drawLine(x1, y1, x2, y2);
		        g1.dispose();
		    
   	        
   	       
			
   	        
		}

		@Override
		public void mouseReleased(MouseEvent ev) {
			
			//miPanel.repaint();
			Graphics g = miPanel.getGraphics();
			DecimalFormat radioDecimal = new DecimalFormat("0.00"); 
            String radio2;
		    ejex2= ev.getX();
	        ejey2=ev.getY();
	        if(ejey2 > 0 && ejey2 <499)
	        {
	        	if( ejex2 > 0 && ejex2 <1000)
	        	{
	        		paint(g,ev);
	        		radio2= radioDecimal.format(distanciaEntreDosPuntos(auxEjex1, auxEjey1, ejex2, ejey2));
		        	 int ax = JOptionPane.showConfirmDialog(null, "Su radio es " + radio2 + " ,seguro que desea ese radio?");
				        if(ax == JOptionPane.YES_OPTION)
				        {
				        	  habilitar();
				        	
				              miPanel.repaint();
				              banderaCancelar= true;
				              radio=distanciaEntreDosPuntos(auxEjex1, auxEjey1, ejex2, ejey2);
				              System.out.println("radio original: "+ radio);
				              AuxRadio= radio;
				              radio= escala(radio, factor);
				              System.out.println("radio aplicado la regla de tres 1: "+ radio);
				            
				              System.out.println("x1= " + ejex1 + " " + "y1 " + ejey1 + " " + " x2 " + ejex2 + " " + " y2 " + ejey2);
				              dibujarCirculo(ejex1, ejey1, radio);
				              mostrarCalculos(AuxRadio);
				            
				        }
				        else if(ax == JOptionPane.NO_OPTION)
				        {
				        	miPanel.repaint();
			    	        miPanel.vaciar();
				        }
				        else if(ax == JOptionPane.CANCEL_OPTION)
				        {
				        	banderaCancelar= false;
				        	
				        	
				        	//miPanel.vaciar();
				           
			    	        System.out.println("x1= " + auxEjex1 + " " + "y1 " + auxEjey1 + " " + " x2 " + ejex2 + " " + " y2 " + ejey2);
			    	        Graphics g1 = miPanel.getGraphics();
			    	        paint (g1, auxEjex1, auxEjey1,ejex2,ejey2);
			    	        
			    	     
				        }
	        	}
	        	else
	        	{
	        		miPanel.repaint();
	    	        miPanel.vaciar();
		        	JOptionPane.showMessageDialog(null, "Error, No puede dibujar fuera del panel :)");
		        	 desahabilitar();
 		        	 calculos.setText("");
	        	}
	        	
	        }
	        else
	        {
	        	miPanel.repaint();
    	        miPanel.vaciar();
	        	JOptionPane.showMessageDialog(null, "Error, No puede dibujar fuera del panel :p");
	        	 desahabilitar();
		        	 calculos.setText("");
	        }
			
		    	
				
		       
			
		}
		
	}
	


	

 
	

  }
