<template>
  <div class="row justify-content-center">
    <h1 class="center">Desculpe, No momento não temos nenhum modelo {{ marca }} disponível.</h1>

    <div v-show="marca == 'BMW' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20uma%20BMW">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/bmw1.jpg" alt="Modelo BMW">
        </div>
      </div>
    </div>

    <div v-show="marca == 'Bugatti' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20um%20Bugatti">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/bugatti2.jpg" alt="Modelo Bugatti">
        </div>
      </div>
    </div>

    <div v-show="marca == 'Ferrari' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20uma%20Ferrari">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/ferrari1.jpg" alt="Modelo Ferrari">
        </div>
      </div>
    </div>

    <div v-show="marca == 'Koenigsegg' "> 
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20um%20Koenigsegg">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/koenigsegg1.png" alt="Modelo Koenigsegg">
        </div>
      </div>
    </div>

    <div v-show="marca == 'Lamborghini' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20uma%20Lamborghini">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/lamborghini1.jpg" alt="Modelo Lamborghini">
        </div>
      </div>
    </div>

    <div v-show="marca == 'McLaren' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20uma%20McLaren">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/mclaren1.jpg" alt="Modelo McLaren">
        </div>
      </div>
    </div>

    <div v-show="marca == 'Pagani' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20um%20Pagani">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/paganiHuayra1.jpg" alt="Modelo Pagani">
        </div>
      </div>
    </div>

    <div v-show="marca == 'Porsche' ">
      <h3 class="contato">Acesse este <a class=link target="_blanks" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Gostaria%20de%20realizar%20a%20encomenda%20de%20um%20Porche">Link</a>, para falar com um de nossos vendedores sobre encomendas.</h3>
      <div class="p-3">
        <div class="box centerAlign">                  
          <img class="d-block w-100 img-modelo" src="@/assets/modelos/porsche2.jpg" alt="Modelo Porche">
        </div>
      </div>
    </div>

    

  </div>
</template>

<script>
export default {
  name:"ModeloNaoExiste",

  props:{
    marca: String
  }
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .box{
    margin-right: 15px !important;
    width: 100% !important;
  }
}
/* Fim media */

  h1{
    font-style: italic;
    color: #d3b04b;
    margin-top: 15px;
  }

  h3{    
    font-style: italic;
    color: #d3b04b;
    margin-top: 1rem;
    margin-bottom: 1rem;
    text-align: center;
  }

  .box{
    width: 80%;
    box-shadow: 0px 0px 8px 5px #ac7d21;
  }

  .img-modelo{
    max-height: 500px;
  }

  .contato{
    color: white;
  }

  .link{
    text-decoration: underline;
  }

</style>