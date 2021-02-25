package br.com.vidal.venda.view.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VendaResponse {
  private String id;
  private String codigoUsuarioComprador;
  private UsuarioCompradorResponse usuarioCompradorResponse;
  private ModeloVendidoResponse modeloVendidoResponse;
  private String dataVenda;
  private String valorTotal;
  private Integer quantidadeVendida;

  NumberFormat nf = new DecimalFormat("#,###.00");

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

  public UsuarioCompradorResponse getUsuarioCompradorResponse() {
    return usuarioCompradorResponse;
  }

  public void setUsuarioCompradorResponse(UsuarioCompradorResponse usuarioCompradorResponse) {
    this.usuarioCompradorResponse = usuarioCompradorResponse;
  }
  
  public ModeloVendidoResponse getModeloVendidoResponse() {
    return modeloVendidoResponse;
  }

  public void setModeloVendidoResponse(ModeloVendidoResponse modeloVendidoResponse) {
    this.modeloVendidoResponse = modeloVendidoResponse;
  }

  public String getDataVenda() {
    return dataVenda;
  }

  public void setDataVenda(LocalDate dataVenda) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    this.dataVenda = dataVenda.format(formatter);
  }

  public String getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotalDouble) {
    this.valorTotal = nf.format(valorTotalDouble);
  }

  public Integer getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public void setQuantidadeVendida(Integer quantidadeVendida) {
    this.quantidadeVendida = quantidadeVendida;
  }
  //#endregion
}
