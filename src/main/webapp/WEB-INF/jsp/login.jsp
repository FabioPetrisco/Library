<%--
  Created by IntelliJ IDEA.
  User: fabiopetrisco
  Date: 18/08/21
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
   <form action="LoginServlet" method="post">
       <label>Email</label>
       <input type="text" name="email">

       <label>Password</label>
       <input type="password" name="password">

       <input type="submit" name="Login">
   </form>
</body>
</html>
