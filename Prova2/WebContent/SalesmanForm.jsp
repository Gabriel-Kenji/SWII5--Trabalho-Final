<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>PROVA 2</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body class="bg-dark text-white">
	<div class="container">

		<h1 class="text-center text-white mt-5 mb-5">SALESMAN</h1>
			<h2 class="text-center">
				<a class="btn btn-primary btn-lg" href="listCustomer"><- Voltar</a> &nbsp;&nbsp;&nbsp; 
				<a class="btn btn-secondary btn-lg" href="newSalesman">Adicionar novo Salesman</a> &nbsp;&nbsp;&nbsp;
				<a class="btn btn-secondary btn-lg" href="listCustomer">Listar todos os Salesmans</a> &nbsp;&nbsp;&nbsp;
			</h2>
		<c:if test="${salesman != null}">
			<h3 class="text-center mt-5 mb-5">Editar Salesman</h3>
		</c:if>
		<c:if test="${salesman == null}">
			<h3 class="text-center mt-5 mb-5">Adicionar novo Salesman</h3>
		</c:if>
		<c:if test="${salesman != null}">
			<form action="updateSalesman" method="post">
		</c:if>
		<c:if test="${salesman == null}">
			<form action="insertSalesman" method="post">
		</c:if>
		<c:if test="${salesman != null}">
			<input type="hidden" name="id" value="<c:out value='${salesman.salesman_id}' />" />
		</c:if>
		<div class="form-group">
			<label for="email">NAME:</label> <input class="form-control mt-1 mb-3"
				type="text" name="name" size="45" placeholder="NAME"
				value="<c:out value='${salesman.name}' />" />

		</div>
		<div class="form-group">
			<label for="pwd">CITY:</label> 
			<input class="form-control mt-1 mb-3" type="text" name="city" size="45"
					placeholder="CITY" value="<c:out value='${salesman.city}' />" />
		</div>
		
		<div class="form-group">
			<label for="pwd">COMMISSION:</label> 
			<input class="form-control mt-1 mb-3" type="text" name="commision" size="5"
				placeholder="COMMISSION"	value="<c:out value='${salesman.commission}' />" />
		</div>
		
		<button type="submit" class="btn btn-success btn-lg btn-block mt-3" style=" width: 100%  ">Salvar</button>
		</form>
	</div>
	
	
	
			
	</div>
</body>
</html>