package ar.edu.unlam.pb2.dominio.entidades;

import ar.edu.unlam.pb2.dominio.enums.Tamanio;
import ar.edu.unlam.pb2.dominio.enums.TipoBebida;

public class Bebida extends Producto {

	private final Double PRECIO_BEBIDA_CHICA_BASE = 2000.0;
	private final Double PRECIO_BEBIDA_GRANDE = 3000.0;
	private final Double PRECIO_EXTRA = 1000.0;

	private Tamanio tamanio;
	private TipoBebida tipoBebida;

	@Override
	public Double obtenerPrecio() {
		Double precio = null;
		TipoBebida bebidaElegida = this.obtenerBebidaElegida();
		switch (bebidaElegida) {
		case AGUA:
			if (tamanio.equals(Tamanio.CHICA)) {
				precio = PRECIO_BEBIDA_CHICA_BASE;
			} else if (tamanio.equals(Tamanio.GRANDE)) {
				precio = PRECIO_BEBIDA_GRANDE;
			}
			break;
		case GASEOSA:
			if (tamanio.equals(Tamanio.CHICA)) {
				precio = PRECIO_BEBIDA_CHICA_BASE + PRECIO_EXTRA;
			} else if (tamanio.equals(Tamanio.GRANDE)) {
				precio = PRECIO_BEBIDA_GRANDE + PRECIO_EXTRA;
			}
			break;
		case JUGO:
			if (tamanio.equals(Tamanio.CHICA)) {
				precio = PRECIO_BEBIDA_CHICA_BASE + PRECIO_EXTRA;
			} else if (tamanio.equals(Tamanio.GRANDE)) {
				precio = PRECIO_BEBIDA_GRANDE + PRECIO_EXTRA;
			}
			break;
		case CERVEZA:
			if (tamanio.equals(Tamanio.CHICA)) {
				precio = PRECIO_BEBIDA_CHICA_BASE + (PRECIO_EXTRA * 2);
			} else if (tamanio.equals(Tamanio.GRANDE)) {
				precio = PRECIO_BEBIDA_GRANDE + (PRECIO_EXTRA * 3);
			}
			break;
		}
		return precio;
	}

	private TipoBebida obtenerBebidaElegida() {
		return this.getTipoBebida();
	}

	public void setTamanio(Tamanio tamanioSeteado) {
		this.tamanio = tamanioSeteado;
	}

	public Tamanio getTamanio() {
		return this.tamanio;
	}

	public void setTipoBebida(TipoBebida tipoBebidaASetear) {
		this.tipoBebida = tipoBebidaASetear;
	}

	public TipoBebida getTipoBebida() {
		return this.tipoBebida;
	}

}
