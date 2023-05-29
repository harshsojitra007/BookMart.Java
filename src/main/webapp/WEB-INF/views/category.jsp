<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"
    pageEncoding="ISO-8859-1"%>

<%@ include file="Header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="AddCategory" method="post">
		<table border="1" align="center">
			
			<tr>
				<td colspan="2"> <center>Category</center> </td>
			</tr>
			
			<tr>
				<td>Category Name</td>
				<td><input type="text" name="categoryName" value="<c:out value="${currCategory.categoryName}"></c:out>" required></td>
			</tr>
			
			<tr>
				<td>Category Description</td>
				<td><input type="text" name="categoryDescription" value="<c:out value="${currCategory.categoryDesc}"></c:out>" required></td>
			</tr>
			
			<tr>
				<td colspan="2"> <center> <input type="submit" value="Submit"> </center> </td>
			</tr>
			
		</table>
	</form>

	<table border="1">
		
		<tr>
			<td>Category Id</td>
			<td>Category Name</td>
			<td>Category Description</td>
			<td>Operation</td>
			
			<c:forEach items="${CategoryList}" var="category">
				
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.categoryName}</td>
					<td>${category.categoryDesc}</td>
					
					<td> <a href="<c:url value="/editCategory/${category.categoryId}" />" class="btn btn-success">Edit</a> </td>
					<td> <a href="<c:url value="/deleteCategory/${category.categoryId}" />" class="btn btn-danger">Delete</a> </td>
				</tr>
				
			</c:forEach>
		</tr>
		
	</table>

</body>
</html>