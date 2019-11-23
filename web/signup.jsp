<%-- 
    Document   : signup
    Created on : Jun 25, 2019, 1:37:56 PM
    Author     : EmiLu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <form action="membership" method="post">
            <input type="hidden" name="action" value="signup">  
            <h1>Sign-Up form</h1>
            <table border="0">
                <tbody>
                    <tr>
                <p>${message}</p>
                <td>First Name</td>
                <td><input type="text" name="firstName" value="<c:out value="${user.firstName}" />"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<c:out value="${user.email}" />" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                               title="Must contain at least one number and one uppercase and lowercase letter, and at 
                               least 8 or more characters " value="<c:out value="${user.password}" />" /></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" value="Sign up"/>
        </form>
    </body>
</html>
