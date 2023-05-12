package eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.entities.Fournisseur;
import eshop.entities.Produit;
import eshop.services.FournisseurService;


/**
 * Servlet implementation class FournisseurController
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private eshop.services.ProduitService produitSrv = null;
	private AnnotationConfigApplicationContext ctx = null;
	private FournisseurService fournisseurSrv = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		ctx = (AnnotationConfigApplicationContext) this.getServletContext().getAttribute("springCtx");
		produitSrv = ctx.getBean(eshop.services.ProduitService.class);
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
			info = "?update=" + produitSrv.update(getProduit(request)).getId();
		} else if (action.equals("create")) {
			info = "?create=" + produitSrv.create(getProduit(request)).getId();
		}
		response.sendRedirect("produit" + info);
	}

	private Produit getProduit(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		double prix = Double.parseDouble(request.getParameter("prix"));
		Fournisseur fournisseur = null;
		Produit produit = new Produit(nom, description, prix, fournisseur);

		if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			Long id = null;
			id = Long.parseLong(request.getParameter("id"));
			produit.setId(id);
		}
		if (request.getParameter("fournisseur.id") != null && !request.getParameter("fournisseur.id").isEmpty()) {
			produit.setFournisseur(fournisseurSrv.getById(Long.parseLong(request.getParameter("fournisseur.id"))));
		}
		return produit;
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("produits", produitSrv.getAll());
		return request.getRequestDispatcher("/WEB-INF/produit/list.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		produitSrv.delete(id);
		response.sendRedirect("produit?delete=" + id);
	}

	private RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("produit", produitSrv.getById(id));
		request.setAttribute("action", "update");
		return goForm(request, response);
	}

	private RequestDispatcher create(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("produit", new Produit());
		request.setAttribute("action", "create");
		return goForm(request, response);
	}

	private RequestDispatcher goForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseurs", fournisseurSrv.getAll());
		return request.getRequestDispatcher("/WEB-INF/produit/edit.jsp");
	}

}
