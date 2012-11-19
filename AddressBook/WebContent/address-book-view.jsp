<%@ page import = "Sheridan.*,java.io.IOException,java.io.PrintWriter,java.util.ArrayList,javax.servlet.RequestDispatcher,javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpSession"language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 3</title>
</head>
<body>

<%
PrintWriter out1= response.getWriter();
AddressBook addressBook = (AddressBook) session.getAttribute("addressbook");
 
if(addressBook!=null){
	out1.println("<table>");
	out1.println("<tr>");
	out1.println("<td>Name</td>");
	out1.println("<td>Email</td>");
	out1.println("<td>Phone</td>");
	out1.println("<td>Address</td>");
	out1.println("</tr>");
	ArrayList<Contact> contactList= addressBook.getContactList();
	for(Contact contact:contactList)
	{
		out1.println("<tr>");
		out1.println("<td>"+contact.getName()+"</td>");
		out1.println("<td>"+contact.getEmail()+"</td>");
		out1.println("<td>"+contact.getPhone()+"</td>");
		out1.println("<td>"+contact.getAddress()+"</td>");
		out1.println("</tr>");
	}
	out1.println("</table>");
}else{
	out1.println("Nothing to be displayed");
}
%>
</table>
<a href=./change-contact.xhtml>Change Contact</a>
</body>
</html>