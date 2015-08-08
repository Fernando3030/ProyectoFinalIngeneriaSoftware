package InterfazGrafica;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Clases.LeerPdf;




public class PanelPdf extends JPanel  {
	//public JFrame v=new JFrame();
	
	
	public PanelPdf(String a){
		
	/*	
		v.setVisible(true);
		v.setSize(980, 600);
		v.setResizable(true);
		*/
		
		
		LeerPdf l=new LeerPdf(a);
		
		
		JPanel p=new JPanel();
		p.setLayout(null);
		
		p.setPreferredSize(new Dimension(940, 580));
		p.add(l);
		
		
		JScrollPane scroll = new JScrollPane(p);
		scroll .setBounds(0,0, 930,550);
		
		
		
	//	v.setContentPane(panel);
		add(scroll);
		
		
		
		//v.setVisible(false);
		//v.setVisible(true);
		
	}
}