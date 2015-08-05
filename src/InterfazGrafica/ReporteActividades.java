package InterfazGrafica;



import java.awt.Color;
import java.awt.Container;




import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import javax.swing.JRadioButton;

import javax.swing.SwingConstants;

import java.awt.Font;



import java.awt.FlowLayout;




import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
		
		panelCentro = new JPanel();
		 lblHasta = new JLabel("Hasta:");
		 JDateDesde = new JDateChooser();
		 JDateDesde.setForeground(new Color(46, 139, 87));
		 JDateHasta = new JDateChooser();
		 JDateHasta.setForeground(new Color(46, 139, 87));
		 
		rbNombre = new JRadioButton("Nombre",  false);
		rbfecha = new JRadioButton("Fecha", false);
		rbTodos = new JRadioButton("Todos",  false);
	
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
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 100, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 11, 65, 28);
		panelCentro.add(lblNombre);
		
		txtNombre = new JTextField();
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
}