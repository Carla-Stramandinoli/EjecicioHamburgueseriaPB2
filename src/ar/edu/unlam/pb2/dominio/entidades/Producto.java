package ar.edu.unlam.pb2.dominio.entidades;

public abstract class Producto {

	private String nombre;

	public abstract Double obtenerPrecio();

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

}