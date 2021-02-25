<template>
  <div class="painel">
    <MenuLateral :idUsuario=idUsuario :nomeUsuario=nomeCompleto />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario=nomeCompleto />
        <div class="posicaoDashboard">  
          <div class="cadastroVeiculo">
            <div class="row justify-content-center">
              <h1 class="m-3 text-center">Cadastro de veículo</h1>      
            </div>
            <div class="row justify-content-center">
              <div class="box">
                <hr class="linha">
                <h3>Ficha Técnica</h3>
                <hr class="linha">
                <form>
                  <div class="row mtop">
                    <div class="col-4">
                      <label for="codigoVeiculo">Codigo do veículo</label>
                      <input type="text" class="form-control" id="codigoVeiculo" placeholder="Ex: 001" v-model="modelo.codigo" @change="$v.modelo.codigo.$touch()" @blur="verificaExistenciaModelo">
                      <p class="errorForm" v-if="$v.modelo.codigo.$error">O código é obrigatório</p>
                      <p class="errorForm" v-if="existeModelo == true">Código já cadastrado anteriomente.</p>
                    </div>            
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="fabricante">Modelo</label>
                      <input type="text" class="form-control" id="fabricante" placeholder="Ex: F8 Tributo" v-model="modelo.modelo" @change="$v.modelo.modelo.$touch()">
                      <p class="errorForm" v-if="$v.modelo.modelo.$error">O modelo é obrigatório</p>
                    </div>
                    <div class="col">
                      <label for="fabricante">Marca</label>
                      <select class="marca" v-model="modelo.marca" @change="$v.modelo.marca.$touch()">
                        <option></option>	
                        <option>BMW</option>
                        <option>Bugatti</option>
                        <option>Ferrari</option>
                        <option>koenigsegg</option>	
                        <option>Lamborghini</option>
                        <option>McLaren</option>
                        <option>Pagani</option>
                        <option>Porsche</option>
                      </select>
                      <p class="errorForm" v-if="$v.modelo.marca.$error">A marca é obrigatório</p>
                    </div>
                    <div class="col">              
                      <label for="preco">Preço (R$)</label>
                      <input v-money="money" type="tel" class="form-control" id="ano" v-model="modelo.preco" @change="$v.modelo.preco.$touch()">
                      <p class="errorForm" v-if="$v.modelo.preco.$error">O preço é obrigatório</p>
                    </div>            
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="ano">Ano</label>
                      <input type="number" class="form-control" id="ano" placeholder="Ex: 2010" v-model="modelo.ano">
                    </div>
                    <div class="col">
                      <label for="combustível">Combustível</label>
                      <input type="text" class="form-control" id="combustível" placeholder="Ex: Gasolina" v-model="modelo.combustivel">
                    </div>           
                    <div class="col">
                      <label for="garantia">Garantia</label>
                      <input type="text" class="form-control" id="garantia" placeholder="Ex: 5 anos e 6 meses" v-model="modelo.garantia">
                    </div>            
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="Lugares">Quantidade De Lugares</label>
                      <input type="number" class="form-control" id="Lugares" placeholder="Ex: 4" v-model="modelo.quantidadeLugares">
                    </div>
                    <div class="col">
                      <label for="portas">Quantidade De Portas</label>
                      <input type="number" class="form-control" id="portas" placeholder="Ex: 4" v-model="modelo.quantidadePortas">
                    </div>
                    <div class="col">
                      <label for="ipva">IPVA (R$)</label>
                      <input v-money="money" type="tel" class="form-control" id="ipva" v-model="modelo.ipva">
                    </div>          
                  </div>
                  <hr class="linha mt-5">
                  <h3>Desempenho</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="velocidadeMaxima">Velocidade máxima (km/h)</label>
                      <input type="number" class="form-control" id="velocidadeMaxima" placeholder="Ex: 300" v-model="modelo.velocidadeMaxima">
                    </div>
                    <div class="col">
                      <label for="aceleração">Aceleração 0-100 km/h</label>
                      <input type="text" class="form-control" id="aceleração" placeholder="Ex: 4,4 s" v-model="modelo.aceleracao">
                    </div>   
                  </div>
                  <hr class="linha mt-5">
                  <h3>Motor</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="cilindros">Cilindros</label>
                      <input type="text" class="form-control" id="cilindros" placeholder="Ex: 3 em linha" v-model="modelo.cilindros">
                    </div>
                    <div class="col">
                      <label for="valvulasPorCilindro">Válvulas por cilindro</label>
                      <input type="text" class="form-control" id="valvulasPorCilindro" placeholder="Ex: 4" v-model="modelo.valvulasPorCilindro">
                    </div>   
                    <div class="col">
                      <label for="cilindradas">Cilindradas</label>
                      <input type="text" class="form-control" id="cilindradas" placeholder="Ex: 1499" v-model="modelo.cilindradas">
                    </div> 
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="pesoPotência">Peso/Potência</label>
                      <input type="text" class="form-control" id="pesoPotência" placeholder="Ex: 6,6 kg/cv" v-model="modelo.pesoPotencia">
                    </div>
                    <div class="col">
                      <label for="pesoTorque">Peso/Torque</label>
                      <input type="text" class="form-control" id="pesoTorque" placeholder="Ex: 6,6 kg/kgfm" v-model="modelo.pesoTorque">
                    </div>   
                    <div class="col">
                      <label for="aspiração">Aspiração</label>
                      <input type="text" class="form-control" id="aspiração" placeholder="Ex: Turbocompressor" v-model="modelo.aspiracao">
                    </div> 
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="alimentação">Alimentação</label>
                      <input type="text" class="form-control" id="alimentação" placeholder="Ex: Direta" v-model="modelo.alimentacao">
                    </div>
                    <div class="col">
                      <label for="ComandoDeValvulas">Comando de válvulas</label>
                      <input type="text" class="form-control" id="ComandoDeValvulas" placeholder="Ex: Duplo no cabeçote" v-model="modelo.comandoValvulas">
                    </div>   
                    <div class="col">
                      <label for="variaçãoDeComando">Variação de comando</label>
                      <input type="text" class="form-control" id="variaçãoDeComando" placeholder="Ex: Admissão e escape" v-model="modelo.variacaoComando">
                    </div> 
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="diametroDosCilindros">Diâmetro dos cilindros</label>
                      <input type="text" class="form-control" id="diametroDosCilindros" placeholder="Ex: 82 mm" v-model="modelo.diametroCilindros">
                    </div>
                    <div class="col">
                      <label for="cursoDosPistões">Curso dos pistões</label>
                      <input type="text" class="form-control" id="cursoDosPistões" placeholder="Ex: 6,6 kg/cv" v-model="modelo.cursoPistoes">
                    </div> 
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="potenciaMaxima">Potência máxima</label>
                      <input type="text" class="form-control" id="potenciaMaxima" placeholder="Ex: 231 v a 5800 rpm" v-model="modelo.potenciaMaxima">
                    </div>
                    <div class="col">
                      <label for="torqueMaximo">Torque máximo</label>
                      <input type="text" class="form-control" id="torqueMaximo" placeholder="Ex: 32,6 kgfm a 3700 rpm" v-model="modelo.torqueMaximo">
                    </div> 
                  </div>
                  <hr class="linha mt-5">
                  <h3>Consumo de combustível</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="consumoCidade">Cidade (km/L)</label>
                      <input type="number" class="form-control" id="consumoCidade" placeholder="Ex: 24.2" v-model="modelo.consumoCidade">
                    </div>
                    <div class="col">
                      <label for="consumoEstrada">Estrada (km/L)</label>
                      <input type="number" class="form-control" id="consumoEstrada" placeholder="Ex: 27.2" v-model="modelo.consumoEstrada">
                    </div>
                  </div>
                  <hr class="linha mt-5">
                  <h3>Transmissão</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="cambio">Câmbio</label>
                      <input type="text" class="form-control" id="cambio" placeholder="Ex: Automático de 6 marchas" v-model="modelo.cambio">
                    </div>
                    <div class="col">
                      <label for="acoplamento">Acoplamento</label>
                      <input type="text" class="form-control" id="acoplamento" placeholder="Ex: Conversor de torque" v-model="modelo.acoplamento">
                    </div>
                  </div>
                  <hr class="linha mt-5">
                  <h3>Suspensão</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="suspensaoDianteira">Dianteira</label>
                      <input type="text" class="form-control" id="suspensaoDianteira" placeholder="Ex: Independente, braços sobrepostos" v-model="modelo.suspensaoDianteira">
                    </div>
                    <div class="col">
                      <label for="suspensaoTraseira">Traseira</label>
                      <input type="text" class="form-control" id="suspensaoTraseira" placeholder="Ex: Independente, multibraço" v-model="modelo.suspensaoTraseira">
                    </div>
                  </div>
                  <hr class="linha mt-5">
                  <h3>Freios</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="freiosDianteiros">Dianteiros</label>
                      <input type="text" class="form-control" id="freiosDianteiros" placeholder="Ex: Disco ventilado" v-model="modelo.freiosDianteiros">
                    </div>
                    <div class="col">
                      <label for="freiosTraseiros">Traseiros</label>
                      <input type="text" class="form-control" id="freiosTraseiros" placeholder="Ex: Disco ventilado" v-model="modelo.freiosTraseiros">
                    </div>
                  </div>
                  <hr class="linha mt-5">
                  <h3>Dimensões</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="comprimento">Comprimento (mm)</label>
                      <input type="number" class="form-control" id="comprimento" placeholder="Ex: 4689" v-model="modelo.comprimento">
                    </div>
                    <div class="col">
                      <label for="largura">Largura (mm)</label>
                      <input type="number" class="form-control" id="largura" placeholder="Ex: 1942" v-model="modelo.largura">
                    </div>
                    <div class="col">
                      <label for="altura">Altura (mm)</label>
                      <input type="number" class="form-control" id="altura" placeholder="Ex: 1291" v-model="modelo.altura">
                    </div>
                  </div>
                  <div class="row mtop">
                    <div class="col">
                      <label for="DistânciaEntreEixos">Distância entre eixos (mm)</label>
                      <input type="number" class="form-control" id="DistânciaEntreEixos" placeholder="Ex: 2800" v-model="modelo.distanciaEntreEixos">
                    </div>
                    <div class="col">
                      <label for="tanqueDeCombustivel">Tanque de combustível (litros)</label>
                      <input type="number" class="form-control" id="tanqueDeCombustivel" placeholder="Ex: 30" v-model="modelo.tanqueCombustivel">
                    </div>            
                  </div>          
                  <div class="row mtop mb-4">
                    <div class="col">
                      <label for="PortaMalas">Porta-malas (litros)</label>
                      <input type="number" class="form-control" id="PortaMalas" placeholder="Ex: 154" v-model="modelo.portaMalas">
                    </div>
                    <div class="col">
                      <label for="peso">Peso (kg)</label>
                      <input type="number" class="form-control" id="peso" placeholder="Ex: 1535" v-model="modelo.peso">
                    </div>            
                  </div>
                  <h3>Estoque</h3>
                  <hr class="linha">
                  <div class="row mtop">
                    <div class="col">
                      <label for="quantidadeEstoque">Quantidade em estoque</label>
                      <input type="number" class="form-control" id="quantidadeEstoque" placeholder="Ex: 3" v-model="estoque.quantidadeEstoque" @change="$v.estoque.quantidadeEstoque.$touch()">
                      <p class="errorForm" v-if="$v.estoque.quantidadeEstoque.$error">A quantidade é obrigatória</p>
                    </div>            
                  </div>
                  <div class="row mtop mb-4 justify-content-center">            
                    <button type="button" class="btn btn-gold" @click="gravarModelo">Cadastrar</button>                                   
                  </div>
                </form>
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
import apiModelo from '@/services/ApiModelos.js';
import { required } from 'vuelidate/lib/validators';
import apiEstoque from '@/services/ApiEstoque.js';
import {VMoney} from 'v-money'

