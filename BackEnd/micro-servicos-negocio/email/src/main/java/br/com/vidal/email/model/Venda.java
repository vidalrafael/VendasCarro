package br.com.vidal.email.model;

public class Venda {
  private Usuario usuarioCompradorResponse;
  private Modelo modeloVendidoResponse;
  private String dataVenda;
  private String valorTotal;
  private Integer quantidadeVendida;

  //#region Gatters and Setters

  public Usuario getUsuarioCompradorResponse() {
    return usuarioCompradorResponse;
  }

  public void setUsuarioCompradorResponse(Usuario usuarioCompradorResponse) {
    this.usuarioCompradorResponse = usuarioCompradorResponse;
  }
  
  public Modelo getModeloVendidoResponse() {
    return modeloVendidoResponse;
  }

  public void setModeloVendidoResponse(Modelo modeloVendidoResponse) {
    this.modeloVendidoResponse = modeloVendidoResponse;
  }
  
  public String getDataVenda() {
    return dataVenda;
  }

  public void setDataVenda(String dataVenda) {
    this.dataVenda = dataVenda;
  }

  public String getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(String valorTotal) {
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
