<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="Header.jsp" %>

<c:forEach items="${productList}" var="product">
	
	<div class="col-sm-4 col-md-3">
		
		<a href="<c:url value="/fullProductDisplay/${product.productId}" />">
			<img src="<c:url value="/resources/${product.productId}.jpg" />" height="300" width="350" />
		</a>
		
		<p align="center">Name: ${product.productName }</p>
		<p align="center">Price: ${product.productPrice }</p>
		<p align="center">Stock: ${product.productStock }</p>
	
	</div>
	
</c:forEach>