export default {
  name: "CadastrarModelo",
  components: {
    MenuLateral,
    Header
  },

  data(){
    return{
      textoHeader: "Painel do Administrador",
      nomeCompleto:"Administrador",
      idUsuario: "999999999",
      modelo:{
        codigo: "",
        modelo: "",
        preco: "",
        ano: "",
        combustivel: "",
        marca: "",
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
        peso: ""
      },

      estoque: {
        codigoModelo: "",
        quantidadeEstoque: ""
      },

      money: {
        decimal: ',',
        thousands: '.',        
        precision: 2,
        masked: false 
      },
      
      existeModelo: ""
    }
  },

  directives: {money: VMoney},

  methods:{
    verificaExistenciaModelo(){
      apiModelo.retornaPorCodigo(this.modelo.codigo)
      .then(resp =>{
        if (resp.data.codigo == this.modelo.codigo) {
          this.existeModelo = true

        }else{
          this.existeModelo = false
        }
      })
    },

    gravarModelo(){
      if (this.existeModelo == false) {
        if(!this.$v.$invalid){
        apiModelo.gravarModelo(this.modelo)
          .then(resp =>{
            alert("Modelo cadastrado com sucesso!\nCodigo: " + resp.data.codigo);
            this.estoque.codigoModelo = resp.data.codigo;
            this.criarEstoque(this.estoque);
            })
          .catch(a => alert(a)) 
        }else{
          alert("Existem campos obrigatórios que não foram preenchidos. Por favor verifique.")
          this.$v.$touch();
        } 
      }else{
        alert("O código informado para o modelo já existe.");
      }

              
    },

    criarEstoque(){
      apiEstoque.gravarEstoque(this.estoque)
      .then(resp =>{
        alert("Criado estoque para o modelo " + resp.data.codigoModelo)
      })
    }
  },

  validations:{
    modelo:{
      codigo: { required },
      preco: { required },
      modelo: { required },
      marca: { required }
    },

    estoque:{
      quantidadeEstoque: { required }
    }
  }
}
</script>

