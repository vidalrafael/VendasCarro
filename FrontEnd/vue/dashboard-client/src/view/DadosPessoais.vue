<template>
  <div class="painel">
    <MenuLateral :idUsuario=usuario.id :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />
    <div class="colunaPainel p-0">
      <div class="row">
        <Header :titulo=textoHeader :nomeUsuario="nomeCompleto" :sexo=usuario.sexo />  
        <div class="posicaoDashboard">
          <div class="dadospessoais ">
            <div class="row justify-content-center">
              <h1 class="m-3 text-center">DADOS PESSOAIS</h1>      
            </div>
            <div class="row justify-content-center mt-4 mb-5">
              <div class="box">
                <div class="row justify-content-center">
                  <h4>Informações Pessoais</h4>          
                </div>   
                <div class="row justify-content-center">
                  <a class="editar" @click="habilitaEdicao">Editar dados</a>  
                </div>           
                <hr class="linha">
                <div class="row">
                  <div class="col-6 p-0">
                    <label class="mr-2">Nome:</label>
                    <label v-show="inputDisabled == true">{{ usuario.nome }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="text" v-model="usuario.nome" @submit="$v.usuario.nome.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.nome.$error">O nome não pode ficar em branco.</p>
                    </div>
                  </div>
                  <div class="col-6 p-0">
                    <label class="mr-2">Sobrenome:</label>
                    <label v-show="inputDisabled == true">{{ usuario.sobrenome }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="text" v-model="usuario.sobrenome" @submit="$v.usuario.sobrenome.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.sobrenome.$error">O sobrenome não pode ficar em branco.</p>              
                    </div>
                  </div>          
                </div>
                <hr class="linha">
                <div class="row">
                  <div class="col-6 p-0">
                    <label class="mr-2">CPF:</label>
                    <label>{{ usuario.cpf }}</label>            
                  </div>
                  <div class="col-6 p-0">
                    <label class="mr-2">Sexo:</label>
                    <label v-show="inputDisabled == true">{{ usuario.sexo }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <div class="inputbox p-0">								
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="Masculino" v-model="usuario.sexo">
                          <label class="form-check-label" for="inlineRadio1">Masculino</label>
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="Feminino" v-model="usuario.sexo">
                          <label class="form-check-label" for="inlineRadio2">Feminino</label>
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="Outros" v-model="usuario.sexo" @submit="$v.usuario.sexo.$touch()"> 
                          <label class="form-check-label" for="inlineRadio2">Outros</label>									
                        </div>
                        <p class="errorForm" v-if="$v.usuario.sexo.$error">O Sexo não pode ficar em branco.</p>
                      </div>
                    </div>
                  </div>          
                </div>
                <hr class="linha">
                <div class="row">
                  <div class="col-12 p-0 m-0">
                    <label class="mr-2">Endereço: </label>
                    <label v-show="inputDisabled == true">{{ usuario.endereco }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="text" v-model="usuario.endereco" @submit="$v.usuario.endereco.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.endereco.$error">O endereço não pode ficar em branco.</p>
                    </div>
                  </div>          
                </div>        
                <hr class="linha">
                <div class="row">
                  <div class="col-4 p-0">
                    <label class="mr-2">Bairro: </label>
                    <label v-show="inputDisabled == true">{{ usuario.bairro }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="text" v-model="usuario.bairro" @submit="$v.usuario.bairro.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.bairro.$error">O bairro não pode ficar em branco.</p>
                    </div>
                  </div>          
                  <div class="col-4 p-0 centralizarEndereço">
                    <label class="mr-2">Cidade: </label>
                    <label v-show="inputDisabled == true">{{ usuario.cidade }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="text" v-model="usuario.cidade" @submit="$v.usuario.cidade.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.cidade.$error">A cidade não pode ficar em branco.</p>
                    </div>
                  </div>
                  <div class="col-4 p-0 centralizarEndereço">
                    <label class="mr-2">UF:</label>
                    <label v-show="inputDisabled == true">{{ usuario.uf }}</label>
                    <div class="row" v-show="inputDisabled == false">              
                      <select class="uf" v-model="usuario.uf" @submit="$v.usuario.uf.$touch()">										
                        <option>AC</option>
                        <option>AL</option>
                        <option>AP</option>
                        <option>AM</option>
                        <option>BA</option>
                        <option>CE</option>
                        <option>DF</option>
                        <option>ES</option>
                        <option>GO</option>
                        <option>MA</option>
                        <option>MT</option>
                        <option>MS</option>
                        <option>MG</option>
                        <option>PA</option>
                        <option>PB</option>
                        <option>PR</option>
                        <option>PE</option>
                        <option>PI</option>
                        <option>RJ</option>
                        <option>RN</option>
                        <option>RS</option>
                        <option>RO</option>
                        <option>RR</option>
                        <option>SC</option>
                        <option>SP</option>
                        <option>SE</option>
                        <option>TO</option>
                      </select>
                    </div>
                  </div>               
                </div>
                <hr class="linha">
                <div class="row justify-content-center">
                  <h4>Informações De Contato</h4>
                </div>        
                <hr class="linha">
                <div class="row">
                  <div class="col-6 p-0">
                    <label class="mr-2">Celular: </label>
                    <label v-show="inputDisabled == true">{{ usuario.celular }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input v-mask="maskCelular" class="input" type="text" v-model="usuario.celular" @submit="$v.usuario.celular.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.celular.$error">O celular não pode ficar em branco.</p>
                    </div>
                  </div>
                  <div class="col-6 p-0">
                    <label class="mr-2">Telefone Fixo:</label>
                    <label v-show="inputDisabled == true">{{ usuario.telefone }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input v-mask="maskTelefone" class="input" type="text" v-model="usuario.telefone" />
                    </div>
                  </div>          
                </div>
                <hr class="linha">
                <div class="row">
                  <div class="col-12 p-0 m-0">
                    <label class="mr-2">Email: </label>
                    <label v-show="inputDisabled == true">{{ usuario.email }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="email" v-model="usuario.email" @submit="$v.usuario.email.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.email.$error">O email não pode ficar em branco.</p>
                    </div>
                  </div>                    
                </div>
                <hr class="linha">
                <div class="row justify-content-center">
                  <h4>Informações De Login</h4>
                </div>        
                <hr class="linha">
                <div class="row">
                  <div class="col-6 p-0">
                    <label class="mr-2">Login: </label>
                    <label>{{ usuario.cpf }}</label>            
                  </div>
                  <div class="col-6 p-0">
                    <label class="mr-2">Senha:</label>
                    <label v-show="inputDisabled == true">{{ usuario.senha }}</label>
                    <div class="row" v-show="inputDisabled == false">
                      <input class="input" type="text" v-model="usuario.senha" @submit="$v.usuario.senha.$touch()"/>
                      <p class="errorForm" v-if="$v.usuario.senha.$error">A senha não pode ficar em branco.</p>
                    </div>
                  </div>          
                </div>                
                <hr class="linha" v-show="inputDisabled == false">
                <div class="row justify-content-center" v-show="inputDisabled == false">          
                  <button class="btn btn-gold" @click="atualizarDados">Atualizar Dados</button>
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
import apiUsuarios from '@/services/ApiUsuarios.js';
import { required } from 'vuelidate/lib/validators';
import MenuLateral from "@/components/MenuLateral.vue";
import Header from "@/view/Header.vue";


export default {
  name: "DadosPessoais",
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
      maskTelefone: "(##) ####-####",
      maskCelular: "(##) #####-####",     

      inputDisabled: true
    }
  },
  

  mounted(){
    apiUsuarios.retornaPorId(this.$route.params.idUsuario)
    .then(resp =>{
      this.usuario = resp.data;
      this.nomeCompleto = `${this.usuario.nome} ${this.usuario.sobrenome}`
    })   
  },

  methods:{
    habilitaEdicao(){
      this.inputDisabled = false
    },

    atualizarDados(){
      if(!this.$v.$invalid){
        apiUsuarios.atualizarUsuario(this.usuario)
        .then(resp => {
          alert("Usuario " + resp.data.nome + " atualizado com sucesso!");
          location.reload();
        })
      }else{
        this.$v.$touch();
      }
    }
  },

  validations:{
    usuario:{
      nome: { required },
      sobrenome: { required },
      sexo: { required },
      cep: { required },
      endereco: { required },
      bairro: { required },
      cidade: { required },
      celular: { required },
      email: { required },
      senha: { required }
    }
  }
}
</script>

<style scoped>
@media only screen and (max-width: 768px){
  .email{
    font-size: 15px;
  }

  .m-left{
    margin-left: 0 !important;
  }

  .centralizarEndereço{
    text-align: start !important;
  }

  
}
/* Fim Media */

  .m-left{
    margin-left: 0.5rem;
  }

  .centralizarEndereço{
    text-align: center;
  }

  .dadospessoais{
    width: 100%;
    color:  white;
  }

  h1{
    font-style: italic;
    color: #d3b04b;
  }

  h4{
    font-style: italic;
    color: #8f7731;
  }

  .box{
    width: 80%;
    max-width: 1000px;
    padding: 20px;
    border-radius: 20px;
    box-shadow: 0px 0px 15px 5px #d3b04b;
  }

  .linha{
    background-color: #d3b14ba1;    
    height: 2px;
    margin-top: 15px;
  }

  label{
    font-size: 20px;
  }

  .input{
    color: #fff;
    background-color: #fff0;
    border: 2px solid #fff0;
    border-radius: 0px;
    font-size: 20px;
    padding-right: 30px;
    margin-left: -5px;
    margin-bottom: 10px;
    border-bottom-color: rgb(155, 148, 148);
    width: 90%;
  }

  input:focus{
    border: 1px solid #d3b14b9a !important;
    box-shadow: 0 0 0 0.1rem #d3b14b9a;
    outline: 0;
  }

  .uf{
    color: #fff;
    background-color: #fff0;
    border: 2px solid #fff0;
    border-radius: 0px;
    font-size: 20px;
    padding-right: 30px;
    margin-left: -5px;
    margin-bottom: 10px;
    border-bottom-color: rgb(155, 148, 148);
    width: 90%;
  }

  .editar{
    text-decoration: underline;
    color: rgb(209, 106, 106);
    cursor: pointer;
  }

  .mr-2{
    color: rgb(158, 158, 158);
  }

  option{
    color: #000;
  }

  .errorForm{
    color: #ff2626;
  }

</style>