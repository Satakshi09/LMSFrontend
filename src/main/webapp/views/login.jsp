<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	<style type="text/css">
body {
/* Created with https://www.css-gradient.com */
background: rgba(238, 113, 228, 1.0);
background: -webkit-radial-gradient(top left, rgba(238, 113, 228, 1.0), rgba(34, 72, 160, 1.0));
background: -moz-radial-gradient(top left, rgba(238, 113, 228, 1.0), rgba(34, 72, 160, 1.0));
background: radial-gradient(to bottom right, rgba(238, 113, 228, 1.0), rgba(34, 72, 160, 1.0));
	/* Make image center */
	background-position: center center;
	/* Make image fixed */
	background-attachment: fixed;
	/* Not repeat images */
	background-repeat: no-repeat;
	/* Set background size auto */
	background-size: auto;
}

	</style>

<title>Login Page</title>
</head>
<body>

	<div class="container" style="color:white;" >
		<div class="row mt-5 align-items-center">
		<h1 style="padding-left:300px">Library Management System</h1>
			<div class="col-md-8 mx-auto offset-md-4 "style="padding-top:100px;">
			
				<div class="card "style="background-color: transparent;>
					<c:if test="${not empty message}">
						<div class="text-center mb-2" style="color: red">
							<h3>${message}</h3>
						</div>
					</c:if>
					<div class="card-header ">
						<h3 class="text-center">Login</h3>
					</div>
					<div class="card-body">
						<form action="/validate" method="post" ">
							<div class="form-group">
								<div class="input-group mb-3 mx-0 mx-md-5">
									<label for="username" class="col-3">Username :</label> <span
										style="color: red">*</span>
									<div class="col-8 col-md-7">
										<input name="username" type="text" class="form-control"
											id="name" minlength="5" maxlength="50" required>
									</div>
									<span class="formerror"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group mb-3 mx-0 mx-md-5">
									<label for="password" class="col-3">Password :</label> <span
										style="color: red">*</span>
									<div class="col-8 col-md-7">
										<input name="password" type="password" class="form-control"
											id="password" minlength="5" maxlength="50" required>
									</div>
								</div>
							</div>
							<div class="card-footer text-center">
								<button type="submit" class="btn ">Login
									</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>