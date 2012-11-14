package invoice;

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
 * Servlet implementation class InvoicingDeptServlet
 */
@WebServlet(description = "Invoice form submision", urlPatterns = { "/InvoicingDeptServlet" })
public class InvoicingDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	ArrayList<Invoice> InvoiceList = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvoicingDeptServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// getting Paramaters from Invoiceform.jsp
		String client = request.getParameter("client");
		String address = request.getParameter("address");
		String dateofShipment = request.getParameter("DateShipment");
		String PaymentDue = request.getParameter("PaymentDue");
		String product = request.getParameter("product");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");

		// input validations
		/*
		 * if (client.equals("") || address.equals("") ||
		 * dateofShipment.equals("") || PaymentDue.equals("") ||
		 * product.equals("") || quantity.equals("") ||
		 * (Integer.parseInt(quantity) > 0) || price.equals("") ||
		 * (Double.parseDouble(price) > 0)) { String errorValidation =
		 * "One of the fields are incorrect"; request.setAttribute("messages",
		 * errorValidation);
		 * request.getRequestDispatcher("invoiceForm.jsp").forward(request,
		 * response); }
		 */

		// calculation of subtotal, gst, and total
		double subtotal = Double.parseDouble(price)
				* Integer.parseInt(quantity);
		final double gst = 1 / 6;
		double gstCalculation = gst * subtotal;
		double total = gstCalculation + subtotal;

		// instanting Invoice object after getting the subtotal, gst, and total
		Invoice newInvoice = new Invoice(client, address, dateofShipment,
				PaymentDue, product, quantity, price, subtotal, gstCalculation,
				total);

		// reason why I had this try and catch block was because the primary
		// cause of the error of the null pointer exception
		// is because the session is null or is that the arraylist is null
		// when i had restarted my laptop , it seems to work fine now.

		session = request.getSession(true);

		if (!session.isNew()) {
			InvoiceList = (ArrayList<Invoice>) session.getAttribute("Invoice");
		} else {
			InvoiceList = new ArrayList<Invoice>();
		}
		InvoiceList.add(newInvoice);
		session.setAttribute("Invoice", InvoiceList);
		PrintWriter out = response.getWriter();
		out.println("<html><body");
		out.println("<table>");
		out.println("<tr>");
		for (Invoice invoice : InvoiceList) {
			out.println("<td>" + invoice.getClient() + "</td>");
			out.println("<td>" + invoice.getAddress() + "</td>");
			out.println("<td>" + invoice.getDateofShipment() + "</td>");
			out.println("<td>" + invoice.getQuantity() + "</td>");
			out.println("<td>" + invoice.getPrice() + "</td>");
		}
		out.println("</tr>");
		out.println("<table>");
		out.println("</body></html>");

		/*
		 * RequestDispatcher dispatcher = request
		 * .getRequestDispatcher("invoiceBinder.jsp");
		 * dispatcher.forward(request, response);
		 */

		// send the data into the list of outstanding invoices

		/*
		 * PrintWriter out = response.getWriter(); out.println("<html><body");
		 * out.println("<table>"); out.println("<tr>"); out.println("<td>");
		 * out.println("Inovice No:"); out.println("</td>");
		 * out.println("<td>"); out.println("Client"); out.println("</td>");
		 * out.println("<td>"); out.println("Total"); out.println("</td>");
		 * out.println("<td>"); out.println("Payment Due Date");
		 * out.println("</td>"); out.println("</tr>"); for (Invoice invoice :
		 * InvoiceList) {
		 * 
		 * out.println("<tr>"); out.println("<td>"); out.println("1");
		 * out.println("</td>"); out.println("<td>");
		 * out.println("invoice.getClient()"); out.println("</td>");
		 * out.println("<td>"); out.println("total"); out.println("</td>");
		 * out.println("<td>"); out.println("payment"); out.println("</td>");
		 * out.println("</tr>"); } out.println("</table>");
		 * out.println("</body></html>");
		 */
	}

}
