package br.com.vidal.estoque.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.estoque.service.EstoqueService;
import br.com.vidal.estoque.shared.EstoqueDto;
import br.com.vidal.estoque.view.model.AdicionarEstoque;
import br.com.vidal.estoque.view.model.EstoqueRequest;
import br.com.vidal.estoque.view.model.EstoqueResponse;
import br.com.vidal.estoque.view.model.RemoverEstoque;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/estoque")
@CrossOrigin
public class EstoqueController {
  @Autowired
  EstoqueService service;

  @GetMapping()
  public ResponseEntity<List<EstoqueResponse>> getRetornaTodos() {
    List<EstoqueDto> listaEstoqueDto = service.retornaTodos();

    if (listaEstoqueDto != null) {
      List<EstoqueResponse> listaEstoqueResponse = listaEstoqueDto.stream()
          .map(list -> new ModelMapper().map(list, EstoqueResponse.class)).collect(Collectors.toList());
      return new ResponseEntity<>(listaEstoqueResponse, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "/{codigoModelo}")
  @CrossOrigin
  public ResponseEntity<EstoqueResponse> retornaEstoquePorCodigoModelo(@PathVariable String codigoModelo) {
    EstoqueDto estoqueDto = service.retornaEstoquePorCodigoModelo(codigoModelo);

    if (estoqueDto != null) {
      return new ResponseEntity<>(new ModelMapper().map(estoqueDto, EstoqueResponse.class), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping()
  @CrossOrigin
  public ResponseEntity<EstoqueResponse> postgravarEstoque(@RequestBody EstoqueRequest request) {
    ModelMapper mapper = new ModelMapper();
    EstoqueDto estoqueDto = mapper.map(request, EstoqueDto.class);

    estoqueDto = service.gravarEstoque(estoqueDto);

    if (estoqueDto != null) {
      return new ResponseEntity<>(mapper.map(estoqueDto, EstoqueResponse.class), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "adicionar/{id}")
  @CrossOrigin
  public ResponseEntity<EstoqueResponse> putAdicionarEstoque(@PathVariable String id, @RequestBody AdicionarEstoque request) {
    Optional<EstoqueDto> estoqueRetornadoDoBancoDto = service.retornaEstoquePorId(id);

    if (estoqueRetornadoDoBancoDto.isPresent()) {      
      EstoqueDto estoqueDto = estoqueRetornadoDoBancoDto.get();      

      estoqueDto.setQuantidadeEstoque(estoqueDto.getQuantidadeEstoque() + request.getAdicionarEstoque());

      estoqueDto = service.gravarEstoque(estoqueDto);

      return new ResponseEntity<>(new ModelMapper().map(estoqueDto, EstoqueResponse.class), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
  }

  @PutMapping(value = "remover/{id}")
  @CrossOrigin
  public ResponseEntity<EstoqueResponse> putRemoverEstoque(@PathVariable String id, @RequestBody RemoverEstoque request) {
    Optional<EstoqueDto> estoqueRetornadoDoBancoDto = service.retornaEstoquePorId(id);

    if (estoqueRetornadoDoBancoDto.isPresent()) {      
      EstoqueDto estoqueDto = estoqueRetornadoDoBancoDto.get();      

      estoqueDto.setQuantidadeEstoque(estoqueDto.getQuantidadeEstoque() - request.getRemoverEstoque());

      estoqueDto = service.gravarEstoque(estoqueDto);

      return new ResponseEntity<>(new ModelMapper().map(estoqueDto, EstoqueResponse.class), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(value = "{id}")
  @CrossOrigin
  public ResponseEntity<Void> excluirEstoque(@PathVariable String id){
    Optional<EstoqueDto> estoqueRetornadoDoBancoDto = service.retornaEstoquePorId(id);

    if (estoqueRetornadoDoBancoDto.isPresent()) {      
      service.excluirEstoque(id);
      return new ResponseEntity<>(HttpStatus.OK);      
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  
  
}
