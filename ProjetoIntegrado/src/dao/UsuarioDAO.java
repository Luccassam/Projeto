package dao;

import classe.Usuario;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
   static {
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

   public Connection obtemConexao() throws SQLException {
      return DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=alunos&password=alunos");
   }

   ConnectionFactory conexao = new ConnectionFactory();
   
   public void incluir(Usuario to) {
	   String sqlInsert = "INSERT INTO usuario(nome, email, senha) VALUES ( ?, ?, ?)";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = conexao.obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	stm.setString(1, to.getNome());
	stm.setString(2, to.getEmail());
	stm.setString(3, to.getSenha());
	stm.execute();
	} catch (SQLException e) {
     e.printStackTrace();
   }
}
//      String sqlInsert = "INSERT INTO usuario(id, nome, email,senha) VALUES (?, ?, ?,?)";
//  
//      try (Connection conn = obtemConexao();
//      PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//         stm.setInt(1, to.getId());
//         stm.setString(2, to.getNome());
//         stm.setString(3, to.getEmail());
//         stm.setString(4, to.getSenha());
//         stm.execute();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
   public void atualizar(Usuario to) {
      String sqlUpdate = "UPDATE usuario SET nome=?,email=?,senha=? WHERE id=? ";

      try (Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
         stm.setString(1, to.getNome());
         stm.setString(2, to.getEmail());
         stm.setString(3, to.getSenha());
         stm.setInt(4, to.getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void excluir(Usuario to) {
      String sqlDelete = "DELETE FROM usuario WHERE id = ?";
  
      try (Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
         stm.setInt(1, to.getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
    public Usuario buscar(Usuario to){
      String sqlSelect = "Select * from usuario where id = ?";
      
   	
      try(Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
         stm.setInt(1, to.getId());
      	
         try (ResultSet rs = stm.executeQuery();) {
            if (rs.next()) {
               to.setNome(rs.getString("nome"));
               to.setEmail(rs.getString("email"));
               to.setSenha(rs.getString("senha"));
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } catch (SQLException e1) {
         System.out.print(e1.getStackTrace());
      }
      return to;
   }

}