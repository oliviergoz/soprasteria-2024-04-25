package formation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgeController
 */
@WebServlet("/age")
public class AgeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/formAge.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getParameter("age") != null && !request.getParameter("age").isEmpty()) {
			Integer age = Integer.parseInt(request.getParameter("age"));
			request.setAttribute("age", age);
			rd = request.getRequestDispatcher("/WEB-INF/age.jsp");
		} else {
			// le parametre est manquant=>probleme
			request.setAttribute("erreur", "il faut un age");
			rd = request.getRequestDispatcher("/WEB-INF/formAge.jsp");
		}
		rd.forward(request, response);
	}

}
