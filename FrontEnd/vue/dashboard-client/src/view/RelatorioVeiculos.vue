<template>
  <div class="painel">
    <MenuLateral :idUsuario=idUsuario :nomeUsuario=nomeCompleto />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" />  
        <div class="posicaoDashboard">
          <div class="row justify-content-center mt-2 mb-2">
            <h1 class="text-center">Relatório de Veículos</h1>
          </div>
          <hr class="linha">
          <div v-show="mostrarResultados == false">            
            <div class="row mt-2 justify-content-center">
              <div class="box">
                <div class="row">
                  <h3>Pesquisar por modelo</h3>
                </div>
                <div class="row mt-3">
                  <label>Modelo:</label>
                  <input class="ml-2 mr-4 inputNome" type="text" placeholder="Nome do modelo ou parte dele" v-model="pesquisaModelo">
                </div>                
                <div class="row justify-content-center mt-2">
                  <button class="btn btn-gold" @click="buscarPorModelo">Buscar por {{pesquisaModelo || "modelo"}}</button>
                </div>
              </div>
            </div>
            <hr class="linha">
            <div class="row mt-2 justify-content-center">
              <div class="box">
                <div class="row">
                  <h3>Pesquisar por codigo</h3>
                </div>
                <div class="row mt-3">
                  <label>Código:</label>
                  <input class="ml-2 mr-4 inputNome" type="text" placeholder="Codigo do modelo" v-model="pesquisaCodigo">
                </div>                
                <div class="row justify-content-center mt-2">
                  <button class="btn btn-gold" @click="buscarPorCodigo">Buscar por {{pesquisaCodigo || "codigo"}}</button>
                </div>
              </div>
            </div>
            <hr class="linha">            
            <div class="row mt-2 justify-content-center">
              <div class="box">
                <div class="row">
                  <h3>Buscar Todos</h3>
                </div>              
                <div class="row mt-3">
                  <label>Ordenação:</label>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input ml-2 mt-n1" type="radio" value="crescente" v-model="ordenacaoTodos">
                    <label class="form-check-label mt-n1" for="inlineRadio1">Crescente (A-z)</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input mt-n1" type="radio" value="decrescente" v-model="ordenacaoTodos">
                    <label class="form-check-label mt-n1" for="inlineRadio2">Decrescente (Z-a)</label>
                  </div>
                </div>
                <div class="row justify-content-center">
                  <button class="btn btn-gold" @click="buscarTodos">Buscar todos</button>
                </div>
              </div>
            </div>
          </div>

          <div v-show="this.mostrarResultados == true">
            <div class="row justify-content-center">
              <div class="table-responsive">
                <table class="table table-striped centerAlign">
                  <thead>
                    <tr class="title">
                      <th scope="col">Código</th>
                      <th scope="col">Modelo</th>
                      <th scope="col">Marca</th>
                      <th scope="col">Preço (R$)</th>
                      <th scope="col">Mais +</th>
                    </tr>
                  </thead>  
                  <tbody v-for="model in modelos" :key="model.id">                    
                    <tr>
                      <th scope="row">{{model.codigo}}</th>
                      <td>{{model.modelo}}</td>
                      <td>{{model.marca}}</td>
                      <td>{{model.preco}}</td>
                      <td class="maisInfo" @click="mostrarInfo(model.id)">Mais informações</td>
                    </tr>
                    <tr v-show="mostrarInformacoes == model.id"> 
                      <td colspan="5" class="labelInfoTitle">
                        Ano:
                        <label class="labelInfo mr-5">{{ model.ano || "n/d" }}</label>
                        Combustível: 
                        <label class="labelInfo mr-5">{{ model.combustivel || "n/d"}}</label> 
                        Garantia: 
                        <label class="labelInfo mr-5"> {{ model.garantia || "n/d" }}</label>
                      </td>
                    </tr> 
                      
                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Quantidade de lugares: 
                        <label class="labelInfo mr-5"> {{ model.quantidadeLugares || "n/d" }}</label> 
                        Quantidade de portas:
                        <label class="labelInfo mr-5"> {{ model.quantidadePortas || "n/d" }}</label>
                        IPVA (R$):
                        <label class="labelInfo mr-5"> {{ model.ipva || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Velociade máxima: 
                        <label class="labelInfo mr-5"> {{ model.velocidadeMaxima || "n/d" }}</label> 
                        Aceleração:
                        <label class="labelInfo mr-5"> {{ model.aceleracao || "n/d" }}</label>
                        Cilindros:
                        <label class="labelInfo mr-5"> {{ model.cilindros || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Válvulas por cilindro:
                        <label class="labelInfo mr-5"> {{ model.valvulasPorCilindro || "n/d" }}</label>
                        Cilindradas:
                        <label class="labelInfo mr-5"> {{ model.cilindradas || "n/d" }}</label>
                        Peso/Potência:
                        <label class="labelInfo mr-5"> {{ model.pesoPotencia || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Peso/Torque:
                        <label class="labelInfo mr-5"> {{ model.pesoTorque || "n/d" }}</label>
                        Aspiração:
                        <label class="labelInfo mr-5"> {{ model.aspiracao || "n/d" }}</label>
                        Alimentação:
                        <label class="labelInfo mr-5"> {{ model.alimentacao || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Comando de válvulas:
                        <label class="labelInfo mr-5"> {{ model.comandoValvulas || "n/d" }}</label>
                        Variação de comando:
                        <label class="labelInfo mr-5"> {{ model.variacaoComando || "n/d" }}</label>
                        Diâmetro dos cilindros:
                        <label class="labelInfo mr-5"> {{ model.diametroCilindros || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Curso dos pistões:
                        <label class="labelInfo mr-5"> {{ model.cursoPistoes || "n/d" }}</label>
                        Potência máxima:
                        <label class="labelInfo mr-5"> {{ model.potenciaMaxima || "n/d" }}</label>
                        Consumo na cidade:
                        <label class="labelInfo mr-5"> {{ model.consumoCidade || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Consumo na estrada:
                        <label class="labelInfo mr-5"> {{ model.consumoEstrada || "n/d" }}</label>
                        Câmbio:
                        <label class="labelInfo mr-5"> {{ model.cambio || "n/d" }}</label>
                        Acoplamento:
                        <label class="labelInfo mr-5"> {{ model.acoplamento || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Suspensão dianteira:
                        <label class="labelInfo mr-5"> {{ model.suspensaoDianteira || "n/d" }}</label>
                        Suspensão traseira':
                        <label class="labelInfo mr-5"> {{ model.suspensaoTraseira || "n/d" }}</label>
                        Freios dianteiros:
                        <label class="labelInfo mr-5"> {{ model.freiosDianteiros || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Freios traseiros:
                        <label class="labelInfo mr-5"> {{ model.freiosTraseiros || "n/d" }}</label>
                        Comprimento (mm):
                        <label class="labelInfo mr-5"> {{ model.comprimento || "n/d" }}</label>
                        Largura (mm):
                        <label class="labelInfo mr-5"> {{ model.largura || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Altura (mm):
                        <label class="labelInfo mr-5"> {{ model.altura || "n/d" }}</label>
                        Disntância entre eixos:
                        <label class="labelInfo mr-5"> {{ model.distanciaEntreEixos || "n/d" }}</label>
                        Tanque de combustível (L):
                        <label class="labelInfo mr-5"> {{ model.tanqueCombustivel || "n/d" }}</label>
                      </td>                                           
                    </tr>

                    <tr v-show="mostrarInformacoes == model.id">
                      <td colspan="5" class="labelInfoTitle">
                        Porta malas:
                        <label class="labelInfo mr-5"> {{ model.portaMalas || "n/d" }}</label>
                        Peso (kg):
                        <label class="labelInfo mr-5"> {{ model.peso || "n/d" }}</label>    
                      </td>                                           
                    </tr>

                  </tbody> 
                </table>
                <div class="row justify-content-center">
                  <h4 class="maisInfo voltar" @click="voltar">Voltar</h4>
                </div>
              </div>
            </div>
          </div>
        </div>  
      </div>
    </div>    
  </div>  
</template>

<script>
import MenuLateral from "@/components/MenuLateral.vue";
import Header from "@/view/Header.vue";
import ApiModelos from "@/services/ApiModelos.js";

export default {
  name: "Comprar",
  components: {
    MenuLateral,
    Header
  },

  data(){
    return{
      textoHeader: "Painel do Administrador",
      nomeCompleto:"Administrador",
      idUsuario: "999999999",
      ordenacaoTodos: "crescente",
      ordenacaoCodigo: "crescente",
      mostrarResultados: false,      
      mostrarInformacoes: 0,
      pesquisaModelo: "",
      pesquisaCodigo:"",
      modelos:[{
        id: "",
        codigo: "",
        modelo: "",
        marca: "",
        preco: "",
        ano: "",
        combustivel: "",        
        garantia: "",
        quantidadeLugares: "",
        quantidadePortas: "",
        ipva: "",
        velocidadeMaxima: "",
        aceleracao: "",
        cilindros: "",
        valvulasPorCilindro: "",
        cilindradas: "",
        pesoPotencia: "",
        pesoTorque: "",
        aspiracao: "",
        alimentacao: "",
        comandoValvulas: "",
        variacaoComando: "",
        diametroCilindros: "",
        cursoPistoes: "",
        potenciaMaxima: "",
        torqueMaximo: "",
        consumoCidade: "",
        consumoEstrada: "",
        cambio: "",
        acoplamento: "",
        suspensaoDianteira: "",
        suspensaoTraseira: "",
        freiosDianteiros: "",
        freiosTraseiros: "",
        comprimento: "",
        largura: "",
        altura: "",
        distanciaEntreEixos: "",
        tanqueCombustivel: "",
        portaMalas: "",
        peso: "",
        quantidadeEstoque: ""
      }],
      

    }
  },

  methods:{
    buscarPorModelo(){
      ApiModelos.retornaPorParteDoModelo(this.pesquisaModelo)
      .then(resp =>{
        this.modelos = resp.data;
        this.mostrarResultados = true;
      })
    },

    buscarPorCodigo(){
      ApiModelos.retornaPorCodigo(this.pesquisaCodigo)
      .then(resp =>{
        this.modelos[0] = resp.data;   
        // console.log(this.modelos)     
        this.mostrarResultados = true;
        
      })
    },

    buscarTodos(){
      ApiModelos.retornaTodos(this.ordenacaoTodos)
      .then(resp =>{
        this.modelos = resp.data;
        this.mostrarResultados = true;
      })
    },

    mostrarInfo(id){
      if (this.mostrarInformacoes != id) {
        this.mostrarInformacoes = id;

      }else{
        this.mostrarInformacoes = 0;
      }      
    },

    voltar(){
      this.mostrarResultados = false;
      this.pesquisaNome = ""
    }

  }


  
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .ml-2{
    margin-left: 0 !important;
  }

  label{
    width: 100%;
  }

  h3{
    text-align: center;
    width: 100%;
  }

  input[type="text" i]{
    width: 100% !important;
    margin: 5px 0 10px 0 !important;
  }

  .box{
    width: 90%;
  }

  .mt-n1{
    margin-top: 2px !important;
  }
}

  h1, h3{
    font-style: italic;
    color: #d3b04b;
  }

  .linha{    
    background-image: linear-gradient(to right, rgb(226, 45, 45) , #d3b04b);
    margin-top: 0; 
    height: 1px;
    margin-bottom: 0;
  }

  label{
    color: #fff;
    font-size: 20px;
  }

  input{
    color: #fff;
    background-color: #fff0;
    border: 2px solid rgba(241, 241, 241, 0.76);
    border-radius: 5px;
    padding: 5px;
  }

  input:focus{
    border: 1px solid #d3b14b;
    box-shadow: 0 0 0 0.1rem #d3b14b9a;
    outline: 0;
  }

  .box{
    width: 80%;
    margin: 15px;
    margin-right: 30px;    
  }

  input[type="text" i]{
    width: 70%;
  }

  .btn-gold{
    width: 100%;
    max-width: 300px;
    margin-top: 15px;
    margin-bottom: 10px;
  }

  .table{
    color: white;
    width: 100%;
  }

  .title{
    color: #bda869;
    font-size: 20px;    
  }

  tbody{
    font-size: 17px;
  }

  tr:nth-child(even) {
    background-color: #252525;
  }

  .table thead th{
    border-top: 0;
  }

  .maisInfo{
    text-decoration: underline;
    font-style: italic;
    cursor: pointer;    
  }

  .labelInfoTitle{
    color: #bda869;
    padding-left: 0.75rem;
    border-top: 0;
    padding-top: 0;
    padding-bottom: 10px;
  }

  .labelInfo{
    padding-left: 0.1rem;
    font-size: 17px;
  }

  .voltar{
    color: rgba(248, 100, 63, 0.767);
  }

</style>