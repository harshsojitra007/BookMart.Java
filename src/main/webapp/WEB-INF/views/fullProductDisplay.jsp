<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="Header.jsp" %>

<form action="<c:url value="/addToCart/${product.productId }" />" >
	
	<table border="1">
		
		<tr>
			<td colspan="8">
				<img src="<c:url value="/resources/${product.productId }.jpg" />" height="300" />
			</td>
		</tr>
		
		<tr>
		
			<td>Name</td>
			<td><c:out value="${product.productName }" /></td>
		
		</tr>
		
		<tr>
		
			<td>Price</td>
			<td><c:out value="${product.productPrice }" /></td>
		
		</tr>
		
		<tr>
		
			<td>Stock</td>
			<td><c:out value="${product.productStock }" /></td>
		
		</tr>
		
		<tr>
			<td>Quantity</td>
			<td>
				
				<select name="quantity">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				
			</td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Buy" class="btn btn-success" /></td>
		</tr>
		
	</table>
	
</form>