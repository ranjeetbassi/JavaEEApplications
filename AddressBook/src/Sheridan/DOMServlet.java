package Sheridan;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

/**
 * Servlet implementation class DOMServlet
 */
@WebServlet("/DOMServlet")
public class DOMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADDRESS_BOOK_PIN = "addressbook";
	private String fullFilePath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DOMServlet() {
		super();
		String relativePath = "./WEB-INF/data/address-book.xml";
		fullFilePath = getServletContext().getRealPath(relativePath);
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			AddressBook addressBook = (AddressBook) session
					.getAttribute(ADDRESS_BOOK_PIN);
			if (addressBook == null) {
				// address book was never created and pinned so create a new one
				addressBook = new AddressBook();
				// ask the model to load the data
				addressBook.load(fullFilePath);
				// pin the model object to the session bulletin board
				session.setAttribute(ADDRESS_BOOK_PIN, addressBook);
			}
			// tell the view to display the model
			request.getRequestDispatcher("address-book-view.jsp").forward(
					request, response);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the HTTP parameters from the user
			String name = request.getParameter("txtName");
			String newEmail = request.getParameter("txtNewEmail");
			// get the address book from the bulletin board
			HttpSession session = request.getSession();
			AddressBook addressBook = (AddressBook) session
					.getAttribute(ADDRESS_BOOK_PIN);
			// tell the address book model object to change the email of the
			// given contact
			addressBook.changeContactEmail(name, newEmail);
			addressBook.save(fullFilePath);
			session.setAttribute(ADDRESS_BOOK_PIN, addressBook);
			// tell the view to display the model
			request.getRequestDispatcher("address-book-view.jsp").forward(
					request, response);
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
