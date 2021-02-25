package br.com.vidal.modelos.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.vidal.modelos.service.ModeloService;
import br.com.vidal.modelos.shared.ModeloDto;
import br.com.vidal.modelos.view.model.ModeloRequest;
import br.com.vidal.modelos.view.model.ModeloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/modelos")
@CrossOrigin
public class ModeloController {
  @Autowired
  ModeloService service;

  @GetMapping(value = "todos/{ordem}")
  @CrossOrigin
  public ResponseEntity<List<ModeloResponse>> getRetornaTodos(@PathVariable String ordem) {
    List<ModeloDto> listaModeloDto = service.retornaTodos(ordem);

    if (listaModeloDto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    List<ModeloResponse> listaModeloResponse = listaModeloDto.stream()
                                              .map(list -> new ModelMapper().map(list, ModeloResponse.class))
                                              .collect(Collectors.toList());

    return new ResponseEntity<>(listaModeloResponse, HttpStatus.OK);
  }

  @GetMapping(value = "/{codigo}")
  @CrossOrigin
  public ResponseEntity<ModeloResponse> getRetornaPorCodigo(@PathVariable String codigo) {
    Optional<ModeloDto> modeloDto = service.retornaPorCodigo(codigo);

    if (modeloDto.isPresent()) {
      return new ResponseEntity<>(new ModelMapper().map(modeloDto.get(), ModeloResponse.class), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "marca/{marca}")
  @CrossOrigin
  public ResponseEntity<List<ModeloResponse>> getRetornaPorMarca(@PathVariable String marca) {
    List<ModeloDto> listaModeloDto = service.retornaPorMarca(marca);

    if (listaModeloDto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    List<ModeloResponse> listaModeloResponse = listaModeloDto.stream()
                                              .map(list -> new ModelMapper().map(list, ModeloResponse.class))
                                              .collect(Collectors.toList());

    return new ResponseEntity<>(listaModeloResponse, HttpStatus.OK);    
  }

  @GetMapping(value = "modelo/{modelo}")
  @CrossOrigin
  public ResponseEntity<List<ModeloResponse>> getRetornaPorParteDoNomeModelo(@PathVariable String modelo) {
    List<ModeloDto> listaModeloDto = service.retornaPorParteDoNomeModelo(modelo);

    if (listaModeloDto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    List<ModeloResponse> listaModeloResponse = listaModeloDto.stream()
                                              .map(list -> new ModelMapper().map(list, ModeloResponse.class))
                                              .collect(Collectors.toList());

    return new ResponseEntity<>(listaModeloResponse, HttpStatus.OK);    
  }

  @PostMapping()
  @CrossOrigin
  public ResponseEntity<ModeloResponse> postGravarModelo(@RequestBody ModeloRequest request) {
    
    if (service.verificaExistenciaCodigoModelo(request.getCodigo())) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    ModelMapper mapper = new ModelMapper();
    ModeloDto modeloDto = mapper.map(request, ModeloDto.class);
    modeloDto = service.gravarModelo(modeloDto);

    if (modeloDto != null) {
      return new ResponseEntity<>(mapper.map(modeloDto, ModeloResponse.class), HttpStatus.CREATED);
    }

    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
  }

  @PutMapping(value="{id}")
  @CrossOrigin
  public ResponseEntity<ModeloResponse> putAlterarModelo(@PathVariable String id, @RequestBody ModeloRequest request) {
    Optional<ModeloDto> modeloRetornadoDoBancoDto = service.retornaPorId(id);

    if (modeloRetornadoDoBancoDto.isPresent()) {
      ModelMapper mapper = new ModelMapper();
      ModeloDto modeloDto = mapper.map(request, ModeloDto.class);
       
      //#region montagem do objeto modeloDto para atulizar no banco
      modeloDto.setId(modeloRetornadoDoBancoDto.get().getId());
      modeloDto.setCodigo(modeloRetornadoDoBancoDto.get().getCodigo());

      if (modeloDto.getPreco() == null) {
        modeloDto.setPreco(modeloRetornadoDoBancoDto.get().getPreco());
      }

      if (modeloDto.getModelo() == null) {
        modeloDto.setModelo(modeloRetornadoDoBancoDto.get().getModelo());
      }

      if (modeloDto.getMarca() == null) {
        modeloDto.setMarca(modeloRetornadoDoBancoDto.get().getMarca());
      }

      if (modeloDto.getAno() == null) {
        modeloDto.setAno(modeloRetornadoDoBancoDto.get().getAno());
      }

      if (modeloDto.getCombustivel() == null) {
        modeloDto.setCombustivel(modeloRetornadoDoBancoDto.get().getCombustivel());
      }      

      if (modeloDto.getGarantia() == null) {
        modeloDto.setGarantia(modeloRetornadoDoBancoDto.get().getGarantia());
      }

      if (modeloDto.getQuantidadeLugares() == null) {
        modeloDto.setQuantidadeLugares(modeloRetornadoDoBancoDto.get().getQuantidadeLugares());
      }

      if (modeloDto.getQuantidadePortas() == null) {
        modeloDto.setQuantidadePortas(modeloRetornadoDoBancoDto.get().getQuantidadePortas());
      }

      if (modeloDto.getIpva() == null) {
        modeloDto.setIpva(modeloRetornadoDoBancoDto.get().getIpva());
      }

      if (modeloDto.getVelocidadeMaxima() == null) {
        modeloDto.setVelocidadeMaxima(modeloRetornadoDoBancoDto.get().getVelocidadeMaxima());
      }

      if (modeloDto.getAceleracao() == null) {
        modeloDto.setAceleracao(modeloRetornadoDoBancoDto.get().getAceleracao());
      }

      if (modeloDto.getCilindros() == null) {
        modeloDto.setCilindros(modeloRetornadoDoBancoDto.get().getCilindros());
      }

      if (modeloDto.getValvulasPorCilindro() == null) {
        modeloDto.setValvulasPorCilindro(modeloRetornadoDoBancoDto.get().getValvulasPorCilindro());
      }

      if (modeloDto.getCilindradas() == null) {
        modeloDto.setCilindradas(modeloRetornadoDoBancoDto.get().getCilindradas());
      }

      if (modeloDto.getPesoPotencia() == null) {
        modeloDto.setPesoPotencia(modeloRetornadoDoBancoDto.get().getPesoPotencia());
      }

      if (modeloDto.getPesoTorque() == null) {
        modeloDto.setPesoTorque(modeloRetornadoDoBancoDto.get().getPesoTorque());
      }

      if (modeloDto.getAspiracao() == null) {
        modeloDto.setAspiracao(modeloRetornadoDoBancoDto.get().getAspiracao());
      }

      if (modeloDto.getAlimentacao() == null) {
        modeloDto.setAlimentacao(modeloRetornadoDoBancoDto.get().getAlimentacao());
      }

      if (modeloDto.getComandoValvulas() == null) {
        modeloDto.setComandoValvulas(modeloRetornadoDoBancoDto.get().getComandoValvulas());
      }

      if (modeloDto.getVariacaoComando() == null) {
        modeloDto.setVariacaoComando(modeloRetornadoDoBancoDto.get().getVariacaoComando());
      }

      if (modeloDto.getDiametroCilindros() == null) {
        modeloDto.setDiametroCilindros(modeloRetornadoDoBancoDto.get().getDiametroCilindros());
      }

      if (modeloDto.getCursoPistoes() == null) {
        modeloDto.setCursoPistoes(modeloRetornadoDoBancoDto.get().getCursoPistoes());
      }

      if (modeloDto.getPotenciaMaxima() == null) {
        modeloDto.setPotenciaMaxima(modeloRetornadoDoBancoDto.get().getPotenciaMaxima());
      }

      if (modeloDto.getTorqueMaximo() == null) {
        modeloDto.setTorqueMaximo(modeloRetornadoDoBancoDto.get().getTorqueMaximo());
      }

      if (modeloDto.getConsumoCidade() == null) {
        modeloDto.setConsumoCidade(modeloRetornadoDoBancoDto.get().getConsumoCidade());
      }

      if (modeloDto.getConsumoEstrada() == null) {
        modeloDto.setConsumoEstrada(modeloRetornadoDoBancoDto.get().getConsumoEstrada());
      }

      if (modeloDto.getCambio() == null) {
        modeloDto.setCambio(modeloRetornadoDoBancoDto.get().getCambio());
      }

      if (modeloDto.getAcoplamento() == null) {
        modeloDto.setAcoplamento(modeloRetornadoDoBancoDto.get().getAcoplamento());
      }

      if (modeloDto.getSuspensaoDianteira() == null) {
        modeloDto.setSuspensaoDianteira(modeloRetornadoDoBancoDto.get().getSuspensaoDianteira());
      }

      if (modeloDto.getsuspensaoTraseira() == null) {
        modeloDto.setsuspensaoTraseira(modeloRetornadoDoBancoDto.get().getsuspensaoTraseira());
      }

      if (modeloDto.getFreiosDianteiros() == null) {
        modeloDto.setFreiosDianteiros(modeloRetornadoDoBancoDto.get().getFreiosDianteiros());
      }

      if (modeloDto.getFreiosTraseiros() == null) {
        modeloDto.setFreiosTraseiros(modeloRetornadoDoBancoDto.get().getFreiosTraseiros());
      }

      if (modeloDto.getComprimento() == null) {
        modeloDto.setComprimento(modeloRetornadoDoBancoDto.get().getComprimento());
      }

      if (modeloDto.getLargura() == null) {
        modeloDto.setLargura(modeloRetornadoDoBancoDto.get().getLargura());
      }

      if (modeloDto.getAltura() == null) {
        modeloDto.setAltura(modeloRetornadoDoBancoDto.get().getAltura());
      }

      if (modeloDto.getDistanciaEntreEixos() == null) {
        modeloDto.setDistanciaEntreEixos(modeloRetornadoDoBancoDto.get().getDistanciaEntreEixos());
      }

      if (modeloDto.getTanqueCombustivel() == null) {
        modeloDto.setTanqueCombustivel(modeloRetornadoDoBancoDto.get().getTanqueCombustivel());
      }

      if (modeloDto.getPortaMalas() == null) {
        modeloDto.setPortaMalas(modeloRetornadoDoBancoDto.get().getPortaMalas());
      }

      if (modeloDto.getPeso() == null) {
        modeloDto.setPeso(modeloRetornadoDoBancoDto.get().getPeso());
      }
      //#endregion

      modeloDto = service.gravarModelo(modeloDto);

      return new ResponseEntity<>(mapper.map(modeloDto, ModeloResponse.class), HttpStatus.OK);      
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);      
  }

  @DeleteMapping(value = "{id}")
  @CrossOrigin
  public ResponseEntity<Void> excluirModelo(@PathVariable String id){
    Optional<ModeloDto> modeloRetornadoDoBancoDto = service.retornaPorId(id);

    if (modeloRetornadoDoBancoDto.isPresent()) {
      service.excluirModelo(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }
  
  
  
  
}
