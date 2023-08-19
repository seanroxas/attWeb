<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance</title>
<link rel="stylesheet" href="CSS/student.css">
</head>
<div class="window">
  <div class="box header">
    <img src="https://preview.redd.it/h5gnz1ji36o61.png?width=225&format=png&auto=webp&s=84379f8d3bbe593a2e863c438cd03e84c8a474fa" alt="" />
    <h2>${students.studentname}</h2><br>
    <h5>${students.email}</h5>
    <h4>${students.idnumber}</h4>
    <a href="http://localhost:8090/choose" class="btn">Log-out</a>
  </div>
</div>
</body>
</html>