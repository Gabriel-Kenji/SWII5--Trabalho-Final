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

		<h1 class="text-center mt-5 mb-5">CUSTOMERS</h1>
		<h2 class="text-center">
			<a class="btn btn-primary btn-lg" href="listCustomer"><- Voltar</a> &nbsp;&nbsp;&nbsp; 
			<a class="btn btn-secondary btn-lg" href="newCustomer">Adicionar novo Customer</a>&nbsp;&nbsp;&nbsp; 
			<a class="btn btn-secondary btn-lg" href="listCustomer">Listar todos os Customers</a> &nbsp;&nbsp;&nbsp; 

		</h2>
		<c:if test="${customer != null}">
			<h3 class="text-center mt-5 mb-5">Editar Customer</h3>
		</c:if>
		<c:if test="${customer == null}">
			<h3 class="text-center mt-5 mb-5">Adicionar novo Customer</h3>
		</c:if>
		<c:if test="${customer != null}">
			<form action="updateCustomer" method="post" class="mt-5 mb-5">
		</c:if>
		<c:if test="${customer == null}">
			<form action="insertCustomer" method="post">
		</c:if>
		<c:if test="${customer != null}">
			<input type="hidden" name="id" value="<c:out value='${customer.customer_id}' />" />
		</c:if>
		<div class="form-group">
			<label for="email">NAME:</label> <input class="form-control mt-1 mb-3"
				type="text" name="name" size="45" placeholder="NAME"
				value="<c:out value='${customer.name}' />" />

		</div>
		<div class="form-group">
			<label for="pwd">CITY:</label> 
			<input class="form-control mt-1 mb-3" type="text" name="city" size="45"
					placeholder="CITY" value="<c:out value='${customer.city}' />" />
		</div>
		
		<div class="form-group">
			<label for="pwd">GRADE:</label> 
			<input class="form-control mt-1 mb-3" type="text" name="grade" size="5"
				placeholder="GRADE"	value="<c:out value='${customer.grade}' />" />
		</div>
		
		
		
				
		<button type="submit" class="btn btn-success btn-lg btn-block mt-3" style=" width: 100%  ">Salvar</button>
		</form>
	</div>
	
	
	
			
	</div>
</body>
</html>