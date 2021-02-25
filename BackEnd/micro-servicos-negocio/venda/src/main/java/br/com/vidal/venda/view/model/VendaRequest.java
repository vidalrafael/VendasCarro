package br.com.vidal.venda.view.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VendaRequest {
  private String codigoUsuarioComprador;
  private UsuarioCompradorRequest usuarioCompradorRequest;
  private ModeloVendidoRequest modeloVendidoRequest;
  private LocalDate dataVenda;
  private Integer quantidadeVendida;

  //#region Gatters and Setters
  public String getCodigoUsuarioComprador() {
    return codigoUsuarioComprador;
  }

  public void setCodigoUsuarioComprador(String codigoUsuarioComprador) {
    this.codigoUsuarioComprador = codigoUsuarioComprador;
  }
  
  public UsuarioCompradorRequest getUsuarioCompradorRequest() {
    return usuarioCompradorRequest;
  }
  
  public void setUsuarioCompradorRequest(UsuarioCompradorRequest usuarioCompradorRequest) {
    this.usuarioCompradorRequest = usuarioCompradorRequest;
  }

  public ModeloVendidoRequest getModeloVendidoRequest() {
    return modeloVendidoRequest;
  }

  public void setModeloVendidoRequest(ModeloVendidoRequest modeloVendidoRequest) {
    this.modeloVendidoRequest = modeloVendidoRequest;
  }

  public LocalDate getDataVenda() {
    return dataVenda;
  }

  public void setDataVenda(String dataVendaString) { 
    this.dataVenda = LocalDate.parse(dataVendaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public Integer getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public void setQuantidadeVendida(Integer quantidadeVendida) {
    this.quantidadeVendida = quantidadeVendida;
  }
  //#endregion

}
