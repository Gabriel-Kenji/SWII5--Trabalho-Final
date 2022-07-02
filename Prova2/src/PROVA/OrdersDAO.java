package PROVA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public OrdersDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public boolean insertOrders(Orders orders) throws SQLException {
		
		String dataString = orders.getOrd_date(); 
		DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd"); 
		 long millis=System.currentTimeMillis();  
	    java.sql.Date date =new java.sql.Date(millis);  
	     System.out.println(date);  
		try {
			date = new java.sql.Date(fmt.parse(dataString).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date); 
		System.out.println(orders.getSalesman_id());  
		System.out.println(orders.getCustomer_id());  
		String sql = "INSERT INTO orders (PURCH_AMT, ORD_DATE, SALESMAN_ID, CUSTOMER_ID) VALUES (?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setFloat(1, orders.getPurch_amt());
        statement.setDate(2, date );
		statement.setInt(3, orders.getSalesman_id());
		statement.setInt(4, orders.getCustomer_id());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Orders> listAllOrders() throws SQLException {
		List<Orders> listOrders = new ArrayList<>();
		
		String sql = "SELECT * FROM orders";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("ORD_NO");
			float purch_amt = resultSet.getFloat("PURCH_AMT");
			String ord_date = resultSet.getDate("ORD_DATE").toString();
			int salesman_id = resultSet.getInt("SALESMAN_ID");
			int customer_id = resultSet.getInt("CUSTOMER_ID");
			
			Orders orders = new Orders(id, purch_amt, ord_date, salesman_id, customer_id);
			listOrders.add(orders);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listOrders;
	}
	
	public boolean deleteOrders(Orders orders) throws SQLException {
		String sql = "DELETE FROM Orders where ORD_NO = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, orders.getOrd_no());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateOrders(Orders orders) throws SQLException {

		String dataString = orders.getOrd_date(); 
		DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd"); 
		 long millis=System.currentTimeMillis();  
	    java.sql.Date date =new java.sql.Date(millis);  
	     System.out.println(date);  
		try {
			date = new java.sql.Date(fmt.parse(dataString).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((java.sql.Date) date); 
		System.out.println(orders.getPurch_amt());
		System.out.println(orders.getSalesman_id());
		System.out.println(orders.getCustomer_id());
		System.out.println(orders.getOrd_no()+ "id");
		String sql = "UPDATE Orders SET PURCH_AMT = ?, ORD_DATE = ?, SALESMAN_ID = ?, CUSTOMER_ID = ?";
		sql += " WHERE ORD_NO = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setFloat(1, orders.getPurch_amt());
		statement.setDate(2, (java.sql.Date) date );
		statement.setInt(3, orders.getSalesman_id());
		statement.setInt(4, orders.getCustomer_id());
		statement.setInt(5, orders.getOrd_no());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}

	public Orders getOrders(int id) throws SQLException {
		Orders orders = null;
		String sql = "SELECT * FROM Orders WHERE ORD_NO = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			float purch_amt = resultSet.getFloat("PURCH_AMT");
			String ord_date = resultSet.getDate("ORD_DATE").toString();
			int salesman_id = resultSet.getInt("SALESMAN_ID");
			int customer_id = resultSet.getInt("CUSTOMER_ID");
			
			orders = new Orders(id, purch_amt, ord_date, salesman_id, customer_id);
		}
		
		resultSet.close();
		statement.close();
		
		return orders;
	}
}

