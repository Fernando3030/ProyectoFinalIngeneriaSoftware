package InterfazGrafica;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import Clases.LeerPdf;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class LeerDocumentoProfesor {

	private JFrame frmLibrosProfesor;

	public Statement sentencias;
	ResultSet resultado;
	private JPanel panel;
	private String url;
	private JScrollPane scrollPane ;
	private  JTree tree;
	String libro;
	 ArrayList <DefaultMutableTreeNode> array=new ArrayList <DefaultMutableTreeNode> ();
	 DefaultMutableTreeNode aux;
	// private JScrollPane scrollCentro;
	 private LeerPdf a;
	// private PanelPdf panelC;
	
	 private JPanel panelCentro;
	// private JScrollPane scrollInterno;

	/**
	 * Create the application.
	 */
	public LeerDocumentoProfesor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmLibrosProfesor = new JFrame();
		frmLibrosProfesor.setTitle("Libros Profesor");
		frmLibrosProfesor.setBounds(100, 100, 1222, 727);
		frmLibrosProfesor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibrosProfesor.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 1206, 112);
		frmLibrosProfesor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(LeerDocumentoProfesor.class.getResource("/Imagenes/libro2.png")));
		lblTitulo.setBounds(350, 0, 164, 111);
		panel.add(lblTitulo);
		
		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibros.setForeground(new Color(255, 255, 255));
		lblLibros.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblLibros.setBounds(497, 26, 237, 62);
		panel.add(lblLibros);
		
		JLabel lblTitulo2 = new JLabel("");
		lblTitulo2.setIcon(new ImageIcon(LeerDocumentoProfesor.class.getResource("/Imagenes/libro2.png")));
		lblTitulo2.setBounds(721, 0, 164, 111);
		panel.add(lblTitulo2);
		
		JButton btnRegresarAlMen = new JButton("");
		btnRegresarAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLibrosProfesor.dispose();
				VentanaBienvenida ventan= new VentanaBienvenida();
	
			}
		});


		btnRegresarAlMen.setOpaque(false);
		btnRegresarAlMen.setContentAreaFilled(false);
		btnRegresarAlMen.setBorderPainted(false);


		btnRegresarAlMen.setBackground(new Color(46, 139, 87));
		btnRegresarAlMen.setIcon(new ImageIcon(LeerDocumentoProfesor.class.getResource("/Imagenes/return.png")));
		btnRegresarAlMen.setForeground(new Color(255, 255, 255));
		btnRegresarAlMen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegresarAlMen.setBounds(1067, 26, 97, 62);
		panel.add(btnRegresarAlMen);
		
		
	
		formarTree();
		 scrollPane = new JScrollPane(tree); // este scroll panel es para el JTree
	    	scrollPane.setBounds(0, 113, 260, 585);
			frmLibrosProfesor.getContentPane().add(scrollPane);
			
			
			
			
			 panelCentro = new JPanel();
			panelCentro.setBounds(264, 113, 942, 585);
			frmLibrosProfesor.getContentPane().add(panelCentro);
			panelCentro.setLayout(null);
			
			
			
			
			
			
		frmLibrosProfesor.setVisible(true);
		
		frmLibrosProfesor.setLocationRelativeTo(null);
		frmLibrosProfesor.setResizable(false); 
		frmLibrosProfesor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void formarTree()
	{
		
		String nombreLibro;
		int contador=0;
		
		DefaultTreeModel modelo;
		DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("Libros");
		DefaultMutableTreeNode primerHijo = new DefaultMutableTreeNode("Libros del Profesor");
		DefaultMutableTreeNode segundoHijo = new DefaultMutableTreeNode("Libros de otros autores");
		
		
		
		modelo = new DefaultTreeModel(abuelo);
		 tree = new JTree(modelo);
		 tree.setSize(100,500);
		 modelo.insertNodeInto(primerHijo,abuelo,0);
			modelo.insertNodeInto(segundoHijo, abuelo, 1);
		try {
		       
	        resultado=sentencias.executeQuery("SELECT * FROM archivosprofesor");
	     
	        while(resultado.next())
			{	
	        	
	        	nombreLibro= resultado.getString(3);
	        	libro= libro+" "+contador;
	        	DefaultMutableTreeNode libro = new DefaultMutableTreeNode(nombreLibro);
	        	
	        	modelo.insertNodeInto(libro,primerHijo,contador);
	        	array.add(libro);   
	        	contador++;
	        
	        	System.out.println(contador);
	        

			       
			        
			}
	        
	        resultado.close();
	        
	        resultado=sentencias.executeQuery("SELECT * FROM archivosautores");
	        contador=0;
	        libro="";
		     
	        while(resultado.next())
			{	
	        	
	        	nombreLibro= resultado.getString(3);
	        	libro= libro+" "+contador;
	        	DefaultMutableTreeNode libro = new DefaultMutableTreeNode(nombreLibro);
	        	
	        	modelo.insertNodeInto(libro,segundoHijo,contador);
	        	array.add(libro);   
	        	contador++;
	        
	        	System.out.println(contador);
	        

			       
			        
			}
	       
	       
	     } // final del try
	     catch(SQLException ex) {
	       
	        System.out.println(ex);
	     }
		
		tree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				
				DefaultMutableTreeNode nseleccionado = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				
		
			    
			    for( int i = 0 ; i  < array.size(); i++){
                    if(array.get(i).equals(nseleccionado)){
                    	aux= array.get(i);
                    	System.out.println("imprimir " + array.get(i).toString());
                      
                    }             
			    }
				//paneles de temas
				if (nseleccionado.equals(aux)) {
					if (evt.getClickCount() == 2) {
						
					
						try {
						       
					        resultado=sentencias.executeQuery("SELECT * FROM archivosprofesor where nombrelibro_prof = '" +nseleccionado.toString() +"'");
					     
					        while(resultado.next())
							{	
					        	panelCentro.removeAll();
					        	panelCentro.repaint();
					       
					        	url= resultado.getString(5);
					        	System.out.println("imprimir url " + url);
					        	a =new LeerPdf(url);
					        	panelCentro.add(a);
					        
					        							        
							}
					        
					        resultado.close();
					        resultado=sentencias.executeQuery("SELECT * FROM archivosautores where nombrearchivo_autores = '" +nseleccionado.toString() +"'");
						     
					        while(resultado.next())
							{	
					        	panelCentro.removeAll();
					        	panelCentro.repaint();
					       
					        	url= resultado.getString(6);
					        	System.out.println("imprimir url " + url);
					        	a =new LeerPdf(url);
					        	panelCentro.add(a);
					        
					        							        
							}
					        
					       
					       
					     } // final del try
					     catch(SQLException ex) {
					       
					       
					     }
						
					}
				}
			}
		});
		
	}
}
