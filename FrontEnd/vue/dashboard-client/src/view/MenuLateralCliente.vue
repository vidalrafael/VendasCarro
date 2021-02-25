<template>
  <div>
    <hr class="linha">
      <li class="boxicones">
        <button @click="acessarDadosPessoais">
          <img src="@/assets/person.png" class="img-fluid icon" alt="Dados Pessoais"><br>
          <span>Dados Pessoais</span>
        </button>            
      </li>
      <hr class="linha">
      <li class="boxicones">
        <button @click="acessarComprar">
          <img src="@/assets/key.png" class="img-fluid iconkey" alt="Comprar"><br>
          <span>Comprar</span>
        </button>            
      </li>
      <hr class="linha">
      <li class="boxicones">
        <button @click="acessarHistorico">
          <img src="@/assets/historico.png" class="img-fluid iconkey" alt="Histórico"><br>
          <span>Histórico de compras</span>
        </button>            
      </li>
      <hr class="linha">
      <li class="boxicones">
        <router-link to="/">
          <button>
            <img src="@/assets/sair.png" class="img-fluid iconkey" alt="Logo Vidal HyperCars"><br>  
            <span>Sair</span>      
          </button>   
        </router-link>                          
      </li>
      <hr class="linha ultima-linha">
  </div> 
</template>

<script>
export default {
  name: "MenuLateralCliente",

  props:{
    idUsuario: String
  },

  methods:{
    acessarDadosPessoais(){
      this.$router.push({path: `/dadosPessoais/${this.idUsuario}`});
    },

    acessarComprar(){
      this.$router.push({path: `/comprar/${this.idUsuario}`});
    },

    acessarHistorico(){
      this.$router.push({path: `/historico/${this.idUsuario}`});
    }    
  }		
}
</script>

<style scoped>
  @media only screen and  (max-width: 768px){

    .ultima-linha{
      margin-bottom: 1px !important;
    }
}

  .linha{
    background-color: rgba(165, 161, 161, 0.575);
    margin: 20px;
    height: 2px;
  }

  button{
    background-color: transparent;
    border: 0;
  }

  .boxicones{
    text-align: center;    
    margin-top: 25px;
  }
  .icon{
    max-width: 50px;
    margin-bottom: 5px;
  }

  span{    
    color: #fff;
  }

  .iconkey{
    max-width: 65px;
  }


</style>