package service;

import dao.UsuarioDAO;
import classe.Usuario;

public class UsuarioService {
	   UsuarioDAO dao;

	   public UsuarioService() {
	      dao = new UsuarioDAO();
	   }

	   public void criar(Usuario to) {
	      dao.incluir(to);
	   }
	   public void atualizar(Usuario to) {
	      dao.atualizar(to);
	   }
	   public void excluir(Usuario to) {
	      dao.excluir(to);
	   }
	   
	   public Usuario buscar(Usuario to) {
	      dao.buscar(to);
	      return to;
	   }

	}