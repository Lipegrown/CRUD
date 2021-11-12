package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import util.Servicos;

public class ServicoBancoServico {
	
	
private final Conexao conexao = new Conexao();
	
	public void insert(Servicos servicos) throws SQLException{
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"insert into cadastro(idServico, nomeServico, horasDeServico, preco)" + 
		"values (0,?,?,?)")){
			
			pst.setString(1, servicos.getNomeServico());
			pst.setInt(2, servicos.getHoras());
			pst.setDouble(3, servicos.getPreco());
			
			
			pst.executeUpdate();
		}
		conexao.close();
		
		this.setIdBancoServicos(servicos);
	}
	
	public void update(Servicos servicos)throws SQLException {
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"update funcionario set idServico = ?, nomeServico = ?, horasDeServico = ?, preco = ? where (id = ?)")){
			pst.setString(1, servicos.getNomeServico());
			pst.setInt(2, servicos.getHoras());
			pst.setDouble(3, servicos.getPreco());
			
			
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void delete (Servicos servicos) throws SQLException{
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"delete from cadastro where (idServico = ?)")){
			pst.setInt(1, servicos.getId());
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void setIdBancoServicos(Servicos servicos)throws SQLException{
		Statement st = conexao.getConexao().createStatement();
		
		ResultSet rs = st.executeQuery("select las_insert_id() idServico");
		
		while(rs.next()) {
			servicos.setId(rs.getInt("idServico"));
		}
		conexao.close();
	}
	
	public Servicos getCadastroById(int id)throws SQLException{
		try(Statement st = conexao.getConexao().createStatement();
				ResultSet rs = st.executeQuery("select * from cadastro where (id_cadastro = " + id + ")")){
			rs.first();
			return new Servicos(rs.getInt("idServico"), 
					           rs.getString("nomeServico"),
					           rs.getInt("horaDeServico"),
                               rs.getDouble("preco")); 
                                
					            
		}
	}

}
