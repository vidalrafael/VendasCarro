<template>
  <div class="painel">
    <MenuLateral :idUsuario=idUsuario :nomeUsuario="nomeCompleto" />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" />  
        <div class="posicaoDashboard">
          <div class="row justify-content-center mt-2 mb-2">
            <h1 class="text-center">Relatório de Vendas - Detalhado</h1>
          </div>
          <hr class="linha">
          <div v-show="mostrarResultados == false">
            <hr class="linha">
            <div class="row mt-2 justify-content-center">
              <div class="box">
                <div class="row">
                  <h3>Filtrar por data</h3>
                </div> 
                <div class="row mt-3">
                  <div class="col-5">
                    <label>Data Inicial:</label>
                    <input v-mask="maskData" class="ml-2 mr-4" type="tel" v-model="dataInicial" @change="$v.dataInicial.$touch()">
                    <p class="error" v-if="$v.dataInicial.$error">Data inicial obrigatória</p>
                  </div>
                  <div class="col-5">
                    <label>Data Final:</label>
                    <input v-mask="maskData" class="ml-2 mr-4"  type="tel" v-model="dataFinal" @change="$v.dataFinal.$touch()">
                    <p class="error" v-if="$v.dataInicial.$error">Data final obrigatória</p>
                  </div>
                </div>              
                <div class="row mt-3">
                  <label>Ordenação:</label>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input ml-2 mt-n1" type="radio" value="crescente" v-model="ordenacaoVenda">
                    <label class="form-check-label mt-n1" for="inlineRadio1">Crescente (A-z)</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input mt-n1" type="radio" value="decrescente" v-model="ordenacaoVenda">
                    <label class="form-check-label mt-n1" for="inlineRadio2">Decrescente (Z-a)</label>
                  </div>
                </div>
                <div class="row justify-content-center">
                  <button class="btn btn-gold" @click="buscarVenda">Buscar todos</button>
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
                      <th scope="col">#</th>
                      <th scope="col">Cliente</th>
                      <th scope="col">Modelo vendido</th>
                      <th scope="col">Data da venda</th>
                      <th scope="col">Quantidade Vendida</th>
                      <th scope="col">Valor Total</th>
                    </tr>
                  </thead>  
                  <tbody v-for="(v, index) in venda" :key="v.id">                    
                    <tr>
                      <th scope="row">{{index + 1}}</th>
                      <!-- <td>{{v.nome + v.sobrenome}}</td> -->
                      <!-- <td>{{v.modelo}}</td> -->
                      <td>{{v.usuarioCompradorResponse.nome}}  {{v.usuarioCompradorResponse.sobrenome}}</td>
                      <td>{{v.modeloVendidoResponse.modelo}}</td>
                      <td>{{v.dataVenda}}</td>
                      <td>{{v.quantidadeVendida}}</td>
                      <td>{{v.valorTotal}}</td>
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
import { required } from "vuelidate/lib/validators"
import ApiVenda from "@/services/ApiVenda.js"

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
      ordenacaoVenda: "crescente",
      mostrarResultados: false,
      dataInicial: "",
      dataFinal: "",
      venda:[{
        id: "",
        usuarioCompradorResponse:{},
        modeloVendidoResponse:{},
        dataVenda: "",
        valorTotal: "",
        quantidadeVendida: "1"
      }],
      maskData: "##-##-####"
    }
  },  

  methods:{
    buscarVenda(){            
      if(!this.$v.$invalid){  
      ApiVenda.retornaPorData(this.dataInicial, this.dataFinal, this.ordenacaoVenda)
      .then(resp =>{
        this.venda = resp.data;
        this.mostrarResultados = true;
      })  
        }else{
          alert("Existem campos obrigatórios que não foram preenchidos. Por favor verifique.")
          this.$v.$touch();
        } 
    },

    voltar(){
      this.mostrarResultados = false;
    }
  },

  validations:{
    dataInicial: { required },
    dataFinal: { required },
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

  input[type="tel" i]{
    width: 60% !important;
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

  input[type="tel" i]{
    width: 45%;
    padding-right: 0;
  }

  .col-5{
    padding-left: 0;
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

  .voltar{
    color: rgba(248, 100, 63, 0.767);
  }

  .error{
    color: #ff2626;    
  }


</style>