package Conexao;

import Classes.Funcionario;
import com.mysql.cj.util.Util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class ServicoBancoFuncionario {

private final Conexao conexao = new Conexao();
	
	public void insert(Funcionario funcionario) throws SQLException{
		 
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"insert into funcionario (idFuncionario,departamento_idDepartamento1, nome, cpf, rg, dataNascimento)" + 
		"values (0,?,?,?,?,?)")){
			
                        pst.setInt(1, funcionario.getIdDepartamento());
			pst.setString(2, funcionario.getNome());
			pst.setString(3, funcionario.getCpf());
			pst.setString(4, funcionario.getRg());
			pst.setDate(5, new java.sql.Date(funcionario.getDataNascimento().getTime()));
			
			pst.executeUpdate();
		}
		conexao.close();
		
		this.setIdBancoFuncionario(funcionario);
	}
	
	public void update(Funcionario funcionario)throws SQLException {
		 
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"update funcionario set departamento_idDepartamento1 = ?, nome = ?, cpf = ?, rg = ?, dataNascimento = ? where (idFuncionario = ?)")){
			pst.setInt(1, funcionario.getIdDepartamento());
			pst.setString(2, funcionario.getNome());
			pst.setString(3, funcionario.getCpf());
			pst.setString(4, funcionario.getRg());
			pst.setDate(5, new java.sql.Date(funcionario.getDataNascimento().getTime()));
                        pst.setInt(6, funcionario.getId());
			
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void delete (Funcionario funcionario) throws SQLException{
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"delete from funcionario where (idFuncionario = ?)")){
			pst.setInt(1, funcionario.getIdDepartamento());
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
                                                    rs.getInt("departamento_idDepartamento1"),
					            rs.getString("nome"),
			                            rs.getString("cpf"),
			                            rs.getString("rg"),
                                                    rs.getDate("dataNascimento")); 
                                
					            
		}
	}
        
        
        public ArrayList getFuncionariobyQuery()throws SQLException{
            ArrayList dados = new ArrayList();
            try(Statement st = conexao.getConexao().createStatement();
                    ResultSet rs = st.executeQuery("select * from funcionario order by nome")){
                
                while (rs.next()){
          dados.add(new String [] { rs.getString(1),  
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6) 
                                   }); 
        }
            
            }
            
            
            return dados;
        
        }
        
        
        public ArrayList getBuscarFuncionario(String a)throws SQLException{
                   ArrayList dados = new ArrayList();
        
            try(Statement st = conexao.getConexao().createStatement();
                     ResultSet rs = st.executeQuery("select * from funcionario  where nome =  \'"  + a + "\'"   )){
                
                while (rs.next()){
          dados.add(new String [] { rs.getString(1),  
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6) 
                                   }); 
        }
            
            }
            
            
            return dados;
        }
        
        
         public ArrayList<Funcionario> getFuncionarioByLista()throws SQLException{
      ArrayList<Funcionario> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from funcionario order by nome ")) {
         
        while (rs.next()){
          lista.add(new Funcionario(rs.getInt("idFuncionario"),
                                    rs.getInt("departamento_idDepartamento1"),
                                    rs.getString("nome"), 
                                    rs.getString("cpf"),
                                    rs.getString("rg"),
                                    rs.getDate("dataNascimento")));
        }
    }
    
     return lista;
 }
	
	
}
