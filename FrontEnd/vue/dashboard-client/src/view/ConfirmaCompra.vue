<template>
  <div class="painel">
    <MenuLateral :idUsuario=usuario.id :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />  
        <div class="posicaoDashboard">
          <div class="row justify-content-center">
            <h1 class="text-center">Confirmação de Compra</h1>
          </div>
          <hr class="linha">
          <div class="row justify-content-center">
            <div class="box">
              <div class="row">
                <div class="col align">
                  <label class="info mr-2">Data da compra:</label>
                  <input v-mask="maskData" type="tel" class="data text-center" v-model="venda.dataVenda" @change="$v.venda.dataVenda.$touch()">
                  <p class="errorVazio" v-if="$v.venda.dataVenda.$error">A data não pode ficar em branco.</p>                 
                </div>
                <div class="col align">
                  <label class="info mr-2">Quantidade:</label>
                  <input type="number" class="data text-center" v-model="venda.quantidadeVendida" @blur="verificaEstoque" @change="$v.venda.quantidadeVendida.$touch()">                  
                  <p class="erroEstoque" v-show="vendaMaiorQueEstoque == true">*No momento temos somente {{estoque.quantidadeEstoque}} unidades em estoque.</p>                  
                  <p class="errorVazio" v-if="$v.venda.quantidadeVendida.$error">A quantidade não pode ficar em branco.</p>
                </div>                
              </div> 
              <hr class="linhaDentroDaBox">

              <div class="row justify-content-center">
                <h4 class="text-center">Informações Pessoais</h4>
                <hr class="linhaDentroDaBox">                
              </div>
              <div class="row">
                <p class="info">Nome Completo:</p>
                <p class="ml-2">{{usuario.nome}} {{usuario.sobrenome}}</p>
              </div>
              <div class="row">
                <p class="info">CPF:</p>
                <p class="ml-2">{{usuario.cpf}}</p>
              </div>   
              <div class="row">
                <p class="info">Endereço:</p>
                <p class="ml-2">{{usuario.endereco}}</p>
              </div>  
              <div class="row">
                <p class="info">E-Mail:</p>
                <p class="ml-2">{{usuario.email}}</p>
              </div> 
              <hr class="linhaDentroDaBox">

              <div class="row justify-content-center">
                <h4 class="text-center">Informações do modelo</h4>
                <hr class="linhaDentroDaBox">                
              </div>
              <div class="row">
                <p class="info">Modelo:</p>
                <p class="ml-2">{{modelo.modelo}}</p>
              </div>
              <div class="row">
                <p class="info">Marca:</p>
                <p class="ml-2">{{modelo.marca}}</p>
              </div>   
              <div class="row">
                <p class="info">Preço (R$):</p>
                <p class="ml-2">{{modelo.preco}}</p>
              </div>  
              <div class="row">
                <p class="info">Garantia:</p>
                <p class="ml-2">{{modelo.garantia}}</p>
              </div>
              <hr class="linhaDentroDaBox">
              <div class="row justify-content-center">
                <button class="btn btn-gold" id="btnComprar" @click="gravarVenda">Comprar</button>                
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
import ApiModelos from "@/services/ApiModelos.js";
import ApiVenda from "@/services/ApiVenda.js";
import ApiEstoque from "@/services/ApiEstoque.js";
import moment from "moment";
import { required } from 'vuelidate/lib/validators'
import ApiEmail from '@/services/ApiEmail.js'

export default {
  name: "ConfirmaCompra",
  components: {
    MenuLateral,
    Header
  },

  data(){
    return{
      textoHeader: "Seja bem vindo ao painel do Cliente",
      nomeCompleto:"",
      usuario:{        
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
      },

      modelo:{
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
      },

      venda:{
        codigoUsuarioComprador: "",
        usuarioCompradorRequest:{},
        modeloVendidoRequest:{},
        dataVenda: "",
        quantidadeVendida: "1"
      },

      maskData: "##/##/####",
      estoque:{
        id: "",
        removerEstoque: "",
        quantidadeEstoque: ""
      },

      vendaMaiorQueEstoque: false
    }    
  },

  mounted(){
    ApiUsuarios.retornaPorId(this.$route.params.idUsuario)
    .then(resp =>{      
      this.usuario = resp.data;
      this.nomeCompleto = `${this.usuario.nome} ${this.usuario.sobrenome}`;  
    })

    ApiModelos.retornaPorCodigo(this.$route.params.codigoModelo)
    .then(resp =>{
      this.modelo = resp.data;      
    })

    ApiEstoque.retornaPorCodigoModelo(this.$route.params.codigoModelo)
    .then(resp =>{
      this.estoque = resp.data;   
    })
     
    this.venda.dataVenda = moment().format("DD/MM/YYYY")
  },

  methods:{    
    gravarVenda(){
      if(!this.$v.$invalid){
        this.venda.codigoUsuarioComprador = this.usuario.id;
        this.venda.usuarioCompradorRequest = this.usuario;
        this.venda.modeloVendidoRequest = this.modelo;  
        this.estoque.removerEstoque = this.venda.quantidadeVendida      
        
        ApiVenda.gravarVenda(this.venda)
        .then(resp => {
          alert("Venda realizada com sucesso!\n\nCodigo da venda: " + resp.data.id);         
          
          ApiEstoque.removerEstoque(this.estoque)
          

          ApiEmail.confirmaVenda(resp.data)
					.then(() =>{
            alert("Verifique sua caixa de email ou a caixa de span com a confirmação do cadastro.");
            this.$router.push({path: `/comprar/${this.usuario.id}`});
					})
          
        })
      
      }else{
        alert("Existem campos obrigatórios que não foram preenchidos. Por favor verifique.")
        this.$v.$touch();
      }

      
    },

    verificaEstoque(){
      if (this.venda.quantidadeVendida > this.estoque.quantidadeEstoque) {
        this.vendaMaiorQueEstoque = true;
        document.getElementById("btnComprar").disabled = true;

      }else{
        document.getElementById("btnComprar").disabled = false;
      }
    }

  },

  validations:{
    venda:{
      dataVenda: { required },
      quantidadeVendida: { required }
    }
  }
  
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .align{
    text-align: start !important;
  }

}
  .posicaoDashboard{
    background-image: url("../assets/fundo-cinza4.png"); 
    color: #fff;
  }

  h1{
    font-style: italic;
    color: #d3b04b;
    margin-top: 15px;
  }

  h4{
    color: #ffffff8c;
  }

  .linha{
    width: 90%;
    background-color: #fff;   
    margin-top: 0; 
  }

  .box{
    width: 90%;
  }

  .linhaDentroDaBox{
    width: 100%;
    background-color: #fff;   
    margin-top: 8px;
  }

  .info{
    color: #d3b14bcb;
  }

  label{
    font-size: 20px;
  }

  input{
    color: #fff;
    background-color: #fff0;
    border: 2px solid rgba(241, 241, 241, 0.76);
    border-radius: 0px;
  }

  input:focus{
    border: 1px solid #d3b14b;
    box-shadow: 0 0 0 0.1rem #d3b14b9a;
    outline: 0;
  }

  .data{
    width: 110px;
  }

  .align{
    text-align: center;
  }

  .btn-gold{
    width: 100%;
    max-width: 300px;
    margin-bottom: 20px;
  }

  .btn-gold:hover{
    background-color: rgb(38, 133, 9);
  }

  .erroEstoque{
    font-size: 17px;
    color: yellow;
  }

  .errorVazio{
    color: #ff3300;
  }

</style>