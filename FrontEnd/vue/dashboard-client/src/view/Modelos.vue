<template>
  <div class="painel">
    <MenuLateral :idUsuario=usuario.id :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />  
        <div class="posicaoDashboard">
          <div id="naoExisteModelo">
            <ModeloNaoExiste :marca=marca />
          </div>
          <div class="modelos" id="existeModelo">  
            <div v-for="modelo in modelos" :key="modelo.id"> 
              <div v-show="modelo.quantidadeEstoque != 0">   
                <div class="row justify-content-center">
                  <h1 class="text-center">{{ modelo.marca }} - {{ modelo.modelo }}</h1>
                </div>      
                <div class="row justify-content-center">
                  <div class="box ">
                    <div id="carouselExampleIndicators" class="carousel slide carousel-fade" data-ride="carousel" data-interval="1000">
                      <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                      </ol>
                      <!-- Aqui seria um v-for com as imagens retorndas do banco ou do servidor de arquivos, mas não consegui fazer :(, ai botei essa imagem padrão -->
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 img-modelo" src="@/assets/modeloPadrao.png" alt="Primeiro Slide">
                        </div>                        
                      </div>          
                    </div>
                  </div>        
                </div>
                <div class="row justify-content-center">
                  <h2 class="text-center">Valor (R$): {{ modelo.preco }}</h2>
                </div>
                <div class="row mb-3 mt-2">    
                  <div class="col-6 text-right center">
                    <button class="btn btn-gold comprar" type="button" @click="comprar(modelo.codigo)">Compre agora</button>
                  </div> 
                  <div class="col-6 text-left center">
                    <button class="btn btn-gold especificacoes" type="button" @click="mostrarEspecificacoes(modelo.id)">Especificações Técnicas</button>
                  </div>        
                </div>
                <!-- Especificações -->
                <div class="row">
                  <div class="w-100" v-show="especificacoesId === modelo.id">
                    <hr class="linha">
                    <h3>Ficha Técnica</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Ano:</label>
                        <label class="m-left">{{ modelo.ano || "n/d" }}</label><br>

                        <label class="mr-2">Combustível:</label>
                        <label class="m-left">{{ modelo.combustivel || "n/d" }}</label><br>

                        <label class="mr-2">Marca:</label>
                        <label class="m-left">{{ modelo.marca || "n/d" }}</label><br>

                        <label class="mr-2">Preço (R$):</label>
                        <label class="m-left">{{ modelo.preco || "n/d" }}</label><br>  
                      </div>
                      <div class="col-6">
                        <label class="mr-2">Lugares:</label>
                        <label class="m-left">{{ modelo.quantidadeLugares || "n/d" }}</label><br>

                        <label class="mr-2">IPVA (R$):</label>
                        <label class="m-left">{{ modelo.ipva || "n/d" }}</label><br>

                        <label class="mr-2">Garantia:</label>
                        <label class="m-left">{{ modelo.garantia || "n/d" }}</label><br>

                        <label class="mr-2">Portas:</label>
                        <label class="m-left">{{ modelo.quantidadePortas || "n/d" }}</label><br>
                      </div>
                    </div>
                    <hr class="linha">
                    <h3>Desempenho</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Velocidade máxima (km/h):</label>
                        <label class="m-left">{{ modelo.velocidadeMaxima || "n/d" }}</label><br>

                        <label class="mr-2">Aceleração 0-100 km/h:</label>
                        <label class="m-left">{{ modelo.aceleracao || "n/d" }}</label><br>                 
                      </div>              
                    </div>  
                    <hr class="linha">
                    <h3>Motor</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Cilindros:</label>
                        <label class="m-left">{{ modelo.cilindros || "n/d" }}</label><br>

                        <label class="mr-2">Válvulas por cilindro:</label>
                        <label class="m-left">{{ modelo.valvulasPorCilindro || "n/d" }}</label><br>

                        <label class="mr-2">Cilindradas:</label>
                        <label class="m-left">{{ modelo.cilindradas || "n/d" }}</label><br>

                        <label class="mr-2">Peso/Potência:</label>
                        <label class="m-left">{{ modelo.pesoPotencia || "n/d" }}</label><br>  

                        <label class="mr-2">Peso/Torque:</label>
                        <label class="m-left">{{ modelo.pesoTorque || "n/d" }}</label><br>

                        <label class="mr-2">Aspiração:</label>
                        <label class="m-left">{{ modelo.aspiracao || "n/d" }}</label><br>

                        <label class="mr-2">Alimentação:</label>
                        <label class="m-left">{{ modelo.alimentacao || "n/d" }}</label><br>
                      </div>
                      <div class="col-6">
                        <label class="mr-2">Comando de válvulas:</label>
                        <label class="m-left">{{ modelo.comandoValvulas || "n/d" }}</label><br>

                        <label class="mr-2">Variação de comando:</label>
                        <label class="m-left">{{ modelo.variacaoComando || "n/d" }}</label><br>

                        <label class="mr-2">Diâmetro dos cilindros:</label>
                        <label class="m-left">{{ modelo.diametroCilindros || "n/d" }}</label><br>

                        <label class="mr-2">Curso dos pistões:</label>
                        <label class="m-left">{{ modelo.cursoPistoes || "n/d" }}</label><br>

                        <label class="mr-2">Potência máxima:</label>
                        <label class="m-left">{{ modelo.potenciaMaxima || "n/d" }}</label><br>

                        <label class="mr-2">Torque máximo:</label>
                        <label class="m-left">{{ modelo.torqueMaximo || "n/d" }}</label><br>
                      </div>
                    </div>
                    <hr class="linha">
                    <h3>Consumo de combustível</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Cidade (km/L):</label>
                        <label class="m-left">{{ modelo.consumoCidade || "n/d" }}</label><br>

                        <label class="mr-2">Estrada (km/L):</label>
                        <label class="m-left">{{ modelo.consumoEstrada || "n/d" }}</label><br>                 
                      </div>              
                    </div> 
                    <hr class="linha">
                    <h3>Transmissão</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Câmbio:</label>
                        <label class="m-left">{{ modelo.cambio || "n/d" }}</label><br>

                        <label class="mr-2">Acoplamento:</label>
                        <label class="m-left">{{ modelo.acoplamento || "n/d" }}</label><br>
                      </div>              
                    </div>
                    <hr class="linha">
                    <h3>Suspensão</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Dianteira:</label>
                        <label class="m-left">{{ modelo.suspensaoDianteira || "n/d" }}</label><br>

                        <label class="mr-2">Traseira:</label>
                        <label class="m-left">{{ modelo.suspensaoTraseira || "n/d" }}</label><br>
                      </div>              
                    </div>
                    <hr class="linha">
                    <h3>Freios</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Dianteiros:</label>
                        <label class="m-left">{{ modelo.freiosDianteiros || "n/d" }}</label><br>

                        <label class="mr-2">Traseiros:</label>
                        <label class="m-left">{{ modelo.freiosTraseiros || "n/d" }}</label><br>
                      </div>
                    </div>
                    <hr class="linha">
                    <h3>Dimensões</h3>
                    <hr class="linha">
                    <div class="row ficha">
                      <div class="col-6">
                        <label class="mr-2">Comprimento (mm):</label>
                        <label class="m-left">{{ modelo.comprimento || "n/d" }}</label><br>

                        <label class="mr-2">Largura (mm):</label>
                        <label class="m-left">{{ modelo.largura || "n/d" }}</label><br>

                        <label class="mr-2">Distância entre eixos (mm):</label>
                        <label class="m-left">{{ modelo.distanciaEntreEixos || "n/d" }}</label><br>

                        <label class="mr-2">Altura (mm):</label>
                        <label class="m-left">{{ modelo.altura || "n/d" }}</label><br>                
                      </div>
                      <div class="col-6">
                        <label class="mr-2">Porta-malas (litros):</label>
                        <label class="m-left">{{ modelo.portaMalas || "n/d" }}</label><br>

                        <label class="mr-2">Peso (kg):</label>
                        <label class="m-left">{{ modelo.peso || "n/d" }}</label><br>                

                        <label class="mr-2">Tanque de combustível (litros):</label>
                        <label class="m-left">{{ modelo.tanqueCombustivel || "n/d" }}</label><br>
                      </div>
                    </div>
                    <hr class="linha">
                    <div class="row ficha justify-content-center">              
                      <button class="btn btn-gold comprar mb-3" type="button" @click="comprar(modelo.codigo)">Compre agora</button>                                     
                    </div>
                    <div class="row justify-content-center">
                      <img src="@/assets/setaUp.png" class="img-fluid setaVoltar" alt="Voltar">  
                      <p class="fecharEspecificacoes" @click="fecharEspecificacoes">Fechar Especificações</p>
                      <img src="@/assets/setaUp.png" class="img-fluid setaVoltar" alt="Voltar">   
                    </div>
                    <hr class="linha">           
                  </div>
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
import ModeloNaoExiste from "@/view/ModeloNaoExiste.vue";
import ApiModelos from '@/services/ApiModelos.js';
import ApiUsuarios from "@/services/ApiUsuarios.js";
import ApiEstoque from "@/services/ApiEstoque.js";

export default {
  name: "Modelos",
  components: {
    MenuLateral,
    Header,
    ModeloNaoExiste
  },

  data(){
    return{
      textoHeader: "Seja bem vindo ao painel do Cliente",  
      nomeCompleto: "",
      existeModelo: true,
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

      modelos:[{
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
      }],

      especificacoesId: "",
      marca:"",
      
    }
  },

  mounted(){
    this.marca = this.$route.params.marca    
    ApiModelos.retornaPorMarca(this.marca)
    .then(resp =>{      
      this.modelos = resp.data;

      if (this.modelos.length == 0) {
        document.getElementById("existeModelo").style.display="none"

      }else{
        document.getElementById("naoExisteModelo").style.display="none"
      }

      this.modelos.forEach(modelo =>{
        ApiEstoque.retornaPorCodigoModelo(modelo.codigo)
        .then(estoque =>{
          modelo.quantidadeEstoque = estoque.data.quantidadeEstoque;          

        })
      })   
      
    })

    ApiUsuarios.retornaPorId(this.$route.params.idUsuario)
    .then(resp =>{
      this.usuario = resp.data;
      this.nomeCompleto = `${this.usuario.nome} ${this.usuario.sobrenome}`           
    })
  },

  methods:{
    mostrarEspecificacoes(id){
      if (this.especificacoesId != id) {
        this.especificacoesId = id;

      }else{
        this.especificacoesId = 0;
      }
    },

    fecharEspecificacoes(){
      this.especificacoesId = 0;

    },

    comprar(codigoModelo){
      this.$router.push({path: `/ConfirmaCompra/${this.usuario.id}/${codigoModelo}`});
    },

    
  }

}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  .comprar{
    margin-right: 0 !important;    
    
  }
  
  .especificacoes{
    margin-left: 0 !important;
    margin-top: 10px;
  }

  .carousel-inner{
    margin-bottom: 0;
  }

  .carousel-indicators {
    margin-bottom: 0;
  }

  .center{
    text-align: center !important;
    
  }

  .box{
    margin-right: 15px !important;
    width: 100% !important;
  }

}
/* Fim media */

  .posicaoDashboard{
    background-image: url("../assets/fundo-cinza4.png"); 
  }

  .modelos{
    width: 100%;
    color:  #fff;
    height: 100%;
    
  }

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

  h2{
    font-style: italic;
    color: #d3b04b;
    margin-top: 15px;
  }

  .box{
    width: 80%;
    margin: 15px;
    margin-right: 30px;
    box-shadow: 0px 0px 8px 5px #ac7d21;
  }

  .img-modelo{
    max-height: 400px;
  }

  .btn-gold{
    width: 187px;
  }

  .comprar:hover{
    background-color: rgb(16, 145, 4);
  }

  .linha{
    width: 90%;
    background-color: #fff;   
    margin-top: 0; 
  }

  .ficha{
    width: 90%;
    margin-left: auto;
    margin-right: auto;
  }

  .m-left{
    color: #e4c163;
  }

  .setaVoltar{
    max-width: 40px;
    max-height: 35px;
  }
  
  .fecharEspecificacoes{
    font-style: oblique;
    margin-right: 15px;
    margin-left: 15px;
    text-decoration: underline;
    cursor: pointer;
  }

  .contato{
    color: white;
  }
</style>