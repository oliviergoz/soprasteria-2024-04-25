package formation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formation.model.Utilisateur;

/**
 * Servlet implementation class InscriptionController
 */
@WebServlet("/inscription")
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/inscription/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		RequestDispatcher rd = null;
		if (prenom == null || prenom.isEmpty() || nom == null || nom.isEmpty() || login == null || login.isEmpty()) {
			request.setAttribute("erreur", true);
			rd = request.getRequestDispatcher("/WEB-INF/inscription/form.jsp");
		} else {
			request.setAttribute("utilisateur", new Utilisateur(prenom, nom, login));
			rd = request.getRequestDispatcher("/WEB-INF/inscription/display.jsp");
		}
		rd.forward(request, response);
	}

}
