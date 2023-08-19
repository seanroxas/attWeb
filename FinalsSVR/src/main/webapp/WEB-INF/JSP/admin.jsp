<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMINISTRATOR LOGIN</title>
    <link rel="stylesheet" href="CSS/add.css">
    <script src="/JS/welcome.js"></script>
</head>
<body onload="generateString()">
<div class="bodydes">
 <div class="login-form">
  <form  action ="/checkadmin" method="get">
    <h1>Administrator Login</h1>
    <h3>${msg}</h3>
    <div class="content">
      <div class="input-field">
        <input name="adminname" type="text" placeholder="Username" required>
      </div>
      <div class="input-field">
        <input name="adminpass" type="password" placeholder="Password" required>
      </div>
      <div class="input-field">
        <input type="hidden" name="key" id="key">
      </div>
    </div>
    <div class="action">
      <button>Sign In</button>
    </div>
  </form>
</div>
</div>
</body>
</html>