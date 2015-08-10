package Clases;

import java.awt.Color;
import java.awt.Graphics;

import java.sql.Time;
import java.util.Date;

 
 public class Circulo {
     protected int x1;
     protected int y1;
    protected double radio;
    protected double diametro;
    protected double area;
    protected double circunferencia;
    protected String usuario;
    protected Date fechaCirculo;
    protected Time hora;

    public Circulo(String usuario, double radio, double diametro, double area, double circunferencia, Date fechaCirculo, Time hora)
    {
    	this.usuario= usuario;
    	this.radio= radio;
    	this.diametro= diametro;
    	this.area= area;
    	this.circunferencia= circunferencia;
    	this.fechaCirculo= fechaCirculo;
    	this.hora= hora;
    	
    }
    
	 public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaCirculo() {
		return fechaCirculo;
	}

	public void setFechaCirculo(Date fechaCirculo) {
		this.fechaCirculo = fechaCirculo;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Circulo()
	 {
		 
	 }
     
     public Circulo(int x1, int y1, double radio){
         cambiarUbicacion(x1, y1);
         cambiarTamano(radio);
     }
 
     public void cambiarUbicacion(int x1, int y1){
         this.x1 = x1;
         this.y1 = y1;
    }
     
     public void cambiarTamano(double radio){
         this.radio = radio;
     }
     
     public int calcularDiametro( double radio){
         diametro = 2 * radio;
         int dia= (int) diametro;
         return dia;
     }
     
     public double calcularArea(double radio){
         area = (float)(Math.PI * Math.pow(radio, 2));
         return area;
     }
     
     public double calcularCircunferencia(double radio){
         circunferencia = (float)(Math.PI * calcularDiametro(radio));
         return circunferencia;
     }
     
     public void dibujar(Graphics g, double radio){
    		// Graphics: fillOval(int x, int y, int width, int height)
    	
	    		 g.setColor(new Color(1,36,38));
	             g.fillRect(0, 0, 500, 500);
	             
	             g.setColor(new Color(2,115,83));
	             g.fillOval(x1, y1,calcularDiametro(radio), calcularDiametro(radio));
    		 
        
     }

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getCircunferencia() {
		return circunferencia;
	}

	public void setCircunferencia(double circunferencia) {
		this.circunferencia = circunferencia;
	}
     
     
     
     
   
 }