package br.com.vidal.usuarios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidal.usuarios.model.Usuario;
import br.com.vidal.usuarios.repository.UsuarioRepositorio;
import br.com.vidal.usuarios.shared.UsuarioDto;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    UsuarioRepositorio repositorio;

    @Override
    public List<UsuarioDto> retornaListaUsuarios(String ordem) {
        List<Usuario> listaUsuarios = new ArrayList<>();

        if (ordem.equals("crescente")) {
            listaUsuarios = repositorio.findAllByOrderByNomeAsc();

        }else if(ordem.equals("decrescente")){
            listaUsuarios = repositorio.findAllByOrderByNomeDesc();
        }

        if (listaUsuarios.isEmpty()) {
            return null;
        }

        List<UsuarioDto> listUsuarioDto = listaUsuarios.stream()
                .map(list -> new ModelMapper().map(list, UsuarioDto.class)).collect(Collectors.toList());

        return listUsuarioDto;
    }

    @Override
    public UsuarioDto retornaUsuarioPorCpf(String cpf) {
        Usuario usuario = repositorio.findByCpf(cpf);

        if (usuario != null) {
            return new ModelMapper().map(usuario, UsuarioDto.class);
        }

        return null;
    }

    @Override
    public UsuarioDto gravarUsuario(UsuarioDto usuarioDto) {
        ModelMapper mapper = new ModelMapper();
        Usuario usuario = repositorio.save(mapper.map(usuarioDto, Usuario.class));

        return mapper.map(usuario, UsuarioDto.class);
    }

    @Override
    public Optional<UsuarioDto> retornaUsuarioPorId(String id) {
        Optional<Usuario> usuario = repositorio.findById(id);

        if (usuario.isPresent()) {
            return Optional.of(new ModelMapper().map(usuario.get(), UsuarioDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void excluirUsuario(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<UsuarioDto> retornaListaUsuariosPorParteDoNome(String nome) {
        List<Usuario> listaUsuarios = repositorio.findByNomeContaining(nome);

        if (listaUsuarios.isEmpty()) {
            return null;
        }

        List<UsuarioDto> listUsuarioDto = listaUsuarios.stream()
            .map(list -> new ModelMapper().map(list, UsuarioDto.class)).collect(Collectors.toList());

        return listUsuarioDto;
    }
    
}
