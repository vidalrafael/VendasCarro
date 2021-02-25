package br.com.vidal.venda.view.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import br.com.vidal.venda.service.VendaService;
import br.com.vidal.venda.shared.ModeloVendidoDto;
import br.com.vidal.venda.shared.UsuarioCompradorDto;
import br.com.vidal.venda.shared.VendaDto;
import br.com.vidal.venda.view.model.ModeloVendidoResponse;
import br.com.vidal.venda.view.model.UsuarioCompradorResponse;
import br.com.vidal.venda.view.model.VendaConsolidadoAuxiliar;
import br.com.vidal.venda.view.model.VendaRequest;
import br.com.vidal.venda.view.model.VendaResponse;




@RestController
@RequestMapping("api/v1/venda")
@CrossOrigin
public class VendaController {
  @Autowired
  VendaService service;

  @GetMapping()
  @CrossOrigin
  public ResponseEntity<List<VendaResponse>> getRetornaTodos() {
    List<VendaDto> listaVendaDto = service.retornaTodos();

    if (listaVendaDto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    List<VendaResponse> listaVendaResponse = new ArrayList<>();
    ModelMapper mapper = new ModelMapper();

    listaVendaDto.stream().forEach(list -> {
      VendaResponse vendaResponse = mapper.map(list, VendaResponse.class);
      vendaResponse.setModeloVendidoResponse(mapper.map(list.getModeloVendidoDto(), ModeloVendidoResponse.class));
      vendaResponse.setUsuarioCompradorResponse(mapper.map(list.getUsuarioCompradorDto(), UsuarioCompradorResponse.class));

      listaVendaResponse.add(vendaResponse);
    });

    return new ResponseEntity<>(listaVendaResponse, HttpStatus.OK);
  }

  @GetMapping(value="{id}")
  @CrossOrigin
  public ResponseEntity<VendaResponse> getRetornaPorId(@PathVariable String id) {
    Optional<VendaDto> vendaDto = service.retornaPorId(id);

    if (vendaDto.isPresent()) {
      ModelMapper mapper = new ModelMapper();
      VendaResponse vendaResponse = mapper.map(vendaDto.get(), VendaResponse.class);
      vendaResponse.setModeloVendidoResponse(mapper.map(vendaDto.get().getModeloVendidoDto(), ModeloVendidoResponse.class));
      vendaResponse.setUsuarioCompradorResponse(mapper.map(vendaDto.get().getUsuarioCompradorDto(), UsuarioCompradorResponse.class));
      
      return new ResponseEntity<>(vendaResponse, HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value="usuario/{codigoUsuarioComprador}")
  @CrossOrigin
  public ResponseEntity<List<VendaResponse>> getRetornaPorIdUsuario(@PathVariable String codigoUsuarioComprador) {
    List<VendaDto> listaVendaDto = service.RetornaPorCodigoUsuarioComprador(codigoUsuarioComprador);

    if (listaVendaDto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    List<VendaResponse> listaVendaResponse = new ArrayList<>();
    ModelMapper mapper = new ModelMapper();

    listaVendaDto.stream().forEach(list -> {
      VendaResponse vendaResponse = mapper.map(list, VendaResponse.class);
      vendaResponse.setModeloVendidoResponse(mapper.map(list.getModeloVendidoDto(), ModeloVendidoResponse.class));
      vendaResponse.setUsuarioCompradorResponse(mapper.map(list.getUsuarioCompradorDto(), UsuarioCompradorResponse.class));

      listaVendaResponse.add(vendaResponse);
    });

    return new ResponseEntity<>(listaVendaResponse, HttpStatus.OK);
  }

  @GetMapping(value = "/relatorioVendaDetalhado/{dataInicial}/{dataFinal}/{ordem}")
  @CrossOrigin
  public ResponseEntity<List<VendaResponse>> getRelatorioVendaDetalhado(@PathVariable String dataInicial, @PathVariable String dataFinal, @PathVariable String ordem) {
      List<VendaDto> listVendaDto = service.retornarPorData(dataInicial, dataFinal, ordem);

      if (listVendaDto == null) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      ModelMapper mapper = new ModelMapper();
      List<VendaResponse> listVendaResponse = new ArrayList<>();

      listVendaDto.stream().forEach(list ->{
        VendaResponse vendaResponse = mapper.map(list, VendaResponse.class);          
        vendaResponse.setUsuarioCompradorResponse(mapper.map(list.getUsuarioCompradorDto(), UsuarioCompradorResponse.class));
        vendaResponse.setModeloVendidoResponse(mapper.map(list.getModeloVendidoDto(), ModeloVendidoResponse.class));

        listVendaResponse.add(vendaResponse);                                  
          
      });
      
      return new ResponseEntity<>(listVendaResponse, HttpStatus.OK);
  }

  @GetMapping(value = "/relatorioVendaConsolidado/{dataInicial}/{dataFinal}/{ordem}")
  @CrossOrigin
  public ResponseEntity<List<VendaConsolidadoAuxiliar>> getRelatorioVendaConsolidado(@PathVariable String dataInicial, @PathVariable String dataFinal, @PathVariable String ordem) {
      List<VendaConsolidadoAuxiliar> listVendaConsolidadoAuxiliar = service.relatorioVendaConsolidado(dataInicial, dataFinal, ordem);

      if (listVendaConsolidadoAuxiliar == null) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }      
      
      return new ResponseEntity<>(listVendaConsolidadoAuxiliar, HttpStatus.OK);
  }

  @PostMapping()
  @CrossOrigin
  public ResponseEntity<VendaResponse> postGravarVenda(@RequestBody VendaRequest request) {
    ModelMapper mapper = new ModelMapper();
    VendaDto vendaDto = mapper.map(request, VendaDto.class);
    vendaDto.setModeloVendidoDto(mapper.map(request.getModeloVendidoRequest(), ModeloVendidoDto.class));
    vendaDto.setUsuarioCompradorDto(mapper.map(request.getUsuarioCompradorRequest(), UsuarioCompradorDto.class));

    vendaDto.setValorTotal(vendaDto.getModeloVendidoDto().getPreco() * vendaDto.getQuantidadeVendida());

    vendaDto = service.gravarVenda(vendaDto);

    VendaResponse vendaResponse = mapper.map(vendaDto, VendaResponse.class);
    vendaResponse.setModeloVendidoResponse(mapper.map(vendaDto.getModeloVendidoDto(), ModeloVendidoResponse.class));
    vendaResponse.setUsuarioCompradorResponse(mapper.map(vendaDto.getUsuarioCompradorDto(), UsuarioCompradorResponse.class));

    return new ResponseEntity<>(vendaResponse, HttpStatus.OK);

  }

  @DeleteMapping(value = "{id}")
  @CrossOrigin
  public ResponseEntity<Void> excluirVenda(@PathVariable String id){
    Optional<VendaDto> vendaDto = service.retornaPorId(id);

    if (vendaDto.isPresent()) {
      service.excluirVenda(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  
  
  
}
