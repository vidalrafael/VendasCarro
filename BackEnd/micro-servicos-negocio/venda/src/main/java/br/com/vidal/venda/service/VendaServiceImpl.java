package br.com.vidal.venda.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidal.venda.model.ModeloVendido;
import br.com.vidal.venda.model.UsuarioComprador;
import br.com.vidal.venda.model.Venda;
import br.com.vidal.venda.repository.VendaRespotorio;
import br.com.vidal.venda.shared.ModeloVendidoDto;
import br.com.vidal.venda.shared.UsuarioCompradorDto;
import br.com.vidal.venda.shared.VendaDto;
import br.com.vidal.venda.view.model.VendaConsolidadoAuxiliar;

@Service
public class VendaServiceImpl implements VendaService {
  @Autowired
  VendaRespotorio repositorio;

  @Override
  public List<VendaDto> retornaTodos() {
    ModelMapper mapper = new ModelMapper();
    List<Venda> listaVenda = repositorio.findAll();
    List<VendaDto> listaVendaDto = new ArrayList<>();

    listaVenda.stream().forEach(list -> {
      VendaDto vendaDto = new VendaDto();

      vendaDto = mapper.map(list, VendaDto.class);
      vendaDto.setModeloVendidoDto(mapper.map(list.getModeloVendido(), ModeloVendidoDto.class));
      vendaDto.setUsuarioCompradorDto(mapper.map(list.getUsuarioComprador(), UsuarioCompradorDto.class));

      listaVendaDto.add(vendaDto);
    });

    return listaVendaDto;

  }

  @Override
  public Optional<VendaDto> retornaPorId(String id) {
    Optional<Venda> venda = repositorio.findById(id);

    if (venda.isPresent()) {
      ModelMapper mapper = new ModelMapper();
      VendaDto vendaDto = mapper.map(venda.get(), VendaDto.class);
      vendaDto.setModeloVendidoDto(mapper.map(venda.get().getModeloVendido(), ModeloVendidoDto.class));
      vendaDto.setUsuarioCompradorDto(mapper.map(venda.get().getUsuarioComprador(), UsuarioCompradorDto.class));

      return Optional.of(vendaDto);
    }

    return Optional.empty();
  }

  @Override
  public List<VendaDto> RetornaPorCodigoUsuarioComprador(String codigoUsuarioComprador) {
    ModelMapper mapper = new ModelMapper();
    List<Venda> listaVenda = repositorio.findByCodigoUsuarioComprador(codigoUsuarioComprador);
    List<VendaDto> listaVendaDto = new ArrayList<>();

    listaVenda.stream().forEach(list -> {
      VendaDto vendaDto = new VendaDto();

      vendaDto = mapper.map(list, VendaDto.class);
      vendaDto.setModeloVendidoDto(mapper.map(list.getModeloVendido(), ModeloVendidoDto.class));
      vendaDto.setUsuarioCompradorDto(mapper.map(list.getUsuarioComprador(), UsuarioCompradorDto.class));

      listaVendaDto.add(vendaDto);
    });

    return listaVendaDto;
  }

  @Override
  public VendaDto gravarVenda(VendaDto vendaDto) {
    ModelMapper mapper = new ModelMapper();
    Venda venda = mapper.map(vendaDto, Venda.class);
    venda.setModeloVendido(mapper.map(vendaDto.getModeloVendidoDto(), ModeloVendido.class));
    venda.setUsuarioComprador(mapper.map(vendaDto.getUsuarioCompradorDto(), UsuarioComprador.class));

    venda = repositorio.save(venda);

    VendaDto vendaDto2 = mapper.map(venda, VendaDto.class);
    vendaDto2.setModeloVendidoDto(mapper.map(venda.getModeloVendido(), ModeloVendidoDto.class));
    vendaDto2.setUsuarioCompradorDto(mapper.map(venda.getUsuarioComprador(), UsuarioCompradorDto.class));

    return vendaDto2;
  }

  @Override
  public void excluirVenda(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public List<VendaDto> retornarPorData(String dataInicial, String dataFinal, String ordem) {
    LocalDate dtInicial = LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    LocalDate dtFinal = LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    List<Venda> listVenda = new ArrayList<>();

    dtInicial = dtInicial.plusDays(-1);
    dtFinal = dtFinal.plusDays(1);

    if (ordem.equals("crescente")) {
      listVenda = repositorio.findByDataVendaBetweenOrderByDataVendaAsc(dtInicial, dtFinal);

    } else if (ordem.equals("decrescente")) {
      listVenda = repositorio.findByDataVendaBetweenOrderByDataVendaDesc(dtInicial, dtFinal);
    }

    if (listVenda.isEmpty()) {
      return null;
    }

    List<VendaDto> listVendaDto = new ArrayList<>();
    ModelMapper mapper = new ModelMapper();

    listVenda.stream().forEach(list -> {
      VendaDto vendaDto = mapper.map(list, VendaDto.class);
      vendaDto.setUsuarioCompradorDto(mapper.map(list.getUsuarioComprador(), UsuarioCompradorDto.class));
      vendaDto.setModeloVendidoDto(mapper.map(list.getModeloVendido(), ModeloVendidoDto.class));

      listVendaDto.add(vendaDto);
    });

    return listVendaDto;
  }

  @Override
  public List<VendaConsolidadoAuxiliar> relatorioVendaConsolidado(String dataInicial, String dataFinal, String ordem) {
    List<VendaDto> listaVendaOrdenada = retornarPorData(dataInicial, dataFinal, ordem);

    if (listaVendaOrdenada == null) {
      return null;
    }

    Map<LocalDate, Double> map = listaVendaOrdenada.stream()                                
                                .collect(groupingBy(VendaDto::getDataVenda, summingDouble(VendaDto::getValorTotal)));
                                
                                                                
    List<VendaConsolidadoAuxiliar> listaVendaConsolidadoAuxiliar = new ArrayList<>(); 

    if (ordem.equals("crescente")) {
      TreeMap<LocalDate, Double> mapOrdenadoCrescente = new TreeMap<>(map);

      mapOrdenadoCrescente.entrySet().forEach(m ->{
        VendaConsolidadoAuxiliar vendaConsolidadoAuxiliar = new VendaConsolidadoAuxiliar();

        vendaConsolidadoAuxiliar.setDataVenda(m.getKey());
        vendaConsolidadoAuxiliar.setValorTotal(m.getValue());


        listaVendaConsolidadoAuxiliar.add(vendaConsolidadoAuxiliar);
      });
      
    }else{
      Map<LocalDate, Double> mapOrdenadoDecrescente = new TreeMap<LocalDate, Double>(Collections.reverseOrder());
      mapOrdenadoDecrescente = map;

      mapOrdenadoDecrescente.entrySet().forEach(m ->{
        VendaConsolidadoAuxiliar vendaConsolidadoAuxiliar = new VendaConsolidadoAuxiliar();

        vendaConsolidadoAuxiliar.setDataVenda(m.getKey());
        vendaConsolidadoAuxiliar.setValorTotal(m.getValue());


        listaVendaConsolidadoAuxiliar.add(vendaConsolidadoAuxiliar);
      });
    }
    
    

    








    return listaVendaConsolidadoAuxiliar ;

  }
  
}
