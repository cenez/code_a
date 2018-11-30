<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de aluno</title>
</head>
<body>
	<a href="/tecnicas">HOME</a> <hr>
	<!-- <form action="/tecnicas/aluno" method="post"> --> 
	<form:form action="${s:mvcUrl('AC#gravar').build() }" method="post" commandName="aluno">
		<div style="width: 36%;">
			<label>Nome</label> <br>
			<form:input path="nome" />
			<form:errors path="nome"/>
		</div><br>
		<div style="width: 36%;">
			<div style="width: 65%; float:left; ">
				<label>Endereco</label> <br>
				<form:textarea  path="endereco" rows="3" cols="40" />
				<form:errors path="endereco"/>
			</div>
			<div style="width: 33%; float:right; ">
				<c:forEach items="${tipos }" var="tipoDoc" varStatus="status">
					<label> ${tipoDoc}</label><br>
					<form:input path="documentos[${status.index}].numero" /><br>
					<form:hidden path="documentos[${status.index}].tipo" value="${tipoDoc}"/>
				</c:forEach>
				<form:errors path="documentos"/>
			</div>
		</div><br><br><br><br><br><br>
		<button type="submit">Cadastrar</button>
	</form:form>
	<hr>
	<jsp:include page="listar.jsp" />
</body>
</html>