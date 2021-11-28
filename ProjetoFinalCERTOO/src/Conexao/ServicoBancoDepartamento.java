package Conexao;

import Classes.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

;


public class ServicoBancoDepartamento {
	
private final Conexao conexao = new Conexao();
	
	public void insert(Departamento departamento) throws SQLException{
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement(
				"insert into departamento(idDepartamento, nomeDepartamento)" + 
		"values (0,?)")){
			
			pst.setString(1, departamento.getNomeDepartamento());
			
			
			pst.executeUpdate();
		}
		conexao.close();
		
		this.setIdBancoDepartamento(departamento);
	}
	
	public void update(Departamento departamento)throws SQLException {
		Connection con = conexao.getConexao();
		try(PreparedStatement pst = con.prepareStatement("update departamento set idDepartamento = ?, nomeDepartamento = ? where (nomeDepartamento = ?)")){
			pst.setString(1, departamento.getNomeDepartamento());
			
			
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void delete (Departamento departamento) throws SQLException{
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"delete from departamento where (idDepartamento = ?)")){
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
				ResultSet rs = st.executeQuery("select * from departamento where (idDepartamento = " + id + ")")){
			rs.first();
			return new Departamento(rs.getInt("idDepartamento"), 
					        rs.getString("nomeDepartamento"));
                                                 
                                
					            
		}
	}
        
        
        public ArrayList<Departamento> getDepartamentoByLista()throws SQLException{
      ArrayList<Departamento> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from departamento order by nomeDepartamento ")) {
         
        while (rs.next()){
          lista.add(new Departamento(rs.getInt("idDepartamento"), 
                                     rs.getString("nomeDepartamento"))); 
                             
        }
    }
    
     return lista;
     
     
     
 }
   
        
         public int getCadastroByName(String name)throws SQLException{
		try(Statement st = conexao.getConexao().createStatement();
				ResultSet rs = st.executeQuery("select * from departamento where nomeDepartamento = \'" + name + "\'")){
			rs.first();
			return rs.getInt("idDepartamento");
                                
					           
                                
					            
		}
	}
         
         public ArrayList getDepartamentobyQuery()throws SQLException{
            ArrayList dados = new ArrayList();
            try(Statement st = conexao.getConexao().createStatement();
                    ResultSet rs = st.executeQuery("select * from departamento order by nomeDepartamento")){
                
                while (rs.next()){
          dados.add(new String [] { rs.getString(1),  
                                    rs.getString(2), 
                                   }); 
        }
            
            }
            
            
            return dados;
         }
         
          public ArrayList getBuscarDepartamento(String a)throws SQLException{
                   ArrayList dados = new ArrayList();
        
            try(Statement st = conexao.getConexao().createStatement();
                     ResultSet rs = st.executeQuery("select * from departamento  where nomeDepartamento =  \'"  + a + "\'"   )){
                
                while (rs.next()){
          dados.add(new String [] { rs.getString(1),  
                                    rs.getString(2) 
                                    
                                   }); 
        }
            
            }
            
            
            return dados;
        }
         
}
        

