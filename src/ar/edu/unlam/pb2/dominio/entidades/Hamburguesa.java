package ar.edu.unlam.pb2.dominio.entidades;

import java.util.Objects;

import ar.edu.unlam.pb2.dominio.enums.CantidadDeMedallones;
import ar.edu.unlam.pb2.dominio.enums.Tamanio;

public class Hamburguesa extends Producto {

	private final Double PRECIO_BASE = 8000.0;
	private final Double PRECIO_MEDALLON = 2000.0;

	private boolean esVegana;
	private int cantidadMedallones;

	public void esVegana(boolean esVegana) {
		this.esVegana = esVegana;
	}

	public boolean esVegana() {
		return this.esVegana;
	}

	@Override
	public Double obtenerPrecio() {
		Double precio = null;
		
		CantidadDeMedallones medallones = this.obtenerOpcionCantidadDeMedallones(this.cantidadMedallones);
		switch (medallones) {
		case UN_MEDALLON:
			precio = PRECIO_BASE;
			break;
		case DOS_MEDALLONES:
			precio = PRECIO_BASE + PRECIO_MEDALLON;
			break;
		case TRES_MEDALLONES:
			precio = PRECIO_BASE + (PRECIO_MEDALLON * 2);
			break;
		case CUATRO_MEDALLONES:
			precio = PRECIO_BASE + (PRECIO_MEDALLON * 3);
			break;
		}
		return precio;
	}

	private CantidadDeMedallones obtenerOpcionCantidadDeMedallones(int cantidadMedallones2) {
		return CantidadDeMedallones.values()[cantidadMedallones - 1];
	}

	public void setCantidadMedallones(int cantidadMedallones) {
		this.cantidadMedallones = cantidadMedallones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadMedallones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hamburguesa other = (Hamburguesa) obj;
		return cantidadMedallones == other.cantidadMedallones;
	}
}
