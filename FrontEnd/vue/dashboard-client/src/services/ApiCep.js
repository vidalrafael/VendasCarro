import axios from 'axios';

export const apiCep = axios.create({
  baseURL: "https://viacep.com.br/ws/"
})


export default {
  retornaCep: (cep) => {    
    return apiCep.get(cep + "/json")
  }
  
}



