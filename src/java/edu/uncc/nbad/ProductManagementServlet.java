/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EmiLu
 */
public class ProductManagementServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductManagementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("addProduct")) {
            getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
        }else if(action != null && action.equals("displayProducts")){
            session.setAttribute("products", ProductTable.selectProducts());
            getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
        }else if(action != null && action.equals("deleteProduct")){
            String myCode = request.getParameter("newCode");
            session.setAttribute("myCode", ProductTable.selectProduct(myCode).getCode());
            System.out.println(ProductTable.selectProduct(myCode).getCode());
            session.setAttribute("currentProductD", ProductTable.selectProduct(myCode));
            getServletContext().getRequestDispatcher("/confirmDelete.jsp").forward(request, response);   
        }else if(action != null && action.equals("delete")){
            String myCode = (String)session.getAttribute("myCode");
            ProductTable.deleteProduct(ProductTable.selectProduct(myCode));
            session.setAttribute("products", ProductTable.selectProducts());
            getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
        }else if(action != null && action.equals("edit")){
            String myCode = request.getParameter("newCode");
            session.setAttribute("myCode", ProductTable.selectProduct(myCode).getCode());
            session.setAttribute("currentProductE", ProductTable.selectProduct(myCode));
            getServletContext().getRequestDispatcher("/editProduct.jsp").forward(request, response);
            
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action != null && action.equals("addProduct")) {
            System.out.println("Hello2");
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String price = request.getParameter("price");
            Product product = new Product();
            product.setCode(code);
            product.setDescription(description);
            product.setPrice(Double.parseDouble(price));
            ProductTable.insertProduct(product);
            System.out.println(product.getCode() + " " + product.getDescription() + " " + product.getPrice());
            session.setAttribute("products", ProductTable.selectProducts());
            getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
            //session.setAttribute("products", ProductTable.selectProducts());
        }else if(action != null && action.equals("editProduct")){
            String code = (String)session.getAttribute("myCode");
            String description = request.getParameter("description");
            String price = request.getParameter("price");
            Product product = new Product();
            product.setCode(code);
            product.setDescription(description);
            product.setPrice(Double.parseDouble(price));
            ProductTable.updateProduct(product);
            session.setAttribute("products", ProductTable.selectProducts());
            getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
