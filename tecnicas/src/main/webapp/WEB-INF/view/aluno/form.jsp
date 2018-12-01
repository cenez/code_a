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
	<link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" >
</head>
<body>
	<a href="/tecnicas">HOME</a> <hr>
	<h1>Alunos</h1>
	<!-- <form action="/tecnicas/aluno" method="post"> -->
	<div>
		<form:form action="${s:mvcUrl('AC#gravar').build() }" method="post" commandName="aluno">
			<div>
				<label>Nome</label> <br>
				<form:input path="nome" />
				<form:errors path="nome"/>
			</div>
			<div>
				<label>Endereco</label> <br>
				<form:textarea  path="endereco" rows="3" cols="40" />
				<form:errors path="endereco"/>
			</div>
			<div>
				<c:forEach items="${tipos }" var="tipo" varStatus="status">
					<label> ${tipo}</label><br>
					<form:input path="documentos[${status.index}].numero" /><br>
					<form:hidden path="documentos[${status.index}].tipo" value="${tipo}"/>
				</c:forEach>
				<form:errors path="documentos"/>
			</div><br>
			<div>
				<form:button>CADASTRAR</form:button>
			</div>
		</form:form>
	</div>
	<hr>
	<div>
		<jsp:include page="listar.jsp" />
	</div>
</body>
</html>