package ar.edu.unlam.pb2.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private List<Producto> productos;
	
	 public Pedido() {
	        this.productos = new ArrayList<>();
	    }
	 
	 public void agregarProducto(Producto producto) {
		 this.productos.add(producto);
	 }
	 
	 public List<Producto> getProductos(){
		 return this.productos;
	 }

	public Double getPrecioTotal() {
		Double precioTotal = 0.0;
		for (Producto producto : productos) {
			Double precioAcumulado = producto.obtenerPrecio();
			precioTotal += precioAcumulado;
		}
		return precioTotal;
	}
}
