package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Clases.Circulo;
import Clases.Validaciones;
 
 public class CirculoAleatorio extends JFrame{
     private Circulo circulo;
     private Panel miPanel;
     private Container contenedor;
    private JTextArea calculos;
     private JButton bDibujar;
     private JPanel panelInferior;
     private JButton btnSalir;
     
		private  Statement sentencias;
		private ResultSet resultado;
		Validaciones validacion= new Validaciones();
     
   
   public CirculoAleatorio(){
	   
	   
        super("Dibujar Circulo Aleatoriamente");
        try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         contenedor = getContentPane();
        setSize(500, 600);
         contenedor.setBackground(Color.WHITE);
         setResizable(false);
         setLocationRelativeTo(null);
         panelInferior= new JPanel();
         panelInferior.setLayout(new GridLayout(1,2,0,3));
         btnSalir= new JButton("Regresar al Menú");
         
         addComponentes();
         addEventos();
         
         setVisible(true);
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
                
             }
         });
         
         btnSalir.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evento){
               dispose();
               VentanaBienvenida ventana= new VentanaBienvenida();
             }
         });
      }
        
        public void dibujarCirculo(){
       
        	int x1= 175;
        	int y1=175;
            double radio = (Math.floor(Math.random()*(150-1+1))+1);
         
         circulo = new Circulo(x1, y1, radio);
        
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
        	Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
            
            
              try {
             	 
             	 sentencias.executeUpdate("INSERT INTO circuloaleatorio VALUES ('"+Login.usuarioAlumno+"',"+"'"+r+"',"+"'"+d+"',"+"'"+a+"',"+"'"+c+"',"+"'"+codigo+"',"+"'"+date.format(now)+"',"+"'"+hour.format(now)+"')");
               }
               catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Insertar el Registro");
                   System.out.println(ex);
               }
        	 
         }
        
         
         
     }
     
   
  }