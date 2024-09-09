package com.MS_Email.Controller;

import com.MS_Email.DTO.EmailDTO;
import com.MS_Email.Entity.EmailEntity;
import com.MS_Email.Service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-email")
    public ResponseEntity<EmailEntity> enviarEmail(@RequestBody @Valid EmailDTO emailDTO){
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDTO,emailEntity);
        emailService.enviaEmail(emailEntity);
        return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
    }
}
