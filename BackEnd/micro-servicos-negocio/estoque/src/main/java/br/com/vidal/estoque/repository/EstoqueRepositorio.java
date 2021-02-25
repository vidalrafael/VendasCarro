package br.com.vidal.estoque.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vidal.estoque.model.Estoque;

@Repository
public interface EstoqueRepositorio extends MongoRepository<Estoque, String> {
  Estoque findByCodigoModelo(String codigoModelo);
}
