package com.myproject.aem.core.services.recaptcha.impl.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "MyProject Recaptcha Configuration" , description = "Contais MyProject Recaptcha Configuration Values")
public @interface RecaptchaServiceConfiguration {

    @AttributeDefinition(name = "reCaptcha site Key" , description = "Enter Recaptcha site key.")
    String getReCaptchaSiteKey();

    @AttributeDefinition(name = "reCaptcha secret Key" , description = "Enter Recaptcha secret key.")
    String getReCaptchaSecretKey();
}
