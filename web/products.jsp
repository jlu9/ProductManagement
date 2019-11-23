
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="styles.css"></head>
    </head>
    <body>
        
        <p>User <a href="index.jsp">Logout</a>
        <h1>Products</h1>
        
        <form action="productManagement" method="get">
            <input type="hidden" name="action" value="addProduct">

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            
        <table border>
             <tr>
                <th style="width:10%">Code</th>
                <th style="width:50%">Description</th>
                <th style="width:10%">Price</th>
                <th style="width:10%"></th>
                <th style="width:10%"></th>
            </tr>
            <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.code}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><fmt:formatNumber value="${product.price}" type="currency" /></td>
                <td><a href="/group7projectpart3/productManagement?action=edit&newCode=${product.code}">Edit</a></td>
                <td><a href="/group7projectpart3/productManagement?action=deleteProduct&newCode=${product.code}">Delete </a></td>
            </tr>
            </c:forEach>
        </table>
        <br>
            <input type="submit" value="Add New">
        </form>
     </body>
</html>
