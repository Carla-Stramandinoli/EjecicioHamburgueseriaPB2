package ar.edu.unlam.pb2.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	public String nombre;
	private List<Pedido> pedidos;
	
	  public Cliente(String nombre) {
	        this.nombre = nombre;
	        this.pedidos = new ArrayList<>();
	    }
	  
	    public String getNombre() {
	        return nombre;
	    }

	    public void agregarPedido(Pedido pedido) {
	        pedidos.add(pedido);
	    }

	    public List<Pedido> getPedidos() {
	        return pedidos;
	    }
}
