<template>
  <div class="row justify-content-center cadastroUsuario">
		<div class="col-8 resp">
			<div class="row">
				<img src="@/assets/LogoIcone.png" class="img-fluid centerAlign logoCadastro" alt="Logo Vidal HyperCars">
			</div>
			<div class="row mt-4">
				<form class="formUsuario">
					<div class="bannerCadastro">
						<h1 class="textBanner">VIDAL HYPERCARS - CADASTRO</h1>
					</div>
					<hr class="linhaBranca">
						<div class="row flex-row ">
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="nome">Nome</label>
									<input type="text" class="form-control" id="nome" placeholder="Ex: João" v-model="usuario.nome" @change="$v.usuario.nome.$touch()" @blur="nomeUsuario">
									<p class="errorForm" v-if="$v.usuario.nome.$error">O nome é obrigatório</p>									
								</div>
							</div>
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="sobrenome">Sobrenome</label>
									<input  type="text" class="form-control" id="sobrenome" placeholder="Ex: Silva de Oliveira" v-model="usuario.sobrenome" @change="$v.usuario.sobrenome.$touch()">
									<p class="errorForm" v-if="$v.usuario.sobrenome.$error">O sobrenome é obrigatório</p>
								</div>
							</div>
						</div>
						<div class="row flex-row ">
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="cpf">CPF</label>
									<input v-mask="mask" type="tel" class="form-control" id="cpf" placeholder="Ex: 999.999.999-99" v-model="usuario.cpf" @change="$v.usuario.cpf.$touch()">
									<p class="errorForm" v-if="$v.usuario.cpf.$error">O CPF é obrigatório</p>
								</div>
							</div>
							<div class="col-6 inputbox">
								<div class="form-group m-0">
									<label for="sexo">SEXO</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="Masculino" v-model="usuario.sexo">
									<label class="form-check-label" for="inlineRadio1">Masculino</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="Feminino" v-model="usuario.sexo">
									<label class="form-check-label" for="inlineRadio2">Feminino</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="Outros" v-model="usuario.sexo" @change="$v.usuario.sexo.$touch()"> 
									<label class="form-check-label" for="inlineRadio2">Outros</label>									
								</div>
								<p class="errorForm" v-if="$v.usuario.sexo.$error">O Sexo é obrigatório</p>
							</div>
						</div>
						<div class="row flex-row alinhaCep">
							<div class="col-6 inputboxcep">
								<div class="form-group">
									<label for="cep">CEP</label>
									<input  type="number" class="form-control formCep" id="cep" aria-describedby="emailHelp" placeholder="00000000" @blur="buscarCep" v-model="usuario.cep" @change="$v.usuario.cep.$touch()">
									<p class="errorForm" v-if="$v.usuario.cep.$error">O CEP é obrigatório</p>
								</div>
							</div>
							<div class="col-6 inputboxceplink">
								<a class="linkCep" href="https://buscacepinter.correios.com.br/app/endereco/index.php?t" target="_blank">NÃO SEI MEU CEP</a>
							</div>
						</div>
						<div class="row">
							<div class="col-12 inputbox">
								<div class="form-group">
									<label for="logradouro">Endereço</label>
									<input  type="text" class="form-control" id="logradouro" placeholder="Rua Exemplo nº 999 Apt: 101 Bl: 04" v-model="usuario.endereco" @change="$v.usuario.endereco.$touch()">
									<p class="errorForm" v-if="$v.usuario.endereco.$error">O endereco é obrigatório</p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-5 inputbox">
								<div class="form-group">
									<label for="bairro">Bairro</label>
									<input  type="text" class="form-control" id="bairro" placeholder="Ex: Copacapana" v-model="usuario.bairro" @change="$v.usuario.bairro.$touch()">
									<p class="errorForm" v-if="$v.usuario.bairro.$error">O bairro é obrigatório</p>
								</div>
							</div>
							<div class="col-5 inputbox">
								<div class="form-group">
									<label for="cidade">Cidade</label>
									<input  type="text" class="form-control" id="cidade" placeholder="Ex: Rio de Janeiro" v-model="usuario.cidade" @change="$v.usuario.cidade.$touch()">
									<p class="errorForm" v-if="$v.usuario.cidade.$error">A cidade é obrigatória</p>
								</div>
							</div>
							<div class="col-2">
								<div class="form-group ">
									<label for="uf">UF</label>
									<select  id="uf" class="form-control uf" v-model="usuario.uf" @change="$v.usuario.uf.$touch()">
										<option selected></option>
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
									<p class="errorForm" v-if="$v.usuario.uf.$error">A UF é obrigatória</p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="telefone">Telefone / Fixo</label>
									<input v-mask="maskTelefone" type="tel" class="form-control" id="telefone" placeholder="Ex: (21) 9999-9999" v-model="usuario.telefone">
								</div>
							</div>
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="celular">Celular / WhatsApp</label>
									<input v-mask="maskCelular"  type="tel" class="form-control" id="celular" placeholder="Ex: (21) 99999-9999" v-model="usuario.celular" @change="$v.usuario.celular.$touch()">
									<p class="errorForm" v-if="$v.usuario.celular.$error">O celular é obrigatório</p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-12 inputbox">
								<div class="form-group">
									<label for="email">Email</label>
									<input  type="email" class="form-control" id="email" placeholder="Ex: joao@gmail.com" v-model="usuario.email" @change="$v.usuario.email.$touch()">
									<p class="errorForm" v-show="usuario.email == ''" v-if="$v.usuario.email.$error">O email é obrigatório</p>
									<p class="errorForm" v-show="usuario.email != ''" v-if="$v.usuario.email.$error">Email inválido</p>									
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="senha">Senha</label>
									<input  type="password" class="form-control" id="senha" placeholder="Ex: #123abc#" v-model="usuario.senha" @change="$v.usuario.senha.$touch()">
									<p class="errorForm" v-if="$v.usuario.senha.$error" @change="testeBorder">A senha é obrigatória</p>
								</div>
							</div>
							<div class="col-6 inputbox">
								<div class="form-group">
									<label for="confirmacaosenha">Confirmação de Senha</label>
									<input  type="password" class="form-control" id="confirmacaosenha" placeholder="Ex: #123abc#" v-model="usuario.confirmacaosenha" @change="$v.usuario.confirmacaosenha.$touch()">
									<p class="errorForm" v-if="$v.usuario.confirmacaosenha.$error">As senhas não coincidem</p>
								</div>
							</div>
						</div>
						<div class="row justify-content-center">
								<a class="termos" target="_blank" href="https://pt.wikipedia.org/wiki/Wikip%C3%A9dia:P%C3%A1gina_principal">Termos de uso</a>
						</div>
						<div class="row justify-content-center">
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input" id="termos" checked>
								<label class="form-check-label " for="termos">Li e concordo com os termos de uso</label>
							</div>
						</div>
						<div class="row justify-content-center">
							<button type="button" class="btn btn-cadastrar" @click="gravarUsuario">Cadastrar</button>
						</div>
				</form>
			</div>
		</div>
  </div>
