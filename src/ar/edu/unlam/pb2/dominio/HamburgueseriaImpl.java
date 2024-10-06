package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.pb2.dominio.contratos.Hamburgueseria;
import ar.edu.unlam.pb2.dominio.entidades.Producto;
import ar.edu.unlam.pb2.dominio.entidades.Bebida;
import ar.edu.unlam.pb2.dominio.entidades.Cliente;
import ar.edu.unlam.pb2.dominio.entidades.Hamburguesa;
import ar.edu.unlam.pb2.dominio.entidades.PapaFrita;
import ar.edu.unlam.pb2.dominio.entidades.Pedido;

public class HamburgueseriaImpl implements Hamburgueseria {

	private static final int CANTIDAD_MAXIMA_PRODUCTOS = 5;
	List<Producto> productos;
	List<Cliente> clientes;
	List<Pedido> pedidos;

	public HamburgueseriaImpl() {
		this.productos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.pedidos = new ArrayList<>();
	}

	@Override
	public Boolean agregarProducto(Producto producto) {
		Boolean agregarProducto = false;
		if (this.productos.size() < CANTIDAD_MAXIMA_PRODUCTOS) {
			this.productos.add(producto);
			return agregarProducto = true;
		}
		return agregarProducto;
	}

	@Override
	public List<Producto> obtener() {
		return this.productos;
	}

	@Override
	public List<Hamburguesa> obtenerHamburguesas(boolean esVegana) {
		List<Hamburguesa> hamburguesas = new ArrayList<>();
		for (Producto comida : this.productos) {
			if (comida instanceof Hamburguesa && ((Hamburguesa) comida).esVegana()) {
				hamburguesas.add((Hamburguesa) comida);
			}
		}
		return hamburguesas;
	}

	public Double obtenerPrecioHamburguesa(Hamburguesa hamburguesa) {
		Double precio = null;
		for (Producto comida : this.productos) {
			if (comida instanceof Hamburguesa && ((Hamburguesa) comida).equals(hamburguesa)) {
				precio = ((Hamburguesa) comida).obtenerPrecio();
			}
		}
		return precio;
	}

	public Double obtenerPrecioPapaFrita(Producto papasFritas) {
		Double precio = null;
		for (Producto comida : this.productos) {
			if (comida instanceof PapaFrita && ((Producto) comida).equals(papasFritas)) {
				precio = ((Producto) comida).obtenerPrecio();
			}
		}
		return precio;
	}

	public Boolean agregarCliente(Cliente cliente) {
		return this.clientes.add(cliente);
	}

	public void crearPedidoParaCLiente(Cliente cliente, List<Producto> productosPedido) {
		Pedido pedido = new Pedido();
		for(Producto producto : productosPedido) {
				pedido.agregarProducto(producto);
		}
		cliente.agregarPedido(pedido);
		this.pedidos.add(pedido);
	}

}
