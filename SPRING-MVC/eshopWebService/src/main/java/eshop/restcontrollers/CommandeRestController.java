package eshop.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.model.ElementPanier;
import eshop.services.ClientService;
import eshop.services.CommandeService;
import eshop.services.ProduitService;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeSrv;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private ProduitService produitSrv;

	@PostMapping("/{idClient}")
	public Commande create(@PathVariable("idClient") Long idClient, @RequestBody List<ElementPanier> elements) {
		Client client = clientSrv.getById(idClient);
		//parcourir la liste elements
		//pour chaque element produitSrv.getById(idProduit)
		//put dans une Map<Produit,Integer>
		commandeSrv.create(client, null);
		return null;
	}
}
