package com.myproject.aem.core.services.recaptcha;

public interface RecaptchaService {

    public boolean validationRecaptcha(String recaptchaSubmission);

    public String getCaptchaSiteKey();

}
