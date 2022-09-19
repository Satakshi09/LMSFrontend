<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Register Page</title>
</head>
<body>
<div class="row mt-5">
		<div class="col-md-6 offset-md-3">
			<div class="card">

				<div class="card-body px-5">
				
					<h3 class="text-center my-3">Sign up here!!</h3>
					<form action="/do_register" method="post">
						<div class="form-group">
							 <label for="name">Username :</label>
							 <input name="name"
								type="text" class="form-control" id="name" required>
							 <label for="name">Password :</label> 
							 <input name="password"
								type="password" class="form-control" id="password" required>
						</div>

						<div class="container">
							<button type="submit" class="btn btn-success">Register</button>
							<button type="reset" class="btn btn-warning">Reset</button>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

</body>
</html>