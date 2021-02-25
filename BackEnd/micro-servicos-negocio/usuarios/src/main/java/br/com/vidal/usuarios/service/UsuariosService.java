package br.com.vidal.usuarios.service;

import java.util.List;
import java.util.Optional;

import br.com.vidal.usuarios.shared.UsuarioDto;

public interface UsuariosService {
    List<UsuarioDto> retornaListaUsuarios(String ordem);
    UsuarioDto retornaUsuarioPorCpf(String cpf);
		UsuarioDto gravarUsuario(UsuarioDto usuarioDto);
		Optional<UsuarioDto> retornaUsuarioPorId(String id);
		void excluirUsuario(String id);
		List<UsuarioDto> retornaListaUsuariosPorParteDoNome(String nome);
}