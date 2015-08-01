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
import javax.swing.JOptionPane;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileEstudiante {

	private JFrame frame;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JPanel panelCentro;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblNombre, lblApellido, lblCurso, lblUsuario, lblContra;
	 private JTextField txtNombre, txtApellido, txtCurso, txtUsuario;
	 private JPasswordField txtContra;
	 private JButton btnRegistrar, btnModificar, btnSalir;
	 private JPanel panelDerecho;
	 
	 JPasswordField confirmarContra;
     
     JLabel titulo;
	
	

	/**
	 * Create the application.
	 */
	public ProfileEstudiante() {
		frame = new JFrame("Alumnos");
		frame.setTitle("Perfiles");
		miPanel= new JPanel();
		miPanel.setBackground(new Color(46, 139, 87));
		panelSuperior= new JPanel();
		panelSuperior.setBounds(0, 0, 444, 131);
		panelSuperior.setBackground(new Color(46, 139, 87));
		lblimagen= new JLabel("");
		lblimagen.setBounds(0, 0, 221, 131);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(ProfileEstudiante.class.getResource("/Imagenes/profileEstudiante.png")));
		lblTitulo= new JLabel("T\u00FA Perfil");
		lblTitulo.setBounds(168, 0, 252, 131);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		confirmarContra = new JPasswordField(); 
		titulo  = new JLabel ("Ingrese la vieja contraseña"); 

		
		
		panelCentro= new JPanel();
		panelCentro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCentro.setBackground(new Color(255, 255, 255));
		panelCentro.setBounds(10, 131, 304, 440);
		lblNombre= new JLabel("Nombres"); 
		lblNombre.setForeground(new Color(0, 100, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(40, 24, 84, 36);
		lblApellido = new JLabel("Apellidos");
		lblApellido.setForeground(new Color(0, 100, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(40, 92, 90, 31);
		lblCurso = new JLabel("Curso");
		lblCurso.setForeground(new Color(0, 100, 0));
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurso.setBounds(40, 163, 71, 25);
		lblUsuario= new JLabel("Nuevo Usuario");
		lblUsuario.setForeground(new Color(0, 100, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(40, 230, 125, 17);
		lblContra = new JLabel("Nueva Contrase\u00F1a");
		lblContra.setForeground(new Color(0, 100, 0));
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContra.setBounds(40, 295, 143, 17);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(46, 139, 87));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(40, 56, 191, 36);
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellido.setForeground(new Color(46, 139, 87));
		txtApellido.setBounds(41, 116, 190, 36);
		txtCurso = new JTextField();
		txtCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCurso.setForeground(new Color(46, 139, 87));
		txtCurso.setBounds(40, 188, 125, 31);
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(46, 139, 87));
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUsuario.setBounds(40, 253, 191, 31);
		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(46, 139, 87));
		txtContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtContra.setBounds(40, 315, 190, 31);
		
		
		
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
		panelCentro.add(lblNombre);
		panelCentro.add(lblApellido);
		panelCentro.add(txtNombre);
		panelCentro.add(txtApellido);
		panelCentro.add(lblCurso);
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
		lblParalelo.setBounds(172, 163, 59, 25);
		panelCentro.add(lblParalelo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(175, 189, 54, 31);
		panelCentro.add(comboBox);
		miFramePane.add(miPanel);
		
		panelDerecho = new JPanel();
		panelDerecho.setBackground(Color.WHITE);
		panelDerecho.setBounds(313, 227, 121, 231);
		miPanel.add(panelDerecho);
		btnModificar = new JButton("");
		panelDerecho.add(btnModificar);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setToolTipText("Modificar Alumno");
		btnModificar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/modificar.png")));
		btnRegistrar= new JButton("");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			      JOptionPane.showConfirmDialog (null, new Object[]{titulo, confirmarContra}, "Confirmar Contreseña", JOptionPane.OK_CANCEL_OPTION);
			      char contraNueva []= confirmarContra.getPassword();
			      String nuevaContra= new String(contraNueva);
			      System.out.println(nuevaContra);
			}
		});
		panelDerecho.add(btnRegistrar);
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setToolTipText("Guardar Alumno");
		btnRegistrar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/saveee.png")));
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VentanaBienvenida bienvenida= new VentanaBienvenida();
			}
		});
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

