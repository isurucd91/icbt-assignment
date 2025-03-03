package services;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Booking;

public class bookService {
	public boolean Insertion(Booking TheBooking) throws ClassNotFoundException
	{
        Class.forName("com.mysql.jdbc.Driver");
        boolean status = false;
        
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into bookings(custid, pickpt, droppt, ridetype, drvid) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, Integer.toString(TheBooking.getmCustomerID()));
            preparedStatement.setString(2, TheBooking.getmPickupAddress());
            preparedStatement.setString(3, TheBooking.getmDropAddress());
            preparedStatement.setString(4, TheBooking.getmRideType());
            preparedStatement.setString(5, Integer.toString(TheBooking.getmDriverID()));
            
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()==1)
            	status = true;

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;	
	}
	
    public List<Booking> GetData(int custid) throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        List<Booking> resrs = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from bookings where custid = ?");
            preparedStatement.setString(1, Integer.toString(custid));

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (status = rs.next()) {
            	Booking res = new Booking();
            	res.setmID(Integer.parseInt(rs.getString(1)));
	            res.setmCustomerID(Integer.parseInt(rs.getString(2)));
	            res.setmPickupAddress(rs.getString(3));
	            res.setmDropAddress(rs.getString(4));
	            res.setmRideType(rs.getString(5));
	            res.setmDriverID(Integer.parseInt(rs.getString(6)));
	            resrs.add(res);
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return resrs;
    }

    public boolean Deletion(Booking TheBooking) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from bookings where id = ?");
            preparedStatement.setString(1, Integer.toString(TheBooking.getmID()));

            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate() == 1)
            	status = true;
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