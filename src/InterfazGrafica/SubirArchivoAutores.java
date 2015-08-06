package InterfazGrafica;


import java.awt.Color;
import java.awt.Container;




import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;

import java.awt.Font;




import Clases.Validaciones;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SubirArchivoAutores {

	private JFrame frame;
	 private Container miFramePane;
	 private JPanel miPanel;
	 private JPanel panelSuperior;
	 private JLabel lblimagen, lblTitulo;
	 private JLabel lblNombreArchivo;

	private JPanel panelCentro ;
	private JLabel lblAutorLibro;
	private JPanel panelInferior;
	private  JButton btnGenerar;
	private JTextField txtURL;
	private JTextField txtNombreArchivo;
	private JTextField txtAutor;
	private JButton btnBusar;
	private 	JButton btnSalir;
	private JButton btnNuevo;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JLabel lbl1 ;
	private JLabel lbl2;
	private String codigo="";
	Validaciones validacion= new Validaciones();
	private boolean banderaModificar;
	public Statement sentencias;
	private String urlLibro;
	ResultSet resultado;
	private boolean camposVacios=true;
	private String nombreRealArchivo;
	private String libroBuscado;
	/**
	 * Create the application.
	 */
	public SubirArchivoAutores() {
		frame = new JFrame("Subir Archivo");
		
		try {
			sentencias= Login.con.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		miPanel= new JPanel();
		miPanel.setBackground(new Color(46, 139, 87));
		panelSuperior= new JPanel();
		panelSuperior.setBounds(0, 0, 522, 123);
		panelSuperior.setBackground(new Color(46, 139, 87));
		lblimagen= new JLabel("");
		lblimagen.setBounds(0, 0, 221, 120);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/upload.png")));
		lblTitulo= new JLabel("Archivos Otros Autores");
		lblTitulo.setBounds(168, 0, 348, 112);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelCentro = new JPanel();
		 lblAutorLibro = new JLabel("Autor Libro:");

			panelInferior = new JPanel();

		lblNombreArchivo= new JLabel("Nombre Archivo:");
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean banderaEncontrado= true;
				
				libroBuscado= JOptionPane.showInputDialog("Ingrese el nombre código del libro a Buscar: ");
				if(libroBuscado != null)
            	{
					
					
					try {
					       
				        resultado=sentencias.executeQuery("SELECT * FROM archivosautores WHERE cod_arch_autores='"+libroBuscado+"'");
				     
				        while(resultado.next())
						{	
				        	 btnNuevo.setEnabled(true);
				        	   btnGenerar.setEnabled(true);
				        	   btnModificar.setEnabled(false);
						    	banderaModificar= true;
				        	banderaEncontrado= false;
				        	txtURL.setText(resultado.getString(6));
				        	txtNombreArchivo.setText(resultado.getString(3));
				        	txtAutor.setText(resultado.getString(4));
				        	txtNombreArchivo.setEnabled(true);
				        	txtAutor.setEnabled(true);
						}
				        if(banderaEncontrado)
				        {
				        	 JOptionPane.showMessageDialog(null,"Libro no registrado");
				        }
					}
					 catch(SQLException ex) {
					       
					        System.out.println(ex);
					     }
            	}
				else
				{
					 JOptionPane.showMessageDialog(null,"Por favor ingrese un código de libro válido");
				}
				
				
				
			}
		});
		btnBorrar = new JButton("");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				libroBuscado= JOptionPane.showInputDialog("Ingrese el código del libro a Eliminar: ");
				if(libroBuscado != null)
            	{
					 lbl1.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("")));
		             	
	            	 lbl2.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("")));
	            	 txtURL.setText("");
	            	 txtNombreArchivo.setText("");
	            	 txtAutor.setText("");
	            	 banderaModificar=false;
	            	 txtNombreArchivo.setEnabled(false);
	            	 txtAutor.setEnabled(false);
	            	 try {
	            		 resultado=sentencias.executeQuery("SELECT * FROM archivosautores WHERE cod_arch_autores='"+libroBuscado+"'");
	            		  while(resultado.next())
							{	
	            			  String fichero2= resultado.getString(6);
	            			  System.out.println(fichero2);
	            			  File fichero = new File(fichero2);
		        	            if (fichero.delete())
		        	            {
		        	         System.out.println("El fichero ha sido borrado satisfactoriamente");
		        	            }
		        	         else
		        	         {
		        	          System.out.println("El fichero no puede ser borrado");
		        	         }
		        	            
	            			  sentencias.executeUpdate("DELETE FROM archivosautores WHERE cod_arch_autores='"+libroBuscado+"'");
		        	        
							}
	            		  
	        	         
	        	       }
	        	       catch (SQLException ex) {
	        	         
	        	       }
            	}
				else
				{
			         JOptionPane.showMessageDialog(null,"No puede ingresar un campo vacío");
				}
			}
		});
		btnSalir = new JButton("");
		btnBusar = new JButton("Buscar");
		btnBusar.setEnabled(false);
		txtURL = new JTextField();
		txtNombreArchivo = new JTextField();
		txtNombreArchivo.setEnabled(false);
		txtAutor = new JTextField();
		txtAutor.setEnabled(false);
		btnNuevo = new JButton("");
		
		
		
		
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
		panelCentro.setBounds(20, 120, 478, 196);
		miPanel.add(panelCentro);
		panelCentro.setLayout(null);
	
		lblNombreArchivo.setBounds(10, 58, 125, 28);
		panelCentro.add(lblNombreArchivo);
		lblNombreArchivo.setForeground(new Color(0, 100, 0));
		lblNombreArchivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		lblAutorLibro.setForeground(new Color(0, 100, 0));
		lblAutorLibro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutorLibro.setBounds(10, 97, 95, 28);
		panelCentro.add(lblAutorLibro);
		
		panelInferior.setBounds(10, 128, 458, 65);
		panelCentro.add(panelInferior);
		panelInferior.setBackground(Color.WHITE);
		
	
		
		btnNuevo.setToolTipText("Nuevo Libro");
		btnNuevo.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/newmediano.png")));
		panelInferior.add(btnNuevo);
		
		
		btnModificar.setToolTipText("Modificar Libro");
		btnModificar.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/modificar.png")));
		panelInferior.add(btnModificar);
		btnGenerar = new JButton("");
	
		btnGenerar.setEnabled(false);
		
		
		btnGenerar.setToolTipText("Subir Libro");
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/Button-Upload-icon.png")));
		panelInferior.add(btnGenerar);
		
		
		btnBorrar.setToolTipText("Eliminar Libro");
		btnBorrar.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/deleteee.png")));
		panelInferior.add(btnBorrar);
		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				VentanaBienvenida ventana= new VentanaBienvenida();
			}
		});
		btnSalir.setIcon(new ImageIcon(ReporteAlumnos.class.getResource("/Imagenes/salirr.png")));
		btnSalir.setToolTipText("Salir");
		panelInferior.add(btnSalir);
		
		
		
		
		txtURL.setForeground(new Color(0, 100, 0));
		txtURL.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtURL.setEditable(false);
		txtURL.setBounds(10, 11, 329, 36);
		panelCentro.add(txtURL);
		txtURL.setColumns(10);
		
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean banderaUrl= true;
				boolean banderaNombre= true;
				boolean banderaAutor=true;
				
				String nombre= txtNombreArchivo.getText();
				String autor= txtAutor.getText();
				String url= txtURL.getText();
				
				 if(nombre.length()!= 0)
	                {
	                	lbl1.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/Accept-icon.png")));
	                	banderaNombre= true;
	                	
	                }
	                else
	                {
	                	lbl1.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/error.png")));
	                	banderaNombre= false;
	                }
				 

				 if(autor.length()!= 0)
	                {
	                	lbl2.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/Accept-icon.png")));
	                	banderaAutor= true;
	                	
	                }
	                else
	                {
	                	lbl2.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/error.png")));
	                	banderaAutor= false;
	                }
				 
				 if(url.length()!= 0)
	                {
	                
					    banderaUrl= true;
	                	
	                }
	                else
	                {
	                	
	                	banderaUrl= false;
	                }
				 
				 if(banderaModificar==false)
	                {
	              	  
	              	   if(banderaNombre && banderaAutor && banderaUrl)
	                     {
	              		   /** creamos la carpeta Libros donde se guardaran nuestros archivos .pdf**/
	              		    File directorio=new File("Libros de otros autores");
	                        directorio.mkdir(); 
	                        String direccion= directorio.getAbsolutePath();
	                         
	                         
	                         File origen= new File(urlLibro);
	                         File destino= new File(direccion + "\\" + nombreRealArchivo);
	                         System.out.println("url completa " + destino);
	                    
	                         validacion.copyFile(origen, destino);
	              		  
	                    	 lbl1.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/Accept-icon.png")));
	                    	
	                    	 lbl2.setIcon(new ImageIcon(SubirArchivoAutores.class.getResource("/Imagenes/Accept-icon.png")));
	                    	
	                    	
	                    	 String query= "select cod_admin from administrador where usuario_admin ='"+Login.usuario+"'";
	                    	 	Date now = new Date(System.currentTimeMillis());
	                            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	                 
	                    	 
							try {
								
								resultado = sentencias.executeQuery(query);
								resultado.next();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                 	
	                         try {
	                        	 
	                        	 sentencias.executeUpdate("INSERT INTO archivosautores VALUES ('"+codigo+"',"+"'"+date.format(now)+"',"+"'"+nombre+"',"+"'"+autor+"',"+"'"+resultado.getString("cod_admin")+"',"+"'"+destino+"',"+"'"+nombreRealArchivo+"')");
	                          }
	                          catch (SQLException ex) {
	                              JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Insertar el Registro");
	                              System.out.println(ex);
	                          }

	                     
	         			
	         				
	  		
	  		              	btnGenerar.setEnabled(false);
	  		          		btnNuevo.setEnabled(true);
	  		          		camposVacios=false;
	  		             	 txtNombreArchivo.setEnabled(false);
	  	                	 txtAutor.setEnabled(false);
	  	                	 btnBusar.setEnabled(false);
	  	                	 btnModificar.setEnabled(true);
	  		          		
	  		
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
	                 	
	              	   if(banderaNombre && banderaAutor && banderaUrl)
	                    {
	              		 Date now = new Date(System.currentTimeMillis());
                         SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			              		 lbl1.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
			                    	
		                    	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("/Imagenes/Accept-icon.png")));
		                    	
		                    	 
		                    	 try {
		                             sentencias.executeUpdate("UPDATE archivosautores SET fecha_archivo='"+date.format(now)+"',"+"nombrearchivo_autores='"+nombre+"',"+"autor_libro='"+autor+"'"+" WHERE cod_arch_autores='"+libroBuscado+"'");
		                             libroBuscado=""; 
		                    	 }
		                           catch (SQLException ex) {
		                               JOptionPane.showMessageDialog(null,"Hubo un Problema al Intentar Modificar el Registro");
		                               System.out.println(ex);
		                           }

	              		  
		                    	 txtNombreArchivo.setEnabled(false);
		  	                	 txtAutor.setEnabled(false);
		                    	 btnGenerar.setEnabled(false);
		                         btnNuevo.setEnabled(true);
		                         btnBusar.setEnabled(false);
		                       
			         				
		                    	 
	  						
	                	camposVacios=false;
	           
	                    }
	                }
	                
	                if(camposVacios)
	                {
	                   	JOptionPane.showMessageDialog(null, "Todos los Datos son Obligatorios");
	                }
				 
				 
			}
		});
		
	
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo=validacion.codigoAleatorio(8);
				 lbl1.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
	             	
            	 lbl2.setIcon(new ImageIcon(GestionAlumnos.class.getResource("")));
            	 txtNombreArchivo.setText("");
            	 txtAutor.setText("");
            	
            	 txtURL.setText("");
            	 banderaModificar=false;
            	 btnGenerar.setEnabled(true);
         		btnNuevo.setEnabled(false);
         		btnBusar.setEnabled(true);
         	
         		btnModificar.setEnabled(true);
         		
         		 txtNombreArchivo.setEnabled(true);
            	 txtAutor.setEnabled(true);
			
			}
			
		});
		
		
		btnBusar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Creamos el objeto JFileChooser
				JFileChooser fc=new JFileChooser();
				 
				//Indicamos lo que podemos seleccionar
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				 
				//Creamos el filtro
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.pdf", "PDF");
				 
				//Le indicamos el filtro
				fc.setFileFilter(filtro);
				 
				//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
				int seleccion=fc.showOpenDialog(fc);
				 
				//Si el usuario, pincha en aceptar
				if(seleccion==JFileChooser.APPROVE_OPTION){
				 
				    //Seleccionamos el fichero
				  File fichero=fc.getSelectedFile();
				 urlLibro= fichero.getAbsolutePath();
				    //Ecribe la ruta del fichero seleccionado en el campo de texto
				    txtURL.setText(urlLibro);
				    nombreRealArchivo= fc.getSelectedFile().getName();
				    System.out.println(nombreRealArchivo);
				}
				
			}
		});
		btnBusar.setForeground(new Color(0, 100, 0));
		btnBusar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBusar.setBounds(349, 11, 119, 36);
		panelCentro.add(btnBusar);
		
	
		txtNombreArchivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombreArchivo.setForeground(new Color(0, 100, 0));
		txtNombreArchivo.setBounds(139, 58, 299, 28);
		panelCentro.add(txtNombreArchivo);
		txtNombreArchivo.setColumns(10);
		

		txtAutor.setForeground(new Color(0, 100, 0));
		txtAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAutor.setColumns(10);
		txtAutor.setBounds(139, 97, 299, 28);
		panelCentro.add(txtAutor);
		
		lbl1 = new JLabel("");
		lbl1.setIcon(null);
		lbl1.setBounds(442, 58, 26, 28);
		panelCentro.add(lbl1);
		
		 lbl2 = new JLabel("");
		lbl2.setBounds(442, 97, 26, 28);
		panelCentro.add(lbl2);
		
		
	
		
		
		 frame.setVisible(true);
		frame.setSize(528,356);
		frame.setLocationRelativeTo(null);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
