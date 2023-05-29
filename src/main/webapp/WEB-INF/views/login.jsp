<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" %>
<%@ include file="Header.jsp" %>

<form action="LoginServlet" method="post">
	
	<table border="1" align="center">
		
		<tr bgcolor="gray">
			<td colspan="2"> <center>Sign In</center> </td>
		</tr>
		
		<tr bgcolor="pink">
			<td>Email</td>
			<td><input type="email" name="email" required></td>
		</tr>
		
		<tr bgcolor="pink">
			<td>Password</td>
			<td><input type="password" name="password" required></td>
		</tr>
		
		<tr bgcolor="gray">
			<td colspan="2"> <center> <input type="submit" value="Log In"> </center> </td>
		</tr>
		
	</table>
	
</form>