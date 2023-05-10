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
		request.setAttribute("fournisseurs", fournisseurSrv.getAll());
		rd = request.getRequestDispatcher("/WEB-INF/fournisseur/list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
