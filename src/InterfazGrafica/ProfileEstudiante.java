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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 private JComboBox comboBox ;
	 JPasswordField confirmarContra;
     
     JLabel titulo;
     public Statement sentencias;

		ResultSet resultado;
	private boolean banderaAdmin= true;
	

	/**
	 * Create the application.
	 */
	public ProfileEstudiante() {
		frame = new JFrame("Alumnos");
		try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(175, 189, 54, 31);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setForeground(new Color(46, 139, 87));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(40, 56, 191, 36);
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellido.setForeground(new Color(46, 139, 87));
		txtApellido.setBounds(41, 116, 190, 36);
		txtCurso = new JTextField();
		txtCurso.setEnabled(false);
		txtCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCurso.setForeground(new Color(46, 139, 87));
		txtCurso.setBounds(40, 188, 125, 31);
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setForeground(new Color(46, 139, 87));
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUsuario.setBounds(40, 253, 191, 31);
		txtUsuario.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String user=txtUsuario.getText();
        		
        		if (!txtUsuario.getText().equals(""))
				{
        			 try {
						resultado=sentencias.executeQuery("SELECT * FROM alumnos WHERE usuario_alumno='"+user+"'");
						 while(resultado.next())
							{	
					        	JOptionPane.showMessageDialog(null,"El usuario  "+ txtUsuario.getText() +", YA SE ENCUENTRA REGISTRADO EN EL SISTEMA","ERROR DE DATOS",JOptionPane.PLAIN_MESSAGE);
								txtUsuario.setText("");
								txtUsuario.requestFocus();
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
				       
			
					
						
						
				}
        	}
        });
		txtContra = new JPasswordField();
		txtContra.setEnabled(false);
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
		
		if(Login.codigo.equals("001")) // esto significa que es el admin
		{
			 try {
				resultado=sentencias.executeQuery("SELECT * FROM administrador WHERE usuario_admin='"+Login.usuario+"'");
				   while(resultado.next())
					{
					   txtNombre.setText(resultado.getString(4));
					   txtApellido.setText(resultado.getString(5));
					   banderaAdmin= true;
				
					   
					}
				   resultado.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     
		}
		else
		{
			 try {
					resultado=sentencias.executeQuery("SELECT * FROM alumnos WHERE usuario_alumno='"+Login.usuarioAlumno+"'");
					   while(resultado.next())
						{
						   txtNombre.setText(resultado.getString(2));
						   txtApellido.setText(resultado.getString(3));
						   txtCurso.setText(resultado.getString(4));
						   String letra= resultado.getString(9);
						   banderaAdmin= false;
						   
					       
					        if(letra.equals("A"))
					        {
					        	comboBox.setSelectedIndex(0);
					        }
					        else
					        	  if(letra.equals("B"))
							        {
							        	comboBox.setSelectedIndex(1);
							        }
					        	  else
					        		  
					        if(letra.equals("C"))
					        {
					        	comboBox.setSelectedIndex(2);
					        }
					        else
					        	  if(letra.equals("D"))
							        {
							        	comboBox.setSelectedIndex(3);
							        }
							
					
					      
						}
					   resultado.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		miPanel.add(panelSuperior);
		miPanel.add(panelCentro);
		
		JLabel lblParalelo = new JLabel("Paralelo");
		lblParalelo.setForeground(new Color(0, 100, 0));
		lblParalelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParalelo.setBounds(172, 163, 59, 25);
		panelCentro.add(lblParalelo);
		
		
		panelCentro.add(comboBox);
		miFramePane.add(miPanel);
		
		panelDerecho = new JPanel();
		panelDerecho.setBackground(Color.WHITE);
		panelDerecho.setBounds(313, 227, 121, 231);
		miPanel.add(panelDerecho);
		btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtUsuario.setEnabled(true);
				txtContra.setEnabled(true);
				btnRegistrar.setEnabled(true);
				btnModificar.setEnabled(false);
			}
		});
		panelDerecho.add(btnModificar);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setToolTipText("Modificar Alumno");
		btnModificar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/modificar.png")));
		btnRegistrar= new JButton("");
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean banderaUsuario= true;
				boolean banderaContra= true;
				if(txtUsuario.getText().length()!= 0)
				{
					banderaUsuario= true;
				}
				else
				{
					banderaUsuario= false;
				}
				
				if(txtContra.getText().length()!= 0)
				{
					banderaContra= true;
				}
				else
				{
					banderaContra= false;
				}
				
				if(banderaUsuario && banderaContra)
				{
					 JOptionPane.showConfirmDialog (null, new Object[]{titulo, confirmarContra}, "Confirmar Contreseña", JOptionPane.OK_CANCEL_OPTION);
				      char contraNueva []= confirmarContra.getPassword();
				      String contraPasado= new String(contraNueva);
				      if(banderaAdmin)
				      {
				    	  try {
								resultado=sentencias.executeQuery("SELECT * FROM administrador WHERE cod_admin='"+Login.codigo+"'");
								 while(resultado.next())
									{
									 String contraVieja =resultado.getString(1);
									 
									   if(contraPasado.equals(contraVieja))
									   {
										   sentencias.executeUpdate("UPDATE administrador SET usuario_admin='"+txtUsuario.getText()+"',"+"contra_admin='"+txtContra.getText()+"'");
										   JOptionPane.showMessageDialog(null,"Datos Actualizados con éxito");
										   txtUsuario.setText("");
										   txtContra.setText("");
										   btnRegistrar.setEnabled(false);
										   btnModificar.setEnabled(true);
										   txtUsuario.setEnabled(false);
										   txtContra.setEnabled(false);
										   
									   }
									   else
									   {
										   JOptionPane.showMessageDialog(null,"Error, no se puede cambiar la contraseña");
										   txtUsuario.setText("");
										   txtContra.setText("");
										   txtUsuario.setEnabled(false);
										   txtContra.setEnabled(false);
										   btnRegistrar.setEnabled(false);
										   btnModificar.setEnabled(true);
										  
									   }
									}
								 resultado.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				      }
				      else
				      {
				    	  
				    	  try {
								resultado=sentencias.executeQuery("SELECT * FROM alumnos WHERE usuario_alumno='"+Login.usuarioAlumno+"'");
								 while(resultado.next())
									{
									 String contraVieja =resultado.getString(7);
									 
									   if(contraPasado.equals(contraVieja))
									   {
										   sentencias.executeUpdate("UPDATE alumnos SET usuario_alumno='"+txtUsuario.getText()+"',"+"contra_alumno='"+txtContra.getText()+"'");
										   JOptionPane.showMessageDialog(null,"Datos Actualizados con éxito");
										   txtUsuario.setText("");
										   txtContra.setText("");
										   btnRegistrar.setEnabled(false);
										   btnModificar.setEnabled(true);
										   txtUsuario.setEnabled(false);
										   txtContra.setEnabled(false);
										   
									   }
									   else
									   {
										   JOptionPane.showMessageDialog(null,"Error, no se puede cambiar la contraseña");
										   txtUsuario.setText("");
										   txtContra.setText("");
										   txtUsuario.setEnabled(false);
										   txtContra.setEnabled(false);
										   btnRegistrar.setEnabled(false);
										   btnModificar.setEnabled(true);
										   resultado.close();
									   }
									}
								 resultado.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    	  
				      }
				     
					  
				      
				}
				else
				{
					 JOptionPane.showMessageDialog(null,"No puede dejar campos vacíos");
				}
				
			      
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

