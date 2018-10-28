<%-- 
    Document   : searchForm
    Created on : Oct 27, 2018, 4:44:57 PM
    Author     : Canyon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Product Search Page for OnlineShop_WS</h2>
        <!-- go to servlet -->
        <form action="processServlet.jsp" method="post">
            Search Phone: <input type="text" name="searchString"> 
            <input type="submit" value="Search" name="Search">
        </form>
    </body>
</html>
