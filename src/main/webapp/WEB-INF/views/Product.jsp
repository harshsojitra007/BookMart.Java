<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="InsertProduct" modelAttribute="newInsertingProduct" method="post" enctype="multipart/form-data">

	<table align="center" border="1">
	
		<tr>
			<td colspan="2"><center>Product Info.</center></td>
		</tr>
		
		<form:input type="hidden" path="productId" />
		
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName" /></td>
		</tr>
		
		<tr>
			<td>Product Price</td>
			<td><form:input path="productPrice" /></td>
		</tr>
		
		<tr>
			<td>Stock</td>
			<td><form:input path="productStock" /></td>
		</tr>
		
		<tr>
			<td>Category</td>
			<td>
				<form:select path="productCategoryId">
					<form:option value="0" label="---Select List---" />
					<c:forEach items="${categoryList}" var="currCategory">
						<form:option value="${currCategory.categoryId}" label="${currCategory.categoryName}" />
					</c:forEach>
				</form:select>
			</td>
		</tr>
		
		<tr>
			<td>Supplier</td>
			<td><form:input path="productSupplierId" /></td>
		</tr>
		
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc" /></td>
		</tr>
	
		<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="productImage" /></td>
		</tr>
		
		<tr>
			<td colspan="2"><center><input type="submit" value="Insert Product"></center></td>
		</tr>
		
	</table>

</form:form>

<table border="1">
	
	<tr>
		<td>Product Id</td>
		<td>Product Name</td>
		<td>Product Price</td>
		<td>Product Stock</td>
		<td>Product Category</td>
		<td>Product Supplier</td>
		<td>Product Operations</td>
	</tr>
	
	<c:forEach items="${productList}" var="product">
	
		<tr>
			<td><c:out value="${product.productId }" /></td>
			<td><c:out value="${product.productName }" /></td>
			<td><c:out value="${product.productPrice }" /></td>
			<td><c:out value="${product.productStock }" /></td>
			<td><c:out value="${product.productCategoryId }" /></td>
			<td><c:out value="${product.productSupplierId }" /></td>
			
			<td> <a href="<c:url value="/editProduct/${product.productId}" />" class="btn btn-success">Edit</a> </td>
			<td> <a href="<c:url value="/deleteProduct/${product.productId}" />" class="btn btn-danger">Delete</a> </td>
		</tr>
	
	</c:forEach>
	
</table>
