import {api} from './Config';

let endPoint = '/modelos/api/v1/modelos'

export default {
  retornaTodos: (ordem)=>{
    return api.get(endPoint + "/todos/" + ordem);
  },

  retornaPorCodigo: (codigo) =>{
    return api.get(endPoint + '/' + codigo);
  },

  retornaPorParteDoModelo: (modelo) =>{
    return api.get(endPoint + '/modelo/' + modelo);
  },

  retornaPorMarca: (marca) =>{
    return api.get(endPoint + "/marca/" + marca);
  },

  gravarModelo: (modelo) =>{
    return api.post(endPoint, modelo);
  }
}
