package InterfazGrafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Clases.JButtonCircle;

public class VentanaBienvenida extends JFrame  implements MouseListener,ActionListener{
	 private Container miFramePane;


	public JPanel panel  = new JPanel(){
        

		public void paintComponent(Graphics g) {        
            Graphics2D g2 =(Graphics2D) g;         
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //para el fondo blanco se pinta un rectangulo en todo el JPanel circular
            g2.setColor( new Color(0,205,115) );
            Rectangle2D body = new Rectangle2D.Float(0, 0, (float) panel.getSize().getWidth(), (float) panel.getSize().getHeight() );
            g2.fill( body );
            
            google_circle( g2 );        
        }
	};
	
    /* tamaño del JPanel circular */
    private Dimension size = new Dimension( 400,400 );
    //bandera boolean para saber si el cursor del mouse esta dentro o fuera del JPanel
    private boolean __in__ = false;
    private Timer timer;
    
    //
    private float alto_ancho = 200; //ancho de circulo
    private float posicionxy = 100; //coordenada de la esquina sup derecha del circulo

    /* array de botones circulares */
    private JButtonCircle[] btn = new JButtonCircle[11];    
    /* coordenadas de los botones circulares */
    private Point[] pB = { new Point(62,170), // boton dibujar con mouse
                           new Point(278,170) , // boton dibujar con parametros

                           new Point(170,64) , // boton dibujar aleatoriamente
                          
                           new Point(170,278) , // boton salir
                           new Point(90 ,98), // boton documentos para leer
                           new Point(225 ,75), // boton perfil estudiante
                           new Point(115 ,265), // subir archivo otro autor
                           new Point(225 ,265), // Reporte Actividades
                         
                           new Point(265 ,115), // registro de alumnos
                           new Point(75 ,225), // subir archivo del profesor
                           new Point(265 ,225), // reporte de alumnos



                      
    };

    /* array de ImageIcon -> fotos para los botones */
    private ImageIcon[] icono = {
        new ImageIcon(getClass().getResource("/Imagenes/circulos.png")),
        new ImageIcon(getClass().getResource("/Imagenes/circulo3.png")),
        new ImageIcon(getClass().getResource("/Imagenes/circulo2.png")),
        new ImageIcon(getClass().getResource("/Imagenes/circulo4.png")),
        new ImageIcon(getClass().getResource("/Imagenes/documentoProfesor.png")),
        new ImageIcon(getClass().getResource("/Imagenes/profile2.png")),
        new ImageIcon(getClass().getResource("/Imagenes/uploadDocumentosAutores.png")),
        new ImageIcon(getClass().getResource("/Imagenes/reporteActividades.png")),
      
        new ImageIcon(getClass().getResource("/Imagenes/adduser.png")),
        new ImageIcon(getClass().getResource("/Imagenes/uploadDocumentosPropio.png")),
        new ImageIcon(getClass().getResource("/Imagenes/reporteAlumnos.png")),
        
    
    };

    /**
 * ActionCommand de los 12 botones circulares
 */
    public enum Accion
    {
        __1, //mouse
        __2, // parametros
        __3, // aleatorio
        __4, // salida
        __5, // documentosProfesor
        __6, // profile estudiante
        __7,  // subir documentos autores
        __8, // reporte de actividades
       
        __9, // agregar estudiante
        __10, // subir archivo del profesor
        __11 // reportes alumnos
      
    }

