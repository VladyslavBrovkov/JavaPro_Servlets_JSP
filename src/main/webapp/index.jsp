<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Prog Academy</title>
</head>
<body>
<% String login = (String) session.getAttribute("user_login"); %>
<% String password = (String) session.getAttribute("password"); %>
<% String age = (String) session.getAttribute("age"); %>
<% if (login == null || "".equals(login)) { %>
<form action="/login" method="POST">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    Age: <input type="text" name="age"><br>
    <input type="submit"/>
</form>
<% } else if ("incorrect".equals(login) && "incorrect".equals(password) && "incorrect".equals(age)) { %>
<form action="/login" method="POST">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    Age: <input type="text" name="age"><br>
    <input type="submit"/>
    <h3>Try again. Incorrect data</h3>
        <% } else if (Integer.parseInt(age) < 18) { %>
    <form action="/login" method="POST">
        Login: <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        Age: <input type="text" name="age"><br>
        <input type="submit"/>
        <h3>Your age is under 18</h3>
            <%} else { %>
        <h1>You are logged in as: <%= login %>
        </h1>
        <br>Click this link to <a href="/login?a=exit">logout</a>
            <% } %>
</body>
</html>
