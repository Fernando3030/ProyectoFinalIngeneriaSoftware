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

import java.awt.Font;



import java.awt.FlowLayout;















import Clases.Alumno;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ReporteAlumnos {

	private JFrame frmReporteDeAlumnos;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblDesde;
	 private JRadioButton rbfecha;
	 private JRadioButton rbTodos;
	 private ButtonGroup group;
	 private JPanel panelSuperiorCentral;
	private JPanel panelCentro ;
	private JLabel lblHasta;
	private  JDateChooser JDateDesde ;
	private  JDateChooser JDateHasta;
	private JPanel panelInferior;
	private  JButton btnGenerar;
	private ArrayList <Alumno> arrayAlumno;
	private Acciones accionesRadioB;
	private Statement sentencias;
	private ResultSet resultado;


	/**
	 * Create the application.
	 */
	public ReporteAlumnos() {
		frmReporteDeAlumnos = new JFrame();
		frmReporteDeAlumnos.setTitle("Reporte de alumnos");
		miPanel= new JPanel();
		miPanel.setBackground(new Color(46, 139, 87));
		panelSuperior= new JPanel();
		panelSuperior.setBounds(0, 0, 522, 131);
		panelSuperior.setBackground(new Color(46, 139, 87));
		lblimagen= new JLabel("");
		lblimagen.setBounds(0, 0, 221, 131);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/repo.png")));
		lblTitulo= new JLabel("Reportes Alumnos");
		lblTitulo.setBounds(168, 0, 348, 131);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelCentro = new JPanel();
		 lblHasta = new JLabel("Hasta:");
		 JDateDesde = new JDateChooser();
		 JDateDesde.setEnabled(false);
		 
		 JDateDesde.setForeground(new Color(46, 139, 87));
		 JDateHasta = new JDateChooser();
		 JDateHasta.setEnabled(false);
		 JDateHasta.setForeground(new Color(46, 139, 87));
		 
		 accionesRadioB= new Acciones();
		 
		rbfecha = new JRadioButton("Fecha", false);
		rbfecha.addItemListener(accionesRadioB);
		rbTodos = new JRadioButton("Todos",  false);
		rbTodos.addItemListener(accionesRadioB);
		group = new ButtonGroup();
	
		
		
		
		
		 miFramePane = frmReporteDeAlumnos.getContentPane();
		
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
		
		try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miPanel.add(panelSuperior);
		miFramePane.add(miPanel);
		

		panelCentro.setBackground(Color.WHITE);
		panelCentro.setBounds(20, 174, 478, 128);
		miPanel.add(panelCentro);
		panelCentro.setLayout(null);
		lblDesde= new JLabel("Desde:");
		lblDesde.setBounds(10, 11, 65, 36);
		panelCentro.add(lblDesde);
		lblDesde.setForeground(new Color(0, 100, 0));
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		lblHasta.setForeground(new Color(0, 100, 0));
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHasta.setBounds(247, 19, 65, 28);
		panelCentro.add(lblHasta);
		
		
		JDateDesde.setBounds(63, 19, 155, 28);
		panelCentro.add(JDateDesde);
		
		
		JDateHasta.setBounds(298, 19, 155, 28);
		panelCentro.add(JDateHasta);
		btnGenerar = new JButton("");
		btnGenerar.setEnabled(false);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayAlumno= new ArrayList<Alumno>();
				if(rbfecha.isSelected()==true){
					
					try {
					       
				        resultado=sentencias.executeQuery("SELECT * FROM alumnos WHERE fech_reg_alumno between '"+JDateDesde.getDate()+"'"+" and '"+ JDateHasta.getDate()+"'");
				     
				        while(resultado.next())
						{	
				        	
						        String nombre= resultado.getString(2);
						        String apellido= resultado.getString(3);
						        String curso= resultado.getString(4);
						        String paralelo= resultado.getString(9);
						        Date fecha= resultado.getDate(5);
						        String usuario= resultado.getString(6);
						        arrayAlumno.add(new Alumno(nombre,apellido,curso,paralelo,fecha,usuario));
						        
						        
						     
						}
				  
						        	
				  
				       
				     } // final del try
				     catch(SQLException ex) {
				       
				        System.out.println(ex);
				     }
					
					try
		    		{
						
		    		    JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reporteAlumnosFinal.jasper");
		    		    
		    		  
		    		    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(arrayAlumno));
		    		//    JasperPrint jasperPrint2 = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(detalle2));
		    		    JRExporter exporter = new JRPdfExporter();
		    		    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		    		    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte Alumnos.pdf"));
		    		    
		    		    JasperViewer jviewer = new JasperViewer(jasperPrint,false);
		    		    jviewer = new JasperViewer(jasperPrint,false);
		    		    jviewer.setTitle("Reportes de Alumnos");
		    		    jviewer.setVisible(true);
		    		    exporter.exportReport();
		    			JOptionPane.showMessageDialog(null, "Factura Generada con Exito");
		    		}
		    		catch(JRException e)
		    		{
		    		    e.printStackTrace();
		    		}
			         

					}
					
					if(rbTodos.isSelected()==true){
						
			        }
				
				
			}
		});
		
		panelInferior = new JPanel();
		panelInferior.setBounds(141, 58, 200, 65);
		panelCentro.add(panelInferior);
		panelInferior.setBackground(Color.WHITE);
		
		
		btnGenerar.setToolTipText("Generar Reporte");
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/Maintenance-icon.png")));
		panelInferior.add(btnGenerar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmReporteDeAlumnos.dispose();
				VentanaBienvenida ventana= new VentanaBienvenida();
			}
		});
		btnSalir.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/salirr.png")));
		btnSalir.setToolTipText("Salir");
		panelInferior.add(btnSalir);
		
		 panelSuperiorCentral = new JPanel();
		panelSuperiorCentral.setBackground(Color.WHITE);
		panelSuperiorCentral.setBounds(20, 137, 169, 38);
		miPanel.add(panelSuperiorCentral);
		panelSuperiorCentral.add(rbfecha);
		panelSuperiorCentral.add(rbTodos);
		group.add(rbfecha);
		group.add(rbTodos);
		
		
	
		
		
		 frmReporteDeAlumnos.setVisible(true);
		frmReporteDeAlumnos.setSize(528,342);
		frmReporteDeAlumnos.setLocationRelativeTo(null);
        frmReporteDeAlumnos.setResizable(false); 
        frmReporteDeAlumnos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class Acciones implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if(rbfecha.isSelected()==true){
	           JDateHasta.setEnabled(true);
	           JDateDesde.setEnabled(true);
	           btnGenerar.setEnabled(true);

			}
			
			if(rbTodos.isSelected()==true){
				JDateHasta.setEnabled(false);
		           JDateDesde.setEnabled(false);
		           btnGenerar.setEnabled(true);
	        }
			
		}
		
	}
}

