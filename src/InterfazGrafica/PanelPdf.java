package InterfazGrafica;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Clases.LeerPdf;


public class PanelPdf extends JPanel  {
	//public JFrame v=new JFrame();
	
	
	public PanelPdf(String a){
		
		
		
		LeerPdf l=new LeerPdf(a);
		
		
		
		
		l.setPreferredSize(new Dimension(1000, 1200));

		
	
		JScrollPane scroll = new JScrollPane(l);
		scroll .setBounds(0,0, 995,673);
		
		add(scroll);
		
		
		
		//v.setVisible(false);
	//	v.setVisible(true);
	}
}
