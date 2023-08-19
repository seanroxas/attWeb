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
<body>
<div class="bodydes">
 <div class="login-form">
  <form action ="/otpcheck" onsubmit="return otpchk()" method="get">
    <h1>One Time Password</h1>
    <h3 id="errormessage">${msg}</h3>
    <div class="content">
      <div class="input-field">
        <input type="text" name="otp" id="otp" placeholder="One Time Password">
      </div>
      <div class="input-field">
        <input type="hidden" name="key" id="key" value="${key}">
      </div>
    </div>
    <div class="action">
      <button type="submit">Sign In</button>
    </div>
  </form>
</div>
</div>
</body>
</html>