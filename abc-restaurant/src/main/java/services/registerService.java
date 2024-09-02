package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class registerService {
	public boolean Insertion(User TheUser) throws ClassNotFoundException
	{
        Class.forName("com.mysql.jdbc.Driver");
        boolean status = false;
        
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(username, password, email, role) values (?, ?, ?, ?)");
            preparedStatement.setString(1, TheUser.getmName());
            preparedStatement.setString(2, TheUser.getmPassword());
            preparedStatement.setString(3, TheUser.getmEmail());
            preparedStatement.setString(4, TheUser.getmRole());
            
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()==1)
            	status = true;

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;	
	}
	
    public boolean Validate(User TheUser) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
            preparedStatement.setString(1, TheUser.getmName());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;
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
