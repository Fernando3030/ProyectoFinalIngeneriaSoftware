package InterfazGrafica;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private URL fondo;

    private Image imagen1;
    private Container miFramePane;
    private JLabel lblUsuario;
    private Image imageTextField;
    private Image imageTextField2;


public JPanel miPanel=new JPanel(){
        

		public void paintComponent(Graphics g){
            g.drawImage(imagen1, 0, 0, getWidth(), getHeight(), null);
    
   }
	};
private JTextField txtUsuario;
private JLabel lblContra;
private JPasswordField txtPassword;


	/**
	 * Create the application.
	 */
	public Login() {
		   frame = new JFrame("Acceso al programa");
		  frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/user.png")));
		  fondo=frame.getClass().getResource("/Imagenes/geoCircleLogin.jpg");
		
		  imagen1=new ImageIcon(fondo).getImage();
		  imageTextField = new ImageIcon( getClass().getResource("/Imagenes/usuario.png") ) .getImage();
		  imageTextField2 = new ImageIcon( getClass().getResource("/Imagenes/pass.png") ) .getImage();
		  
		  txtUsuario = new JTextField()
		  {
			
			  public void paint(Graphics g)
			  {
			   if ( isVisible() ) { //sobrescribiendo el componente
			    super.paint(g);
			    g.drawImage( imageTextField, 1,1, null); // dibujo la imagen
			   }
			  }
		  };
		  
		  txtPassword = new JPasswordField() {
			
			  public void paint(Graphics g)
			  {
			   if ( isVisible() ) { //sobrescribiendo el componente
			    super.paint(g);
			    g.drawImage( imageTextField2, 1,1, null); // dibujo la imagen
			   }
			  }
		  };
		  txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		  txtUsuario.setToolTipText("Ingrese el usuario");
		  txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		
	      
	      lblUsuario = new JLabel("Usuario:");
	      lblUsuario.setForeground(Color.WHITE);
	      lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 22));
	      lblUsuario.setBounds(274, 64, 101, 32);
	     
	      miPanel.setLayout(null);
	      miFramePane = frame.getContentPane();
	    
		ensamblaje();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void ensamblaje() {
		   miPanel.add(lblUsuario);
		    miFramePane.add(miPanel);
		    
		 
		    txtUsuario.setBounds(274, 99, 296, 32);
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
	       
	        frame.setVisible(true);
	        frame.setSize(600,305);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
