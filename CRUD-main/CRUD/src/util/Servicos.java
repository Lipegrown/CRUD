package util;

public class Servicos {
	
	private String nomeServico;
	private int horas, id;
	private double preco;
	
	public Servicos(int id, String nomeServico, int horas, double preco) {
		super();
		this.nomeServico = nomeServico;
		this.horas = horas;
		this.id = id;
		this.preco = preco;
	}

	public Servicos() {
		super();
	}
	

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	
	
	

}
