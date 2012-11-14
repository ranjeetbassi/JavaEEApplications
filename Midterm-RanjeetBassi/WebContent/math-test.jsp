<%@ page import = "sheridan.*,java.io.IOException,java.io.PrintWriter,java.util.ArrayList,javax.servlet.RequestDispatcher,javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpSession" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<%
PrintWriter out1 = response.getWriter();
out1.println("Student Name: Ranjeet Bassi");
out1.println("<h2>Math Test </h2>");
ArrayList<MathEquation> mathEquationList = (ArrayList<MathEquation>)session.getAttribute("equation");



for(MathEquation newEquation:mathEquationList)
{
	
	out1.println("<h5>"+newEquation.getFirstNumber()+" "+newEquation.getOperand()+" "+newEquation.getSecondNumber()+"="+newEquation.getFinalAnswer()+"<h5>");
	if(newEquation.equals("+"))
	{
		int finalanswer = newEquation.getFirstNumber()+newEquation.getSecondNumber();
	}else if(newEquation.equals("-"))
	{
		int finalanswer = newEquation.getFirstNumber()-newEquation.getSecondNumber();
	}
	
}
out1.println("<a href=math-question-answer.html>Next Question</a>");

out1.close();

%>
</body>
</html>