package connection;

import service.AlunoService;
import classe.Aluno;
import dao.AlunoDAO;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterAluno.do")
public class ManterAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pAluno_id = Integer.parseInt(request.getParameter("aluno"));
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pRa = request.getParameter("ra");
		
		//instanciar o javabean
		Aluno aluno = new Aluno(pAluno_id, pNome, pEmail, pSenha, pAluno_id, pRa);
		aluno.setId(pAluno_id);
		aluno.setNome(pNome);
		aluno.setEmail(pEmail);
		aluno.setSenha(pSenha);
		aluno.setIdA(pAluno_id);
		aluno.setRa(pRa);

		
		/*AlunoDAO dao = new AlunoDAO();
		dao.incluir(aluno);*/
		
		
		//instanciar o service
		
		AlunoService cs = new AlunoService();
		cs.criarUsuario(aluno);
		cs.criar(aluno);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Aluno Cadastrado</title></head><body>");
		out.println(	"id: "+aluno.getIdA()+"<br>");
		out.println(	"RA: "+aluno.getRa()+"<br>");
		out.println(	"Email: "+aluno.getEmail()+"<br>");
		out.println(	"Senha: "+aluno.getSenha()+"<br>");
		out.println(	"Nome: "+aluno.getNome()+"<br>");

	    out.println("</body></html>");
		
	}

}
