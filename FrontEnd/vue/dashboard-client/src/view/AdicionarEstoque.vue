<template>
  <div class="painel">
    <MenuLateral :idUsuario=idUsuario :nomeUsuario=nomeCompleto />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" />  
        <div class="posicaoDashboard">
          <div class="row justify-content-center">
            <h1 class="m-3 text-center">Adicionar Estoque</h1>      
          </div>
          <div class="row justify-content-center">
            <div class="box">
              <hr class="linha">
              <form action="">
                <div class="row mtop">          
                  <div class="col">
                    <label for="codigoVeiculo">Codigo do veículo</label>
                    <input type="text" class="form-control" id="codigoVeiculo" placeholder="Ex: 001" @blur="verificaExistenciaModelo" v-model="estoque.codigoModelo" @change="$v.estoque.codigoModelo.$touch()">
                    <p class="errorForm" v-if="$v.estoque.codigoModelo.$error">O código é obrigatório</p>
                    <p class="errorForm" v-if="existeModelo === false">Código não encontrado</p>
                  </div>
                  <div class="col">
                    <label for="codigoVeiculo">Adicionar ao estoque</label>
                    <input type="number" class="form-control" id="codigoVeiculo" placeholder="Ex: 2" v-model="estoque.adicionarEstoque" @change="$v.estoque.adicionarEstoque.$touch()">
                    <p class="errorForm" v-if="$v.estoque.adicionarEstoque.$error">A quantidade é obrigatória</p>
                  </div>   
                </div>
                <div class="row mtop">          
                  <div class="col text-center">              
                    <button class="btn btn-gold" type="button" id="botaoGravar" @click="adicionarEstoque" >Gravar</button>
                  </div>               
                </div>
              </form>
              <div v-if="existeModelo == true">
                <hr class="linha mt-3 mb-3">
                <div class="row justify-content-center">
                  <h4>Informações do veículo</h4>            
                </div>
                <div class="row">
                  <label class="labelInformacoes">Modelo:</label>
                  <label> {{ modelo.modelo || "n/d"}}</label>
                </div>
                <div class="row">
                  <label class="labelInformacoes">Marca:</label>
                  <label>{{ modelo.marca || "n/d"}}</label>
                </div>
                <div class="row">
                  <label class="labelInformacoes">Preço (R$):</label>
                  <label>{{ modelo.preco || "n/d"}}</label>
                </div>
                <div class="row">
                  <label class="labelInformacoes">Quantidade em estoque:</label>
                  <label>{{ modelo.quantidadeEstoque || "n/d"}}</label>
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
import { required } from 'vuelidate/lib/validators'
import apiEstoque from '@/services/ApiEstoque.js'
import apiModelo from '@/services/ApiModelos.js'


export default {
  name: "AdicionarEstoque",
  components: {
    MenuLateral,
    Header
  },

  data(){
    return {
      textoHeader: "Painel do Administrador",
      nomeCompleto:"Administrador",
      idUsuario: "999999999",
      estoque: {
        idEstoque: "",
        codigoModelo: "",
        adicionarEstoque: ""
      },

      modelo:{
        modelo: "",
        marca: "",
        preco: "",
        quantidadeEstoque: ""
      },

      existeModelo: "",
      
    };
  },

  methods:{
    verificaExistenciaModelo(){
      apiModelo.retornaPorCodigo(this.estoque.codigoModelo)
      .then(resp =>{
        if (resp.data.codigo == this.estoque.codigoModelo) {
          this.existeModelo = true
          this.buscarInformacoes();
          document.getElementById("botaoGravar").disabled = false

        }else{
          this.existeModelo = false
          document.getElementById("botaoGravar").disabled = true
        }
      })
    },

    buscarInformacoes(){
      apiModelo.retornaPorCodigo(this.estoque.codigoModelo)
      .then(resp =>{        
        this.modelo.modelo = resp.data.modelo;
        this.modelo.marca = resp.data.marca;
        this.modelo.preco = resp.data.preco;

        apiEstoque.retornaPorCodigoModelo(this.estoque.codigoModelo)
        .then(r =>{
          this.modelo.quantidadeEstoque = r.data.quantidadeEstoque;          
          this.estoque.idEstoque = r.data.id;
        })
      })
    },

    adicionarEstoque(){
      if (!this.$v.$invalid) {
        apiEstoque.atualizarEstoque(this.estoque)
        .then(resp =>{          
          alert("Foram adicionados " + this.estoque.adicionarEstoque + " ao estoque.\n\nTotal em estoque: " + resp.data.quantidadeEstoque)
          this.modelo.quantidadeEstoque = resp.data.quantidadeEstoque
        })
      }else{
        alert("Existem campos obrigatórios que não foram preenchidos. Por favor verifique.")
        this.$v.$touch();
      }
    }
  },

  validations:{
    estoque: {
      codigoModelo: { required },
      adicionarEstoque: { required }
    }
  }

  
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .col{
    margin-top: 1.5rem;
  }

  .mtop{
    margin-top: 0 !important;
  }

  .btn-gold{
    width: 80% !important;
  }

}

  h1{
    font-style: italic;
    color: #d3b04b;
  }
  
  .linha{    
    background-image: linear-gradient(to right, rgb(226, 45, 45) , #d3b04b);
    margin-top: 0; 
    height: 1px;
    margin-bottom: 0;
  }

  .box{
    width: 90%;    
  }

  .mtop{
    margin-top: 1.5rem;
  }

  .form-control{
    color: #fff;
    background-color: #fff0;
    border: 2px solid #fff0;
    border-radius: 0px;
    border-bottom-color: #ffffff;
  }

  .form-control:focus{
    border: 1px solid #d3b14b9a;
    box-shadow: 0 0 0 0.1rem #d3b14b9a;
  }

  label{
    color: #eebf32c2;
    font-size: 20px;
    margin-bottom: 0;
    padding-left: 0.75rem;    
  }

  .btn-gold{
    width: 20%;
  }

  .btn-gold:hover{
    background-color: rgb(11, 175, 19);
  }

  h4{
    color: rgba(255, 255, 255, 0.418);
  }

  .labelInformacoes{
    color:  rgba(255, 255, 255, 0.418);
  }

  .errorForm{
    color: #ff2626;    
  }

</style>