package eshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Client;
import eshop.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("clients", clientSrv.getAll());
		return "client/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id, Model model) {
		clientSrv.delete(id);
		model.addAttribute("delete", id);
		return "redirect:/client";
	}

	@GetMapping("/edit")
	public String update(@RequestParam("id") Long id, Model model) {
		return goForm(clientSrv.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Client(), model);
	}

	private String goForm(Client client, Model model) {
		model.addAttribute("client", client);
		return "client/edit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Client client,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goForm(client,model);
		}
		if (client.getId() == null) {
			client = clientSrv.create(client);
			model.addAttribute("create", client.getId() );
		} else {
			client = clientSrv.update(client);
			model.addAttribute("update", client.getId());
		}
		return "redirect:/client";
	}

}
