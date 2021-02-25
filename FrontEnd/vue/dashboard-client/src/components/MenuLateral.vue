<template>
  <div class="menu">
    <div class="avatarmobile">
      <p class="nomeCliente">{{ nomeUsuario }}</p>
      <img v-show="sexo == 'Feminino' " src="@/assets/woman.png" class="img-fluid avatar p-1" alt="Foto Cliente">
      <img v-show="sexo == 'Masculino' " src="@/assets/man.png" class="img-fluid avatar p-1" alt="Foto Cliente">
      <img v-show="sexo == 'Outros' " src="@/assets/lgbt.png" class="img-fluid avatar mr-1 p-1" alt="Foto Cliente">
      <img v-show="nomeUsuario == 'Administrador' " src="@/assets/adm.png" class="img-fluid avatar p-1" alt="Foto Cliente">
    </div>
    
    <nav class="navbar navbar-expand-lg navbar-dark p-0">
      <button class="navbar-toggler m-2" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Alterna navegação">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <ul>
          <li class="boxlogo">
            <img src="@/assets/LogoIcone.png" class="img-fluid logo" alt="Logo Vidal HyperCars">
          </li>
          <MenuLateralCliente v-show="idUsuario != '999999999'" :idUsuario=idUsuario />
          <MenuLateralAdm v-show="idUsuario == '999999999'" :idUsuario=idUsuario />
        </ul>
      </div>
    </nav>
  </div> 
</template>

<script>
import MenuLateralCliente from '@/view/MenuLateralCliente.vue'
import MenuLateralAdm from '@/view/MenuLateralAdm.vue'

export default {
  name: "MenuLateral",
  components:{
    MenuLateralCliente,
    MenuLateralAdm,
  },

  props:{
    idUsuario: String,
    nomeUsuario: String,
    sexo: String
  },

  
		
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){  

  .boxlogo{
    margin-top: 0 !important;
  }

  ul{
    width: 100% !important;
    height: auto !important;
    
  }

  .ultima-linha{
    margin-bottom: 1px !important;
  }

  button{
    z-index: 999;
  }

  .avatarmobile{
    display: flex !important;
    width: 100vw;
    justify-content: flex-end;
    padding-top: 10px;
    margin-bottom: -66px;
    
  }

  .nomeCliente{
		color: #fff;
		margin-right: 15px;
		font-size: 18px;
		margin-top: auto;
    margin-bottom: auto;
    text-transform: uppercase;
	}

	.avatar{
    max-width: 60px;
    max-height: 50px;
    float: left;
    margin-top: auto;
    margin-bottom: auto;
    margin-right: 15px;
  }
  
}

  .menu{
    width: 100%;
  }

  nav{
    position: fixed;
    background-color: transparent;  
    width: auto;
  }

  .avatarmobile{
    display: none;
  }

	ul {
		list-style-type: none;
		margin: 0 !important;
		padding: 0;
		background-color: #181818;
    height: 101vh;
    width: 250px;  
	}

  button{
    background-color: transparent;
    border: 0;
  }

  .boxlogo{
    text-align: center;
    margin-top: 20px;
  }
  .logo{
    max-width: 180px;    
  }


</style>