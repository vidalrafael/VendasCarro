package br.com.vidal.venda.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Venda {
  @Id
  private String id;
  private String codigoUsuarioComprador;
  private UsuarioComprador usuarioComprador;
  private ModeloVendido modeloVendido;
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

  public UsuarioComprador getUsuarioComprador() {
    return usuarioComprador;
  }

  public void setUsuarioComprador(UsuarioComprador usuarioComprador) {
    this.usuarioComprador = usuarioComprador;
  }

  public ModeloVendido getModeloVendido() {
    return modeloVendido;
  }

  public void setModeloVendido(ModeloVendido modeloVendido) {
    this.modeloVendido = modeloVendido;
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
