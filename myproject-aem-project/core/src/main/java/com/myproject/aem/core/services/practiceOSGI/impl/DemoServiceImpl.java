package com.myproject.aem.core.services.practiceOSGI.impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.myproject.aem.core.services.practiceOSGI.DemoService;
import com.myproject.aem.core.services.user.Practiceuser;
import org.apache.poi.util.Removal;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.util.Collections;
import java.util.Iterator;

@Component(service = DemoService.class ,immediate = true )
public class DemoServiceImpl implements DemoService{
    private static final Logger LOG = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Reference
    Practiceuser practiceuser;

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Activate
    public void activate(ComponentContext componentContext){
        LOG.info("======= Inside Activate ========");
        LOG.info("\n {} = {} ", componentContext.getBundleContext().getBundle().getBundleId(), componentContext.getBundleContext().getBundle().getSymbolicName());
    }

    @Deactivate
    public void deActivate(){
        LOG.info("======= Inside Activate ========");
    }


    @Override
    public Iterator<Page> getPages() {
        try {
            LOG.info(" Iterator<Page> getPages() method loading");
            ResourceResolver resourceResolver1 = practiceuser.getResourceResolver();
            LOG.info(" from practice resource, {} ", resourceResolver1.getUserID());
            ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(Collections.singletonMap(ResourceResolverFactory.SUBSERVICE,"practiceService"));
            LOG.info(" from factory resource, {} ", resourceResolver.getUserID());
            Resource resource = resourceResolver.getResource("/content/myproject/in/en");
            LOG.info("======= resource ========");
            PageManager pageManager = resource.adaptTo(PageManager.class);
            Page page = pageManager.getPage("/content/myproject/in/en");
            LOG.info("======= page ========");
            Iterator<Page> pages = page.listChildren();
            LOG.info("======= pages ========");
            return pages;
        } catch(Exception e){
            LOG.info("Exception {}", e.getMessage());
        }
        return null;
    }
}