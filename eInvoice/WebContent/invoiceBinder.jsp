<%@ page language="java" import="java.util.* ,java.io.IOException,
java.io.PrintWriter,
java.util.ArrayList,

javax.servlet.RequestDispatcher,
javax.servlet.ServletException,
javax.servlet.annotation.WebServlet,
javax.servlet.http.HttpServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
javax.servlet.http.HttpSession,
invoice.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>easyInvoice - outstanding Invoices</title>
</head>
<body>

<h1>easyInvoice - Outstanding Invoices</h1>
<hr />
<br />
<br />
<br />
<!-- I am not sure why I am having a problem importing the Invoice.I thought I had imported all the libraries. -->
<% 

ArrayList<Invoice> newInvoice = (ArrayList<Invoice>)session.getAttribute("statename");
	int i = 0;
if(newInvoice != null) {
	
	
	out.println("<table bgcolor=#6EA6E4>");
	out.println("<tr>");
	out.println("<td>Invoice No.</td>");
	out.println("<td>Client</td>");
	out.println("<td>Total</td>");
	out.println("<td>Payment</td>");
	out.println("</tr>");
	 for(Invoice invoice:newInvoice)
	{
		out.println("<tr>");
		out.println("<td>"+(i++)+"</td>");
		out.println("<td>"+invoice.getClient()+"</td>");
		out.println("<td>"+invoice.getTotal()+"</td>");
		out.println("<td>"+invoice.getPaymentdue()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	
	
}else{
	out.println("<h1> Nothing to be displayed.</h1>");
}
%>

<table bgcolor="#6EA6E4">
<tr >
<td>Total Receivables</td>
<td width="200"><a href="invoiceForm.jsp">Add Invoices</a></td>
<td width="200"><a href="errorPage.jsp">Save Invoices</a></td>
<td width="200"><a href="index.html">eInvoice Home</a></td>
</tr>

</table>
</body>
</html>