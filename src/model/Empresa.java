package model;

public class Empresa {
	private String razaoSocial;
	private String cnpj;
	private String temperatura;
	private int conjunto;
	private Horario horaFuncionamento, horaArCondicionado;
	
	public Empresa() {}
	
	public Empresa(String razaoSocial, String cnpj, String temperatura, int conjunto, Horario horaFuncionamento, Horario horaArCondicionado) {
		setRazaoSocial(razaoSocial);
		setCnpj(cnpj);
		setTemperatura(temperatura);
		setConjunto(conjunto);
		setHoraFuncionamento(horaFuncionamento);
		setHoraArCondicionado(horaArCondicionado);
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getConjunto() {
		return conjunto;
	}

	public void setConjunto(int conjunto) {
		this.conjunto = conjunto;
	}

	public Horario getHoraFuncionamento() {
		return horaFuncionamento;
	}

	public void setHoraFuncionamento(Horario horaFuncionamento) {
		this.horaFuncionamento = horaFuncionamento;
	}

	public Horario getHoraArCondicionado() {
		return horaArCondicionado;
	}

	public void setHoraArCondicionado(Horario horaArCondicionado) {
		this.horaArCondicionado = horaArCondicionado;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
}
