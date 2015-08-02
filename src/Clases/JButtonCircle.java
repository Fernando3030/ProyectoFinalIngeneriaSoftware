package Clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonCircle extends JButton {

    private Image image = null;
    

    /** Constructor de clase */
    public JButtonCircle(){}

    /**
 * Constructor de clase
 * @param coord de tipo Point 
 * Es la coordenada de la esquina superior derecha del boton 
 */
    public JButtonCircle( Point coord )
    {
        this.setBounds( coord.x, coord.y, 60, 60 );        
        this.setCursor( new Cursor(Cursor.HAND_CURSOR));
 this.setContentAreaFilled(false);
 this.setBorderPainted(false);

  
 this.repaint();
    }

    public void setFotografia( ImageIcon icono )
    {
        this.image = ((ImageIcon)icono).getImage();
        
    }

    public Image getFotografia()
    {
        return this.image;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int w = getWidth(); int h = getHeight();
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setPaint(new Color(255,255,255));//COLOR DE FONDO
        g2.fill(new Ellipse2D.Double(3, 3, w-6, h-6));//FORMA DEL BOTON
      g2.setColor(new Color(100, 100, 100));//COLOR DEL CONTORNO
      g2.drawOval(3, 3, getWidth()-7, getHeight()-7);//DIBUJO UN CIRCULO
      g2.setColor(new Color(255, 255, 255, 50));
       g2.drawOval(3, 3, getWidth()-6, getHeight()-6); 

        g2.setClip( new Ellipse2D.Float(3, 3, w-6,h-6) );
        g2.drawImage(image,3,3, w-6,h-6,this);//PINTO LA IMAGEN EN EL BOTON
        g2.dispose();      
    }

    @Override
    protected void paintBorder(Graphics g) {
        int w = getWidth(); int h = getHeight();
        Graphics2D g2 = (Graphics2D)g.create();
 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.8f));
        g2.setColor(new Color(21,160,203));
        g2.drawOval(3, 3, w-6 , h-6);
        g2.dispose();
    }

}