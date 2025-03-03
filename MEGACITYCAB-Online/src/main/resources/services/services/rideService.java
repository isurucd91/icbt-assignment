package services;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RideType;

public class rideService {
	public boolean Insertion(RideType TheRideType) throws ClassNotFoundException
	{
        Class.forName("com.mysql.jdbc.Driver");
        boolean status = false;
        
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into rides(ridetype, ridedetails, drvid) values (?, ?, ?)");
            preparedStatement.setString(1, TheRideType.getmRideType());
            preparedStatement.setString(2, TheRideType.getmRideDetails());
            preparedStatement.setString(3, Integer.toString(TheRideType.getmDriverID()));
            
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()==1)
            	status = true;

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;	
	}
	
    public List<RideType> GetData(int drvid) throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        List<RideType> resrs = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from rides where drvid = ?");
            preparedStatement.setString(1, Integer.toString(drvid));

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (status = rs.next()) {
            	RideType res = new RideType();
            	res.setmID(Integer.parseInt(rs.getString(1)));
	            res.setmRideType(rs.getString(2));
	            res.setmRideDetails(rs.getString(3));
	            res.setmDriverID(Integer.parseInt(rs.getString(4)));
	            resrs.add(res);
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return resrs;
    }

    public boolean Deletion(RideType TheRideType) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from rides where id = ?");
            preparedStatement.setString(1, Integer.toString(TheRideType.getmID()));

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