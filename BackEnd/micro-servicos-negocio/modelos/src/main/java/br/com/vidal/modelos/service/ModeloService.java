package br.com.vidal.modelos.service;

import java.util.List;
import java.util.Optional;

import br.com.vidal.modelos.shared.ModeloDto;

public interface ModeloService {
  List<ModeloDto> retornaTodos(String ordem);
  Optional<ModeloDto> retornaPorCodigo(String codigo);
  ModeloDto gravarModelo(ModeloDto modeloDto);
  boolean verificaExistenciaCodigoModelo(String codigo);
  Optional<ModeloDto> retornaPorId(String id);
  void excluirModelo(String id);
  List<ModeloDto> retornaPorMarca(String modelo);
  List<ModeloDto> retornaPorParteDoNomeModelo(String modelo);  
}
