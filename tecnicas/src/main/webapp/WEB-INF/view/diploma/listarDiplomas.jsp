<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="UTF-8">
<title>Listagem de diploma</title>
</head>
<body>
	<h1>Lista de Diplomas</h1>
	<div>${sucesso}</div>
	<table>
		<tr>
			<td bgcolor="orange">Registro</td>
			<td bgcolor="orange">Aluno</td>
		</tr>
		<c:forEach items="${diplomas }" var="diploma">
			<tr>
				<td>${diploma.registro}</td>
				<td>${diploma.aluno.nome }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/tecnicas">HOME</a>
</body>
</html>