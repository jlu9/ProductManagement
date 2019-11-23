/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserTable {

    static String url = "jdbc:mysql://localhost:3306/shop";
    static String username = "user";
    static String password = "123";

    static Connection connection = null;
    static PreparedStatement selectUser = null;
    static ResultSet resultset = null;
    static ArrayList<User> users = new ArrayList();
    static HashMap<String, User> usersHashMap = new HashMap();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static void addRecord(User user) throws IOException {
        try {
            connection = DriverManager.getConnection(url, username, password);

            if (!UserTable.exists(user.getEmail())) {
                selectUser = connection.prepareStatement("INSERT INTO shop.users (firstName, lastName, email, password) VALUES (?,?,?,?)");
                selectUser.setString(1, user.getFirstName());
                selectUser.setString(2, user.getLastName());
                selectUser.setString(3, user.getEmail());
                selectUser.setString(4, user.getPassword());
                selectUser.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String emailAddress) throws IOException {
        User result = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectUser = connection.prepareStatement("select * from shop.users where email= ? ");
            selectUser.setString(1, emailAddress);

            resultset = selectUser.executeQuery();

            if (resultset != null) {
                resultset.next();

                result = new User();

                result.setFirstName(resultset.getString("firstName"));
                result.setLastName(resultset.getString("lastName"));
                result.setEmail(resultset.getString("email"));
                result.setPassword(resultset.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<User> getUsers() throws IOException {
        User result = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectUser = connection.prepareStatement("SELECT * FROM shop.users");

            resultset = selectUser.executeQuery();

            while (resultset != null) {
                resultset.next();

                result = new User();

                result.setFirstName(resultset.getString("firstName"));
                result.setLastName(resultset.getString("lastName"));
                result.setEmail(resultset.getString("email"));
                result.setPassword(resultset.getString("password"));
                users.add(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static HashMap<String, User> getUsersMap() throws IOException {
        User result = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectUser = connection.prepareStatement("SELECT * FROM shop.users");

            resultset = selectUser.executeQuery();

            while (resultset != null) {
                resultset.next();

                result = new User();

                result.setFirstName(resultset.getString("firstName"));
                result.setLastName(resultset.getString("lastName"));
                result.setEmail(resultset.getString("email"));
                result.setPassword(resultset.getString("password"));
                usersHashMap.put(result.getFirstName(), result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersHashMap;
    }

    public static boolean exists(String emailAddress) {

        User result = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            selectUser = connection.prepareStatement("SELECT * FROM shop.users WHERE email = ? ");
            selectUser.setString(1, emailAddress);
            resultset = selectUser.executeQuery();

            if (resultset != null) {
                resultset.next();
                if (resultset.getString("email").equals(emailAddress)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

