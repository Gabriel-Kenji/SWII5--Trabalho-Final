//Gabriel Kenji Utiyama CB3012069
package PROVA;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesmanDAO salesmanDAO;
	private CustomerDAO customerDAO;
	private OrdersDAO ordersDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		salesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
		customerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
		ordersDAO = new OrdersDAO(jdbcURL, jdbcUsername, jdbcPassword);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/listSalesman":
				listSalesman(request, response);
				break;
			case "/newSalesman":
				showNewFormSalesman(request, response);
				break;
			case "/insertSalesman":
				insertSalesman(request, response);
				break;
			case "/deleteSalesman":
				deleteSalesman(request, response);
				break;
			case "/editSalesman":
				showEditFormSalesman(request, response);
				break;
			case "/updateSalesman":
				updateSalesman(request, response);
				break;
			case "/listOrders":
				listOrders(request, response);
				break;
			case "/newOrders":
				showNewFormOrders(request, response);
				break;
			case "/insertOrders":
				insertOrders(request, response);
				break;
			case "/deleteOrders":
				deleteOrders(request, response);
				break;
			case "/editOrders":
				showEditFormOrders(request, response);
				break;
			case "/updateOrders":
				updateOrders(request, response);
				break;
			case "/listCustomer":
				listCustomer(request, response);
				break;
			case "/newCustomer":
				showNewFormCustomer(request, response);
				break;
			case "/insertCustomer":
				insertCustomer(request, response);
				break;
			case "/deleteCustomer":
				deleteCustomer(request, response);
				break;
			case "/editCustomer":
				showEditFormCustomer(request, response);
				break;
			case "/updateCustomer":
				updateCustomer(request, response);
				break;
			case "/creditos":
				creditos(request, response);
				break;
			default:
				index(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	//Orders
		private void listOrders(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Orders> listOrders = ordersDAO.listAllOrders();
			request.setAttribute("listOrders", listOrders);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersList.jsp");
			dispatcher.forward(request, response);
		}

		private void showNewFormOrders(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			List<Salesman> listSalesman = salesmanDAO.listAllSalesman();
			request.setAttribute("listSalesman", listSalesman);
			List<Customer> listCustomer = customerDAO.listAllCustomer();
			request.setAttribute("listCustomer", listCustomer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
			
			dispatcher.forward(request, response);
		}

		private void showEditFormOrders(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Orders existingCustomer = ordersDAO.getOrders(id);
			System.out.println(existingCustomer);
			List<Salesman> listSalesman = salesmanDAO.listAllSalesman();
			request.setAttribute("listSalesman", listSalesman);
			List<Customer> listCustomer = customerDAO.listAllCustomer();
			request.setAttribute("listCustomer", listCustomer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
			request.setAttribute("customer", existingCustomer);
			
			dispatcher.forward(request, response);

		}

		private void insertOrders(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			
			Float name = Float.parseFloat(request.getParameter("name"));
			String date = request.getParameter("city");
			int customer = Integer.parseInt(request.getParameter("customer"));
			int salesman = Integer.parseInt(request.getParameter("salesman"));
			System.out.println(date + "aasdad");
			Orders newOrders = new Orders(name, date, salesman, customer );
			ordersDAO.insertOrders(newOrders);
			response.sendRedirect("listOrders");
		}

		private void updateOrders(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Float name = Float.parseFloat(request.getParameter("name"));
			String date = request.getParameter("city");
			System.out.println(date + "aasdad");
			int customer = Integer.parseInt(request.getParameter("customer"));
			int salesman = Integer.parseInt(request.getParameter("salesman"));
			System.out.println(request.getParameter("id")+"id");
			Orders orders = new Orders(id, name, date, salesman,customer);
			
			ordersDAO.updateOrders(orders);
			response.sendRedirect("listOrders");
		}

		private void deleteOrders(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));

			Customer customer = new Customer(id);
			customerDAO.deleteCustomer(customer);
			response.sendRedirect("listOrders");

		}
	
	//Customer
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = customerDAO.listAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDAO.getCustomer(id);
		System.out.println(existingCustomer.customer_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float grade = Float.parseFloat(request.getParameter("grade"));

		Customer newCustomer = new Customer(name, city, grade);
		customerDAO.insertCustomer(newCustomer);
		response.sendRedirect("listCustomer");
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float grade = Float.parseFloat(request.getParameter("grade"));
		System.out.println("teste");
		Customer customer = new Customer(id, name, city, grade);
		System.out.println(customer.name);
		customerDAO.updateCustomer(customer);
		response.sendRedirect("listCustomer");
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Customer customer = new Customer(id);
		customerDAO.deleteCustomer(customer);
		response.sendRedirect("listCustomer");

	}
	
	//Salesman
	
	private void listSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Salesman> listSalesman = salesmanDAO.listAllSalesman();
		request.setAttribute("listSalesman", listSalesman);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormSalesman(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Salesman existingSalesman = salesmanDAO.getSalesman(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		request.setAttribute("salesman", existingSalesman);
		dispatcher.forward(request, response);

	}

	private void insertSalesman(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float commision = Float.parseFloat(request.getParameter("commision"));

		Salesman newSalesman = new Salesman(name, city, commision);
		salesmanDAO.insertSalesman(newSalesman);
		response.sendRedirect("listSalesman");
	}

	private void updateSalesman(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float commision = Float.parseFloat(request.getParameter("commision"));

		Salesman salesman = new Salesman(id, name, city, commision);
		salesmanDAO.updateSalesman(salesman);
		response.sendRedirect("listSalesman");
	}

	private void deleteSalesman(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Salesman salesman = new Salesman(id);
		salesmanDAO.deleteSalesman(salesman);
		response.sendRedirect("listSalesman");

	}
	
	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void creditos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("creditos.jsp");
		dispatcher.forward(request, response);
	}

}
