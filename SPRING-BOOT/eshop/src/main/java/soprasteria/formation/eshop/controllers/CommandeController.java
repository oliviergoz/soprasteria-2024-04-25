package soprasteria.formation.eshop.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.services.ClientService;
import soprasteria.formation.eshop.services.CommandeService;
import soprasteria.formation.eshop.services.ProduitService;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	private ProduitService produitSrv;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private CommandeService commandeSrv;

	@GetMapping("/commander")
	public String produits(Model model) {
		model.addAttribute("produits", produitSrv.getAll());
		return "commande/commander";
	}

	@GetMapping("/panier/add")
	public String add(@RequestParam("id") Long id, HttpSession session) {
		Produit produit = produitSrv.getById(id);

		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + 1);
		} else {
			panier.put(produit, 1);
		}
		return "redirect:/commande/commander";
	}

	@GetMapping("/panier/remove")
	public String remove(@RequestParam("id") Long id, HttpSession session) {
		Produit produit = produitSrv.getById(id);

		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");

		if (panier.get(produit) == 1) {
			panier.remove(produit);
		} else {
			panier.put(produit, panier.get(produit) - 1);
		}
		return "redirect:/commande/commander";
	}

	@GetMapping("/client")
	public String clients(Model model) {
		model.addAttribute("clients", clientSrv.getAll());
		return "commande/client";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") Long idClient, HttpSession session, Model model) {
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Client client = clientSrv.getById(idClient);
		model.addAttribute("commande", commandeSrv.create(client, panier));
		session.invalidate();
		return "commande/confirm";
	}
}
