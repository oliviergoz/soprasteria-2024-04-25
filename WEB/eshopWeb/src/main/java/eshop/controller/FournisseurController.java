package eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.configurations.JpaConfig;
import eshop.entities.Adresse;
import eshop.entities.Fournisseur;
import eshop.services.FournisseurService;

/**
 * Servlet implementation class FournisseurController
 */
@WebServlet("/fournisseur")
public class FournisseurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FournisseurService fournisseurSrv = null;
	private AnnotationConfigApplicationContext ctx = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FournisseurController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		ctx = (AnnotationConfigApplicationContext) this.getServletContext().getAttribute("springCtx");
		fournisseurSrv = ctx.getBean(FournisseurService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String query = request.getParameter("q");
		if (query == null || query.isEmpty()) {
			// liste des fournisseurs
			rd = list(request, response);
		} else if (query.equals("delete")) {
			delete(request, response);
		} else if (query.equals("update")) {
			rd = update(request, response);
		} else if (query.equals("add")) {
			rd = create(request, response);
		} else {
			// query pas gere
		}
		if (request.getParameter("delete") != null) {
			request.setAttribute("delete", request.getParameter("delete"));
		}
		if (request.getParameter("create") != null) {
			request.setAttribute("create", request.getParameter("create"));
		}
		if (request.getParameter("update") != null) {
			request.setAttribute("update", request.getParameter("update"));
		}

		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		String info = null;
		if (action.equals("update")) {
			info = "?update=" + fournisseurSrv.update(getFournisseur(request)).getId();
		} else if (action.equals("create")) {
			info = "?create=" + fournisseurSrv.create(getFournisseur(request)).getId();
		}
		response.sendRedirect("fournisseur" + info);
	}

	private Fournisseur getFournisseur(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String contact = request.getParameter("contact");
		String numero = request.getParameter("adresse.numero");
		String rue = request.getParameter("adresse.rue");
		String codePostal = request.getParameter("adresse.codePostal");
		String ville = request.getParameter("adresse.ville");
		Fournisseur fournisseur = new Fournisseur(nom, new Adresse(numero, rue, codePostal, ville), contact);
		if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			Long id = null;
			id = Long.parseLong(request.getParameter("id"));
			fournisseur.setId(id);
		}
		return fournisseur;
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseurs", fournisseurSrv.getAll());
		return request.getRequestDispatcher("/WEB-INF/fournisseur/list.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		fournisseurSrv.delete(id);
		response.sendRedirect("fournisseur?delete=" + id);
	}

	private RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("fournisseur", fournisseurSrv.getById(id));
		request.setAttribute("action", "update");
		return goForm(request, response);
	}

	private RequestDispatcher create(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseur", new Fournisseur());
		request.setAttribute("action", "create");
		return goForm(request, response);
	}

	private RequestDispatcher goForm(HttpServletRequest request, HttpServletResponse response) {
		return request.getRequestDispatcher("/WEB-INF/fournisseur/edit.jsp");
	}

}
