package br.com.vidal.estoque.view.model;

public class EstoqueRequest {
  private String codigoModelo;
  private Integer quantidadeEstoque;

  //#region Getters and Setters
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
  //#endregion
}