</template>

<script>
import ApiUsuarios from '@/services/ApiUsuarios.js'
import ApiCep from '@/services/ApiCep.js'
import ApiEmail from '@/services/ApiEmail.js'
import { required, email, sameAs } from 'vuelidate/lib/validators'

export default {
  name: "TelaCadastroUsuario",
  data(){
		return{
			usuario:{
				nome: "",
				sobrenome: "",
				sexo: '',
				cpf: "",
				cep: "",
				endereco: "",
				bairro: "",
				cidade: "",
				uf: "",
				telefone: "",
				celular: "",
				email: "",
				senha: "",
				confirmacaosenha: ""
			},
			termos: "",
			mask: "###.###.###-##",
			maskTelefone: "(##) ####-####",
			maskCelular: "(##) #####-####",
		}
  },

  methods:{		
    buscarCep(){
			ApiCep.retornaCep(this.usuario.cep)
			.then(resp => {
					this.usuario.endereco = resp.data.logradouro
					this.usuario.bairro = resp.data.bairro
					this.usuario.cidade = resp.data.localidade
					this.usuario.uf = resp.data.uf					
			})
    },

    gravarUsuario(){
			if(!this.$v.$invalid){
				ApiUsuarios.gravarUsuario(this.usuario)
				.then(resp => {
					alert(resp.data.nome + " " + resp.data.sobrenome + " cadastrado com sucesso!")
				
					ApiEmail.confirmaCadastro(this.usuario)
					.then(() =>{
						alert("Verifique sua caixa de email ou a caixa de span com a confirmação do cadastro.")
					})

					this.$router.push({path: `/`});
					
				})
				.catch(erro => alert(erro));
			}else{
				alert("Existem campos obrigatórios que não foram preenchidos. Por favor verifique.")
				this.$v.$touch();
			}			
    },

		nomeUsuario(){
			if (this.usuario.nome == "admin") {
				this.usuario.nome=""
				alert("Não é possível cadastrar o nome 'admin'")
			}
		}
		
  },

	validations:{
		usuario:{
			nome: { required },
			sobrenome: { required },
			sexo: { required },
			cpf: { required },
			cep: { required },
			endereco: { required },
			bairro: { required },
			cidade: { required },
			uf: { required },
			celular: { required },
			email: { required, email },
			senha: { required },
			confirmacaosenha: { sameAs: sameAs('senha') }
		}
	}
}
</script>

<style scoped>
.cadastroUsuario{
	color: #7c5f0d;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-size: 20px;
	background-image: url("../assets/fundo-cinza4.png");
	background-size: cover;
}

.resp{
	max-width: 850px;
}

.formUsuario{
	width: 100%;
	padding: 15px;
	background-color: #b1afab5b;
	border-radius: 15px;
	color: white;
	margin-bottom: 10px;
	box-shadow: 0px 0px 8px 5px #dee2de;
}

.logoCadastro{
	max-width: 200px;
	margin-top: 25px;
}

.bannerCadastro{
	text-align: center;
	color: white;
}

.textBanner{
	font-size: 45px;
	font-style: italic;
}

.linhaBranca{
	background-color: white;
}

.inputbox{
	min-width: 300px;
}

.linkCep{
	color: #f3bb20 !important;
	font-size: 16px;
	text-decoration: underline;
}

.alinhaCep{
	justify-content: start;
}

.inputboxcep{
	flex: 0;
	min-width: 145px;
}

.inputboxceplink{
	min-width: 180px !important;
	padding: 0;
	margin-top: 2.5rem;
}

.btn-cadastrar{
	width: 200px;
	background-color: #0c7c28cc;
	color: white;
	font-size: 20px;
}

label{
	color:#f3bb20
}

h1{
	color:#d3a62b
}

.form-check-label{
	color: #fff;
}

.termos{
	color: #000000d0;
	font-size: 19px;
	text-decoration: underline;
}

.errorForm{
	color: rgb(151, 0, 0);	
}

</style>