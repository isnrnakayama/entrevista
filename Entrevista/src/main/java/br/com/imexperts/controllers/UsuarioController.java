package br.com.imexperts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.imexperts.models.Usuario;
import br.com.imexperts.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping("/")
	String index() {
		System.out.println("Acessando página principal.");

		return "index";
	}

	@RequestMapping(value = "adicionar", method = RequestMethod.POST)
	String adicionar(@RequestParam("nome") String nome, @RequestParam("cpf") String cpf,
			@RequestParam("endereco") String endereco, @RequestParam("telefone") String telefone, Model model) {

		System.out.println(nome);
		Usuario usuario = new Usuario(nome, cpf, endereco, telefone);

		service.salvar(usuario);

		return "sucesso";
	}

	@RequestMapping("listarUsuarios")
	String listarUsuarios(Model model) {

		Iterable<Usuario> usuarios = service.obterTodos();

		model.addAttribute("usuarios", usuarios);
		
		return "listarusuarios";

	}

}
