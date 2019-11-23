/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductTable {

    static String url = "jdbc:mysql://localhost:3306/shop";
    static String username = "user";
    static String password = "123";

    static Connection connection = null;
    static PreparedStatement selectProduct = null;
    static ResultSet resultset = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static ArrayList<Product> selectProducts() {
        Product result = null;
        ArrayList<Product> products = new ArrayList();

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectProduct = connection.prepareStatement("SELECT * FROM shop.products");

            resultset = selectProduct.executeQuery();

            while (resultset != null) {
                resultset.next();

                result = new Product();

                result.setCode(resultset.getString("code"));
                result.setDescription(resultset.getString("description"));
                result.setPrice(Double.parseDouble(resultset.getString("price")));
                products.add(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public static Product selectProduct(String productCode) {
        Product result = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectProduct = connection.prepareStatement("SELECT * FROM shop.products WHERE code = ? ");
            selectProduct.setString(1, productCode);
            resultset = selectProduct.executeQuery();

            if (resultset != null) {
                resultset.next();

                result = new Product();

                result.setCode(resultset.getString("code"));
                result.setDescription(resultset.getString("description"));
                result.setPrice(Double.parseDouble(resultset.getString("price")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean exists(String productCode) {

        Product result = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectProduct = connection.prepareStatement("SELECT * FROM shop.products WHERE code = ? ");
            selectProduct.setString(1, productCode);
            resultset = selectProduct.executeQuery();

            if (resultset != null) {
                resultset.next();
                if (resultset.getString("code").equals(productCode)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private static void saveProducts(List<Product> products) {
        try {
            for (Product p : products) {
                ProductTable.insertProduct(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertProduct(Product product) {
        try {
            connection = DriverManager.getConnection(url, username, password);

            if (!ProductTable.exists(product.getCode())) {
                selectProduct = connection.prepareStatement("INSERT INTO shop.products "
                        + "(code, description, price) VALUES (?,?,?)");
                selectProduct.setString(1, product.getCode());
                selectProduct.setString(2, product.getDescription());
                selectProduct.setDouble(3, product.getPrice());

                selectProduct.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
        try {
            connection = DriverManager.getConnection(url, username, password);

            if (ProductTable.exists(product.getCode())) {
                selectProduct = connection.prepareStatement("UPDATE shop.products SET description= ?, price= ? WHERE code= ?");
                selectProduct.setString(1, product.getDescription());
                selectProduct.setDouble(2, product.getPrice());
                selectProduct.setString(3, product.getCode());
                selectProduct.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(Product product) {
        try {
            connection = DriverManager.getConnection(url, username, password);

            if (ProductTable.exists(product.getCode())) {
                selectProduct = connection.prepareStatement("DELETE FROM shop.products WHERE code= ? ");
                selectProduct.setString(1, product.getCode());
                selectProduct.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
