<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Log-In</title>
    <link rel="stylesheet" href="CSS/add.css">
    <script src="/JS/welcome.js"></script>
</head>
<body>
<div class="bodydes">
 <div class="login-form">
  <form  action="/attend" method="post">
    <h1>Student Login</h1>
     <h3>${msg}</h3>
    <div class="content">
      <div class="input-field">
        <input name="email" type="email" placeholder="E-Mail" required>
      </div>
      <div class="input-field">
        <input name="studentpass" type="password" placeholder="Password" required>
      </div>
          <h2>Password = Student lastname, ex. roxas</h2>
    </div>

    <div class="action">
      <button>Sign In</button>
    </div>
  </form>
</div>
</div>
</body>
</html>