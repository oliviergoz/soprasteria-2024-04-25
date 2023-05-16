package eshop.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.entities.Produit;
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
//		Map<Produit,Integer > panier=new HashMap<>();
//		elements.forEach(e->{
//			panier.put(produitSrv.getById(e.getIdProduit()),e.getQuantite());
//		});
		
		Map<Produit,Integer > panier=elements.stream().collect(Collectors.toMap((e)->produitSrv.getById(e.getIdProduit()),ElementPanier::getQuantite));
		return commandeSrv.create(client, panier);
	}
}
