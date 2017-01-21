package br.com.imexperts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.imexperts.models.Usuario;
import br.com.imexperts.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Iterable<Usuario> obterTodos() {

		Iterable<Usuario> convidados = repository.findAll();

		return convidados;

	}

	public void salvar(Usuario usuario) {
		
		repository.save(usuario);
	}

}
