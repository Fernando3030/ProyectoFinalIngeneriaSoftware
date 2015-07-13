package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Clases.Circulo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
 
 public class CirculoParametros extends JFrame{
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
   
   public CirculoParametros(){
        super("Dibujar Circulo con Parámetros");
         contenedor = getContentPane();
        setSize(500, 600);
         contenedor.setBackground(Color.WHITE);
         setResizable(false);
         setLocationRelativeTo(null);
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
         
         addComponentes();
         addEventos();
         
         setVisible(true);
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
            		 if(radio >= 1 & radio <=150)
            		 {
		                 dibujarCirculo(radio);
		                 mostrarCalculos(radio);
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
               dispose();
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
          				getToolkit().beep();
          				JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
          			}
          		}
          		else
          		{
          			if(!Character.isDigit(c)&& c!= KeyEvent.VK_BACK_SPACE)
          			{
          				ke.consume();
          				getToolkit().beep();
          				JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
          			}
          		}
                 
                 
                
          }});
      }
        
        public void dibujarCirculo(double radio){
      
        	int x1= 175;
        	int y1=175;
         
         
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
     }
  }