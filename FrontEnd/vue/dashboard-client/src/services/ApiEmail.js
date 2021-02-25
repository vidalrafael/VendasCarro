import axios from 'axios';

export const api = axios.create({
  baseURL: 'http://192.168.0.105:8020/',
  withCredentials: false,
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Headers": "Authorization",
    "Access-Control-Allow-Methods": "GET, POST, PUT, OPTIONS",
    "Content-type": "application/json;charset=UTF-8"
  }
})

let endpoint = "api/v1/email"

export default{
  confirmaCadastro: (usuario) =>{
    return api.post(endpoint + "/confirmaCadastro", usuario);
  },

  confirmaVenda: (venda) =>{
    return api.post(endpoint + "/confirmaVenda", venda);
  },


}