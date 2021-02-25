<template>
  <div class="header">
    <div class="row m-0">
      <div class="col-8">
        <p class="bemVindo text-center">{{ titulo }}</p>
      </div>
      <div class="col-4 justify-content-end">
        <p class="nomeCliente">{{ nomeUsuario }}</p>
        <img v-show="sexo == 'Feminino' " src="@/assets/woman.png" class="img-fluid avatar p-1" alt="Foto Cliente">
        <img v-show="sexo == 'Masculino' " src="@/assets/man.png" class="img-fluid avatar p-1" alt="Foto Cliente">
        <img v-show="sexo == 'Outros' " src="@/assets/lgbt.png" class="img-fluid avatar mr-1 p-1" alt="Foto Cliente">
        <img v-show="nomeUsuario == 'Administrador' " src="@/assets/adm.png" class="img-fluid avatar p-1" alt="Foto Cliente">
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "Header",
  
  props:{
    titulo: String,
    nomeUsuario: String,
    sexo: String
  }

}
</script>

<style scoped>
  @media only screen and  (max-width: 768px){
    .nomeCliente, .avatar{
      display: none;
    }

    .col-8{
      min-width: 100vw;
      text-align: center;
    }

    .col-4{
      min-width: 100vw;
      justify-content: center !important;
    }    
  }

  .header{
    background-color:#d1ae4d9a;
    border: 1px solid white;
    width: 100%;
  }

  .bemVindo{
    color: #fff;
    margin-top: auto;
		margin-bottom: auto;
    font-size: 35px;
    font-weight: 15;
  }

  .col-4{
    display: flex;
  }  

  .nomeCliente{
		color: #fff;
		margin-right: 15px;
		font-size: 22px;
		margin-top: auto;
		margin-bottom: auto;
    text-transform: uppercase;
	}

	.avatar{
    max-width: 60px;
    max-height: 60px;
    float: left;
    margin-top: auto;
		margin-bottom: auto;
  }


</style>