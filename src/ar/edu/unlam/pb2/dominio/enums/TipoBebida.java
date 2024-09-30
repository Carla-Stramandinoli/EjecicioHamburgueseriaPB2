package ar.edu.unlam.pb2.dominio.enums;

public enum TipoBebida {

	AGUA("agua"),
	GASEOSA("gaseosa"),
	JUGO("jugo"),
	CERVEZA("cerveza");
	
	private String tipoBebida;
	
	TipoBebida(String tipoBebida){
		this.tipoBebida = tipoBebida;
	}
	
	public String getTipoBebida() {
		return this.tipoBebida;
	}
}
