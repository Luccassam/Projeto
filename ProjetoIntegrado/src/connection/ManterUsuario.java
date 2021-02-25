package connection;

import service.UsuarioService;
import classe.Usuario;
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
@WebServlet("/ManterUsuario.do")
public class ManterUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		int pId = Integer.parseInt(request.getParameter("id"));
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		
		//instanciar o javabean
		Usuario usuario = Usuario();
		usuario.setId(pId);
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);
		
		//instanciar o service
		UsuarioService cs = new UsuarioService();
		cs.criar(usuario);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Usuario Cadastrado</title></head><body>");
		out.println(	"id: "+usuario.getId()+"<br>");
		out.println(	"nome: "+usuario.getNome()+"<br>");
		out.println(	"e-mail: "+usuario.getEmail()+"<br>");
		out.println(	"senha: "+usuario.getSenha()+"<br>");
	    out.println("</body></html>");
		
	}

	private Usuario Usuario() {
		// TODO Auto-generated method stub
		return null;
	}

}

