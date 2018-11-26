<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="UTF-8">
<title>Editar diploma</title>
</head>
<body>
	<form action="/tecnicas/diploma" method="post">
		<div>
			<label>Registro</label>
			<input type="text" name="registro">
		</div>
		<div> <label>${aluno.id }</label>       </div>
		<div> <label>${aluno.nome }</label>     </div>
		<div> <label>${aluno.endereco }</label> </div>
		<div> <input type="hidden" name="aluno.id" value=${aluno.id }> </div>
		<div> <input type="hidden" name="aluno.nome" value=${aluno.nome }> </div>
		<div> <input type="hidden" name="aluno.endereco" value=${aluno.endereco }> </div>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>