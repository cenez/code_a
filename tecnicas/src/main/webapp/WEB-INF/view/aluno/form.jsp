<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de aluno</title>
</head>
<body>
	<form action="/tecnicas/aluno" method="post">
		<div>
			<label>Nome</label>
			<input type="text" name="nome">
		</div>
		<div>
			<label>Endereco</label>
			<textarea rows="3" cols="40" name="endereco"></textarea>
		</div>
		<c:forEach items="${tipos }" var="tipoDoc" varStatus="status">
			<div>
				<label>"${tipoDoc}"</label>
				<input type="text" name="documentos[${status.index}].numero">
				<input type="hidden" name="documentos[${status.index}].tipo" value="${tipoDoc}">
			</div>
		</c:forEach>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>