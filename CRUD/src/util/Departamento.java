package util;

public class Departamento {
	
	private String nomeDepartamento;
	private int id;
	
	public Departamento(int id, String nomeDepartamento) {
		super();
		this.nomeDepartamento = nomeDepartamento;
		this.id = id;
	}

	public Departamento() {
		super();
	}
	
	

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
