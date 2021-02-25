import Vue from 'vue'
import App from './App.vue'
import router from "@/router.js";
import MenuLateral from '@/components/MenuLateral.vue';
import Vuelidate from 'vuelidate';
import {VueMaskDirective} from 'v-mask';
import money from 'v-money';
import VueApexCharts from 'vue-apexcharts'

Vue.use(VueApexCharts)

Vue.directive("mask", VueMaskDirective);
Vue.directive("maskTelefone", VueMaskDirective);
Vue.directive("maskCelular", VueMaskDirective);
Vue.directive("maskData", VueMaskDirective);

Vue.config.productionTip = false

Vue.use(Vuelidate);
Vue.use(money, {precision: 4});

Vue.component("MenuLateral", MenuLateral);

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
