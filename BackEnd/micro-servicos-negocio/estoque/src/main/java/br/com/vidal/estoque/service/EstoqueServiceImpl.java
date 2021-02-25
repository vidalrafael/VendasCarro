package br.com.vidal.estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidal.estoque.model.Estoque;
import br.com.vidal.estoque.repository.EstoqueRepositorio;
import br.com.vidal.estoque.shared.EstoqueDto;

@Service
public class EstoqueServiceImpl implements EstoqueService {
  @Autowired
  EstoqueRepositorio repositorio;

  @Override
  public List<EstoqueDto> retornaTodos() {
    List<Estoque> listaEstoque = repositorio.findAll();

    if (listaEstoque.isEmpty()) {
      return null;
    }

    List<EstoqueDto> listaEstoqueDto = listaEstoque.stream().map(list -> new ModelMapper().map(list, EstoqueDto.class))
        .collect(Collectors.toList());
    return listaEstoqueDto;
  }

  @Override
  public EstoqueDto retornaEstoquePorCodigoModelo(String codigoModelo) {
    Estoque estoque = repositorio.findByCodigoModelo(codigoModelo);

    if (estoque != null) {
      return new ModelMapper().map(estoque, EstoqueDto.class);
    }

    return null;
  }

  @Override
  public EstoqueDto gravarEstoque(EstoqueDto estoqueDto) {
    ModelMapper mapper = new ModelMapper();
    Estoque estoque = repositorio.save(mapper.map(estoqueDto, Estoque.class));

    if (estoque != null) {
      return mapper.map(estoque, EstoqueDto.class);
    }

    return null;
  }

  @Override
  public Optional<EstoqueDto> retornaEstoquePorId(String id) {
    Optional<Estoque> estoque = repositorio.findById(id);

    if (estoque.isPresent()) {
      return Optional.of(new ModelMapper().map(estoque.get(), EstoqueDto.class));
    }

    return Optional.empty();
  }

  @Override
  public void excluirEstoque(String id) {
    repositorio.deleteById(id);

  }
  

  

}
