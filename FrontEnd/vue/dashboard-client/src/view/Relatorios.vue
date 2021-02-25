<template>
  <div class="painel">
    <MenuLateral :idUsuario=idUsuario :nomeUsuario=nomeCompleto />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" />  
        <div class="posicaoDashboard">
          <div class="row justify-content-center">
            <h1 class="m-3 text-center">Relatórios</h1>          
          </div>    
          <hr class="linha">    
          <div class="row justify-content-center">
            <div class="card">
              <div class="fotoMarca">
                <img src="@/assets/iconCliente.png" class="img-fluid p-1" alt="Icone cliente">
              </div>
              <h2 class="text-center m-title">Relatório de Clientes</h2>
              <div class="text-center mb-3">
                <button type="button" class="btn btn-gold" @click="acessarRelatorioClientes"><strong>Ver relatório</strong></button>
              </div>
            </div>
            <div class="card">
              <div class="fotoMarca">
                <img src="@/assets/iconCarro.png" class="img-fluid p-3" alt="Icone veiculos">
              </div>
              <h2 class="text-center m-title">Relatório de Veículos</h2>
              <div class="text-center mb-3">
                <button type="button" class="btn btn-gold" @click="acessarRelatorioVeiculos"><strong>Ver relatório</strong></button>
              </div>
            </div>
          </div>  
          <div class="row justify-content-center"> 
            <div class="card">
              <div class="fotoMarca">
                <img src="@/assets/iconVendasDetalhado.png" class="img-fluid p-2" alt="Icone cliente">
              </div>
              <h2 class="text-center m-title">Relatório de Vendas - Detalhado</h2>
              <div class="text-center mb-3">
                <button type="button" class="btn btn-gold" @click="acessarRelatorioVendasDetalhado"><strong>Ver relatório</strong></button>
              </div>
            </div>   
            <div class="card">
              <div class="fotoMarca">
                <img src="@/assets/iconVendasConsolidado.png" class="img-fluid p-1 mt-1" alt="Icone cliente">
              </div>
              <h2 class="text-center m-title">Relatório de Vendas - Consolidado</h2>
              <div class="text-center mb-3">
                <button type="button" class="btn btn-gold" @click="acessarRelatorioVendasConsolidado"><strong>Ver relatório</strong></button>
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

export default {
  name: "Relatorios",
  components: {
    MenuLateral,
    Header
  },

  data(){
    return{
      textoHeader: "Painel do Administrador",
      nomeCompleto:"Administrador",
      idUsuario: "999999999",      
    }
  },

  methods:{
    acessarRelatorioClientes(){
      this.$router.push({path: `/RelatorioClientes/adm/${this.idUsuario}`});
    },

    acessarRelatorioVeiculos(){
      this.$router.push({path: `/RelatorioVeiculos/adm/${this.idUsuario}`});
    },

    acessarRelatorioVendasConsolidado(){
      this.$router.push({path: `/RelatorioVendasConsolidado/adm/${this.idUsuario}`});
    },

    acessarRelatorioVendasDetalhado(){
      this.$router.push({path: `/RelatorioVendasDetalhado/adm/${this.idUsuario}`});
    },
  }
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .card{
    min-width: 100% !important;
    max-width: 100% !important;
  }

  .row{
    padding-left: 15px;
    padding-right: 15px;
  };

}
/* Fim media */


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

  .card{
    max-width: 400px;
    min-width: 400px;
    margin: 20px;
    background-color: inherit;
    box-shadow: 0px 0px 8px 5px #cfcecc;
    border-radius: 15px;
    border: 1px solid white;
  }

  .card:hover{
    box-shadow: 0px 0px 8px 5px #9e9b8bab;
  }

  .fotoMarca{
    height: 100px;
    text-align: center;
  }

  .img-fluid{
    height: 100%;
  }

  h2{
    margin-bottom: 5px;
    background-color: #615d50b4;
    border: 1px solid white;
    color: rgba(252, 252, 252, 0.808);
  }

  .m-title{
    margin-top: 10px;
    margin-bottom: 15px;
  }



</style>