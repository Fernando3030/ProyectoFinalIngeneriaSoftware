package Clases;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;

public class LeerPdf extends JInternalFrame implements ActionListener {
	static String a="";
	//
	public JButton nextPage = new JButton("Siguiente");
	public JButton backPage = new JButton("Anterior");
	public JButton search = new JButton("Buscar");
	public JTextField area1 = new JTextField();
	public int pagina = 0;
	public int paginas = 900;
	public int number = 0;
	public PagePanel panel = new PagePanel();
	//public JPanel prueba = new JPanel();
	

			public LeerPdf(String b) {
				a=b;
	    						setTitle("Pdf Archivos de Ayuda");
	        					setResizable(true);
	        					setMaximizable(true);
	        					setLayout(null);
	        					setSize(940, 580);
	        					setVisible(true);
	        					
	        
	   		//Botones y area texto 
								nextPage.setBounds(350,5,100,20);
								nextPage.addActionListener(this);
								backPage.setBounds(240,5,100,20);
								backPage.addActionListener(this);
								search.setBounds(570,5,100,20);
								search.addActionListener(this);
								area1.setBounds(500, 5, 40, 30);
			
			//Dimesion del frame y panel
							//	Dimension pantalla, cuadro;
	        					//pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	        					//cuadro = this.getSize();
	        					//this.setLocation(((pantalla.width - cuadro.width)/2),
	        					//(pantalla.height - cuadro.height)/2);
	        					panel.setBounds(10,50,940, 580);
	        					panel.setBackground(new Color(46,139,87));
	    	//Agrego todos los elemntos al frame principal
	        					add(nextPage);
	        					add(backPage);
	        					add(panel);
	        					add(search);
	        					add(area1);
	        					repaint();
	        					
	        //Cuando se cierre la ventana se acaba la compilación
	        					setDefaultCloseOperation(EXIT_ON_CLOSE);
	        }

	 
			public void actionPerformed(ActionEvent e)
				{

	        					if (e.getSource()==nextPage)
	        					{
							     pagina+=1;
								 if(pagina>paginas||pagina<1)
									{
									pagina=1;
									}
								try {

								File file = new File(a); 
								//Ubicación del archivo pdf
								RandomAccessFile raf = new RandomAccessFile(file, "r");
								FileChannel channel = raf.getChannel();

								ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
								PDFFile pdffile = new PDFFile(buf);

								// muestra la pagina en la posición de la variable pagina page channel.size()
								PDFPage page = pdffile.getPage(pagina);
								paginas = pdffile.getNumPages(); //numero de paginas del documento
								panel.useZoomTool(false);
								panel.showPage(page);
									}
	   							
	   							catch (Exception ex) 
	   								{
	                				ex.printStackTrace();
	            					}
	 							repaint();
	 							panel.repaint();
	 
	        					}
	        
	        					if(e.getSource()==backPage)
	        					{
	        					pagina-=1;
									if(pagina>paginas||pagina<1)
									{
									pagina=1;
									}
								try {

								File file = new File(a);
								//ubicación del archivo pdf.
								RandomAccessFile raf = new RandomAccessFile(file, "r");
								FileChannel channel = raf.getChannel();
								ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
								PDFFile pdffile = new PDFFile(buf);

								// Muestra la pagina indicada por la variable paginas
								PDFPage page = pdffile.getPage(pagina);
								paginas = pdffile.getNumPages(); ////numero de paginas del documento
								panel.useZoomTool(false);
								panel.showPage(page);

								}
	   							catch (Exception ex) 
	   								{
	                			    ex.printStackTrace();
	            					}
	 							repaint();
	 							panel.repaint();
	        					}
	        
	        					if(e.getSource()==search)
	        					{
								number=Integer.parseInt(area1.getText());
								pagina=number;

									if(pagina>paginas||pagina<0)
									{
									pagina=1;
									}
								try {

								File file = new File(a); 
								//ubicación directorio y con el nombre del archivo pdf
								RandomAccessFile raf = new RandomAccessFile(file, "r");
								FileChannel channel = raf.getChannel();
								ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
								PDFFile pdffile = new PDFFile(buf);
								// abre la pagina segun el valor de la variable numero
								PDFPage page = pdffile.getPage(pagina);
								paginas = pdffile.getNumPages(); //numero de paginas del documento
								panel.useZoomTool(false);
								panel.showPage(page);
									}
	   
	   							catch (Exception ex) 
	   								{
	                				ex.printStackTrace();
	           					 	}
	 							repaint();
	 							panel.repaint();


	        					}
					}

	public void keyPressed(KeyEvent el)
		{
			if (el.getKeyCode()==KeyEvent.VK_A)
				panel.removeAll();
	                        panel.repaint();
	                        repaint();
	                                
		}
}
