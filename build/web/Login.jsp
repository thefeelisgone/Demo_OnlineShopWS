<%-- 
    Document   : Login
    Created on : Oct 23, 2018, 9:12:47 AM
    Author     : Canyon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="services.VerifyUserServlet"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page for OnlineShop_WS</title>
    </head>
    <body>
        <h2>Login page for OnlineShop_WS</h2>
        <!-- go to servlet -->
        <form action="VerifyUserServlet" method="POST">
            Login ID: <input type='text' name='userid'/>
            Password: <input type='text' name='password'/>
            <input type='submit' name='btnSubmit' value='Login'/>
            <input type='reset' name='btnReset' value='Reset'/>
        </form>
    </body>
</html>
