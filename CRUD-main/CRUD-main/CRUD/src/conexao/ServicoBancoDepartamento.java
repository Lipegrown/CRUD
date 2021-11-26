package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.Departamento;


public class ServicoBancoDepartamento {
	
private final Conexao conexao = new Conexao();
	
	public void insert(Departamento departamento) throws SQLException{
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"insert into cadastro(idDepartamento, nomeDepartamento)" + 
		"values (0,?,?,?,?)")){
			
			pst.setString(1, departamento.getNomeDepartamento());
			
			
			pst.executeUpdate();
		}
		conexao.close();
		
		this.setIdBancoDepartamento(departamento);
	}
	
	public void update(Departamento departamento)throws SQLException {
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"update funcionario set idDepartamento = ?, nomeDepartamento = ? where (id = ?)")){
			pst.setString(1, departamento.getNomeDepartamento());
			
			
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void delete (Departamento departamento) throws SQLException{
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"delete from cadastro where (idDepartamento = ?)")){
			pst.setInt(1, departamento.getId());
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void setIdBancoDepartamento(Departamento departamento)throws SQLException{
		Statement st = conexao.getConexao().createStatement();
		
		ResultSet rs = st.executeQuery("select las_insert_id() idDepartamento");
		
		while(rs.next()) {
			departamento.setId(rs.getInt("idDepartamento"));
		}
		conexao.close();
	}
	
	public Departamento getCadastroById(int id)throws SQLException{
		try(Statement st = conexao.getConexao().createStatement();
				ResultSet rs = st.executeQuery("select * from cadastro where (idDepartamento = " + id + ")")){
			rs.first();
			return new Departamento(rs.getInt("idDepartamento"), 
					                rs.getString("nomeDepartamento")); 
                                
					            
		}
	}
        
        
        public ArrayList<Departamento> getUsuarioByLista()throws SQLException{
      ArrayList<Departamento> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from tusuario order by nome ")) {
         
        while (rs.next()){
           lista.add(new Departamento(rs.getInt("codigo"), 
                             rs.getString("nome"), 
                             rs.getString("email"),
                             rs.getString("fone")));
        }
    }

}
