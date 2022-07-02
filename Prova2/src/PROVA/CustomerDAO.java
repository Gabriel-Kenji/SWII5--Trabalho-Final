package PROVA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public CustomerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO customer (CUST_NAME, CITY, GRADE) VALUES (?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getCity());
		statement.setFloat(3, customer.getGrade());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Customer> listAllCustomer() throws SQLException {
		List<Customer> listCustomer = new ArrayList<>();
		
		String sql = "SELECT * FROM customer";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("CUSTOMER_ID");
			String name = resultSet.getString("CUST_NAME");
			String city = resultSet.getString("CITY");
			float grade = resultSet.getFloat("GRADE");
			
			Customer customer = new Customer(id, name, city, grade);
			listCustomer.add(customer);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listCustomer;
	}
	
	public boolean deleteCustomer(Customer customer) throws SQLException {
		
		String sql = "DELETE FROM Orders where CUSTOMER_ID = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, customer.getCustomer_id());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		
		String sql1 = "DELETE FROM Customer where CUSTOMER_ID = ?";
		
		connect();
		
		PreparedStatement statement1 = jdbcConnection.prepareStatement(sql1);
		statement1.setInt(1, customer.getCustomer_id());
		
		boolean rowDeleted1 = statement1.executeUpdate() > 0;
		statement1.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateCustomer(Customer customer) throws SQLException {
		String sql = "UPDATE Customer SET CUST_NAME = ?, CITY = ?, GRADE = ?";
		sql += " WHERE CUSTOMER_ID = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getCity());
		statement.setFloat(3, customer.getGrade());
		statement.setInt(4, customer.getCustomer_id());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public Customer getCustomer(int id) throws SQLException {
		Customer customer = null;
		String sql = "SELECT * FROM Customer WHERE CUSTOMER_ID = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String name = resultSet.getString("CUST_NAME");
			String city = resultSet.getString("CITY");
			float grade = resultSet.getFloat("GRADE");
			
			customer = new Customer(id, name, city, grade);
		}
		
		resultSet.close();
		statement.close();
		
		return customer;
	}
}
