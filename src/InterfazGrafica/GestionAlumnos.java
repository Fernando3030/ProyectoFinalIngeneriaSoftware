package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

public class GestionAlumnos {

	private JFrame frame;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JPanel panelCentro;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblCodigo, lblNombre, lblApellido, lblCurso, lblFecha, lblUsuario, lblContra,lblBlanco, lblBlanco3;
	 private JTextField txtNombre, txtCodigo, txtApellido, txtCurso, txtFecha, txtUsuario;
	 private JPasswordField txtContra;
	 private JPanel panelInferior;
	 private JButton btnIngresar, btnRegistrar, btnBuscar, btnModificar, btnEliminar, btnSalir, btnNuevo;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAlumnos window = new GestionAlumnos();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionAlumnos() {
		frame = new JFrame("Alumnos");
		miPanel= new JPanel();
		miPanel.setLayout(new BorderLayout());
		panelSuperior= new JPanel();

		panelSuperior.setLayout(new GridLayout(1,2,2,3));
		panelSuperior.setBackground(new Color(62,205,142));
		lblimagen= new JLabel("");
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/userrrr.png")));
		lblTitulo= new JLabel("Gestión de Alumno");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panelCentro= new JPanel();
		
		lblCodigo= new JLabel("Codigo");
		lblCodigo.setForeground(new Color(0, 100, 0));
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(23, 0, 84, 50);
		lblNombre= new JLabel("Nombres"); 
		lblNombre.setForeground(new Color(0, 100, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(23, 72, 84, 36);
		lblApellido = new JLabel("Apellidos");
		lblApellido.setForeground(new Color(0, 100, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(222, 69, 90, 42);
		lblCurso = new JLabel("Curso");
		lblCurso.setForeground(new Color(0, 100, 0));
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurso.setBounds(23, 140, 71, 42);
		lblFecha= new JLabel("Fecha de Registro");
		lblFecha.setForeground(new Color(0, 100, 0));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(222, 151, 148, 31);
		lblUsuario= new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 100, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(23, 219, 103, 31);
		lblContra = new JLabel("Contraseña");
		lblContra.setForeground(new Color(0, 100, 0));
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContra.setBounds(222, 221, 96, 31);
		lblBlanco = new JLabel();
		lblBlanco.setBounds(222, 0, 222, 50);
		lblBlanco3 = new JLabel();
		
		txtNombre = new JTextField();
		txtNombre.setBounds(23, 104, 178, 36);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(23, 42, 178, 31);
		txtApellido = new JTextField();
		txtApellido.setBounds(222, 104, 212, 36);
		txtCurso = new JTextField();
		txtCurso.setBounds(23, 177, 178, 31);
		txtFecha = new JTextField();
		txtFecha.setBounds(222, 177, 212, 31);
		txtUsuario = new JTextField();
		txtUsuario.setBounds(23, 250, 178, 31);
		txtContra = new JPasswordField();
		txtContra.setBounds(222, 250, 212, 31);
		
		panelInferior= new JPanel();
		panelInferior.setLayout(new GridLayout(2, 4, 2,3));
		btnIngresar= new JButton("Ingresar");
		btnRegistrar= new JButton("Registrar");
		btnBuscar = new JButton("Buscar");
		btnModificar = new JButton("Modificar");
		btnEliminar = new JButton("Eliminar");
		btnSalir = new JButton("Salir");
		btnNuevo = new JButton("Nuevo");
		
		
		
		 miFramePane = frame.getContentPane();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		panelSuperior.add(lblimagen);
		panelSuperior.add(lblTitulo);
		panelCentro.setLayout(null);
		
		panelCentro.add(lblCodigo);
		panelCentro.add(lblBlanco);
		panelCentro.add(txtCodigo);
		panelCentro.add(lblNombre);
		panelCentro.add(lblApellido);
		panelCentro.add(txtNombre);
		panelCentro.add(txtApellido);
		panelCentro.add(lblCurso);
		panelCentro.add(lblFecha);
		panelCentro.add(txtCurso);
		panelCentro.add(txtFecha);
		panelCentro.add(lblUsuario);
		panelCentro.add(lblContra);
		panelCentro.add(txtUsuario);
		panelCentro.add(txtContra);
		
		
		panelInferior.add(btnIngresar);
		panelInferior.add(btnNuevo);
		panelInferior.add(btnRegistrar);
		panelInferior.add(btnBuscar);
		panelInferior.add(btnModificar);
		panelInferior.add(btnEliminar);
		panelInferior.add(btnSalir);
		panelInferior.add(lblBlanco3);
		
		
		miPanel.add(panelSuperior, BorderLayout.NORTH);
		miPanel.add(panelCentro, BorderLayout.CENTER);
		miPanel.add(panelInferior, BorderLayout.SOUTH);
		miFramePane.add(miPanel);
	
		
		
		 frame.setVisible(true);
		frame.setSize(450,600);
		frame.setLocationRelativeTo(null);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
