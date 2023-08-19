<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Admin</title>
 <link rel="stylesheet" href="CSS/add.css">
 <script src="/JS/welcome.js"></script>
</head>
<body>
<div class="bodydes">
 <div class="login-form">
  <form  action ="/addition" onsubmit="return addminchk()" method="get">
    <h1>Add Administrator</h1>
    <h3 id="errormessage">${msg}</h3>
    <div class="content">
      <div class="input-field">
        <input name="username" type="text" placeholder="Username" required>
      </div>
      <div class="input-field">
        <input id="password" name="password" type="password" placeholder="Password" required>
      </div>
            <div class="input-field">
        <input id="admincpass" name="admincpass" type="password" placeholder="Confirm Password" required>
      </div>
    </div>
    <div class="action">
      <button>ADD</button>
    </div>
  </form>
</div>
</div>
</body>
</html>