<template>
  <div class="painel">
    <MenuLateral :idUsuario=idUsuario :nomeUsuario=nomeCompleto />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" />  
        <div class="posicaoDashboard">
          <div class="row justify-content-center mt-2 mb-2">
            <h1 class="text-center">Relatório de Clientes</h1>
          </div>
          <hr class="linha">
          <div v-show="mostrarResultados == false">            
            <div class="row mt-2 justify-content-center">
              <div class="box">
                <div class="row">
                  <h3>Pesquisar por nome</h3>
                </div>
                <div class="row mt-3">
                  <label>Nome:</label>
                  <input class="ml-2 mr-4 inputNome" type="text" placeholder=" Nome ou parte dele" v-model="pesquisaNome">
                </div>                
                <div class="row justify-content-center mt-2">
                  <button class="btn btn-gold" @click="buscarPorNome">Buscar por {{pesquisaNome || "nome"}}</button>
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
                      <th scope="col">#</th>
                      <th scope="col">Nome Completo</th>
                      <th scope="col">CPF</th>
                      <th scope="col">Contato</th>
                      <th scope="col">Mais +</th>
                    </tr>
                  </thead>  
                  <tbody v-for="(user, index) in usuario" :key="user.id">                    
                    <tr>
                      <th scope="row">{{index + 1}}</th>
                      <td>{{user.nome + " " + user.sobrenome}}</td>
                      <td>{{user.cpf}}</td>
                      <td>{{user.celular}}</td>
                      <td class="maisInfo" @click="mostrarInfo(user.id)">Mais informações</td>
                    </tr>
                    <tr v-show="mostrarInformacoes == user.id">                      
                      <th class="border-0" scope="row"></th> 
                      <td colspan="4" class="labelInfoTitle">
                        Email:
                        <label class="labelInfo mr-4">{{ user.email }}</label>
                        Sexo: 
                        <label class="labelInfo">{{ user.sexo }}</label>                        
                      </td>
                    </tr> 
                    <tr v-show="mostrarInformacoes == user.id">
                      <th class="border-0" scope="row"></th> 
                      <td colspan="4" class="labelInfoTitle">
                        Endereço: 
                        <label class="labelInfo"> {{ user.endereco }}</label>
                      </td>
                    </tr>  
                    <tr v-show="mostrarInformacoes == user.id">
                      <th class="border-0" scope="row"></th> 
                      <td colspan="4" class="labelInfoTitle">
                        Bairro: 
                        <label class="labelInfo mr-5"> {{ user.bairro }}</label> 
                        Cidade:
                        <label class="labelInfo mr-5"> {{ user.cidade }}</label>
                        UF:
                        <label class="labelInfo mr-5"> {{ user.uf }}</label>
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
import ApiUsuarios from "@/services/ApiUsuarios.js";

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
      mostrarResultados: false,      
      mostrarInformacoes: 0,
      pesquisaNome: "",
      usuario:[{        
        id: "",
        nome: "",
        sobrenome: "",
        sexo: "",
        cpf: "",
        cep: "",
        endereco: "",
        bairro: "",
        cidade: "",
        uf: "",
        telefone: "",
        celular: "",
        email: "",
        senha: ""
      }]

    }
  },

  methods:{
    buscarPorNome(){
      ApiUsuarios.retornaPorParteDoNome(this.pesquisaNome)
      .then(resp =>{
        this.usuario = resp.data;
        this.mostrarResultados = true;
      })
    },

    buscarTodos(){
      ApiUsuarios.retornaTodos(this.ordenacaoTodos)
      .then(resp =>{
        this.usuario = resp.data;
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
    padding-bottom: 0;
  }

  .labelInfo{
    padding-left: 0.1rem;
    font-size: 17px;
  }

  .voltar{
    color: rgba(248, 100, 63, 0.767);
  }






</style>