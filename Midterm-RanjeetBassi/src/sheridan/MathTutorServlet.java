package sheridan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MathTutorServlet
 */
@WebServlet("/MathTutorServlet")
public class MathTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<MathEquation> mathEquationList = null;
	HttpSession session = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MathTutorServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int firstNumber = Integer.parseInt(request.getParameter("firstnumber"));
		String operand = request.getParameter("equation");
		int secondNumber = Integer.parseInt(request
				.getParameter("secondnumber"));

		int result = Integer.parseInt(request.getParameter("mathanswer"));
		MathEquation newEquation = new MathEquation(firstNumber, operand,
				secondNumber, result);

		session = request.getSession(true);

		if (!session.isNew()) {
			mathEquationList = (ArrayList<MathEquation>) session
					.getAttribute("equation");
		} else {
			mathEquationList = new ArrayList<MathEquation>();
		}

		mathEquationList.add(newEquation);
		session.setAttribute("equation", mathEquationList);
		/*
		 * PrintWriter out = response.getWriter();
		 * out.println("the first number is " + newEquation.getFirstNumber());
		 * out.println("the operand is " + newEquation.getOperand());
		 * out.println("the second number is " + newEquation.getSecondNumber());
		 * out.println("the final answer is" + newEquation.getFinalAnswer());
		 * out.close();
		 */
		RequestDispatcher rd = request.getRequestDispatcher("math-test.jsp");
		rd.forward(request, response);

	}

}
