package ar.edu.unlam.pb2.dominio.entidades;

import ar.edu.unlam.pb2.dominio.enums.Tamanio;

public class PapaFrita extends Producto {

	private final Double PRECIO_PAPA_CHICA = 3000.0;
	private final Double PRECIO_PAPA_GRANDE = 5000.0;

	public Tamanio tamanio;


	@Override
	public Double obtenerPrecio() {
		Double precio = null;
		if (tamanio.equals(Tamanio.CHICA)) {
			precio = PRECIO_PAPA_CHICA;
		} else if (tamanio.equals(Tamanio.GRANDE)) {
			precio = PRECIO_PAPA_GRANDE;
		}
		return precio;
	}

	public Producto setTamanio(Tamanio tamanioSeteado) {
		 this.tamanio = tamanioSeteado;
		 return this;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

}
