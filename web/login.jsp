<%-- 
    Document   : login
    Created on : Jun 25, 2019, 1:37:29 PM
    Author     : EmiLu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Login</h1>
        <form action="membership" method="post">
            <input type="hidden" name="action" value="login">  
            <table border="0">
                <tbody>
                    <tr>
                        <c:if test="${message.equals('')}">
                            <p>${message}</p>
                        </c:if>
                        <td>Email</td>
                        <td><input type="email" name="email" value="<c:out value='${user.email}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="<c:out value='${user.password}'/>"/></td>
                    </tr>
                </tbody>
            </table>
            <br/>
            <input type="submit" value="Login"/>
        </form>
        <p><a href="/group7projectpart3/membership?action=signup">New Users? Click here to register</a>
    </body>
</html>
