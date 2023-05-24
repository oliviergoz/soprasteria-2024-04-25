package soprasteria.formation.eshop.restcontrollers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.Commande;
import soprasteria.formation.eshop.entities.Compte;
import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.entities.jsonviews.JsonViews;
import soprasteria.formation.eshop.model.ElementPanier;
import soprasteria.formation.eshop.services.ClientService;
import soprasteria.formation.eshop.services.CommandeService;
import soprasteria.formation.eshop.services.ProduitService;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeSrv;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private ProduitService produitSrv;

	@PostMapping("")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@AuthenticationPrincipal Compte compte, @RequestBody List<ElementPanier> elements) {
		Client client =compte.getClient();

		Map<Produit, Integer> panier = elements.stream()
				.collect(Collectors.toMap((e) -> produitSrv.getById(e.getIdProduit()), ElementPanier::getQuantite));
		return commandeSrv.create(client, panier);
	}
}
