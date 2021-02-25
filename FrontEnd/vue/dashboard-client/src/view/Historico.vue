<template>
  <div class="painel">
    <MenuLateral :idUsuario=usuario.id :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />  
        <div class="posicaoDashboard">
          <div class="historico">
            <div class="row justify-content-center">
              <h1 class="m-3 text-center">Historico de compras</h1>
            </div>
            <div class="row justify-content-center">
              <div class="table-responsive">
                <table class="table table-striped centerAlign">
                  <thead>
                    <tr class="title">
                      <th scope="col">#</th>
                      <th scope="col">Modelo</th>
                      <th scope="col">Marca</th>
                      <th scope="col">Data da compra</th>
                      <th scope="col">Quantidade</th>
                      <th scope="col">Valor Total (R$)</th>
                    </tr>
                  </thead>
                  <tbody v-for="(v, index) in venda" :key="v.id">                                    
                    <tr>
                      <th scope="row">{{index + 1}}</th>
                      <td>{{v.modeloVendidoResponse.modelo}}</td>
                      <td class="text">{{v.modeloVendidoResponse.marca}}</td>
                      <td>{{v.dataVenda}}</td>
                      <td>{{v.quantidadeVendida}}</td>
                      <td>{{v.valorTotal}}</td>
                    </tr>                      
                  </tbody>
                </table>
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
import ApiVenda from "@/services/ApiVenda.js";

export default {
  name: "Historico",
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

      venda:[{
        id: "",
        modeloVendidoResponse:{},
        dataVenda: "",
        quantidadeVendida: "1",
        valorTotal: ""
      }],
    }
  },

  mounted(){
    ApiUsuarios.retornaPorId(this.$route.params.idUsuario)
    .then(resp =>{
      this.usuario = resp.data;
      this.nomeCompleto = `${this.usuario.nome} ${this.usuario.sobrenome}`
    })

    ApiVenda.retornaPorCodigoUsuarioComprador(this.$route.params.idUsuario)
    .then(resp =>{
      this.venda = resp.data;
    })
  }
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .table{
    width: 100% !important;
  }
}
/* Fim media */

  .historico{
    width: 100%;
    height: 100%;
    background-image: url("../assets/fundo-cinza3.jpg");
    overflow: auto;
  }

  h1{
    font-style: italic;
    color: #d3b04b;
  }

  .table{
    color: white;
    width: 90%;
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
</style>