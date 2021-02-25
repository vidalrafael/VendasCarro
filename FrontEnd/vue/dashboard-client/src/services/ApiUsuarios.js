import {api} from './Config.js';

let endPoint = "usuarios/api/v1/usuarios";

export default {

  retornaTodos: (ordem) => {
    return api.get(endPoint + "/ordenacao/" + ordem);
  },

  retornaPorCpf: (usuario) => {
    return api.get(endPoint + "/cpf/" + usuario.cpf);
  },

  retornaPorId: (id) => {
    return api.get(endPoint + "/" + id);
  },

  retornaPorParteDoNome: (nome) => {
    return api.get(endPoint + "/nome/" + nome);
  },

  gravarUsuario: (usuario) => {
    return api.post(endPoint, usuario);
  },

  atualizarUsuario: (usuario) => {
    return api.put(endPoint + "/" + usuario.id, usuario);
  }
}

