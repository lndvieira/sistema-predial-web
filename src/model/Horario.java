package model;

public class Horario {
	private String entrada;
	private String saida;
	
	public Horario() {}
	
	public Horario(String entrada, String saida) {
		setEntrada(entrada);
		setSaida(saida);
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return getEntrada() + "-" + getSaida();
	}
}