<style scoped>
@media only screen and  (max-width: 768px){
  h3{    
    text-align: center;
  }

  .col{
    margin-top: 1.5rem;
  }

}
/* fim media */

  .cadastroVeiculo{
    height: 100%;
    color: #fff;
  } 

  h1{
    font-style: italic;
    color: #d3b04b;
  }

  h3{  
    color: #f0eaeab7;
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;
    padding-left: 15px;
    text-align: center;
    font-family: 'Courier New', Courier, monospace;
    letter-spacing: 2px;
  }
  
  .mtop{
    margin-top: 1.5rem;
  }

  .linha{    
    background-image: linear-gradient(to right, rgb(226, 45, 45) , #d3b04b);
    margin-top: 0; 
    height: 1px;
    margin-bottom: 0;
  }

  .box{
    width: 90%;    
  }

  .form-control{
    color: #fff;
    background-color: #fff0;
    border: 2px solid #fff0;
    border-radius: 0px;
    border-bottom-color: #ffffff;
  }

  .form-control:focus{
    border: 1px solid #d3b14b9a;
    box-shadow: 0 0 0 0.1rem #d3b14b9a;
  }

  ::placeholder { 
    color: #ffffff70;
  }

  label{
    color: #eebf32;
    font-size: 20px;
    margin-bottom: 0;
    padding-left: 0.75rem;    
  }

  .btn{
    width: 400px;
  }

  .btn-gold:hover{
    background-color: #267c1b;
  }

  .errorForm{
    color: #ff2626;    
  }

  .marca{
    color: #fff;
    background-color: #fff0;
    border: 2px solid #fff0;
    border-radius: 0px;
    font-size: 1rem;    
    margin-bottom: 10px;
    border-bottom-color: #fff;
    width: 100%;
    height: 38px;
    padding-left: 0.75rem;
  }

  option{
    color: #000;
  }
</style>