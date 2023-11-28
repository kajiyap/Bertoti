package Models;

public class Roupas {
	private String codigoID;
	private String tipo;
	private String marca;
	private String tamanho;
	
	
	public Roupas(String codigoID, String tipo, String marca, String tamanho) {
		this.codigoID = codigoID;
		this.tipo = tipo;
		this.marca = marca;
		this.tamanho = tamanho;
	}
	public String getCodigoID() {
		return codigoID;
	}
	public void setCodigoID(String codigoID) {
		this.codigoID = codigoID;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	
}
