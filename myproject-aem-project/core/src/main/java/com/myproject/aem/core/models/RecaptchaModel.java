package com.myproject.aem.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.aem.core.services.recaptcha.RecaptchaService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RecaptchaModel {

    private String siteKey;

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getSiteKey() {
        return siteKey;
    }

    private static final Logger LOG = LoggerFactory.getLogger(RecaptchaModel.class);

    @OSGiService
    RecaptchaService recaptchaService;

    @PostConstruct
    public void initialize(){
        LOG.info("site Key: {}", recaptchaService.getCaptchaSiteKey());

        this.siteKey = recaptchaService.getCaptchaSiteKey();
    }


}
