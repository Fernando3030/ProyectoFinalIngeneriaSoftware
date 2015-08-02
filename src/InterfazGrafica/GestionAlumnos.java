package InterfazGrafica;


import java.awt.Color;
import java.awt.Container;

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















import javax.swing.border.EtchedBorder;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;







import Clases.Conexion;
import Clases.Validaciones;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	 private JButton btnGuardar, btnBuscar, btnModificar, btnEliminar, btnSalir, btnNuevo;
	 private JPanel panelDerecho;
	 private JDateChooser dateChooser;
	 private JLabel lblParalelo;
	 private JComboBox comboBox;
	 private String codigo;
	 private Validaciones validacion = new Validaciones();
	 private boolean banderaModificar;
	 private JLabel lbl1;
	String usuarioBuscado;
	 private JLabel lbl2;
	 private JLabel lbl3;
	 private JLabel lbl4;
	 private JLabel lbl5;
	 private JLabel lbl6;
	 private JLabel lbl7;
	 private String combo;
	 private boolean camposVacios=true;
	 
		public Statement sentencias;
		ResultSet resultado;

	
	

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public GestionAlumnos()  {
		
		try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		panelCentro.setBounds(10, 131, 304, 429);
		
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
		txtNombre.setEnabled(false);
		txtNombre.setForeground(new Color(46, 139, 87));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(41, 86, 191, 36);
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setEnabled(false);
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigo.setForeground(new Color(46, 139, 87));
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(41, 26, 191, 31);
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellido.setForeground(new Color(46, 139, 87));
		txtApellido.setBounds(42, 146, 190, 36);
		txtCurso = new JTextField();
		txtCurso.setEnabled(false);
		txtCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCurso.setForeground(new Color(46, 139, 87));
		txtCurso.setBounds(41, 261, 125, 31);
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setForeground(new Color(46, 139, 87));
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUsuario.setBounds(41, 319, 191, 31);
		txtContra = new JPasswordField();
		txtContra.setEnabled(false);
		txtContra.setForeground(new Color(46, 139, 87));
		txtContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtContra.setBounds(42, 379, 190, 31);
		

		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		
		
		
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
		
		lblParalelo = new JLabel("Paralelo");
		lblParalelo.setForeground(new Color(0, 100, 0));
		lblParalelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParalelo.setBounds(173, 236, 59, 25);
		panelCentro.add(lblParalelo);
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(176, 262, 54, 31);
		panelCentro.add(comboBox);
		
		dateChooser.setForeground(new Color(46, 139, 87));
		dateChooser.setBounds(41, 207, 191, 31);
		panelCentro.add(dateChooser);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(237, 26, 35, 31);
		panelCentro.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBounds(237, 86, 35, 31);
		panelCentro.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setBounds(237, 146, 35, 31);
		panelCentro.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setBounds(237, 207, 35, 31);
		panelCentro.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setBounds(237, 261, 35, 31);
		panelCentro.add(lbl5);
		
		lbl6 = new JLabel("");
		lbl6.setBounds(237, 319, 35, 31);
		panelCentro.add(lbl6);
		
		lbl7 = new JLabel("");
		lbl7.setBounds(237, 379, 35, 31);
		panelCentro.add(lbl7);
		miFramePane.add(miPanel);
		
		panelDerecho = new JPanel();
		panelDerecho.setBackground(Color.WHITE);
		panelDerecho.setBounds(313, 151, 121, 391);
		miPanel.add(panelDerecho);
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo=validacion.codigoAleatorio(8);
				 lbl1.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
             	
            	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
            	 lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
            	 lbl4.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
            	 lbl5.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
            	 lbl6.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
            	 lbl7.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
		
				txtCodigo.setText(codigo);
				txtNombre.setEnabled(true);
				txtNombre.requestFocus();
				txtNombre.setText("");
				txtApellido.setEnabled(true);
				txtApellido.setText("");
				txtCurso.setEnabled(true);
				txtCurso.setText("");
				txtUsuario.setEnabled(true);
				txtUsuario.setText("");
				txtContra.setEnabled(true);
				txtContra.setText("");
				dateChooser.setDate(null);
				dateChooser.setEnabled(true);
				btnGuardar.setEnabled(true);
        		btnNuevo.setEnabled(false);
        		comboBox.setEnabled(true);
        		btnModificar.setEnabled(false);
        		banderaModificar=false;
				
			}
		});
		panelDerecho.add(btnNuevo);
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setToolTipText("Nuevo Alumno");
		btnNuevo.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/newmediano.png")));
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean banderaEncontrado= true;
			
				usuarioBuscado= JOptionPane.showInputDialog("Ingrese el nombre del usuario a Buscar: ");
				if(usuarioBuscado != null)
            	{
					String letra;
					
					try {
					       
				        resultado=sentencias.executeQuery("SELECT * FROM alumnos WHERE usuario_alumno='"+usuarioBuscado+"'");
				     
				        while(resultado.next())
						{	
				        	btnGuardar.setEnabled(false);
				        	banderaEncontrado= false;
				        	codigo=resultado.getString(1);
				        	    txtCodigo.setText(codigo);
						        txtNombre.setText(resultado.getString(2));
						        txtApellido.setText(resultado.getString(3));
						        dateChooser.setDate(resultado.getDate(5));
						        txtCurso.setText(resultado.getString(4));
						        txtUsuario.setText(resultado.getString(6));
						        txtContra.setText(resultado.getString(7));
						        letra= resultado.getString(9);
						       
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
						        
						        btnModificar.setEnabled(true);
						        deshabilitar();
						}
				        if(banderaEncontrado)
				        {
				        	 JOptionPane.showMessageDialog(null,"Usuario no registrado");
				        }
						        	
				  
				       
				     } // final del try
				     catch(SQLException ex) {
				       
				        System.out.println(ex);
				     }
				     
				     
					
				
					
            	}
				
				
				else
				{
					 JOptionPane.showMessageDialog(null,"Por favor ingrese un usuario válido");
				}
			    

			}
		});
		panelDerecho.add(btnBuscar);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setToolTipText("Buscar Alumno");
		btnBuscar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/search-icon.png")));
		btnGuardar= new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean banderaNombre= true;
				boolean banderaApellido=true;
				boolean banderaCurso= true;
				boolean banderaUsuario= true;
				boolean banderaContra= true;
			
				boolean banderaFecha = true;
				String nombre= txtNombre.getText();
				String apellido= txtApellido.getText();
				String curso= txtCurso.getText();
				String usuario = txtUsuario.getText();
				String contraseña= txtContra.getText();
				
				Date fecha = dateChooser.getDate();
				
				banderaNombre=!validacion.ValidacionString(nombre);
	                if(nombre.length()!= 0)
	                {
	                 if(!banderaNombre )
	                 {
	                	 //banderaProducto=false;
	                	 
	                	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                 }
	                 else
	                 {
	                	 //banderaProducto=true;
	                	
	                	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                 }
	                }
	                else
	                {
	                	banderaNombre=false;
	                	lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                	
	                }
	                
	                banderaApellido=!validacion.ValidacionString(apellido);
	                if(apellido.length()!= 0)
	                {
	                 if(!banderaApellido )
	                 {
	                	 //banderaProducto=false;
	                	 
	                	 lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                 }
	                 else
	                 {
	                	 //banderaProducto=true;
	                	
	                	 lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                 }
	                }
	                else
	                {
	                	banderaApellido=false;
	                	lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                	
	                }
	                
	                if (fecha != null){
	          			
	                	banderaFecha=true;
          				
          				lbl4.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
          			
          				
          			}
	          	    else
	          	    {
	          	    	banderaFecha=false;
	          	    	lbl4.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	          	    }
	                
	                if(curso.length()!= 0)
	                {
	                	lbl5.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                	banderaCurso= true;
	                	
	                }
	                else
	                {
	                	lbl5.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                	banderaCurso= false;
	                }
	                
	                if(usuario.length()!= 0)
	                {
	                	lbl6.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                	banderaUsuario= true;
	                	
	                }
	                else
	                {
	                	lbl6.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                	banderaUsuario= false;
	                }
	                
	                if(contraseña.length()!= 0)
	                {
	                	lbl7.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                	banderaContra= true;
	                	
	                }
	                else
	                {
	                	lbl7.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/error.png")));
	                	banderaContra= false;
	                }
	                
	                combo= String.valueOf(comboBox.getSelectedItem());
	                
	                if(banderaModificar==false)
	                {
	              	  
	              	   if((!banderaNombre)&&(!banderaApellido)&&(banderaFecha)&&(banderaCurso)&&(banderaUsuario)&&(banderaContra))
	                     {
	              		   
	              		  
	                    	 lbl1.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	
	                    	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	 lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	 lbl4.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	 lbl5.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	 lbl6.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	 lbl7.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
	                    	System.out.println("usuario nuevo " + Login.usuario);
	                    	 String query= "select cod_admin from administrador where usuario_admin ='"+Login.usuario+"'";
	                    	 System.out.println("imprimir query " + query);
	                 		
							try {
								
								resultado = sentencias.executeQuery(query);
								resultado.next();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                 	
	                         try {
	                        	 
	                        	 sentencias.executeUpdate("INSERT INTO alumnos VALUES ('"+codigo+"',"+"'"+nombre+"',"+"'"+apellido+"',"+"'"+curso+"',"+"'"+fecha+"',"+"'"+usuario+"'," +"'"+contraseña+"',"+"'"+resultado.getString("cod_admin")+"',"+"'"+combo+"')");
	                          }
	                          catch (SQLException ex) {
	                              JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Insertar el Registro");
	                              System.out.println(ex);
	                          }

	                         txtCodigo.setText(codigo);
	         			
	         				
	  		
	  		              	btnGuardar.setEnabled(false);
	  		          		btnNuevo.setEnabled(true);
	  		          		camposVacios=false;
	  		          		deshabilitar();
	  		          		
	  		
	  		              	 JOptionPane.showMessageDialog(null, "Datos Guardado con Exito");
	                     
	                
	                }
	                
	                else 
	                {
	            	    JOptionPane.showMessageDialog(null, "Algun campo esta erroneo");
	                }
	              	  
	              	  
	                }
	                else
	                {
	              	  System.out.println("se ejecuto el metodo");
	                 	
	              	   if((!banderaNombre)&&(!banderaApellido)&&(banderaFecha)&&(banderaCurso)&&(banderaUsuario)&&(banderaContra))
	                    {
			              		 lbl1.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
			                    	
		                    	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	 lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	 lbl4.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	 lbl5.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	 lbl6.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	 lbl7.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	 
		                    	 try {
		                             sentencias.executeUpdate("UPDATE alumnos SET nom_alumno='"+nombre+"',"+"ape_alumno='"+apellido+"',"+"curso_alumno='"+curso+"',"+"fech_reg_alumno='"+fecha+"',"+"usuario_alumno='"+usuario+"',"+"contra_alumno='"+contraseña+"',"+"paralelo='"+combo+"'"+" WHERE usuario_alumno='"+usuarioBuscado+"'");
		                           }
		                           catch (SQLException ex) {
		                               JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Modificar el Registro");
		                               System.out.println(ex);
		                           }

	              		  
		                    	 deshabilitar();
		                    	 btnGuardar.setEnabled(false);
		                         btnNuevo.setEnabled(true);
		                         txtCodigo.setText(codigo);
		 	         			
			         				
		                    	 
	  						
	                	camposVacios=false;
	           
	                    }
	                }
	                
	                if(camposVacios)
	                {
	                   	JOptionPane.showMessageDialog(null, "Todos los Datos son Obligatorios");
	                }
	                 
		
				
				
			}
		});
		btnGuardar.setEnabled(false);
		panelDerecho.add(btnGuardar);
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setToolTipText("Guardar Alumno");
		btnGuardar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/saveee.png")));
		btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				    btnNuevo.setEnabled(true);
	        	   btnGuardar.setEnabled(true);
	        	   btnModificar.setEnabled(false);
			    	banderaModificar= true;
				    habilitar();
			}
		});
		btnModificar.setEnabled(false);
		panelDerecho.add(btnModificar);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setToolTipText("Modificar Alumno");
		btnModificar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/modificar.png")));
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usuarioBuscado= JOptionPane.showInputDialog("Ingrese el nombre del usuario a Eliminar: ");
				if(usuarioBuscado != null)
            	{
					 lbl1.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
		             	
	            	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
	            	 lbl3.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
	            	 lbl4.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
	            	 lbl5.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
	            	 lbl6.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
	            	 lbl7.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
			
					txtCodigo.setText("");
					txtNombre.setEnabled(false);
					
					txtNombre.setText("");
					txtApellido.setEnabled(false);
					txtApellido.setText("");
					txtCurso.setEnabled(false);
					txtCurso.setText("");
					txtUsuario.setEnabled(false);
					txtUsuario.setText("");
					txtContra.setEnabled(false);
					txtContra.setText("");
					dateChooser.setDate(null);
					dateChooser.setEnabled(false);
					btnGuardar.setEnabled(false);
	        		btnNuevo.setEnabled(true);
	        		comboBox.setEnabled(false);
	        		btnModificar.setEnabled(false);
	        		banderaModificar=false;
	        	      try {
	        	          sentencias.executeUpdate("DELETE FROM alumnos WHERE usuario_alumno='"+usuarioBuscado+"'");
	        	       }
	        	       catch (SQLException ex) {
	        	           JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Eliminar el Registro");
	        	       }

            	}
				else
				{
			         JOptionPane.showMessageDialog(null,"No puede ingresar un campo vacío");
				}
			}
		});
		panelDerecho.add(btnEliminar);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setToolTipText("Eliminar Alumno");
		btnEliminar.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/deleteee.png")));
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VentanaBienvenida ventana= new VentanaBienvenida();
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
	
	public void habilitar()
	{
		
		
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
	
		txtCurso.setEnabled(true);
		
		txtUsuario.setEnabled(true);
		
		txtContra.setEnabled(true);
		
		dateChooser.setEnabled(true);
		comboBox.setEnabled(true);
	}
	public void deshabilitar()
	{

		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
	
		txtCurso.setEnabled(false);
		
		txtUsuario.setEnabled(false);
		
		txtContra.setEnabled(false);
		
		dateChooser.setEnabled(false);
		comboBox.setEnabled(false);
	}
}
