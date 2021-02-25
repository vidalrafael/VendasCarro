package br.com.vidal.estoque.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estoque {
  @Id
  private String id;
  private String codigoModelo;
  private Integer quantidadeEstoque;

  //#region Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodigoModelo() {
    return codigoModelo;
  }

  public void setCodigoModelo(String codigoModelo) {
    this.codigoModelo = codigoModelo;
  }

  public Integer getQuantidadeEstoque() {
    return quantidadeEstoque;
  }

  public void setQuantidadeEstoque(Integer quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }
  //#endregion
  
}
