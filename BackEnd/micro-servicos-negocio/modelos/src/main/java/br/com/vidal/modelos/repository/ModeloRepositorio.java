package br.com.vidal.modelos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vidal.modelos.model.Modelo;

@Repository
public interface ModeloRepositorio extends MongoRepository<Modelo, String>{
  Optional<Modelo> findByCodigo(String codigo);
  List<Modelo> findByMarca(String marca);
  List<Modelo> findByModeloContaining(String nome);
  List<Modelo> findAllByOrderByCodigoAsc(); 
  List<Modelo> findAllByOrderByCodigoDesc();

}
