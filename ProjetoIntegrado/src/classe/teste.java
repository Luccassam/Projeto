package classe;

import dao.AlunoDAO;

public class teste {

	public static void main(String[] args) {
		
		Aluno al = new Aluno(0, null, null, null, 0, null);
		AlunoDAO dao  = new AlunoDAO(); 
		
		al.setNome("Lucas");
		al.setEmail("teste");
		al.setSenha("asdasds");
		al.setIdA(2);
		al.setRa("qwewqewq");
		
		dao.incluir(al);

	}

}
