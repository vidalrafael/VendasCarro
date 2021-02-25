package br.com.vidal.email.mail.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import br.com.vidal.email.model.Mail;

@Service
public class EmailSenderService {
  @Autowired
  private JavaMailSender emailSender;

  @Autowired
  private SpringTemplateEngine templateEngine;

  public void sendEmail(Mail mail, String modeloEmail) throws MessagingException, IOException {
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message,
                                                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                                                    StandardCharsets.UTF_8.name());    

    Context context = new Context();
    context.setVariables(mail.getProps());

    // String html = templateEngine.process("newsletter-template", context);

    String html = "";

    if (modeloEmail.equals("confirmaCadastro")) {
      html = templateEngine.process("ConfirmaCadastro", context);
    }

    if (modeloEmail.equals("confirmaVenda")) {
      html = templateEngine.process("ConfirmaVenda", context);
    }

    helper.setTo(mail.getMailTo());
    helper.setText(html, true);
    helper.setSubject(mail.getSubject());
    helper.setFrom(mail.getFrom());

    emailSender.send(message);
  }
  
}
