package soprasteria.formation.eshop.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.jsonviews.JsonViews;
import soprasteria.formation.eshop.services.ClientService;
import soprasteria.formation.eshop.services.CompteService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestController {

	@Autowired
	private ClientService clientSrv;
	@Autowired
	private CompteService compteSrv;

	@GetMapping("/login/{login}")
	public boolean loginExist(@PathVariable String login){
		return compteSrv.loginExist(login);
	}

	@GetMapping("")
	@JsonView(JsonViews.Client.class)
	public List<Client> getAll() {
		return clientSrv.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client getById(@PathVariable("id") Long id) {
		return clientSrv.getById(id);
	}

	@GetMapping("/{id}/commandes")
	@JsonView(JsonViews.ClientWithCommandes.class)
	public Client getByIdWithProduits(@PathVariable("id") Long id) {
		return clientSrv.getByIdWithCommandes(id);
	}

	@GetMapping("/nom/{nom}")
	@JsonView(JsonViews.Client.class)
	public List<Client> getByNom(@PathVariable String nom) {
		return clientSrv.getByNom(nom);
	}

	@PostMapping({ "", "/inscription" })
	@JsonView(JsonViews.Client.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return clientSrv.create(client);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client update(@Valid @RequestBody Client client, BindingResult br, @PathVariable Long id) {
		client.setId(id);
		return clientSrv.update(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientSrv.delete(id);
	}
}
