package com.myproject.aem.core.services.recaptcha.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.myproject.aem.core.services.recaptcha.RecaptchaService;
import com.myproject.aem.core.services.recaptcha.impl.config.RecaptchaServiceConfiguration;
import com.myproject.aem.core.services.recaptcha.response.RecaptchaResponse;

@Component(service = RecaptchaService.class, enabled = true , immediate = false )
@Designate( ocd = RecaptchaServiceConfiguration.class )
public class RecaptchaServiceImpl implements RecaptchaService{

    private static final Logger LOG = LoggerFactory.getLogger(RecaptchaServiceImpl.class);

    private static final String CAPTCHA_HTTP_URL = "https://www.google.com/recaptcha/api/siteverify";

    private String captchaSecretKey;

    private String captchaSiteKey;

    @Override
    public boolean validationRecaptcha(String recaptchaSubmission){

        String query = null;

        try{
            query = "?secret=" + captchaSecretKey + "&response=" + recaptchaSubmission;
            LOG.info(query);

            HttpClient httpClient = new HttpClient() ;
            GetMethod getMethod = new GetMethod(CAPTCHA_HTTP_URL + query);

            int code = httpClient.executeMethod(getMethod);
            LOG.info("code: {}" , code);

            if(code == 200){
                Gson gson = new Gson();
                RecaptchaResponse recaptchaResponse = gson.fromJson(getMethod.getResponseBodyAsString(), RecaptchaResponse.class);
                if(recaptchaResponse.isSuccess()){
                    getMethod.releaseConnection();
                    return true;
                }
            }
        } catch(IOException | JsonSyntaxException e){
            LOG.error("Exception in getting Recaptcha Response: {}" , e.getMessage());
        }
        return false;
    } 

    @Activate
    protected void Activate(RecaptchaServiceConfiguration config){
        this.captchaSecretKey = PropertiesUtil.toString(config.getReCaptchaSecretKey(), "6Ld2knIqAAAAALoZV2ptR3us-I-9Y4bOeGpq5hKl");

        this.captchaSiteKey = PropertiesUtil.toString(config.getReCaptchaSiteKey(), "6Ld2knIqAAAAAI9ewTgUMixNqINJNGvVFd-oCJt_");
    }

    @Override
    public String getCaptchaSiteKey(){
        return this.captchaSiteKey;
    }

}
