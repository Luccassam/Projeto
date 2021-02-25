package service;

import dao.AlunoDAO;
import classe.Aluno;

public class AlunoService {
	   AlunoDAO dao = new AlunoDAO();
	   Aluno to = new Aluno(0, null, null, null, 0, null);

	   public AlunoService() {
	      dao = new AlunoDAO();
	   }

	   public void criar(Aluno to) {
	      dao.incluir(to);
	   }
	   
	   public void criarUsuario(Aluno to) {
		      dao.incluirUsuario(to);
		   }
	   public void atualizar(Aluno to) {
	      dao.atualizar(to);
	   }
	   public void excluir(Aluno to) {
	      dao.excluir(to);
	   }
	   
	   public Aluno carregar(int id){
			return dao.carregar(id);
		}

	}