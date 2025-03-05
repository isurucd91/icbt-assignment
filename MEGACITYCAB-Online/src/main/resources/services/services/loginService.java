package services;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class loginService {

	public boolean Validate(User TheUser) throws ClassNotFoundException {

		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where username = ? and password = ? ");
			preparedStatement.setString(1, TheUser.getmName());
			preparedStatement.setString(2, TheUser.getmPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return status;
	}

	public String GetType(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String type = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			type = rs.getString(5);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return type;
	}
	
	public String GetNIC(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String nic = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			nic = rs.getString(7);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return nic;
	}
	
	public String GetRegNo(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String rno = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			rno = rs.getString(6);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rno;
	}
	
	public String GetEMail(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String email = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			email = rs.getString(4);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return email;
	}
	
	public String GetTelephone(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String tp = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			tp = rs.getString(8);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tp;
	}
	
	public String GetAddress(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String address = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			address = rs.getString(9);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return address;
	}
	
	public String GetUserName(int id) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String username = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
			preparedStatement.setString(1, Integer.toString(id));

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			username = rs.getString(2);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return username;
	}
	
	public int GetUserID(String username) throws ClassNotFoundException, SQLException {

		boolean status = false;
		String uid = "";

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			uid = rs.getString(1);
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Integer.parseInt(uid);
	}

	public List<String> GetCustomerIDList() throws ClassNotFoundException, SQLException {

		boolean status = false;
		List<String> cidlist = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where type=?");
			preparedStatement.setString(1, "customer");
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (status = rs.next()) {
				String cid = rs.getString(1);
				cidlist.add(cid);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return cidlist;
	}
	
	public List<String> GetDriverIDList() throws ClassNotFoundException, SQLException {

		boolean status = false;
		List<String> didlist = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccdb", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where type=?");
			preparedStatement.setString(1, "driver");
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (status = rs.next()) {
				String did = rs.getString(1);
				didlist.add(did);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return didlist;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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
