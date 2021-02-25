package br.com.vidal.venda.service;

import java.util.List;
import java.util.Optional;

import br.com.vidal.venda.shared.VendaDto;
import br.com.vidal.venda.view.model.VendaConsolidadoAuxiliar;

public interface VendaService {
	List<VendaDto> retornaTodos();
	Optional<VendaDto> retornaPorId(String id);
	VendaDto gravarVenda(VendaDto vendaDto);
	void excluirVenda(String id);
	List<VendaDto> RetornaPorCodigoUsuarioComprador(String codigoUsuarioComprador);
	List<VendaDto> retornarPorData(String dataInicial, String dataFinal, String ordem);
	List<VendaConsolidadoAuxiliar> relatorioVendaConsolidado(String dataInicial, String dataFinal, String ordem);
  
}
