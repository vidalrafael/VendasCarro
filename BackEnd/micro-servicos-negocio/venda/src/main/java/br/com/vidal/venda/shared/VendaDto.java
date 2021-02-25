package br.com.vidal.venda.shared;

import java.time.LocalDate;

public class VendaDto {
  private String id;
  private String codigoUsuarioComprador;
  private UsuarioCompradorDto usuarioCompradorDto;
  private ModeloVendidoDto modeloVendidoDto;
  private LocalDate dataVenda;
  private Double valorTotal;
  private Integer quantidadeVendida;

  //#region Gatters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodigoUsuarioComprador() {
    return codigoUsuarioComprador;
  }

  public void setCodigoUsuarioComprador(String codigoUsuarioComprador) {
    this.codigoUsuarioComprador = codigoUsuarioComprador;
  }

  public UsuarioCompradorDto getUsuarioCompradorDto() {
    return usuarioCompradorDto;
  }

  public void setUsuarioCompradorDto(UsuarioCompradorDto usuarioCompradorDto) {
    this.usuarioCompradorDto = usuarioCompradorDto;
  }

  public ModeloVendidoDto getModeloVendidoDto() {
    return modeloVendidoDto;
  }

  public void setModeloVendidoDto(ModeloVendidoDto modeloVendidoDto) {
    this.modeloVendidoDto = modeloVendidoDto;
  }

  public LocalDate getDataVenda() {
    return dataVenda;
  }

  public void setDataVenda(LocalDate dataVenda) {
    this.dataVenda = dataVenda;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Integer getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public void setQuantidadeVendida(Integer quantidadeVendida) {
    this.quantidadeVendida = quantidadeVendida;
  }
  //#endregion
}
