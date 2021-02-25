package br.com.vidal.modelos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.vidal.modelos.model.Modelo;
import br.com.vidal.modelos.repository.ModeloRepositorio;
import br.com.vidal.modelos.shared.ModeloDto;

@Service
public class ModeloServiceImpl implements ModeloService {
  @Autowired
  ModeloRepositorio repositorio;

  @Override
  public List<ModeloDto> retornaTodos(String ordem) {
    List<Modelo> listaModelo = new ArrayList<>();

    if (ordem.equals("crescente")) {
      listaModelo = repositorio.findAllByOrderByCodigoAsc();

    }else if(ordem.equals("decrescente")){
      listaModelo = repositorio.findAllByOrderByCodigoDesc();

    }

    List<ModeloDto> listaModeloDto = listaModelo.stream().map(list -> new ModelMapper().map(list, ModeloDto.class))
        .collect(Collectors.toList());
    return listaModeloDto;
  }

  @Override
  public Optional<ModeloDto> retornaPorCodigo(String codigo) {
    Optional<Modelo> modelo = repositorio.findByCodigo(codigo);

    if (modelo.isPresent()) {
      return Optional.of(new ModelMapper().map(modelo.get(), ModeloDto.class));
    }
    
    return Optional.empty();
  }

  @Override
  public boolean verificaExistenciaCodigoModelo(String codigo){
    Optional<ModeloDto> modeloDto = retornaPorCodigo(codigo);

    if (modeloDto.isPresent()) {
      return true;
    }    

    return false;
  }

  @Override
  public ModeloDto gravarModelo(ModeloDto modeloDto) {
    ModelMapper mapper = new ModelMapper();
    Modelo modelo = mapper.map(modeloDto, Modelo.class);
    
    try {
      modelo = repositorio.save(modelo);

    } catch (Exception e) {      
      return null;
    }
    
    return mapper.map(modelo, ModeloDto.class);
  }

  @Override
  public Optional<ModeloDto> retornaPorId(String id) {
    Optional<Modelo> modelo = repositorio.findById(id);

    if (modelo.isPresent()) {
      return Optional.of(new ModelMapper().map(modelo.get(), ModeloDto.class));
    }

    return Optional.empty();
  }

  @Override
  public void excluirModelo(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public List<ModeloDto> retornaPorMarca(String marca) {
    List<Modelo> listaModelo = repositorio.findByMarca(marca);

    List<ModeloDto> listaModeloDto = listaModelo.stream()
                                    .map(list -> new ModelMapper().map(list, ModeloDto.class))
                                    .collect(Collectors.toList());

    return listaModeloDto;
  }

  @Override
  public List<ModeloDto> retornaPorParteDoNomeModelo(String modelo) {
    List<Modelo> listaModelo = repositorio.findByModeloContaining(modelo);

    List<ModeloDto> listaModeloDto = listaModelo.stream()
                                    .map(list -> new ModelMapper().map(list, ModeloDto.class))
                                    .collect(Collectors.toList());

    return listaModeloDto;
  }
  
}
