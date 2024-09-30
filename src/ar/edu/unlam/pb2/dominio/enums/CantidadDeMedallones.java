package ar.edu.unlam.pb2.dominio.enums;

public enum CantidadDeMedallones {
	UN_MEDALLON(1),
	DOS_MEDALLONES(2),
	TRES_MEDALLONES(3),
	CUATRO_MEDALLONES(4);
;
	
	private int cantidadDeMedallones;
	
	CantidadDeMedallones(int cantidadDeMedallones){
		this.cantidadDeMedallones = cantidadDeMedallones;
	}
	
	public int getCantidadDeMedallones() {
		return this.cantidadDeMedallones;
	}
}
