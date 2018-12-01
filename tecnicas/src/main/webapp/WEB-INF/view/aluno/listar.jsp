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
	<div>
		<div>${sucesso}</div>
		<table>
			<tr>
				<td bgcolor="orange">Nome</td>
				<td bgcolor="orange">Endereco</td>
				<td bgcolor="orange" colspan="2">Diploma</td>
			</tr>
			<c:forEach items="${alunos }" var="aluno">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.endereco }</td>
					<td>[<a href="/tecnicas/aluno/${aluno.id}">Add</a>]</td>
					<td>[<a href="/tecnicas/aluno/form/${aluno.id}">Listar</a>]</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div>
		<table>
			<tr>
				<td colspan="2" bgcolor="orange">Registros Diploma</td>
			</tr>
			<c:forEach items="${diplomas }" var="diploma">
				<tr>
					<td>${diploma.registro}</td>
					<td>${diploma.aluno.nome }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>