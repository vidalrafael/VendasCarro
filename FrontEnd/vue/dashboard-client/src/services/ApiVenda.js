import {api} from './Config'

let endPoint = "venda/api/v1/venda"

export default{
  retornaTodos: () =>{
    return api.get(endPoint);
  },

  retornaPorId: (id) =>{
    return api.get(endPoint + "/" + id);
  },

  retornaPorCodigoUsuarioComprador: (codigoUsuarioComprador) =>{
    return api.get(endPoint + "/usuario/" + codigoUsuarioComprador);
  },

  retornaPorData: (dataInicial, dataFinal, ordem) =>{
    return api.get(endPoint + "/relatorioVendaDetalhado/" + dataInicial + "/" + dataFinal + "/" + ordem);
  },

  retornaRelatorioVendaConsolidado: (dataInicial, dataFinal, ordem) =>{
    return api.get(endPoint + "/relatorioVendaConsolidado/" + dataInicial + "/" + dataFinal + "/" + ordem);
  },

  gravarVenda: (venda) =>{
    return api.post(endPoint, venda);
  }
}