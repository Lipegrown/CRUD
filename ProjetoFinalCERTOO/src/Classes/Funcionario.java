package Classes;

import java.util.Date;

public class Funcionario {

	private String nome, cpf, rg;
	private Date dataNascimento;
	private int idDepartamento,id;

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public Funcionario(int id, int idDepartamento, String nome, String cpf, String rg, Date dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.idDepartamento = idDepartamento;
	}

    public Funcionario(int idDepartamento, String nome, String cpf, String rg, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return  nome ;
    }

	public Funcionario() {
		super();
	}

    public Funcionario(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int id) {
		this.idDepartamento = idDepartamento;
	}
	
	
	
	
	
}
