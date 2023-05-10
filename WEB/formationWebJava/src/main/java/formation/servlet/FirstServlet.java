package formation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String ageEnString = request.getParameter("age");
		Integer age = 0;
		if (ageEnString != null) {
			age = Integer.parseInt(ageEnString);
		}
		response.getWriter().append("<!DOCTYPE html>")
							.append("<html>").append("<head>")
							.append("<meta charset=\"UTF-8\">")
							.append("<title>formation</title>")
							.append("</head>")
							.append("<body>")
							.append("<h1>bonjour " + prenom + ", age: " + age + "</h1>");
		if (age < 18) {
			response.getWriter().append(" mineur");
		} else {
			response.getWriter().append(" majeur");
		}

		response.getWriter().append("</body>").append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
