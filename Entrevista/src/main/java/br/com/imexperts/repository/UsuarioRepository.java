package br.com.imexperts.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.imexperts.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
