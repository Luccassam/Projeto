package dao;

import connection.ConnectionFactory;
import classe.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AlunoDAO {
   ConnectionFactory conexao = new ConnectionFactory();
   
   public void incluir(Aluno to) {
	   String sqlInsert = "INSERT INTO aluno(aluno_id, ra) VALUES (?, ?)";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = conexao.obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlInsert)){ 
	stm.setInt(1, to.getIdA());
	stm.setString(2, to.getRa());
	stm.execute();
	} catch (SQLException e) {
	     e.printStackTrace();
	   }
	}
   
   
   public void incluirUsuario(Aluno to) {
	   String sqlInsert = "INSERT INTO usuario(nome, email,senha) VALUES (?, ?,?)";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = conexao.obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlInsert)){ 
	stm.setString(1, to.getNome());
	stm.setString(2, to.getEmail());
	stm.setString(3, to.getSenha());
	stm.execute();
	} catch (SQLException e) {
	     e.printStackTrace();
	   }
	}
//      String sqlInsert = "INSERT INTO aluno(aluno_id, ra) VALUES (?, ?)";
//   
//      try (Connection conn = conexao.obtemConexao();
//      PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//         stm.setInt(1, to.getIdA());
//         stm.setString(2, to.getRa());
//         stm.execute();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
   
   
   
   public void atualizar(Aluno to) {
      String sqlUpdate = "UPDATE aluno SET ra=? WHERE aluno_id=? ";
   
      try (Connection conn = conexao.obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
         stm.setString(1, to.getRa());
         stm.setInt(2, to.getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void excluir(Aluno to) {
      String sqlDelete = "DELETE FROM aluno WHERE aluno_id = ?";
   
      try (Connection conn = conexao.obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
         stm.setInt(1, to.getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   

   
   
	public Aluno carregar(int id) {
		Aluno aluno = new Aluno(id, null, null, null, id, null);
		aluno.setId(id);
		String sqlSelect = "SELECT nome, fone, email FROM aluno WHERE aluno.aluno_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, aluno.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aluno.setNome(rs.getString("nome"));
					aluno.setSenha(rs.getString("senha"));
					aluno.setEmail(rs.getString("email"));
					aluno.setIdA(rs.getInt("aluno_id"));
					aluno.setRa(rs.getString("ra"));
				} else {
					aluno.setId(-1);
					aluno.setIdA(-1);
					aluno.setNome(null);
					aluno.setSenha(null);
					aluno.setEmail(null);
					aluno.setRa(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return aluno;
	}

}