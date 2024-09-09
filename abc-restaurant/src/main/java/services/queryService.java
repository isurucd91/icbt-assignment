package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Query;

public class queryService {
	public boolean Insertion(Query TheQuery) throws ClassNotFoundException
	{
        Class.forName("com.mysql.jdbc.Driver");
        boolean status = false;
        
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into queries(querytext, replytext, custid) values (?, ?, ?)");
            preparedStatement.setString(1, TheQuery.getQueryText());
            preparedStatement.setString(2, TheQuery.getReplyText());
            preparedStatement.setString(3, Integer.toString(TheQuery.getmCustId()));
            
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()==1)
            	status = true;

        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return status;	
	}
	
    public List<Query> GetData(int custid) throws ClassNotFoundException, SQLException {
    	
        boolean status = false;
        List<Query> queries = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from queries where custid = ?");
            preparedStatement.setString(1, Integer.toString(custid));

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (status = rs.next()) {
            	Query query = new Query();
            	query.setmID(Integer.parseInt(rs.getString(1)));
            	query.setQueryText(rs.getString(2));
            	query.setReplyText(rs.getString(3));
            	query.setmCustId(Integer.parseInt(rs.getString(4)));
            	queries.add(query);
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return queries;
    }
	
    public boolean Update(Query TheQuery) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcr", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("update queries set replytext = ? where id = ?");
            preparedStatement.setString(1, TheQuery.getReplyText());
            preparedStatement.setString(2, Integer.toString(TheQuery.getmID()));

            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()==1)
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