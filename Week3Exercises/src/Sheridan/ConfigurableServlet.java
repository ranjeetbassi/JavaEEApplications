package Sheridan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigurableServlet
 */
@WebServlet(asyncSupported = true, name = "ConfigurableServlet", urlPatterns = { "/ConfigurableServlet" }, initParams = {
		@WebInitParam(name = "Mood", value = ":-)"),
		@WebInitParam(name = "Mood1", value = ":-("),
		@WebInitParam(name = "Mood2", value = ";-(") })
public class ConfigurableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigurableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * @WebInitParam(name = "Mood1", value = ":-("),
		 * 
		 * @WebInitParam(name = "Mood2", value = ";-(")
		 */
		String servletoptions = request.getParameter("servletOptions");

		if (servletoptions.equals("BusyServlet")) {
			RequestDispatcher rd = request.getRequestDispatcher("BusyServlet");
			rd.forward(request, response);
		} else if (servletoptions.equals("KnowItAllServlet")) {
			RequestDispatcher rd = request
					.getRequestDispatcher("KnowItAllServlet");
			rd.forward(request, response);
		} else if (servletoptions.equals("SmartServlet")) {
			RequestDispatcher rd = request.getRequestDispatcher("SmartServlet");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
