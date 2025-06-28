package com.myproject.aem.core.services.user.impl;

import com.myproject.aem.core.services.user.Practiceuser;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(service = Practiceuser.class, immediate = true)
public class PracticeuserImpl implements Practiceuser{

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public ResourceResolver getResourceResolver() {
        ResourceResolver resolver = null;
        Map<String, Object> param = getServiceParams();
        try {
            resolver = resourceResolverFactory.getServiceResourceResolver(param);
        } catch (LoginException e) {
            e.printStackTrace();
        }
         return resolver;
    }

    public static Map<String, Object> getServiceParams() {
        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, "practiceService");
        return param;
    }

}
