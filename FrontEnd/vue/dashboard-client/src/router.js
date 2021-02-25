import Vue from 'vue';
import VueRouter from 'vue-router';
import Inicio from '@/view/Inicio.vue';
import TelaCadastroUsuario from "@/view/TelaCadastroUsuario.vue";
import Comprar from '@/view/Comprar.vue';
import DadosPessoais from '@/view/DadosPessoais.vue';
import Historico from '@/view/Historico.vue';
import Modelos from '@/view/Modelos.vue';
import CadastrarModelo from '@/view/CadastrarModelo.vue';
import Relatorios from '@/view/Relatorios.vue';
import AdicionarEstoque from '@/view/AdicionarEstoque.vue';
import ConfirmaCompra from '@/view/ConfirmaCompra.vue';
import RelatorioClientes from '@/view/RelatorioClientes.vue';
import RelatorioVeiculos from '@/view/RelatorioVeiculos.vue';
import RelatorioVendasConsolidado from '@/view/RelatorioVendasConsolidado.vue';
import RelatorioVendasDetalhado from '@/view/RelatorioVendasDetalhado.vue';


Vue.use(VueRouter);

export default new VueRouter({
  base: '/',
  mode: 'history',
  routes: [
    { path: '/', component: Inicio },
    { path: '/tela-cadastro-usuario', component: TelaCadastroUsuario },
    { path: '/comprar/:idUsuario', component: Comprar },
    { path: '/dadosPessoais/:idUsuario', component: DadosPessoais },
    { path: '/historico/:idUsuario', component: Historico },
    { path: '/modelos/:idUsuario/:marca', component: Modelos },
    { path: '/cadastrarModelo/adm/:idUsuario', component: CadastrarModelo },
    { path: '/relatorios/adm/:idUsuario', component: Relatorios },
    { path: '/adicionarEstoque/adm/:idUsuario', component: AdicionarEstoque },
    { path: '/ConfirmaCompra/:idUsuario/:codigoModelo', component: ConfirmaCompra },
    { path: '/RelatorioClientes/adm/:idUsuario', component: RelatorioClientes },
    { path: '/RelatorioVeiculos/adm/:idUsuario', component: RelatorioVeiculos },
    { path: '/RelatorioVendasConsolidado/adm/:idUsuario', component: RelatorioVendasConsolidado },
    { path: '/RelatorioVendasDetalhado/adm/:idUsuario', component: RelatorioVendasDetalhado }
  ] 
});