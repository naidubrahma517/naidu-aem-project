package com.myproject.aem.core.services.recaptcha.response;

import java.util.ArrayList;
import java.util.List;

public class RecaptchaResponse {

    private boolean success = false;
    private List<String> errorCodes = new ArrayList<>();


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public List<String> getErrorCodes() {
        return errorCodes;
    }
    
    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    @Override
    public String toString(){
        return "RecaptchaResponse [ success: " + success + ", errorCodes: " + errorCodes + "]";
    }
    

}
