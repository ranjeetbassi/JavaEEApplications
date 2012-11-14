package Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupplierManager
 */
/*
 * Part 2 of the week 2 exercises asked whether when you get the link to of the
 * servlet and reenter it again , would you be able to to get the same values
 * again.
 * 
 * The answer is No. When you enter the link to the servlet again without no
 * parameters, the servlet page will show null for the full name and the phone
 * number.
 */
/*
 * Part 3 of the question exercises asked to run the program again through
 * eclipse without closing the first browser view. What happened?
 * 
 * It would enter the last full name and phone number that you have entered.
 * 
 * While an Eclipse browser view is open, copy and paste the URL of your XHTML
 * page to a real browser of your choice. Add a few suppliers. What happened
 * this time? why?
 * 
 * When I had ran the application through the eclipse browser, i was able to
 * enter the full name and the phone number repeatedly. However when I opened
 * another browser and typed in the link and entered the full name and phone
 * number , you will not able to see the other information that you had typed in
 * the eclipse browser. But rather a new session has been created and a new list
 * of names and phone numbers will be generated.
 */
@WebServlet(description = "retrives the name and the phone number to process into a table like format.", urlPatterns = { "/SupplierManager" })
public class SupplierManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SupplierInfo> SupplierList = null;
	HttpSession session = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupplierManager() {
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
		String fullName = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneN");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Full Name:</td>");
		out.println("<td>" + fullName + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Phone Number:</td>");
		out.println("<td>" + phoneNumber + "</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</html></body>");
		/*
		 * out.println("<html><body>"); out.println(
		 * "<h1>I am your friendly neighbourhood supplier directory!</h1>");
		 * out.println("</html></body>");
		 */
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneN");
		SupplierInfo newsSupplier = new SupplierInfo(fullName, phoneNumber);
		session = request.getSession(true);
		if (!session.isNew()) {
			SupplierList = (ArrayList<SupplierInfo>) session
					.getAttribute("SupplierList.POJOList");
		} else {
			SupplierList = new ArrayList<SupplierInfo>();
		}
		SupplierList.add(newsSupplier);
		session.setAttribute("SupplierList.POJOList", SupplierList);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<table>");
		for (SupplierInfo Supplier : SupplierList) {
			out.println("<tr>");
			out.println("<td>Full Name:</td>");
			out.println("<td>" + Supplier.getFullName() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Phone Number:</td>");
			out.println("<td>" + Supplier.getPhoneNumber() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</html></body>");
		out.close();

	}
}
