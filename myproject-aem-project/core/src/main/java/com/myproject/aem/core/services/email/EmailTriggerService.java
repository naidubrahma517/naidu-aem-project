package com.myproject.aem.core.services.email;

public interface EmailTriggerService {

    public boolean sendEmailWithoutAttachment(String from, String to, String subject, String body);
}
