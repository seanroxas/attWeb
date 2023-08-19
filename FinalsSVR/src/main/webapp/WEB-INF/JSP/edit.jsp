<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="CSS/add.css">
</head>
<body>
<div class="bodydes">
 <div class="login-form">
  <form action="/update" method="post">
    <h1>Student Update</h1>
     <h3>${msg}</h3>
    <div class="content">
    <div class="input-field">
        <input value ="${students.idnumber}" name="idnumber" type="hidden">
      </div>
      <div class="input-field">
        <input value ="${students.email}" name="email" type="email" placeholder="E-Mail" required>
      </div>
      <div class="input-field">
        <input value ="${students.studentname}" name="studentname" type="text" placeholder="Password" required>
      </div>
    </div>
    <div class="action">
      <button>Update</button>
    </div>
  </form>
</div>
</div>
</body>
</html>