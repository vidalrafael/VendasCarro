package br.com.vidal.email.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.email.mail.service.EmailSenderService;
import br.com.vidal.email.model.Mail;
import br.com.vidal.email.model.Usuario;
import br.com.vidal.email.model.Venda;

@RestController
@RequestMapping("api/v1/email")
@CrossOrigin
@ComponentScan("br.com.vidal.email.mail.service")
public class EmailController {
  @Autowired
  private EmailSenderService emailService;  
	
	@PostMapping(value = "/confirmaCadastro")
	@CrossOrigin
  public String postConfirmaCadastro(@RequestBody Usuario usuario) throws MessagingException, IOException {		
		Mail mail = new Mail();
		mail.setFrom("vidalhypercars@gmail.com");
		mail.setMailTo(usuario.getEmail());
		mail.setSubject("Confirmação de cadastro");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nome", usuario.getNome());
		model.put("sobrenome", usuario.getSobrenome());
		model.put("sexo", usuario.getSexo());
		model.put("cpf", usuario.getCpf());
		model.put("cep", usuario.getCep());
		model.put("endereco", usuario.getEndereco());
		model.put("bairro", usuario.getBairro());
		model.put("cidade", usuario.getCidade());
		model.put("uf", usuario.getUf());
		model.put("telefone", usuario.getTelefone());
		model.put("celular", usuario.getCelular());
		model.put("email", usuario.getEmail());
		model.put("senha", usuario.getSenha());
		mail.setProps(model);

		emailService.sendEmail(mail, "confirmaCadastro");
		
		return "sucesso";    
	}
	
	@PostMapping(value = "/confirmaVenda")
	@CrossOrigin
  public String postConfirmaVenda(@RequestBody Venda venda) throws MessagingException, IOException {		
		Mail mail = new Mail();
		mail.setFrom("vidalhypercars@gmail.com");
		mail.setMailTo(venda.getUsuarioCompradorResponse().getEmail());
		mail.setSubject("Confirmação de venda");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nome", venda.getUsuarioCompradorResponse().getNome());
		model.put("cpf", venda.getUsuarioCompradorResponse().getCpf());
		model.put("endereco", venda.getUsuarioCompradorResponse().getEndereco());
		model.put("bairro", venda.getUsuarioCompradorResponse().getBairro());
		model.put("cidade", venda.getUsuarioCompradorResponse().getCidade());
		model.put("uf", venda.getUsuarioCompradorResponse().getUf());
		model.put("celular", venda.getUsuarioCompradorResponse().getCelular());
		model.put("modelo", venda.getModeloVendidoResponse().getModelo());
		model.put("marca", venda.getModeloVendidoResponse().getMarca());
		model.put("dataVenda", venda.getDataVenda());
		model.put("quantidade", venda.getQuantidadeVendida());
		model.put("valorTotal", venda.getValorTotal());
		mail.setProps(model);

		emailService.sendEmail(mail, "confirmaVenda");
		
		return "sucesso";    
  }
  
  
}
