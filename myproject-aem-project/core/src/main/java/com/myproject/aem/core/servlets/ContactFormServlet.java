package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drew.lang.annotations.NotNull;
import com.myproject.aem.core.models.RecaptchaModel;
import com.myproject.aem.core.services.email.EmailTriggerService;
import com.myproject.aem.core.services.recaptcha.RecaptchaService;

@Component(service = Servlet.class, property = {
    ServletResolverConstants.SLING_SERVLET_PATHS + "=" + "/bin/ContactFormServlet",
    ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST
})
public class ContactFormServlet extends SlingAllMethodsServlet{

    @Reference
    RecaptchaService recaptchaService;

    @Reference
    EmailTriggerService emailTriggerService;

    private static final String CLASS_NAME = ContactFormServlet.class.getSimpleName();

    private static final Logger LOG = LoggerFactory.getLogger(ContactFormServlet.class);

    private static final String RESPONSE_TYPE = "text/html";

    @NotNull
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        doProcessing(request, response);
    }

    private void doProcessing(SlingHttpServletRequest request, SlingHttpServletResponse response){
        response.setContentType(RESPONSE_TYPE);
        try{
            String company = request.getParameter("companyName");
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String country = request.getParameter("country");
            String formCaptcha = request.getParameter("g-recaptcha-response");

            boolean validCaptcha = validationRecaptcha(formCaptcha);
            JSONObject jsonObject = new JSONObject();
            if(validCaptcha){
                //String body = getContentFramentTemplatedata(respConnetctionFcarory.getConnection().getresResolver());
                response.setContentType("application/json;chartset=UTF-8");
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//                if(StringUtils.isNotBlank(body)){
//                    String replacedEmailFinalBody = replaceBody(body, phone,email,name);
//                }
               // emailTriggered(fromEmailAddress, toEmailAddress, subject,replacedEmailFinalBody);
                response.setStatus(SlingHttpServletResponse.SC_OK);
                jsonObject.put("message", "servlet calling");
                response.getWriter().write("successful");
                response.getWriter().append(jsonObject.toString());
            }
        }catch(Exception e){
            LOG.error("exception while calling servlet", e.getMessage(), CLASS_NAME);
        }
    }

    private boolean validationRecaptcha(String formCaptcha){
        return recaptchaService.validationRecaptcha(formCaptcha);
    }


    /* Email Trigger method */
    // private void emailTriggered(String from, String toEmail, String subject, String body){
    //     try{
    //         boolean emailstatus = emailTriggerService.sendEmailWithoutAttachment(from, toEmail, body, subject);
    //     }catch(Exception e){
    //         LOG.error("exception in method emailTriggered", e);
    //     }
    // }

//    /* Content Fragment template data*/
//
//    private String getContentFramentTemplatedata(ResourceResolver resolver)throws NullPointerException{
//        String body ="";
//        try{
//            if (resolver != null){
//                Resource res = resolver.getResource("contentFramentPath");
//                if(res != null){
//                    ContentFragment contentFragment = res.adaptTo(ContentFragment.class);
//                    if(contentFragment != null){
//                        Iterator<ContentElement> contentElementiterator = contentFragment.getElements();
//                        while (contentElementiterator.hasNext()){
//                            ContentElement contentElementObject = contentElementiterator.next();
//                            body = contentElementObject.getContent();
//                        }
//                    }
//                }
//            } return body;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }


//    /* replace body method */
//
//    public String replaceBody (String body, String name ,  String email, String phone) {
//        String replaceBody ="";
//        if(body.contains("%name%")){
//            replaceBody = body.replace("%name%",name);
//        }
//        if(body.contains("%email%")){
//            replaceBody = body.replace("%mail%",email);
//        }
//        if(body.contains("%phone%")){
//            replaceBody = body.replace("%phone%",phone);
//        }
//        if(StringUtils.isNotBlank(replaceBody)){
//            return replaceBody;
//        } else{
//            return body;
//        }
//    }
}
