<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>easyInvoice - Invoice Form</title>
</head>
<body>

<h1>easyInvoice - Invoice Form</h1>
<hr />
<br />
<br />
<br />

<form action="InvoicingDeptServlet"method="post">
<table>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Client:</div></td>
<td ><div><input type="text" name="client" size="60"></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Address:</div></td>
<td ><div><input type="Text" name="address" height="300"size="60"></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Date of Shipment:</div></td>
<td ><div><input type="text" name="DateShipment" size="60"></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Payment Due:</div></td>
<td ><div ><input type="text" name="PaymentDue" size="60" ></div></td>
</tr>
</table>
<hr/>
<!-- second block of the form -->
<table>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Product:</div></td>
<td ><div><input type="text" name="product" size="60"></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Quantity:</div></td>
<td ><div><input type="text" name="quantity" ></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Price:</div></td>
<td ><div><input type="text" name="price" >
<select name="currencyType">
  			<option value="CanadianDollar">CAD</option>
  			<option value="USDollar">USD</option>
		</select></div>
</td>
</tr>
</table>

<hr />
<!-- third block of form  Note these fields are to be read only!!!-->

<table>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Subtotal:</div></td>
<td width="500"><div><input type="text" name="subtotal" readonly ></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >GST(6%):</div></td>
<td width="500"><div><input type="text" name="gst" readonly ></div></td>
</tr>
<tr>
<td width="150"><div style="background-color:#6EA6E4 " >Total:</div></td>
<td width="500"><div><input type="text" name="total"readonly></div></td>
</tr>
<%
String errorValidation = (String)session.getAttribute("message");

if ( errorValidation != null)
{
	out.println("one of fields is missing");
}
%>
</table>
<div align="center"><input type="submit" value="Submit Invoice" ></div>
</form>
</body>
</html>