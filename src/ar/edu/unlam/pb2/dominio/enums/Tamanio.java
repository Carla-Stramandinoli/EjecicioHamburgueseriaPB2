package ar.edu.unlam.pb2.dominio.enums;

public enum Tamanio {

	CHICA("chica"),
	GRANDE("grande");
	
	private String tamanio;
	
	Tamanio(String tamanio){
		this.tamanio = tamanio;
	}
	
	public String getTamanio() {
		return this.tamanio;
	}
}