    /**
 * Constructor de clase
 */
    public VentanaBienvenida()
    {
    	miFramePane = this.getContentPane();
    	
        panel.setPreferredSize( size );
        panel.setSize( size );        
        panel.setVisible(true); 
        
     
       

        panel.addMouseListener(this);

        //añade los botones circulares al jpanel circular 
        for( int i=0; i<11 ; i++)
        {
            btn[i] = new JButtonCircle( pB[i] );
            btn[i].setVisible( false );
            btn[i].setActionCommand("__" + (i+1) );
            if(i== 0)
            {
            btn[i].setToolTipText("Dibujar circuferencia con mouse"  );
           
            }
            else
            	 if(i== 1)
                 {
                 btn[i].setToolTipText("Dibujar circuferencia escribiendo valores"  );
                 }
            	 else
                	 if(i== 2)
                     {
                     btn[i].setToolTipText("Dibujar circuferencia de forma aleatoria"  );
                     }
                	 else
	            if(i== 3)
	            {
	            btn[i].setToolTipText("Salida"  );
	            }
	            else
	            	 if(i== 4)
	 	            {
	 	            btn[i].setToolTipText("Documentos de lectura"  );
	 	            }
	            	 else
		            	 if(i== 5)
		 	            {
		 	            btn[i].setToolTipText("Perfiles"  );
		 	            }
		            	 else
			            	 if(i== 6)
			 	            {
			 	            btn[i].setToolTipText("Subir archivo de otros autores"  );
			 	             btn[i].setEnabled(Login.ActivarMenu);
			 	          
			 	          
			 	            }
			            	 else
				            	 if(i== 7)
				 	            {
				 	            btn[i].setToolTipText("Reporte de actividades"  );
				 	           btn[i].setEnabled(Login.ActivarMenu);
				 	         
				 	            }
				            	
					            	 else
						            	 if(i== 8)
						 	            {
						 	            btn[i].setToolTipText("Agregar estudiante"  );
						 	           btn[i].setEnabled(Login.ActivarMenu);
						 	        
						 	            }
						            	 else
							            	 if(i== 9)
							 	            {
							 	            btn[i].setToolTipText("Subir archivo propio"  );
							 	           btn[i].setEnabled(Login.ActivarMenu);
							 	          
							 	            }
							            	 else
								            	 if(i== 10)
								 	            {
								 	            btn[i].setToolTipText("Reportes de Alumno"  );
								 	           btn[i].setEnabled(Login.ActivarMenu);
								 	         
								 	      
								 	            }
            btn[i].setFotografia( icono[i] );
            btn[i].addActionListener( this ); 
            btn[i].addMouseListener(this);
            panel.add( btn[i] );
        }

        //JLabel
        JLabel label = new JLabel();
        label.setText("Elija la opción");
        label.setForeground( Color.white );
        label.setFont( new Font("Arial", Font.BOLD, 16) );
        label.setOpaque(false);
        label.setBounds(152, 184, 140, 30);        
        label.setVisible(true);
        panel.add(label);

        //se asigna layout al JPCircle !importante: siempre al final
        panel.setLayout(null);
        miFramePane.add(panel);
       
        
        this.setTitle("Bienvenidos");
	   
	    
	    this.setSize(420, 435);
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this. setResizable(false);
        
        //inicia animacion
        animacion();
    }

    
   
    /**
 * pinta el circulo utilizando java2d
 * @param g2 Graphics2D
 */
    private void google_circle( Graphics2D g2 )
    {
        //cuerpo circulo
        g2.setColor( new Color(0,129,72) );                    
        Ellipse2D bcircle = new Ellipse2D.Float( posicionxy , posicionxy , alto_ancho ,alto_ancho );            
        g2.fill( bcircle );
        //pinta borde blanco si es necesario
        if( alto_ancho > 251)
        {            
            g2.setColor( new Color(62,205,142) );
            g2.setStroke(new BasicStroke(15.0f));
            Ellipse2D bcircle1 = new Ellipse2D.Float( posicionxy , posicionxy ,alto_ancho , alto_ancho);
            g2.draw( bcircle1 );
        }

        //muestra botones circulares si es necesario
        if( alto_ancho >= 294 )
        {            
            for( int i=0; i<11 ; i++)
            {            
                btn[i].setVisible(true);     
              
            }
        }
        else if( alto_ancho < 288 ) //si el circulo es muy pequeño los oculta
        {
            for( int i=0; i<11 ; i++)
            {            
                btn[i].setVisible(false);            
            }
        }

        //pinta borde oscuro
        g2.setColor( new Color(34,135,101) );
        g2.setStroke(new BasicStroke( 3.0f) );
        Ellipse2D bcircle2 = new Ellipse2D.Float(posicionxy ,posicionxy ,alto_ancho , alto_ancho );
        g2.draw( bcircle2 );

        //-------------------------------------------------------------------//
        //pinta el circulo interior azul
        g2.setColor( new Color(62,205,142) );
        Ellipse2D circle_int = new Ellipse2D.Float(125.0f ,125.0f ,150.0f ,150.0f);
        g2.fill( circle_int );                
        //borde
        g2.setColor( new Color(34,135,101) );
        g2.setStroke(new BasicStroke(2.0f));
        Ellipse2D bc2 = new Ellipse2D.Float(125.0f ,125.0f ,150.0f ,150.0f);
        g2.draw( bc2 );     
        //-------------------------------------------------------------------//

    }

