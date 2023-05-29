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

	<form action="<c:url value="/updateCategory/${currCategory.categoryId}" />" method="post">
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

</body>
</html>