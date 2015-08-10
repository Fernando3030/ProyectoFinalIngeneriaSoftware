package InterfazGrafica;



import java.awt.Color;
import java.awt.Container;











import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.Font;



import java.awt.FlowLayout;











import Clases.Alumno;
import Clases.Circulo;
import InterfazGrafica.ReporteAlumnos.Acciones;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteActividades {

	private JFrame frame;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblDesde;
	 private JRadioButton rbfecha;
	 private JRadioButton rbTodos;
	 private JRadioButton rbNombre;
	 private ButtonGroup group;
	 private JPanel panelSuperiorCentral;
	private JPanel panelCentro ;
	private JLabel lblHasta;
	private  JDateChooser JDateDesde ;
	private  JDateChooser JDateHasta;
	private JPanel panelInferior;
	private  JButton btnGenerar;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private Acciones  accionesRadioB;
	
	private ArrayList <Circulo> arrayCirculo;

	private Statement sentencias;
	private ResultSet resultado;
	  SimpleDateFormat hora;
	

	/**
	 * Create the application.
	 */
	public ReporteActividades() {
		frame = new JFrame();
		frame.setTitle("Reporte Actividades");
		miPanel= new JPanel();
		miPanel.setBackground(new Color(46, 139, 87));
		panelSuperior= new JPanel();
		panelSuperior.setBounds(0, 0, 522, 131);
		panelSuperior.setBackground(new Color(46, 139, 87));
		lblimagen= new JLabel("");
		lblimagen.setBounds(0, 0, 221, 131);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/repo.png")));
		lblTitulo= new JLabel("Reportes Actividades");
		lblTitulo.setBounds(168, 0, 348, 131);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		panelCentro = new JPanel();
		 lblHasta = new JLabel("Hasta:");
		 JDateDesde = new JDateChooser();
		 JDateDesde.setEnabled(false);
		 JDateDesde.setForeground(new Color(46, 139, 87));
		 JDateHasta = new JDateChooser();
		 JDateHasta.setEnabled(false);
		 JDateHasta.setForeground(new Color(46, 139, 87));
		 accionesRadioB= new Acciones();
		rbNombre = new JRadioButton("Usuario",  false);
		rbNombre.addItemListener(accionesRadioB);
		rbfecha = new JRadioButton("Fecha", false);
		rbfecha.addItemListener(accionesRadioB);
		rbTodos = new JRadioButton("Todos",  false);
		rbTodos.addItemListener(accionesRadioB);
		hora = new SimpleDateFormat("HH:mm:ss");
	
		group = new ButtonGroup();
	
		
		
		
		
		 miFramePane = frame.getContentPane();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panelSuperior.setLayout(null);

		panelSuperior.add(lblimagen);
		panelSuperior.add(lblTitulo);
		miPanel.setLayout(null);
		
		
		miPanel.add(panelSuperior);
		miFramePane.add(miPanel);
		

		panelCentro.setBackground(Color.WHITE);
		panelCentro.setBounds(20, 174, 478, 159);
		miPanel.add(panelCentro);
		panelCentro.setLayout(null);
		lblDesde= new JLabel("Desde:");
		lblDesde.setBounds(10, 50, 65, 28);
		panelCentro.add(lblDesde);
		lblDesde.setForeground(new Color(0, 100, 0));
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		lblHasta.setForeground(new Color(0, 100, 0));
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHasta.setBounds(247, 50, 65, 28);
		panelCentro.add(lblHasta);
		
		
		JDateDesde.setBounds(73, 50, 155, 28);
		panelCentro.add(JDateDesde);
		
		
		JDateHasta.setBounds(298, 50, 155, 28);
		panelCentro.add(JDateHasta);
		btnGenerar = new JButton("");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				arrayCirculo= new ArrayList<Circulo>();
				
				String nombre= txtNombre.getText();
				if(rbfecha.isSelected()==true)
				{
					Date fechaDesde = JDateDesde.getDate();
					Date fechaHasta = JDateHasta.getDate();
					
					if(fechaDesde != null && fechaHasta != null)
					{
						try {
						       
					        resultado=sentencias.executeQuery("SELECT * FROM circulo WHERE fecha between '"+fechaDesde+"'"+" and '"+ fechaHasta+"'");
					     
					        while(resultado.next())
							{	
					        	
							        String usuario= resultado.getString(1);
							        
							        double  radio= resultado.getDouble(2);
							        double  diametro= resultado.getDouble(3);
							        double area = resultado.getDouble(4);
							        double  circunferencia= resultado.getDouble(5);
							        
							        Date fecha= resultado.getDate(7);
							        Time hora= resultado.getTime(8);
							        System.out.println("hora " + hora);
							 
							        arrayCirculo.add(new Circulo(usuario,radio,diametro,area,circunferencia,fecha,hora));
							        
							        
							     
							}
					  
							        	
					  
					       
					     } // final del try
					     catch(SQLException ex) {
					       
					        System.out.println(ex);
					     }
						
						try
			    		{
							
			    		    JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reporteActividades.jasper");
			    		    
			    		  
			    		    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(arrayCirculo));
			    		//    JasperPrint jasperPrint2 = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(detalle2));
			    		    JRExporter exporter = new JRPdfExporter();
			    		    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			    		    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte Actividades.pdf"));
			    		    
			    		    JasperViewer jviewer = new JasperViewer(jasperPrint,false);
			    		    jviewer = new JasperViewer(jasperPrint,false);
			    		    jviewer.setTitle("Reportes de Actividades");
			    		    jviewer.setVisible(true);
			    		    exporter.exportReport();
			    			JOptionPane.showMessageDialog(null, "Reporte Generada con Exito");
			    		}
			    		catch(JRException e)
			    		{
			    		    e.printStackTrace();
			    		}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No puede dejar campos vacíos");
					}
				}
				
				
               if(rbTodos.isSelected()==true){
					JDateDesde.setDate(null);
					JDateHasta.setDate(null);
					
					
						try {
						       
					        resultado=sentencias.executeQuery("SELECT * FROM circulo");
					     
					        while(resultado.next())
							{	
					        	
							        String usuario= resultado.getString(1);
							        
							        double  radio= resultado.getDouble(2);
							        double  diametro= resultado.getDouble(3);
							        double area = resultado.getDouble(4);
							        double  circunferencia= resultado.getDouble(5);
							        
							        Date fecha= resultado.getDate(7);
							        Time hora= resultado.getTime(8);
							        System.out.println("hora " + hora);
							 
							        arrayCirculo.add(new Circulo(usuario,radio,diametro,area,circunferencia,fecha,hora));
							        
							        
							     
							}
					  
							        	
					  
					       
					     } // final del try
					     catch(SQLException ex) {
					       
					        System.out.println(ex);
					     }
						
						try
			    		{
							
			    		    JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reporteActividades.jasper");
			    		    
			    		  
			    		    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(arrayCirculo));
			    		//    JasperPrint jasperPrint2 = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(detalle2));
			    		    JRExporter exporter = new JRPdfExporter();
			    		    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			    		    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte de Todas las Actividades.pdf"));
			    		    
			    		    JasperViewer jviewer = new JasperViewer(jasperPrint,false);
			    		    jviewer = new JasperViewer(jasperPrint,false);
			    		    jviewer.setTitle("Reportes de Actividades");
			    		    jviewer.setVisible(true);
			    		    exporter.exportReport();
			    			JOptionPane.showMessageDialog(null, "Reporte Generada con Exito");
			    		}
			    		catch(JRException e)
			    		{
			    		    e.printStackTrace();
			    		}
						
					}
				
			
				
					
			if(rbNombre.isSelected()==true)
			{
				JDateDesde.setDate(null);
				JDateHasta.setDate(null);
				if(nombre.length() != 0)
				{
					try {
					       
				        resultado=sentencias.executeQuery("SELECT * FROM circulo where usuario_alumno = '" + nombre+ "'");
				     
				        while(resultado.next())
						{	
				        	
						        String usuario= resultado.getString(1);
						        
						        double  radio= resultado.getDouble(2);
						        double  diametro= resultado.getDouble(3);
						        double area = resultado.getDouble(4);
						        double  circunferencia= resultado.getDouble(5);
						        
						        Date fecha= resultado.getDate(7);
						        Time hora= resultado.getTime(8);
						        System.out.println("hora " + hora);
						 
						        arrayCirculo.add(new Circulo(usuario,radio,diametro,area,circunferencia,fecha,hora));
						        
						        
						     
						}
				  
						        	
				  
				       
				     } // final del try
				     catch(SQLException ex) {
				       
				        System.out.println(ex);
				     }
					
					try
		    		{
						
		    		    JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reporteActividades.jasper");
		    		    
		    		  
		    		    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(arrayCirculo));
		    		//    JasperPrint jasperPrint2 = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(detalle2));
		    		    JRExporter exporter = new JRPdfExporter();
		    		    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		    		    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte de Todas las Actividades.pdf"));
		    		    
		    		    JasperViewer jviewer = new JasperViewer(jasperPrint,false);
		    		    jviewer = new JasperViewer(jasperPrint,false);
		    		    jviewer.setTitle("Reportes de Actividades");
		    		    jviewer.setVisible(true);
		    		    exporter.exportReport();
		    			JOptionPane.showMessageDialog(null, "Reporte Generada con Exito");
		    		}
		    		catch(JRException e)
		    		{
		    		    e.printStackTrace();
		    		}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No puede dejar campos vacíos");
				}
			}
				
					
				
			
	
			         

				
				
			
				}});
		btnGenerar.setEnabled(false);
		
		panelInferior = new JPanel();
		panelInferior.setBounds(137, 89, 200, 65);
		panelCentro.add(panelInferior);
		panelInferior.setBackground(Color.WHITE);
		
		
		btnGenerar.setToolTipText("Generar Reporte");
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/Maintenance-icon.png")));
		panelInferior.add(btnGenerar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				VentanaBienvenida ventana= new VentanaBienvenida();
			}
		});
		btnSalir.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/salirr.png")));
		btnSalir.setToolTipText("Salir");
		panelInferior.add(btnSalir);
		
		lblNombre = new JLabel("Usuario:");
		lblNombre.setForeground(new Color(0, 100, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 11, 65, 28);
		panelCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setForeground(new Color(46, 139, 87));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(73, 13, 155, 28);
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		 panelSuperiorCentral = new JPanel();
		panelSuperiorCentral.setBackground(Color.WHITE);
		panelSuperiorCentral.setBounds(20, 137, 215, 38);
		miPanel.add(panelSuperiorCentral);
		panelSuperiorCentral.add(rbfecha);
		panelSuperiorCentral.add(rbTodos);
		panelSuperiorCentral.add(rbNombre);
		group.add(rbNombre);
		group.add(rbfecha);
		group.add(rbTodos);
		
		
	
		
		
		 frame.setVisible(true);
		frame.setSize(531,373);
		frame.setLocationRelativeTo(null);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class Acciones implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if(rbfecha.isSelected()==true){
	           JDateHasta.setEnabled(true);
	           JDateDesde.setEnabled(true);
	           btnGenerar.setEnabled(true);
	           txtNombre.setEnabled(false);

			}
			
			if(rbTodos.isSelected()==true){
				JDateHasta.setEnabled(false);
		           JDateDesde.setEnabled(false);
		           btnGenerar.setEnabled(true);
		           txtNombre.setEnabled(false);
	        }
			
			if(rbNombre.isSelected()==true){
				JDateHasta.setEnabled(false);
		           JDateDesde.setEnabled(false);
		           txtNombre.setEnabled(true);
		           btnGenerar.setEnabled(true);
	        }
			
		}
		
	}
}