package com.myproject.aem.core.services.email.impl;

import java.util.ArrayList;
import javax.mail.internet.InternetAddress;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.myproject.aem.core.services.email.EmailTriggerService;

@Component(immediate = true)
public class EmailTriggerServiceImpl implements EmailTriggerService{

    private static final Logger LOG = LoggerFactory.getLogger(EmailTriggerServiceImpl.class);

    @Reference
    MessageGatewayService messageGatewayService;

    @Override
    public boolean sendEmailWithoutAttachment(String from, String toEmail, String subject, String body){
        MultiPartEmail email = new HtmlEmail();
        ArrayList<InternetAddress> emailRecipents = new ArrayList<InternetAddress>();

        try{
            if(toEmail.contains(";")){
                String[] multipleAddress = toEmail.split(";");
                for(String address : multipleAddress){
                    emailRecipents.add(new InternetAddress(address));
                    LOG.info("Email Address: " + emailRecipents.size());
                }
            } else{
                emailRecipents.add(new InternetAddress(toEmail));
            }
            email.setFrom(from); //from mail
            email.setTo(emailRecipents); // to Email
            email.setSubject(subject); // subject
            email.addPart(body, "text/html; charset=UTF-8");
            email.setCharset("UTF-8");

            final MessageGateway<MultiPartEmail> messageGateway = messageGatewayService.getGateway(MultiPartEmail.class);

            if(null != messageGateway){
                messageGateway.send(email);
                LOG.info("class:EmailTriggerServiceImpl - sendEmail - Email Sent!!");
                return true;
            } else{
                LOG.info("class:EmailTriggerServiceImpl - sendEmail - please check email configuration.");
                return false;
            }
        } catch (final Exception e){
            LOG.error("class:EmailTriggerServiceImpl - sendEmail - exception -", e);
        }
        return false;
    }

}
