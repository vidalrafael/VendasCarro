<template>
  <div>
    <hr class="linha">
    <li class="boxicones">
      <button @click="acessarCadastrarVeiculo">
        <img src="@/assets/cadastro-carro.png" class="img-fluid icon" alt="Cadastrar modelo"><br>
        <span>Cadastrar Veículo</span>
      </button>            
    </li>
    <hr class="linha">
    <li class="boxicones">
      <button @click="acessarAdicionarEstoque">
        <img src="@/assets/estoque.png" class="img-fluid iconkey" alt="Cadastrar Estoque"><br>
        <span>Adicionar Estoque</span>
      </button>            
    </li>
    <hr class="linha">
    <li class="boxicones">
      <button @click="acessarRelatorios">
        <img src="@/assets/relatorios.png" class="img-fluid iconkey" alt="Relatorios"><br>
        <span>Relatorios</span>
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
    name: "MenuLateralAdm",

    props:{
      idUsuario: String
    },
    
    methods:{
    acessarCadastrarVeiculo(){
      this.$router.push({path: `/cadastrarModelo/adm/${this.idUsuario}`});
    },

    acessarAdicionarEstoque(){
      this.$router.push({path: `/adicionarEstoque/adm/${this.idUsuario}`});
    },

    acessarRelatorios(){
      this.$router.push({path: `/relatorios/adm/${this.idUsuario}`});
    },

    
  }	
		
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){

  .ultima-linha{
    margin-bottom: 1px !important;
  }

  button{
    z-index: 999;
  }

  
}

  button{
    background-color: transparent;
    border: 0;
  }

  .linha{
    background-color: rgba(165, 161, 161, 0.575);
    margin: 20px;
    height: 2px;
  }

  .boxicones{
    text-align: center;    
    margin-top: 25px;
  }
  .icon{
    max-width: 75px;
    margin-bottom: 5px;
  }

  span{    
    color: #fff;
  }

  .iconkey{
    max-width: 65px;
    margin-bottom: 10px;
  }


</style>