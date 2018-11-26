<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="UTF-8">
<title>Listagem de aluno</title>
</head>
<body>
	<h1>Lista de Alunos</h1>
	<div>${sucesso}</div>
	<table>
		<tr>
			<td bgcolor="orange">Nome</td>
			<td bgcolor="orange">Endereco</td>
			<td bgcolor="orange">Manter</td>
		</tr>
		<c:forEach items="${alunos }" var="aluno">
			<tr>
				<td>${aluno.nome}</td>
				<td>${aluno.endereco }</td>
				<td><a href="aluno/${aluno.id}">Diplomas</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/tecnicas">HOME</a>
</body>
</html>