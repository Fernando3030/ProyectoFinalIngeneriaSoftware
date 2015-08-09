package Clases;

import java.util.Date;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private String codigo;
	private String curso;
	private Date fechaRegistro;
	private String paralelo;
	
	public Alumno(String nombre, String apellido, String curso, String paralelo, Date fechaRegistro, String usuario)
	{
		this.nombre= nombre;
		this.apellido= apellido;
		this.curso= curso;
		this.paralelo= paralelo;
		this.fechaRegistro= fechaRegistro;
		this.usuario= usuario;
	}
	
	public String getParalelo() {
		return paralelo;
	}
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}
	private String usuario;
	private String contrasena;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

}
