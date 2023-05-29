<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="Header.jsp" %>

<table border="1">

	<tr>
		<td colspan="6"><center>Wish-list</center></td>
	</tr>

	<tr>
		
		<td>Product Id</td>
		<td>Product Name</td>
		<td>Quantity</td>
		<td>Price</td>
		<td>Sub-Total</td>
		<td>Operation</td>
		
	</tr>
	
	<c:forEach items="${cartItemList }" var="cartItem">
		
		<form action="<c:url value = "/updateCartItem/${cartItem.cartItemId }" />" >
		
			<tr>
				<td>${cartItem.productId }</td>
				<td>${cartItem.productName }</td>
				<td><input type="number" value="${cartItem.quantity }" name="quantity" /></td>
				<td>${cartItem.price }</td>
				<td>${cartItem.price} * ${cartItem.quantity }</td>
				
				<td>
					<input type="submit" value="Update" class="btn btn-success" />
					<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId }" />" class="btn btn-danger">Delete</a>
				</td>
			</tr>
			
		</form>
		
	</c:forEach>
	
	<tr>
		<td colspan="4">Total Purchase Amount</td>
		<td colspan="2">${grandTotal }</td>
	</tr>
	
	<tr>
		<td colspan="3">
			<center><a href="<c:url value="/" />" class="btn btn-success">Continue your shopping</a></center>
		</td>
		
		<td colspan="3">
			<center><a href="<c:url value="/checkout" />" class="btn btn-success">Check Out</a></center>
		</td>
	</tr>

</table>