   /**
 * Se hace uso de un Timerpara la animacion 
 * cuando el raton esta dentro del JPanel se expande, si esta fuera decrece
 * la velocidad se mide en milisegundo, en este caso se hace uso de 5 milisegundos
 */
   public void animacion() {
    TimerTask task = new TimerTask() {
      @Override
      public void run() {          
          if( __in__ ) //Si raton esta dentro de JPCircle -> crece
          {
            if( alto_ancho <= 300 )
            {
              alto_ancho = alto_ancho + 1;
              posicionxy = posicionxy - 0.5f ;
            }          
          }
          else //Si raton esta fuera de JPCircle -> decrece
          {
            if( alto_ancho > 200 )
            {
                alto_ancho = alto_ancho - 1;
                posicionxy = posicionxy + 0.5f ;
            }                        
          }          
          panel.repaint();
      }
    };
    timer = new Timer();    
    timer.schedule(task, 0, 5 );
  }

    //-----------------------------------------------------------------------//
    // Eventos del raton
    @Override
    public void mouseClicked(MouseEvent e) { /*...*/ }

    @Override
    public void mousePressed(MouseEvent e) { /*...*/ }

    @Override
    public void mouseReleased(MouseEvent e) { /*...*/ }

    @Override
    public void mouseEntered(MouseEvent e) {

       __in__ = true;
       
       panel.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

        __in__ = false;
     
        panel.repaint();        
    }

    /**
 * Aqui se deben colocar las acciones que se llevaran a cabo cuando se presione
 * algunos de los botones circulares
 * @param e ActionEvent
 */
    @Override
    public void actionPerformed(ActionEvent e) {       
       switch ( Accion.valueOf( e.getActionCommand() ) )
       {
            case __1:
            	this.dispose();
            	CirculoMouse mouse= new CirculoMouse();
              
               break;
            case __2: 
            	this.dispose();
            	CirculoParametros circulo= new CirculoParametros();
            	
                
                break;    
            case __3: 
            	CirculoAleatorio ventana = new CirculoAleatorio();
                this.dispose();
                break;    
            case __4: 
            	Login login= new Login();
            	this.dispose();
                break;  
                
            case __5: 
            	LeerDocumentoProfesor leer= new LeerDocumentoProfesor();
            	this.dispose();
                break;  
            case __6: 
           	   ProfileEstudiante profile = new ProfileEstudiante();
           	    this.dispose();
           	    break;
            case __7: 
            	   SubirArchivoAutores subir = new SubirArchivoAutores();
            	    this.dispose();
            	    break;
            case __8: 
           	    ReporteActividades reporteAc= new ReporteActividades();
           	    this.dispose();
               break;  
               
            case __9: 
           	    GestionAlumnos alumno= new GestionAlumnos();
           	    this.dispose();
               break;  
               
            case __10: 
           	    SubirArchivoProfesor subirP= new SubirArchivoProfesor();
           	    this.dispose();
               break;  
               
            case __11: 
           	    ReporteAlumnos reporteA= new ReporteAlumnos();
           	    this.dispose();
               break;  
              

       }
    }


}

