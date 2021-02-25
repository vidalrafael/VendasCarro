package br.com.vidal.estoque.service;

import java.util.List;
import java.util.Optional;

import br.com.vidal.estoque.shared.EstoqueDto;

public interface EstoqueService {
  List<EstoqueDto> retornaTodos();
  EstoqueDto retornaEstoquePorCodigoModelo(String codigoModelo);
  EstoqueDto gravarEstoque(EstoqueDto estoqueDto);
  Optional<EstoqueDto> retornaEstoquePorId(String id);
  void excluirEstoque(String id);
  
  
}
