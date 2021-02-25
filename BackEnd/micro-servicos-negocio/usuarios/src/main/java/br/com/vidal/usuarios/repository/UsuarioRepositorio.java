package br.com.vidal.usuarios.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vidal.usuarios.model.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario,String> {
    Usuario findByCpf(String cpf);
    List<Usuario> findByNomeContaining(String nome);
    List<Usuario> findAllByOrderByNomeAsc(); 
    List<Usuario> findAllByOrderByNomeDesc();    
}
