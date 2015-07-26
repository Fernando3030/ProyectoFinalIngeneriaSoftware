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

public class GestionAlumnos {

	private JFrame frame;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JPanel panelCentro;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblCodigo, lblNombre, lblApellido, lblCurso, lblFecha, lblUsuario, lblContra;
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
		 try {
	 			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	}

	/**
	 * Create the application.
	 */
	public GestionAlumnos() {
		frame = new JFrame("Alumnos");
		miPanel= new JPanel();
		miPanel.setBackground(new Color(62,205,142));
		panelSuperior= new JPanel();
		panelSuperior.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelSuperior.setBounds(0, 0, 444, 131);
		panelSuperior.setBackground(new Color(46, 139, 87));
		lblimagen= new JLabel("");
		lblimagen.setBounds(0, 0, 221, 131);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/userrrr.png")));
		lblTitulo= new JLabel("Gestión de Alumno");
		lblTitulo.setBounds(168, 0, 252, 131);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panelCentro= new JPanel();
		panelCentro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCentro.setBackground(new Color(255, 255, 255));
		panelCentro.setBounds(0, 131, 444, 342);
		
		lblCodigo= new JLabel("Codigo");
		lblCodigo.setForeground(new Color(0, 100, 0));
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(24, 11, 84, 50);
		lblNombre= new JLabel("Nombres"); 
		lblNombre.setForeground(new Color(0, 100, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(24, 83, 84, 36);
		lblApellido = new JLabel("Apellidos");
		lblApellido.setForeground(new Color(0, 100, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(232, 80, 90, 42);
		lblCurso = new JLabel("Curso");
		lblCurso.setForeground(new Color(0, 100, 0));
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurso.setBounds(24, 151, 71, 42);
		lblFecha= new JLabel("Fecha de Registro");
		lblFecha.setForeground(new Color(0, 100, 0));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(233, 162, 148, 31);
		lblUsuario= new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 100, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(24, 230, 103, 31);
		lblContra = new JLabel("Contraseña");
		lblContra.setForeground(new Color(0, 100, 0));
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContra.setBounds(233, 232, 96, 31);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(46, 139, 87));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(24, 115, 178, 36);
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigo.setForeground(new Color(46, 139, 87));
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(24, 53, 178, 31);
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellido.setForeground(new Color(46, 139, 87));
		txtApellido.setBounds(233, 115, 190, 36);
		txtCurso = new JTextField();
		txtCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCurso.setForeground(new Color(46, 139, 87));
		txtCurso.setBounds(24, 188, 178, 31);
		txtFecha = new JTextField();
		txtFecha.setForeground(new Color(46, 139, 87));
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFecha.setBounds(233, 188, 190, 31);
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(46, 139, 87));
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUsuario.setBounds(24, 261, 178, 31);
		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(46, 139, 87));
		txtContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtContra.setBounds(233, 261, 190, 31);
		
		panelInferior= new JPanel();
		panelInferior.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelInferior.setBackground(new Color(46, 139, 87));
		panelInferior.setBounds(0, 474, 444, 97);
		btnIngresar= new JButton("");
		btnIngresar.setToolTipText("Ingresar al Sistema");
		btnIngresar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Log-Out-icon.png")));
		btnIngresar.setBackground(UIManager.getColor("Button.background"));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBounds(0, 28, 65, 43);
		btnRegistrar= new JButton("");
		btnRegistrar.setToolTipText("Guardar Alumno");
		btnRegistrar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/save.png")));
		btnRegistrar.setBounds(195, 28, 65, 43);
		btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar Alumno");
		btnBuscar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/search-icon.png")));
		btnBuscar.setBounds(321, 28, 58, 43);
		btnModificar = new JButton("");
		btnModificar.setToolTipText("Modificar Alumno");
		btnModificar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Actions-document-edit-icon.png")));
		btnModificar.setBounds(66, 28, 65, 43);
		btnEliminar = new JButton("");
		btnEliminar.setToolTipText("Eliminar Alumno");
		btnEliminar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/delete-file-icon.png")));
		btnEliminar.setBounds(258, 28, 65, 43);
		btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Apps-session-logout-icon.png")));
		btnSalir.setBounds(377, 28, 65, 43);
		btnNuevo = new JButton("");
		btnNuevo.setToolTipText("Nuevo Alumno");
		btnNuevo.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/new.png")));
		btnNuevo.setBounds(130, 28, 65, 43);
		
		
		
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
		panelCentro.add(txtFecha);
		panelCentro.add(lblUsuario);
		panelCentro.add(lblContra);
		panelCentro.add(txtUsuario);
		panelCentro.add(txtContra);
		panelInferior.setLayout(null);
		
		
		panelInferior.add(btnIngresar);
		panelInferior.add(btnNuevo);
		panelInferior.add(btnRegistrar);
		panelInferior.add(btnBuscar);
		panelInferior.add(btnModificar);
		panelInferior.add(btnEliminar);
		panelInferior.add(btnSalir);
		miPanel.setLayout(null);
		
		
		miPanel.add(panelSuperior);
		miPanel.add(panelCentro);
		miPanel.add(panelInferior);
		miFramePane.add(miPanel);
	
		
		
		 frame.setVisible(true);
		frame.setSize(450,600);
		frame.setLocationRelativeTo(null);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
