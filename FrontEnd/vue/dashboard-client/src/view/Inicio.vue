<template>
  <div>
    <span id="topo"></span>
    <!-- Barra de navegação -->
    <nav class="navbar-expand-md navbar-dark">
        <ul class="nav mobile justify-content-center">
            <li class="nav-item position-absolute">
                <img src="@/assets/LogoIcone.png" class="logonav" alt="Logo Vidal HyperCars" title="Logo Vidal HyperCars">
            </li>
        </ul>        
        
        <button class="navbar-toggler mt-n5" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Alterna navegação">
            <span class="navbar-toggler-icon"></span>
        </button>        
        <div class="collapse navbar-collapse posicao" id="navbarTogglerDemo01">
            <ul class="nav desktop">
                <li class="nav-item">
                    <img src="@/assets/LogoIcone.png" class="logonav" alt="Logo Vidal HyperCars" title="Logo Vidal HyperCars">
                </li>
            </ul>            
            <ul class="nav alinhaStart mr-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#topo">HOME</a>
                </li>
                <div class="linha-vertical"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#sobre">SOBRE</a>
                </li>
                <div class="linha-vertical"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#marcas">MARCAS</a>
                </li>                   
                <div class="linha-vertical"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#clientes">CLIENTES</a>
                </li> 
                <div class="linha-vertical"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#contato">CONTATO</a>
                </li>                   
            </ul>

            <ul class="nav formMobile">                                           
                <li class="dropdown" >
                    <a href="" class="nav-link" data-toggle="dropdown">LOGIN</a>
                    <form class="dropdown-menu p-3">
                        <div class="form-group">
                            <label for="cpf">Login</label>
                            <input v-mask="mask" type="tel" class="form-control" id="cpf" placeholder="Digite seu CPF" v-model="usuario.cpf" @click="apagarLinhaVermelha('cpf')" >
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" id="senha" placeholder="******" v-model="usuario.senha" @click="apagarLinhaVermelha('senha')">
                            <a href="https://www.google.com" class="form-text align-right link">Esqueci minha senha</a>
                        </div>  
                        <div class="center">
                            <button type="button" class="btn btn-entrar" @click="login">Entrar</button>
                        </div> 
                    </form>
                </li>
                <div class="linha-vertical desktop"></div>                
                    <router-link class="nav-link cadastro" to="/tela-cadastro-usuario">CADASTRE-SE</router-link>
            </ul>
        </div>
      </nav>
    <header>
        <!-- Slides -->
        <div class="row mt-1">
            <div class="col-12 p-0">
                <div id="SlideCarrosApresentacao" class="carousel slide carousel-fade" data-ride="carousel" data-interval="4000">
                    <ol class="carousel-indicators">
                        <li data-target="#SlideCarrosApresentacao" data-slide-to="0" class="active"></li>
                        <li data-target="#SlideCarrosApresentacao" data-slide-to="1"></li>
                        <li data-target="#SlideCarrosApresentacao" data-slide-to="2"></li>
                        <li data-target="#SlideCarrosApresentacao" data-slide-to="3"></li>
                    </ol>                    
                    <div class="carousel-inner">                        
                        <div class="vidalhypercars">
                            <h1 class="textologo">VIDAL HYPERCARS</h1>                        
                        </div>
                        <div class="carousel-item active">
                            <img class="d-block w-100 imgSlide" src="@/assets/paganiHuayra1.jpg" alt="Primeiro Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h4 class="subtitle">Pagani Hauyra bc Roadster</h4>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100 imgSlide" src="@/assets/ferrari-f8-tributo.jpg" alt="Segundo Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h4 class="subtitle1">Ferrari F8 Tributo</h4>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100 imgSlide" src="@/assets/lamborghini-aventador.jpg" alt="Terceiro Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h4 class="subtitle1">Lamborghini Aventador</h4>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100 imgSlide" src="@/assets/ferrari-f8-interior.jpg" alt="Quarto Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h4 class="subtitle1">Interior - Ferrari F8 Tributo</h4>
                            </div>
                        </div>
                    </div>
                  </div>
            </div>
        </div>
    </header>
    <!-- Sobre -->
    <section class="m-3">
        <a name="sobre"></a>        
        <div class="row">
            <div class="col-1"></div>
            <div class="col-5 center mt-3">
                <img src="@/assets//desenho carro.jpg" class="img-fluid desenhoCarro" alt="Desenho carro">
            </div>
            

            <div class="col-5">
                <p class="capitular">Para você que sempre sonhou em ter uma super máquina, a <em> Vidal HyperCars </em>chegou para realizar o seu sonho.<br>
                    Atuando no mercado brasileiro des de 2007, buscamos não somente vender carros, mas sim, proporcionar experiências incríveis sobre 4 rodas.</p>
                <p class="capitular">
                    Nossa missão é levar até você verdadeiras joias, com todo cuidado que elas necessitam. Des do momento da compra até a entrega em sua residência, tudo é feito com muito carinho por todos os nossos colaboradores.
                </p>
            </div>
            <div class="col-1"></div>
        </div>        
    </section>
    <!-- Marcas -->
    
    <section class="marcas">
        <a name="marcas"></a>        
        <div class="row">            
            <div class="col-1"></div> 
            <div class="col-5 mb-3">                
                <p class="capitular">Atualmente trabalhamos* com as as marcas mais desejadas do mercado.</p>
                <div class="row rowMarcas">
                    <div class="col-6">
                        <ul class="pt-0 mb-0 key">
                            <li class="key2">PAGANI</li><br>
                            <li class="key2">FERRARI</li><br>
                            <li class="key2">LAMBORGHINI</li><br>
                            <li class="key2">BUGATTI</li>
                        </ul>
                    </div>
                    <div class="col-6">
                        <ul class="pt-0 mb-0 key">                            
                            <li class="key2">BMW</li><br>
                            <li class="key2">KOENIHSEGG</li><br>
                            <li class="key2">MCLAREN</li><br>
                            <li class="key2">PORSCHE</li>
                        </ul>
                    </div>
                </div>
                <small class="ml-n1">*Consulte a disponibilidade com nossos vendedores.</small>              
            </div>
            <div class="col-6 pt-3 marginMarcas">
                <div id="marcas1" class="carousel slide carousel-fade slideMarcas" data-ride="carousel" data-interval="4000">
                    <ol class="carousel-indicators mt-5 mb-0 ">
                        <li data-target="#marcas1" data-slide-to="0" class="active"></li>
                        <li data-target="#marcas1" data-slide-to="1"></li>
                        <li data-target="#marcas1" data-slide-to="2"></li>
                        <li data-target="#marcas1" data-slide-to="3"></li>
                        <li data-target="#marcas1" data-slide-to="4"></li>
                        <li data-target="#marcas1" data-slide-to="5"></li>
                        <li data-target="#marcas1" data-slide-to="6"></li>
                        <li data-target="#marcas1" data-slide-to="7"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100 logoMarcas" src="@/assets/pagani-logo.png" alt="Logo Pagani">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas ferrari" src="@/assets/ferrari-logo.png" alt="Logo Ferrari">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas lamborghini" src="@/assets/lamborghini-logo.png" alt="Logo Lamborghini">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas" src="@/assets/Bugatti-logo.png" alt="Logo Bugatti">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas bmw" src="@/assets/bmw-logo.png" alt="Logo BMW">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas koenigsegg" src="@/assets/Koenigsegg-logo.png" alt="Logo Koenigsegg">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas maclaren" src="@/assets/maclaren-logo.png" alt="Logo McLaren">
                        </div>
                        <div class="carousel-item center">
                            <img class="d-block w-100 logoMarcas" src="@/assets/porsche-logo.png" alt="Logo Porche">
                        </div>
                    </div>
                </div>
            </div>            
        </div>
    </section>
    <!-- Cientes -->
    <section class="direcao">
        <a name="clientes"></a>
        <div class="row justify-content-center">
            <h2 class="titulodepoimento">Veja o depoimento de alguns de nossos clientes</h2>
        </div>
        <div class="row direcao">
            <div class="card mCards" style="width: 18rem;">
                <img class="card-img-top" src="@/assets//cr7.jpg" alt="Imagem de capa do card">
                <div class="card-body">
                    <h5 class="card-title center">Cristiano Ronaldo</h5>
                    <p class="card-text">"Melhor revendedor de carros da europa. Sempre que posso vou na loja no centro de lisboa."</p>
                </div>
            </div>

            <div class="card mCards" style="width: 18rem;">
                <img class="card-img-top kylie" src="@/assets//kylie janner.jpg" alt="Imagem de capa do card">
                <div class="card-body">
                    <h5 class="card-title center">kylie Janner</h5>
                    <p class="card-text">"Depois que conheci a Vidal em Los Angeles, nunca mais fui em outro lugar."</p>
                </div>
            </div>

            <div class="card mCards" style="width: 18.2rem;">
                <img class="card-img-top kylie" src="@/assets//ronaldinho.jpeg" alt="Imagem de capa do card">
                <div class="card-body">
                    <h5 class="card-title">Ronaldinho Gaúcho</h5>
                    <p class="card-text">"Des dos tempos de barcelona, só compro meus carros na Vidal."</p>
                </div>
            </div>
        </div>
    </section>
    <!-- Contato -->
    <footer class="mt-4">
        <a name="contato"></a>
        <div class="row flexfooter justify-content-center">
            <img src="@/assets//LogoIcone.png" class="img-fluid logofooter" alt="Logo VidalHyperCars">
            <p class="m-4">
                VIDAL HYPERCARS BRAZIL<br>
                CNPJ: 98.982.264/0001-92 <br>
                Av. Atlântica, 1702 - Copacabana, Rio de Janeiro - RJ, 22021-001 <br>
                Telefones: +55 (21) 2548-7070 / 2548-9572 <br>
                WhatsApp: (21) 97301-3437
            </p>  
            <div class="redessociais">
                <div class="row justify-content-center mt-3">
                    <h5 class="redessociaistext">REDES SOCIAIS</h5>
                </div>
                <div class="row justify-content-center mt-2">
                    <a target="_blank" href="https://api.whatsapp.com/send?phone=5521973013437&text=Olá!%20Estou%20interessado%20em%20adquirir%20um%20carro%20na%20VidalHyperCars."><img src="@/assets/whatsapp.png" class="img-fluid whatsapp" alt="icone whatsapp"></a>
                    <a target="_blank" href="https://www.facebook.com/"><img src="@/assets/icons8_Facebook_60px.png" class="img-fluid" alt="icone facebook"></a>
                    <a target="_blank" href="https://www.instagram.com/"><img src="@/assets/icons8_instagram_64px.png" class="img-fluid" alt="icone instagram"></a>
                    <a target="_blank" href="https://twitter.com/"><img src="@/assets/icons8_twitter_64px.png" class="img-fluid" alt="icone twitter"></a>
                </div>                
            </div>
        </div>
    </footer>  
  </div>
