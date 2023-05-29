<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"
    pageEncoding="ISO-8859-1"%>

<%@ include file="Header.jsp" %>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>

    <link rel="stylesheet" type="text/css" href="contactUs.css">
</head>
<body>
	<center>
	
        <div class="contactus">
            <h1>CONTACT US</h1>
       	</div>
          
	</center>
<div class="container">
  <form>
      <input type = "text" id = "name" placeholder="Your name">
      <input type = "email" id = "email" placeholder="Your email id">
      <input type = "number" id = "phone" placeholder="Your Phone number">
      <textarea id="message" rows="4" placeholder="How can we help you?"></textarea>
    <button type="submit"><h5>Submit</h5></button>
    </form>
</div>

</body>
</html>