package br.com.vidal.modelos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Modelo {
  @Id
  private String id;
  private String codigo;
  private String modelo;
  private String marca;
  private Double preco;
  private Integer ano;
  private String combustivel;
  private String garantia;
  private Integer quantidadeLugares;
  private Integer quantidadePortas;
  private Double ipva;
  private Double velocidadeMaxima;
  private String aceleracao;
  private String cilindros;
  private String valvulasPorCilindro;
  private String cilindradas;
  private String pesoPotencia;
  private String pesoTorque;
  private String aspiracao;
  private String alimentacao;
  private String comandoValvulas;
  private String variacaoComando;
  private String diametroCilindros;
  private String cursoPistoes;
  private String potenciaMaxima;
  private String torqueMaximo;
  private Double consumoCidade;
  private Double consumoEstrada;
  private String cambio;
  private String acoplamento;
  private String suspensaoDianteira;
  private String suspensaoTraseira;
  private String freiosDianteiros;
  private String freiosTraseiros;
  private Double comprimento;
  private Double largura;
  private Double altura;
  private Double distanciaEntreEixos;
  private Double tanqueCombustivel;
  private Integer portaMalas;
  private Double peso;

  //#region Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public String getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(String combustivel) {
    this.combustivel = combustivel;
  }

  public String getGarantia() {
    return garantia;
  }

  public void setGarantia(String garantia) {
    this.garantia = garantia;
  }

  public Integer getQuantidadeLugares() {
    return quantidadeLugares;
  }

  public void setQuantidadeLugares(Integer quantidadeLugares) {
    this.quantidadeLugares = quantidadeLugares;
  }

  public Integer getQuantidadePortas() {
    return quantidadePortas;
  }

  public void setQuantidadePortas(Integer quantidadePortas) {
    this.quantidadePortas = quantidadePortas;
  }

  public Double getIpva() {
    return ipva;
  }

  public void setIpva(Double ipva) {
    this.ipva = ipva;
  }

  public Double getVelocidadeMaxima() {
    return velocidadeMaxima;
  }

  public void setVelocidadeMaxima(Double velocidadeMaxima) {
    this.velocidadeMaxima = velocidadeMaxima;
  }

  public String getAceleracao() {
    return aceleracao;
  }

  public void setAceleracao(String aceleracao) {
    this.aceleracao = aceleracao;
  }

  public String getCilindros() {
    return cilindros;
  }

  public void setCilindros(String cilindros) {
    this.cilindros = cilindros;
  }

  public String getValvulasPorCilindro() {
    return valvulasPorCilindro;
  }

  public void setValvulasPorCilindro(String valvulasPorCilindro) {
    this.valvulasPorCilindro = valvulasPorCilindro;
  }

  public String getCilindradas() {
    return cilindradas;
  }

  public void setCilindradas(String cilindradas) {
    this.cilindradas = cilindradas;
  }

  public String getPesoPotencia() {
    return pesoPotencia;
  }

  public void setPesoPotencia(String pesoPotencia) {
    this.pesoPotencia = pesoPotencia;
  }

  public String getPesoTorque() {
    return pesoTorque;
  }

  public void setPesoTorque(String pesoTorque) {
    this.pesoTorque = pesoTorque;
  }

  public String getAspiracao() {
    return aspiracao;
  }

  public void setAspiracao(String aspiracao) {
    this.aspiracao = aspiracao;
  }

  public String getAlimentacao() {
    return alimentacao;
  }

  public void setAlimentacao(String alimentacao) {
    this.alimentacao = alimentacao;
  }

  public String getComandoValvulas() {
    return comandoValvulas;
  }

  public void setComandoValvulas(String comandoValvulas) {
    this.comandoValvulas = comandoValvulas;
  }

  public String getVariacaoComando() {
    return variacaoComando;
  }

  public void setVariacaoComando(String variacaoComando) {
    this.variacaoComando = variacaoComando;
  }

  public String getDiametroCilindros() {
    return diametroCilindros;
  }

  public void setDiametroCilindros(String diametroCilindros) {
    this.diametroCilindros = diametroCilindros;
  }

  public String getCursoPistoes() {
    return cursoPistoes;
  }

  public void setCursoPistoes(String cursoPistoes) {
    this.cursoPistoes = cursoPistoes;
  }

  public String getPotenciaMaxima() {
    return potenciaMaxima;
  }

  public void setPotenciaMaxima(String potenciaMaxima) {
    this.potenciaMaxima = potenciaMaxima;
  }

  public String getTorqueMaximo() {
    return torqueMaximo;
  }

  public void setTorqueMaximo(String torqueMaximo) {
    this.torqueMaximo = torqueMaximo;
  }

  public Double getConsumoCidade() {
    return consumoCidade;
  }

  public void setConsumoCidade(Double consumoCidade) {
    this.consumoCidade = consumoCidade;
  }

  public Double getConsumoEstrada() {
    return consumoEstrada;
  }

  public void setConsumoEstrada(Double consumoEstrada) {
    this.consumoEstrada = consumoEstrada;
  }

  public String getCambio() {
    return cambio;
  }

  public void setCambio(String cambio) {
    this.cambio = cambio;
  }

  public String getAcoplamento() {
    return acoplamento;
  }

  public void setAcoplamento(String acoplamento) {
    this.acoplamento = acoplamento;
  }

  public String getSuspensaoDianteira() {
    return suspensaoDianteira;
  }

  public void setSuspensaoDianteira(String suspensaoDianteira) {
    this.suspensaoDianteira = suspensaoDianteira;
  }

  public String getsuspensaoTraseira() {
    return suspensaoTraseira;
  }

  public void setsuspensaoTraseira(String suspensaoTraseira) {
    this.suspensaoTraseira = suspensaoTraseira;
  }

  public String getFreiosDianteiros() {
    return freiosDianteiros;
  }

  public void setFreiosDianteiros(String freiosDianteiros) {
    this.freiosDianteiros = freiosDianteiros;
  }

  public String getFreiosTraseiros() {
    return freiosTraseiros;
  }

  public void setFreiosTraseiros(String freiosTraseiros) {
    this.freiosTraseiros = freiosTraseiros;
  }

  public Double getComprimento() {
    return comprimento;
  }

  public void setComprimento(Double comprimento) {
    this.comprimento = comprimento;
  }

  public Double getLargura() {
    return largura;
  }

  public void setLargura(Double largura) {
    this.largura = largura;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getDistanciaEntreEixos() {
    return distanciaEntreEixos;
  }

  public void setDistanciaEntreEixos(Double distanciaEntreEixos) {
    this.distanciaEntreEixos = distanciaEntreEixos;
  }

  public Double getTanqueCombustivel() {
    return tanqueCombustivel;
  }

  public void setTanqueCombustivel(Double tanqueCombustivel) {
    this.tanqueCombustivel = tanqueCombustivel;
  }

  public Integer getPortaMalas() {
    return portaMalas;
  }

  public void setPortaMalas(Integer portaMalas) {
    this.portaMalas = portaMalas;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  //#endregion


}
