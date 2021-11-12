package conexao;

import com.mysql.cj.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import util.Funcionario;

public class ServicoBancoFuncionario {

private final Conexao conexao = new Conexao();
	
	public void insert(Funcionario funcionario) throws SQLException{
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"insert into cadastro(idFuncionario, nome, cpf, rg, dataNascimento)" + 
		"values (0,?,?,?,?)")){
			
			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getCpf());
			pst.setString(3, funcionario.getRg());
			pst.setDate(4, new java.sql.Date(funcionario.getDataNascimento().getTime()));
			
			pst.executeUpdate();
		}
		conexao.close();
		
		this.setIdBancoFuncionario(funcionario);
	}
	
	public void update(Funcionario funcionario)throws SQLException {
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"update funcionario set idFuncionario = ?, nome = ?, cpf = ?, rg = ?, dataNascimento = ? where (id = ?)")){
			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getCpf());
			pst.setString(3, funcionario.getRg());
			pst.setDate(4, new java.sql.Date(funcionario.getDataNascimento().getTime()));
			
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void delete (Funcionario funcionario) throws SQLException{
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"delete from cadastro where (idFuncionario = ?)")){
			pst.setInt(1, funcionario.getId());
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void setIdBancoFuncionario(Funcionario funcionario)throws SQLException{
		Statement st = conexao.getConexao().createStatement();
		
		ResultSet rs = st.executeQuery("select las_insert_id() idFuncionario");
		
		while(rs.next()) {
			funcionario.setId(rs.getInt("idFuncionario"));
		}
		conexao.close();
	}
	
	public Funcionario getCadastroById(int id)throws SQLException{
		try(Statement st = conexao.getConexao().createStatement();
				ResultSet rs = st.executeQuery("select * from cadastro where (idFuncionario = " + id + ")")){
			rs.first();
			return new Funcionario(rs.getInt("idFuncionario"), 
					            rs.getString("nome"),
			                    rs.getString("cpf"),
			                    rs.getString("rg"),
                                rs.getDate("dataNascimento")); 
                                
					            
		}
	}
        
        
        public ArrayList getFuncionariobyQuery()throws SQLException{
            ArrayList dados = new ArrayList();
            
            Util util = new Util();
            
            try(Statement st = conexao.getConexao().createStatement();
                    ResultSet rs = st.executeQuery("select * funcionario")){
            
            }
            
            
            return dados;
        
        }
	
	
}
