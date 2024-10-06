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
	 
	 
}
