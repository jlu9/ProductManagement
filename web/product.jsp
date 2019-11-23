<%-- 
    Document   : product
    Created on : Jun 25, 2019, 2:18:11 PM
    Author     : EmiLu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <p>User <a href="index.jsp">Logout</a>
        <h1>Product</h1>
        
        <!--<form action="/productManagement?action=addProduct" method="post">-->
        <form action="productManagement" method="post">
            <input type="hidden" name="action" value="addProduct">
                <label for="code" class="labels">Code:</label>  
                <input class="inputs" type="text" name="code" value="${currentProduct.code}" required/>  <br /><br />
                <label for="desc" class="labels">Description:</label>  
                <textarea class="inputs" name="description" id="desc" required>${currentProduct.description}</textarea>  <br /><br /><br /><br />
                <label for="price" class="labels">Price:</label>  
                <input class="inputs" type="number" step="0.01" name="price" value="${currentProduct.price}" required/>  <br /><br />

                <input class="productsButtons" type="submit" name="update" value="Update Product List" /> 
                <a href="/group7projectpart3/productManagement?action=displayProducts"><button type="button" name="viewProducts">View Products</button></a>
            </form>
    </body>
</html>
