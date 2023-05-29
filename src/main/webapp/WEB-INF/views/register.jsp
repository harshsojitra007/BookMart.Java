<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"
    pageEncoding="ISO-8859-1"%>

<%@ include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
<div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">Register</div>
                            <div class="card-body">

                                <form:form class="form-horizontal" method="post" modelAttribute="newCustomer" action="registerNewCustomer">

                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Your Name</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                                <form:input type="text" class="form-control" path="customerName" placeholder="Enter your Name" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="cols-sm-2 control-label">Your Email</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                                <form:input type="email" class="form-control" path="customerEmail" placeholder="Enter your Email" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="contact" class="cols-sm-2 control-label">Contact</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                                <form:input type="text" class="form-control" path="customerContact" placeholder="Enter your Contact" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="cols-sm-2 control-label">Password</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                                <form:input type="password" class="form-control" path="customerPassword" placeholder="Enter your Password" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="address" class="cols-sm-2 control-label">Address</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                                <form:input type="text" class="form-control" path="customerAddress" placeholder="Enter your Address" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <input type="submit" class="btn btn-primary btn-lg btn-block login-button">
                                    </div>
                                    <div class="login-register">
                                        <a href="<c:url value="/login" /> ">Login</a>
                                    </div>
                                </form:form>
                            </div>

                        </div>
                    </div>
                </div>
</div>