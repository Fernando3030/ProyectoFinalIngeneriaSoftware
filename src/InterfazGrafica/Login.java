package InterfazGrafica;

import java.awt.AlphaComposite;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;








import Clases.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private URL fondo;

    private Image imagen1;
    private Container miFramePane;

   public static Conexion con= new Conexion();
    ResultSet resultado;
    ResultSet resultado2;
    String superUser="";
    String passAdmin="";
    String userAlumno="";
    String contra="";
    public static String usuario;
    public static String codigo;
    public static String usuarioAlumno;
    public static boolean ActivarMenu= true;
	public Statement sentencias;
	private boolean  banderaEncontrado= true;



public JPanel miPanel=new JPanel(){
        

		public void paintComponent(Graphics g){
            g.drawImage(imagen1, 0, 0, getWidth(), getHeight(), null);
    
   }
	};

public JPanel panel=new JPanel(){
        
	private float tran= 0.6f;
	protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			AlphaComposite old = (AlphaComposite) g2.getComposite();
			g2.setComposite(AlphaComposite.SrcOver.derive(tran));
			super.paintComponent(g);
			g2.setComposite(old);
		}

	};
private JTextField txtUsuario;
private JPasswordField passwordField;
//private JTextField txtUsuario;
//private JLabel lblContra;
//private JPasswordField txtPassword;


	/**
	 * Create the application.
	 */
	public Login() {
		
		try {
			sentencias= con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   frame = new JFrame("Acceso al programa");
		  frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/user.png")));
		  fondo=frame.getClass().getResource("/Imagenes/fondo3.jpg");
		
		  imagen1=new ImageIcon(fondo).getImage();
		
	     
	      miPanel.setLayout(null);
	      panel.setBackground(Color.WHITE);
	      
	 
	    
	      panel.setBounds(60, 61, 366, 458);
	      
	      miFramePane = frame.getContentPane();
	    
		ensamblaje();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void ensamblaje() {
		 //  miPanel.add(lblUsuario);
		    miPanel.add(panel);
		    panel.setLayout(null);
		    
		    JLabel lblLogin = new JLabel("Login");
		    lblLogin.setBounds(32, 0, 141, 39);
		    panel.add(lblLogin);
		    lblLogin.setBackground(new Color(62,205,142));
		    lblLogin.setForeground(Color.WHITE);
		    lblLogin.setOpaque(true);
		    lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		    lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		    
		    txtUsuario = new JTextField();
		    txtUsuario.setForeground(new Color(46, 139, 87));
		    txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		    txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		    txtUsuario.setBounds(81, 125, 247, 48);
		    panel.add(txtUsuario);
		    txtUsuario.setColumns(10);
		    
		    JLabel lblUsuario = new JLabel("Usuario:");
		    lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblUsuario.setBounds(33, 88, 87, 26);
		    panel.add(lblUsuario);
		    
		    JLabel lblcontra = new JLabel("");
		    lblcontra.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/candado.jpg")));
		    lblcontra.setBounds(33, 212, 56, 48);
		    panel.add(lblcontra);
		    
		    JLabel lbluser = new JLabel("");
		    lbluser.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/userr.jpg")));
		    lbluser.setBounds(32, 125, 56, 48);
		    panel.add(lbluser);
		    
		    passwordField = new JPasswordField();
		    passwordField.setForeground(new Color(46, 139, 87));
		    passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		    passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		    passwordField.setBounds(83, 212, 247, 48);
		    panel.add(passwordField);
		    
		    JLabel lblContra = new JLabel("Contrase\u00F1a:");
		    lblContra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblContra.setBounds(31, 183, 87, 26);
		    panel.add(lblContra);
		    
		    JButton btnIngresar = new JButton("Ingresar");
		    btnIngresar.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		
		    		  String password = String.valueOf(passwordField.getPassword()); //Convierte el valor de char del password a String
		    		  try {
						resultado= con.ExtraerAdmin();
					
						while(resultado.next())
						{		
							superUser = resultado.getString("usuario_admin");
						    passAdmin = resultado.getString("contra_admin");
						    codigo= resultado.getString("cod_admin");
						  
						}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                     if(((txtUsuario.getText()).equals(superUser))&&((password).equals(passAdmin)))
	                     {
	                           
	                         frame.dispose();
	                         usuario= superUser;
	                         ActivarMenu= true;
	                         banderaEncontrado= false;
	                         usuarioAlumno="";
	                        VentanaBienvenida ventana = new VentanaBienvenida();
	                        
	                      
	                      
	                     } 
	                     else
	                     {
	                    	 try {
	                    		 
	                    		 PreparedStatement query= con.con.prepareStatement("SELECT * FROM alumnos WHERE usuario_alumno=? AND contra_alumno=?"); 
	                    		 query.setString(1, txtUsuario.getText()); 
	                    		 query.setString(2, password); 
	                    		 resultado = query.executeQuery();
								
								while(resultado.next())
		 						{	
								     frame.dispose();
									 ActivarMenu= false;
									 banderaEncontrado= false;
									 usuarioAlumno= txtUsuario.getText();
									 codigo="";
									 VentanaBienvenida ventana = new VentanaBienvenida();
					                   
		 						}
							} catch (SQLException e) {
								System.out.println(e);
								e.printStackTrace();
							}
	                     }
	                     if(banderaEncontrado)
	                     {
	                    	 JOptionPane.showMessageDialog(null,"Usuario no registrado");
	                    	 txtUsuario.setText("");
	                    	 passwordField.setText("");
	                    	 txtUsuario.requestFocus();
	                     }
		    	}
		    });
		    btnIngresar.setBackground(new Color(255,66,66));
		    btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		    btnIngresar.setForeground(Color.WHITE);
		    btnIngresar.setBounds(45, 333, 129, 48);
		    panel.add(btnIngresar);
		    
		    JButton btnSalir = new JButton("Salir");
		    btnSalir.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		System.exit(0);
		    	}
		    });
		    btnSalir.setForeground(Color.WHITE);
		    btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		    btnSalir.setBackground(new Color(255, 66, 66));
		    btnSalir.setBounds(184, 333, 129, 48);
		    panel.add(btnSalir);
		    
		    JLabel lblGeocircleMachala = new JLabel("\u00A9 GeoCircle - Machala");
		    lblGeocircleMachala.setHorizontalAlignment(SwingConstants.CENTER);
		    lblGeocircleMachala.setBounds(67, 417, 213, 30);
		    panel.add(lblGeocircleMachala);
		    miFramePane.add(miPanel);
		    
		 
		    //txtUsuario.setBounds(274, 99, 296, 32);
		    /*
		    miPanel.add(txtUsuario);
		    txtUsuario.setColumns(10);
		    
		    lblContra = new JLabel("Contrase\u00F1a:");
		    lblContra.setForeground(Color.WHITE);
		    lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 22));
		    lblContra.setBounds(274, 138, 147, 32);
		    miPanel.add(lblContra);
		    
		   
		    txtPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		    txtPassword.setEchoChar('*');
		    txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		    txtPassword.setBounds(274, 173, 296, 38);
		    miPanel.add(txtPassword);
		    */
		    /*
		    JButton btnIngresar = new JButton("Ingresar");
		    btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		    btnIngresar.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    	}
		    });
		    btnIngresar.setBounds(319, 232, 102, 33);
		    miPanel.add(btnIngresar);
		    
		    JButton btnSalir = new JButton("Salir");
		    btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		    btnSalir.setBounds(434, 232, 102, 33);
		    miPanel.add(btnSalir);
		    */
	       
	        frame.setVisible(true);
	        frame.setSize(500,600);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
