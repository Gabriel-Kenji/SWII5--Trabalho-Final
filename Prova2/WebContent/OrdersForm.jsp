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

		<h1 class="text-center text-white mt-5 mb-5">ORDERS</h1>
			<h2 class="text-center">
				<a class="btn btn-primary btn-lg" href="listOrders"><- Voltar</a> &nbsp;&nbsp;&nbsp; 
				<a class="btn btn-secondary btn-lg" href="newOrders">Adicionar nova Order</a> &nbsp;&nbsp;&nbsp;
				<a class="btn btn-secondary btn-lg" href="listOrders">Listar todas as Orders</a> &nbsp;&nbsp;&nbsp;
			</h2>
		<c:if test="${customer != null}">
			<h3 class="text-center mt-5 mb-5">Editar livro</h3>
		</c:if>
		<c:if test="${customer == null}">
			<h3 class="text-center mt-5 mb-5">Adicionar novo livro</h3>
		</c:if>
		<c:if test="${customer != null}">
			<form action="updateOrders" method="post">
		</c:if>
		<c:if test="${customer == null}">
			<form action="insertOrders" method="post">
		</c:if>
		<c:if test="${customer != null}">
			<input type="hidden" name="id" value="<c:out value='${customer.ord_no}' />" />
		</c:if>
		<div class="form-group">
			<label for="email">PURCH_AMT:</label> <input class="form-control mt-1 mb-3"
				type="text" name="name" size="45" placeholder="PURCH_AMT"
				value="<c:out value='${customer.purch_amt}' />" />

		</div>
		<div class="form-group">
			<label for="pwd">ORD_DATE:</label> 
			<input class="form-control mt-1 mb-3" type="text"  id="city" name="city" size="45"
					placeholder="yyyy/mm/dd" value="<c:out value='${customer.ord_date}' />" />
		</div>
		
		
		<div class="form-group">
			<label for="pwd">SALESMAN:</label> 
			<select class="form-select mt-1 mb-3" name="salesman" aria-label="Default select example">
			  <option selected>Selecione um Salesman</option>
			  <c:forEach var="salesman" items="${listSalesman}">
			  		<c:choose>
					    <c:when test="${salesman.salesman_id == customer.salesman_id}">
					        <option value="${salesman.salesman_id}" selected="selected">${salesman.name}</option> 
					    </c:when>    
					    <c:otherwise>
					       <option value="${salesman.salesman_id}">${salesman.name}</option> 
					    </c:otherwise>
					</c:choose>
				  
			  </c:forEach>	  
		</select>
		</div>
	
		
		<div class="form-group">
			<label for="pwd">CUSTOMER:</label> 
			<select class="form-select mt-1 mb-3" name="customer" aria-label="Default select example">
			  <option selected>Selecione um Customer</option>
			  <c:forEach var="customers" items="${listCustomer}">
			  	<c:choose>
					    <c:when test="${customer.customer_id == customers.customer_id}">
					        <option value="${customer.customer_id}" selected="selected">${customers.name}</option>
					    </c:when>    
					    <c:otherwise>
					       <option value="${customers.customer_id}">${customers.name}</option>
					    </c:otherwise>
				</c:choose>
			  </c:forEach>	  
		</select>
		</div>
		
		
		<button type="submit" class="btn btn-success btn-lg btn-block mt-3" style=" width: 100%  ">Salvar</button>
		</form>
	</div>
	
	
	
			
	</div>
	<script type='text/javascript' src='https://code.jquery.com/jquery-1.11.0.js'></script>
  	<script type='text/javascript' src="https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		    $(":input").inputmask();
		    
		    
		    
		    $("#city").inputmask({
		  mask: '9999/99/99',
		  placeholder: 'yyyy/mm/dd',
		  showMaskOnHover: false,
		  showMaskOnFocus: false,
		  onBeforePaste: function (pastedValue, opts) {
		    var processedValue = pastedValue;
	
		    //do something with it
	
		    return processedValue;
		  }
		});
		});
	</script>
</body>
</html>