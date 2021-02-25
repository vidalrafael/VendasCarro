import {api} from './Config'

let endpoint = "estoque/api/v1/estoque"

export default{
  retornaTodos: () =>{
    return api.get(endpoint);
  },

  retornaPorCodigoModelo: (codigoModelo) =>{
    return api.get(endpoint + "/" + codigoModelo);
  },

  gravarEstoque: (estoque) =>{
    return api.post(endpoint, estoque);
  },

  atualizarEstoque: (estoque) =>{
    return api.put(endpoint + "/adicionar/" + estoque.idEstoque, estoque);
  },

  removerEstoque: (estoque) =>{
    return api.put(endpoint + "/remover/" + estoque.id, estoque);
  }

}