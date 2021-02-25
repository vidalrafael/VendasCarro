package br.com.vidal.usuarios.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.usuarios.service.UsuariosService;
import br.com.vidal.usuarios.shared.UsuarioDto;
import br.com.vidal.usuarios.view.model.UsuarioResponse;
import br.com.vidal.usuarios.view.model.UsuariosRequest;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin
public class UsuarioController {
    @Autowired
    UsuariosService service;

    @GetMapping(value = "ordenacao/{ordem}")
    @CrossOrigin
    public ResponseEntity<List<UsuarioResponse>> getRetornaListaUsuarios(@PathVariable String ordem) {
        List<UsuarioDto> listUsuarioDto = service.retornaListaUsuarios(ordem);
        if (listUsuarioDto != null) {
            List<UsuarioResponse> listUsuarioResponse = listUsuarioDto.stream()
                    .map(list -> new ModelMapper().map(list, UsuarioResponse.class)).collect(Collectors.toList());
            return new ResponseEntity<>(listUsuarioResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "cpf/{cpf}")
    @CrossOrigin
    public ResponseEntity<UsuarioResponse> getRetornaUsuarioPorCpf(@PathVariable String cpf) {
        UsuarioDto usuarioDto = service.retornaUsuarioPorCpf(cpf);
        if (usuarioDto != null) {
            return new ResponseEntity<>(new ModelMapper().map(usuarioDto, UsuarioResponse.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}")
    @CrossOrigin
    public ResponseEntity<UsuarioResponse> getRetornaUsuarioPorId(@PathVariable String id) {
        Optional<UsuarioDto> usuarioDto = service.retornaUsuarioPorId(id);

        if (usuarioDto.isPresent()) {
            return new ResponseEntity<>(new ModelMapper().map(usuarioDto.get(), UsuarioResponse.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "nome/{nome}")
    @CrossOrigin
    public ResponseEntity<List<UsuarioResponse>> getRetornaUsuarioPorParteDoNome(@PathVariable String nome) {
        List<UsuarioDto> listUsuarioDto = service.retornaListaUsuariosPorParteDoNome(nome);
        if (listUsuarioDto != null) {
            List<UsuarioResponse> listUsuarioResponse = listUsuarioDto.stream()
                    .map(list -> new ModelMapper().map(list, UsuarioResponse.class)).collect(Collectors.toList());
            return new ResponseEntity<>(listUsuarioResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    @CrossOrigin
    public ResponseEntity<UsuarioResponse> postGravarUsuario(@RequestBody UsuariosRequest request) {
        ModelMapper mapper = new ModelMapper();
        UsuarioDto usuarioDto = mapper.map(request, UsuarioDto.class);
        usuarioDto = service.gravarUsuario(usuarioDto);

        if (usuarioDto != null) {
            return new ResponseEntity<>(mapper.map(usuarioDto, UsuarioResponse.class), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/{id}")
    @CrossOrigin
    public ResponseEntity<UsuarioResponse> putAtualizarUsuario(@PathVariable String id, @RequestBody UsuariosRequest request) {
        Optional<UsuarioDto> usuarioRetornadoDoBancoDto = service.retornaUsuarioPorId(id);

        if (usuarioRetornadoDoBancoDto.isPresent()){
            ModelMapper mapper = new ModelMapper();
            UsuarioDto usuarioDto = mapper.map(request, UsuarioDto.class);

            //#region construção do objeto usuarioDto para manda o PUT para o banco
            usuarioDto.setId(usuarioRetornadoDoBancoDto.get().getId());
            usuarioDto.setCpf(usuarioRetornadoDoBancoDto.get().getCpf());

            if (usuarioDto.getNome() == null){
                usuarioDto.setNome(usuarioRetornadoDoBancoDto.get().getNome());
            }
            
            if (usuarioDto.getSobrenome() == null){
                usuarioDto.setSobrenome(usuarioRetornadoDoBancoDto.get().getSobrenome());
            }

            if (usuarioDto.getSexo() == null){
                usuarioDto.setSexo(usuarioRetornadoDoBancoDto.get().getSexo());
            }

            if (usuarioDto.getCep() == null){
                usuarioDto.setCep(usuarioRetornadoDoBancoDto.get().getCep());
            }

            if (usuarioDto.getEndereco() == null){
                usuarioDto.setEndereco(usuarioRetornadoDoBancoDto.get().getEndereco());
            }

            if (usuarioDto.getBairro() == null){
                usuarioDto.setBairro(usuarioRetornadoDoBancoDto.get().getBairro());
            }

            if (usuarioDto.getCidade() == null){
                usuarioDto.setCidade(usuarioRetornadoDoBancoDto.get().getCidade());
            }

            if (usuarioDto.getUf() == null){
                usuarioDto.setUf(usuarioRetornadoDoBancoDto.get().getUf());
            }

            if (usuarioDto.getTelefone() == null){
                usuarioDto.setTelefone(usuarioRetornadoDoBancoDto.get().getTelefone());
            }

            if (usuarioDto.getCelular() == null){
                usuarioDto.setCelular(usuarioRetornadoDoBancoDto.get().getCelular());
            }

            if (usuarioDto.getEmail() == null){
                usuarioDto.setEmail(usuarioRetornadoDoBancoDto.get().getEmail());
            }

            if (usuarioDto.getSenha() == null){
                usuarioDto.setSenha(usuarioRetornadoDoBancoDto.get().getSenha());
            }
            //#endregion
        
            usuarioDto = service.gravarUsuario(usuarioDto);
            UsuarioResponse usuarioResponse = mapper.map(usuarioDto, UsuarioResponse.class);

            return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable String id){
        Optional<UsuarioDto> usuarioRetornadoDoBancoDto = service.retornaUsuarioPorId(id);

        if (usuarioRetornadoDoBancoDto.isPresent()) {
            service.excluirUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
		
   
    
    
}
