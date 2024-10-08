package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Query;
import model.User;

public class loginService {
	
    public boolean Validate(User TheUser) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ? ");
            preparedStatement.setString(1, TheUser.getmName());
            preparedStatement.setString(2, TheUser.getmPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }
    
    public String GetRole(String username) throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        String role = "";
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
            preparedStatement.setString(1, username);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            role = rs.getString(5);
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return role;
    }
    
    public int GetCustID(String username) throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        String cid = "";
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
            preparedStatement.setString(1, username);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            cid = rs.getString(1);
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return Integer.parseInt(cid);
    }
    
    public List<String> GetCustIDList() throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        List<String> cidlist = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where role=?");
            preparedStatement.setString(1, "customer");
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();
            while (status = rs.next()) {
            	String cid = rs.getString(1);
            	cidlist.add(cid);
            }

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return cidlist;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
