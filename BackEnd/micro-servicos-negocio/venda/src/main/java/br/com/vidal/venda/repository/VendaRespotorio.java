package br.com.vidal.venda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vidal.venda.model.Venda;

@Repository
public interface VendaRespotorio extends MongoRepository<Venda, String> {
  List<Venda> findByCodigoUsuarioComprador(String codigoUsuarioComprador);
  List<Venda> findByDataVendaBetweenOrderByDataVendaAsc(LocalDate dataInicial, LocalDate dataFinal);
  List<Venda> findByDataVendaBetweenOrderByDataVendaDesc(LocalDate dataInicial, LocalDate dataFinal);

}
