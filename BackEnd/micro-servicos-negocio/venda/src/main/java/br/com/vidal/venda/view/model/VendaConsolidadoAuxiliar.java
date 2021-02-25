package br.com.vidal.venda.view.model;

import java.time.LocalDate;

import br.com.vidal.venda.shared.VendaDto;

public class VendaConsolidadoAuxiliar {
  private double valorTotal;
  private LocalDate dataVenda;

  public VendaConsolidadoAuxiliar(){

  }

  public VendaConsolidadoAuxiliar(VendaDto vendaDto) {
    valorTotal = vendaDto.getValorTotal();
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public LocalDate getDataVenda() {
    return dataVenda;
  }

  public void setDataVenda(LocalDate dataVenda) {
    this.dataVenda = dataVenda;
  }

  public VendaConsolidadoAuxiliar concatenar (VendaConsolidadoAuxiliar antigo){      
    valorTotal += antigo.getValorTotal();
    return this;
  }
}
