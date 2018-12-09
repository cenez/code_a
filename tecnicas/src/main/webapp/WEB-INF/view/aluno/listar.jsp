<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
	<meta charset="UTF-8">
	<title>Listagem de aluno</title>
	<script type="text/javascript">
		window.onload = function listar(){
			var titulo = document.getElementById("aluno_nome").innerHTML;
			document.getElementById("diploma_titulo").innerHTML = titulo;
		};
	</script>
</head>
<body>
  <div>
    <div>${sucesso}</div>
	<div style="float: left;">
		<table>
			<tr>
				<td bgcolor="orange">Nome</td>
				<td bgcolor="orange">Endereco</td>
				<td bgcolor="orange">Aluno</td>
				<td bgcolor="orange" colspan="2">Diploma</td>
			</tr>
			<c:forEach items="${alunos }" var="aluno" varStatus="status">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.endereco }</td>
					<td>
						<form action="/tecnicas/aluno/remove" method="get">
							<input type="hidden" name="id" value=${aluno.id }>
							<button type="submit">DEL</button>
						</form>
					</td>					
					<td><input type="submit" value="ADD" onclick="location. href= '/tecnicas/aluno/${aluno.id}'"></td>
					<td><input type="submit" value="VER" onclick="location. href= '/tecnicas/aluno/form/${aluno.id}'"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="float: left;">
		<table>
			<tr>
				<td id="diploma_titulo" colspan="1" bgcolor="orange"></td>
			<c:forEach items="${diplomas }" var="diploma">
				<tr>
					<td>${diploma.registro}</td>
					<td id="aluno_nome" style="display:none;"><b>${diploma.aluno.nome }</b></td>
				</tr>
			</c:forEach>
		</table>
	</div>
  </div>
</body>
</html>