<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

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
<title>Listing of books</title>
</head>
<body>
	<!-- header -->
	<header class="bg-primay bordered">
		<%@ include file="navbar.jsp"%>
	</header>

	<div class="container" style="min-height: 100vh; color:white;">
		<!-- <div class="card">
			<div class="card-body"> -->
		<div class="container">
			<div class="row mt-3 mb-4"style="padding-top:100px;">

				<h3 class=" text-center ml-auto mr-auto" >Book Listing</h3>
				<button class="btn " type="submit" onclick="location.href='/addform'">Add
					a book</button>

			</div>
			<div class="col-12">
				<table class="table h-100 table-bordered text-center"
					id="output-table">
					<thead>
						<tr>

							<th class="col-4 col-md-2 ">Book Code</th>
							<th class="col-4 col-md-2 ">Book Name</th>
							<th class="col-10 col-md-2 ">Author</th>
							<th class="col-4 col-md-2 ">Data Added</th>
							<th class="col-10 col-md-3">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td class="col-4 col-md-2 align-middle">${book.get("bookCode")}</td>
								<td class="col-4 col-md-2 align-middle">${book.get("bookName")}</td>
								<td class="col-10 col-md-2 align-middle">${book.get("authorName")}</td>
								<td class="col-4 col-md-2 align-middle">${book.get("createdDate")}</td>
								<td class="col-10 col-md-3 align-middle">
								<button class="btn btn-sm" type="submit" onclick="location.href='/edit/${book.get("bookId")}'">Edit</button>&nbsp;&nbsp;
								<button class="btn btn-outline-danger btn-sm" type="submit" onclick="location.href='/delete/${book.get("bookId")}'">Delete</button>
								</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>


</body>
</html>