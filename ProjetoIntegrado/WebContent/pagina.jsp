<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@page import="classe.Usuario"%>
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>Aluno</title>
</head>
<body>
<%Usuario usuario = (Usuario)request.getAttribute("usuario"); %>
Id: <%=usuario.getId() %><br>
Nome: <%=usuario.getNome() %><br>
E-mail: <%=usuario.getEmail() %><br>
Senha: <%=usuario.getSenha() %><br>
</body>
</html>