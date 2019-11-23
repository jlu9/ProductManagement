<%-- 
    Document   : confirmDelete
    Created on : Jun 25, 2019, 3:40:25 PM
    Author     : EmiLu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <p>User <a href="index.jsp">Logout</a>
        <h1>Are you sure you want to delete this product?</h1>
        
        <label for="code" class="labels"> Code: </label>
            <i name="code"><c:out value='${currentProductD.code}'/></i><br />
            <br/>
            <label for="desc" class="labels">Description:</label>  
            <i name="desc"><c:out value='${currentProductD.description}'/></i><br/>
            <br/>
            <label for="price" class="labels">Price:</label>  
            <i name="price"><c:out value='${currentProductD.price}'/></i></i>
        <br /><br />
        <a href="/group7projectpart3/productManagement?action=delete"><button type="button" name="yesDelete">Yes</button></a>
        <a href="/group7projectpart3/productManagement?action=displayProducts"><button type="button" name="noDelete">No</button></a> 
    </body>
</html>
