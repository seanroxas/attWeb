<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>ATTENDANCE SUBMITTED</title>
<link rel="stylesheet" href="CSS/login.css">
<script src="/JS/welcome.js"></script>
</head>
<body  onLoad="colorstat()">
<header class="header">
		<h1 class="logo"><a href="https://www.eac.edu.ph/">Emilio Aguinaldo College</a></h1>
		<h1 class="logo2"><a href="https://www.eac.edu.ph/">{ Attendance System }</a></h1>
      <ul class="main-nav">
          <li><a href="http://localhost:8090/reset">Reset Attendance</a></li>
          <li><a href="http://localhost:8090/addteach">Add an Admin</a></li>
          <li><a href="http://localhost:8090/choose">Log-Out</a></li>
      </ul>
	</header>
<div class="container">
        <table>
            <thead>
                <tr>
                    <th>Id Number</th>
                    <th>E-Mail</th>
                    <th>Student Name</th>
                    <th>Attendance</th>
                    <th>Action</th>
                </tr>
           
            </thead>

            <tbody>
 <c:forEach var="list" items="${listOfUsers}">
                <tr>
                    <td>${list.idnumber}</td>
                    <td>${list.email}</td>
                    <td>${list.studentname}</td>
                    <td id="status" >${list.status}</td>
                    <td class="buttons">
                    <a class="edit" href="/edit?idnumber=${list.idnumber}">Edit</a>
					<a class="delete" href="/delete?idnumber=${list.idnumber}" onclick="return DeleteConfirm()">Delete</a>
					</td>
                </tr>
   </c:forEach>
            </tbody>
        </table>
        	<a class="add" href="/add"> Add </a>
    </div>
</body>

</html>