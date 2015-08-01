package InterfazGrafica;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class GestionAlumnos {

	private JFrame frame;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JPanel panelCentro;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblCodigo, lblNombre, lblApellido, lblCurso, lblFecha, lblUsuario, lblContra;
	 private JTextField txtNombre, txtCodigo, txtApellido, txtCurso, txtUsuario;
	 private JPasswordField txtContra;
	 private JButton btnRegistrar, btnBuscar, btnModificar, btnEliminar, btnSalir, btnNuevo;
	 private JPanel panelDerecho;

	
	

	/**
	 * Create the application.
	 */
	public GestionAlumnos() {
		frame = new JFrame("Alumnos");
		miPanel= new JPanel();
		miPanel.setBackground(new Color(46, 139, 87));
		panelSuperior= new JPanel();
		panelSuperior.setBounds(0, 0, 444, 131);
		panelSuperior.setBackground(new Color(46, 139, 87));
		lblimagen= new JLabel("");
		lblimagen.setBounds(0, 0, 221, 131);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/userrrr.png")));
		lblTitulo= new JLabel("Gesti\u00F3n de Alumnos");
		lblTitulo.setBounds(168, 0, 252, 131);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panelCentro= new JPanel();
		panelCentro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCentro.setBackground(new Color(255, 255, 255));
		panelCentro.setBounds(10, 131, 304, 440);
		
		lblCodigo= new JLabel("Codigo");
		lblCodigo.setForeground(new Color(0, 100, 0));
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(41, 0, 84, 31);
		lblNombre= new JLabel("Nombres"); 
		lblNombre.setForeground(new Color(0, 100, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(41, 54, 84, 36);
		lblApellido = new JLabel("Apellidos");
		lblApellido.setForeground(new Color(0, 100, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(41, 122, 90, 31);
		lblCurso = new JLabel("Curso");
		lblCurso.setForeground(new Color(0, 100, 0));
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurso.setBounds(41, 236, 71, 25);
		lblFecha= new JLabel("Fecha de Registro");
		lblFecha.setForeground(new Color(0, 100, 0));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(41, 181, 148, 31);
		lblUsuario= new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 100, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(41, 303, 71, 17);
		lblContra = new JLabel("Contraseña");
		lblContra.setForeground(new Color(0, 100, 0));
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContra.setBounds(41, 361, 96, 17);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(46, 139, 87));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(41, 86, 191, 36);
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigo.setForeground(new Color(46, 139, 87));
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(41, 26, 191, 31);
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellido.setForeground(new Color(46, 139, 87));
		txtApellido.setBounds(42, 146, 190, 36);
		txtCurso = new JTextField();
		txtCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCurso.setForeground(new Color(46, 139, 87));
		txtCurso.setBounds(41, 261, 125, 31);
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(46, 139, 87));
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUsuario.setBounds(41, 319, 191, 31);
		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(46, 139, 87));
		txtContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtContra.setBounds(42, 379, 190, 31);
		
		
		
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
		panelCentro.setLayout(null);
		
		panelCentro.add(lblCodigo);
		panelCentro.add(txtCodigo);
		panelCentro.add(lblNombre);
		panelCentro.add(lblApellido);
		panelCentro.add(txtNombre);
		panelCentro.add(txtApellido);
		panelCentro.add(lblCurso);
		panelCentro.add(lblFecha);
		panelCentro.add(txtCurso);
		panelCentro.add(lblUsuario);
		panelCentro.add(lblContra);
		panelCentro.add(txtUsuario);
		panelCentro.add(txtContra);
		miPanel.setLayout(null);
		
		
		miPanel.add(panelSuperior);
		miPanel.add(panelCentro);
		
		JLabel lblParalelo = new JLabel("Paralelo");
		lblParalelo.setForeground(new Color(0, 100, 0));
		lblParalelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParalelo.setBounds(173, 236, 59, 25);
		panelCentro.add(lblParalelo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(176, 262, 54, 31);
		panelCentro.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(46, 139, 87));
		dateChooser.setBounds(41, 207, 191, 31);
		panelCentro.add(dateChooser);
		miFramePane.add(miPanel);
		
		panelDerecho = new JPanel();
		panelDerecho.setBackground(Color.WHITE);
		panelDerecho.setBounds(313, 151, 121, 397);
		miPanel.add(panelDerecho);
		btnNuevo = new JButton("");
		panelDerecho.add(btnNuevo);
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setToolTipText("Nuevo Alumno");
		btnNuevo.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/newmediano.png")));
		btnBuscar = new JButton("");
		panelDerecho.add(btnBuscar);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setToolTipText("Buscar Alumno");
		btnBuscar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/search-icon.png")));
		btnRegistrar= new JButton("");
		panelDerecho.add(btnRegistrar);
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setToolTipText("Guardar Alumno");
		btnRegistrar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/saveee.png")));
		btnModificar = new JButton("");
		panelDerecho.add(btnModificar);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setToolTipText("Modificar Alumno");
		btnModificar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/modificar.png")));
		btnEliminar = new JButton("");
		panelDerecho.add(btnEliminar);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setToolTipText("Eliminar Alumno");
		btnEliminar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/deleteee.png")));
		btnSalir = new JButton("");
		panelDerecho.add(btnSalir);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/salirr.png")));
	
		
		
		 frame.setVisible(true);
		frame.setSize(450,600);
		frame.setLocationRelativeTo(null);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
