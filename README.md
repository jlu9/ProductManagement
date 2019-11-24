# Product Management

This project was created for my Network-based Application Development course. The Product Management website was designed to store different products into a database and the users can add, edit, and remove products from the databases. This project was modeled after the Model-View-Controller design pattern. The SQL queries were encoded with Prepared Statements in order to prevent SQL injection.

* Frontend: HTML, CSS, and JSP 
* Backend: Java 
* Database: MySQL database 

## Model-View-Controller (MVC) design pattern
### MVC for Product
* Model: Product.java
* View: Index.jsp, product.jsp, products.jsp, confirmDelete.jsp, login.jsp, signup.jsp
* Controller: ProductManagementServlet.java

### MVC for User
* Model: User.java
* View: Index.jsp, product.jsp, products.jsp, confirmDelete.jsp, login.jsp, signup.jsp
* Controller: MembershipServlet.java
