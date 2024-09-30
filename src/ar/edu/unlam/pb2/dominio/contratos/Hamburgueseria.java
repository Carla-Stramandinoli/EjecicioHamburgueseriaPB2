package ar.edu.unlam.pb2.dominio.contratos;

import java.util.List;

import ar.edu.unlam.pb2.dominio.entidades.Producto;
import ar.edu.unlam.pb2.dominio.entidades.Hamburguesa;

public interface Hamburgueseria {

	 Boolean agregarProducto(Producto producto);
	 List<Producto> obtener();
	 List<Hamburguesa> obtenerHamburguesas(boolean esVegana);
	 Double obtenerPrecioHamburguesa(Hamburguesa hamburguesa);
	 Double obtenerPrecioPapaFrita(Producto papasFritas);
}
