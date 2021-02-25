<template>
  <div class="painel">
    <MenuLateral :idUsuario=usuario.id :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />  
        <div class="posicaoDashboard">
          <div class="comprar">
            <div class="row justify-content-center">
              <h1 class="m-3 text-center">Selecione a marca que deseja comprar</h1>
            </div>
            <div class="row justify-content-center">
              <!-- bmw -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/bmw-logo.png" class="img-fluid" alt="Logo BMW">
                </div>
                <h2 class="text-center m-title">BMW</h2>
                <div class="textoMarca">
                  <p>Descubra o puro prazer de dirigir com os exclusivos veículos BMW, que oferecem benefícios únicos de conforto e performance.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('BMW')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!--  bugatti -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/Bugatti-logo.png" class="img-fluid logobugatti" alt="Logo Bugatti">
                </div>
                <h2 class="text-center m-title">BUGATTI</h2>
                <div class="textoMarca">
                  <p>Luxo e muita velocidade! Isso resume os modelos da Bugatti. Sinta agora a sensação de pilotar os carros mais rapidos do mundo.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('Bugatti')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!-- ferrari -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/ferrari-logo.png" class="img-fluid logoferrari" alt="Logo Ferrari">
                </div>
                <h2 class="text-center m-title">FERRARI</h2>
                <div class="textoMarca">
                  <p>A marca mais famosa do mundo. Desajada por muitos, conquistada por poucos. Unanimidade entre os apaixonados por velocidade. </p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('Ferrari')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!-- Koenigsegg -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/Koenigsegg-logo.png" class="img-fluid logoKoenigsegg" alt="Logo Koenigsegg">
                </div>
                <h2 class="text-center m-title">KOENIGSEGG</h2>
                <div class="textoMarca">
                  <p>Lar do primeiro Mega-GT. Dona de uma dos carros mais rápidos já produzidos no mundo. Um Koenigsegg não é para qualquer um.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('Koenigsegg')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!-- Lamborghini -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/lamborghini-logo.png" class="img-fluid logoLamborghini" alt="Logo Lamborghini">
                </div>
                <h2 class="text-center m-title">LAMBORGHINI</h2>
                <div class="textoMarca">
                  <p>Com 57 anos de história, cada carro é feito com muito requinte e atenção nos detalhes. Além do seu design inconfundível.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('Lamborghini')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!-- McLarem -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/maclaren-logo.png" class="img-fluid logoLamborghini" alt="Logo McLarem">
                </div>
                <h2 class="text-center m-title">MCLAREM</h2>
                <div class="textoMarca">
                  <p>Da fórmula 1 para sua garegem. Cada carro McLarem é feito com a tecnologia que a marca desenvolve com sua equipe na F1.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('McLaren')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!-- Pagani -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/pagani-logo.png" class="img-fluid logoPagani" alt="Logo Pagani">
                </div>
                <h2 class="text-center m-title">PAGANI</h2>
                <div class="textoMarca">
                  <p>Um sonho em 4 rodas. Cada carro feito exclusivamente a mão para o comprador. Velocidades incríveis sem perder a beleza.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('Pagani')"><strong>Ver Modelos</strong></button>
                </div>
              </div>
              <!-- Porsche -->
              <div class="card">
                <div class="fotoMarca">
                  <img src="@/assets/porsche-logo.png" class="img-fluid logoPorsche" alt="Logo Porsche">
                </div>
                <h2 class="text-center m-title">PORSCHE</h2>
                <div class="textoMarca">
                  <p>Extremo conforto combinado com motores poderosos. Os modelos super esportivos da porsche fazem jus a perfeição alemã.</p>
                </div>
                <div class="text-center mb-3">
                  <button type="button" class="btn btn-gold" @click="verModelos('Porsche')"><strong>Ver Modelos</strong></button>
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
import ApiUsuarios from "@/services/ApiUsuarios.js"

export default {
  name: "Comprar",
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
      }
    }
  },

  mounted(){    
    ApiUsuarios.retornaPorId(this.$route.params.idUsuario)
    .then(resp =>{
      this.usuario = resp.data;
      this.nomeCompleto = `${this.usuario.nome} ${this.usuario.sobrenome}`
    })
  },

  methods:{    
    verModelos(marca){
    this.$router.push({path: `/modelos/${this.usuario.id}/${marca}`})
    }
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
  }
}
/* Fim media */


  .comprar{
    width: 100%;
    color:  rgb(0, 0, 0);
    background-color: #252525;
    
  }

  h1{
    font-style: italic;
    color: #d3b04b;
  }

  .card{
    max-width: 350px;
    min-width: 350px;
    margin: 20px;
    background-image: url("../assets/fundo-cinza1.jpg");
    box-shadow: 0px 0px 8px 5px #cfcecc;
    border-radius: 15px;
    border: 1px solid white;
  }

  .card:hover{
    box-shadow: 0px 0px 8px 5px #10dd097a;
  }

  .fotoMarca{
    width: 100%;
    height: 227px;
    text-align: center;
  }

  .img-fluid{
    height: 100%;
  }

  h2{
    margin-bottom: 5px;
    background-color: #d3b14bb4;
    border: 1px solid white;
    color: rgba(252, 252, 252, 0.808);
  }

  .m-title{
    margin-top: -20px;
  }

  .textoMarca{
    padding: 0 10px 10px 10px ;    
  }

  p{
    margin: 0;
    color: rgba(255, 255, 255, 0.884)
  }

  .logobugatti{
    width: 290px;
    max-height: 176px;
    margin-top: 20px
  }

  .logoferrari{
    max-height: 196px;
    margin-top: 10px
  }

  .logoKoenigsegg{
    width: 290px;
    max-height: 140px;
    margin-top: 30px
  }

  .logoLamborghini{
    max-height: 176px;
    margin-top: 17px
  }

  .logoPagani{
    width: 290px;
    max-height: 170px;
    margin-top: 20px
  }

  .logoPorsche{
    width: 290px;
    max-height: 180px;
    margin-top: 10px
  }

</style>