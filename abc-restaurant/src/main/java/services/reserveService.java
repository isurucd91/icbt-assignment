package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reservation;

public class reserveService {
	public boolean Insertion(Reservation TheReservation) throws ClassNotFoundException
	{
        Class.forName("com.mysql.jdbc.Driver");
        boolean status = false;
        
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into reservations(curdate, cutime, type, status, custid) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, TheReservation.getmDate());
            preparedStatement.setString(2, TheReservation.getmTime());
            preparedStatement.setString(3, TheReservation.getmType());
            preparedStatement.setString(4, TheReservation.getmStatus());
            preparedStatement.setString(5, Integer.toString(TheReservation.getmCustID()));
            
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()==1)
            	status = true;

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;	
	}
	
    public Reservation GetData(int custid) throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        Reservation res = new Reservation();
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from reservations where custid = ?");
            preparedStatement.setString(1, Integer.toString(custid));

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            res.setmDate(rs.getString(2));
            res.setmTime(rs.getString(3));
            res.setmType(rs.getString(4));
            res.setmStatus(rs.getString(5));
            res.setmCustID(Integer.parseInt(rs.getString(6)));
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return res;
    }
	
    public boolean Validate(Reservation TheReservation) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from reservations where custid = ?");
            preparedStatement.setString(1, Integer.toString(TheReservation.getmCustID()));

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            if (rs.getString(5) == "reserved")
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