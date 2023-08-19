<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
  <link rel="stylesheet" href="CSS/add.css">
  <script src="/JS/welcome.js"></script>
</head>
<body>
<div class="bodydes">
 <div class="login-form">
  <form  action ="/email" onsubmit="return addchk()" method="get">
    <h1>Add A student</h1>
    <h3 id="errormessage">${msg}</h3>
    <div class="content">
      <div class="input-field">
        <input name="email" type="email" placeholder="Email" required>
      </div>
      <div class="input-field">
        <input name="studentname" type="text" placeholder="Student Name" required>
      </div>
      <div class="input-field">
        <input id="studentpass" name="studentpass" type="password" placeholder="Password" required>
      </div>
      <div class="input-field">
        <input id="cpass" name="cpass" type="password" placeholder="Confirm Password" required>
      </div>
    </div>
    <div class="action">
      <button>Add the Student</button>
    </div>
  </form>
</div>
</div>
</body>
</html>
