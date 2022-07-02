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
<body class="bg-dark">
	
	<div class="container">
		
		
			<h1 class="text-center text-white mt-5 mb-5">ORDERS</h1>
			<h2 class="text-center">
				<a class="btn btn-primary btn-lg" href="home"><- Voltar</a> &nbsp;&nbsp;&nbsp; 
				<a class="btn btn-secondary btn-lg" href="newOrders">Adicionar nova Order</a> &nbsp;&nbsp;&nbsp;
			</h2>
		
	
		<h2>Lista de livros</h2>  
		<table class="table table-dark table-hover table-bordered">
			<thead>
				<tr>
					<th>ORD_NO</th>
					<th>PURCH_AMT</th>
					<th>ORD_DATE</th>
					<th>SALESMAN_ID</th>
					<th>CUSTOMER_ID</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="orders" items="${listOrders}">
					<tr>
						<td><c:out value="${orders.ord_no}" /></td>
						<td><c:out value="${orders.purch_amt}" /></td>
						<td><c:out value="${orders.ord_date}" /></td>
						<td><c:out value="${orders.salesman_id}" /></td>
						<td><c:out value="${orders.customer_id}" /></td>
						<td><a class="btn btn-warning btn-sm" href="editOrders?id=<c:out value='${orders.ord_no}' />">Editar</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a class="btn btn-danger btn-sm" href="deleteOrders?id=<c:out value='${orders.ord_no}' />">Deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>
