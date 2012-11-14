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
@WebServlet("/SupplierManager")
public class SupplierManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hello World from Servlet!");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("txtFirst");
		String lastName = request.getParameter("txtLast");

		Name addName = new Name(firstName, lastName);

		ArrayList<Name> nameList = null;
		HttpSession session = request.getSession();

		if (!session.isNew()) {
			nameList = (ArrayList<Name>) session.getAttribute("StateName");
		} else {
			new ArrayList<Name>();
		}

		nameList.add(addName);
		session.setAttribute("StateName", nameList);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Name name : nameList) {
			out.println("<h1>Hello " + name.getFirstName() + " "
					+ name.getLastName() + "!!!!</h1>");
		}
		out.println("</body></html>");
		out.close();
	}

}