</template>

<script>
import apiUsuarios from '@/services/ApiUsuarios.js'

export default {
  name: "Inicio",
  data(){
    return{
      usuario:{
        id: "",
        cpf: "",
        senha: "",
      },
      mask: "###.###.###-##"
    }  
  },
  
  methods:{
    login(){
        if ((this.usuario.cpf == 999) && (this.usuario.senha == 999)) {
            this.usuario.id = 999999999
            this.$router.push({path: `cadastrarModelo/adm/${this.usuario.id}`});
            
        }else{
            apiUsuarios.retornaPorCpf(this.usuario)       
            .then(resp =>{
                if ((this.usuario.cpf == resp.data.cpf) && (this.usuario.senha == resp.data.senha)) {
                    this.usuario = resp.data;
                    this.$router.push({path: `comprar/${this.usuario.id}`});
                }else{
                    if (this.usuario.cpf != resp.data.cpf) {
                        document.getElementById("cpf").style.border="1px solid #ff0000d1";
                        document.getElementById("cpf").style.boxShadow="1px 1px 10px 4px #ff0000d1";
                    }

                    if (this.usuario.senha != resp.data.senha) {
                        document.getElementById("senha").style.border="1px solid #ff0000d1";
                        document.getElementById("senha").style.boxShadow="1px 1px 10px 4px #ff0000d1";
                        this.usuario.senha="";
                        alert("Senha Incorreta")
                    }
                }
            })
        }          
    },

    apagarLinhaVermelha(id){
        document.getElementById(id).style.border="1px solid #ced4da";
        document.getElementById(id).style.boxShadow="0 0 0 0.2rem rgba(0, 123, 255, 0.25)";        
        document.getElementById(id).style.borderColor= "#80bdff";
    }

  }
}

</script>

<style scoped>
  .col-12{
      margin: 0;
  }

  h1{
      color: white;
  }

  .posicao{
      padding: 0 3rem 0 5rem;
  }

  .whatsapp{
      margin-right: 8px;
      margin-top: 4px;
      max-width: 50px;
  }

</style>