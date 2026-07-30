package com.myproject.aem.core.servlets;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;

import com.adobe.granite.ui.components.rendercondition.RenderCondition;
import com.adobe.granite.ui.components.rendercondition.SimpleRenderCondition;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import org.osgi.service.component.annotations.Component;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes=myproject/components/renderconditions/templatecondition",
                "sling.servlet.methods=GET"
        })
public class TemplateRenderConditionServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) {

        Resource resource = request.getResource();

        PageManager pageManager =
                resource.getResourceResolver().adaptTo(PageManager.class);

        Page currentPage = pageManager.getContainingPage(resource);

        boolean show = false;

        if (currentPage != null) {

            String template =
                    currentPage.getProperties().get("cq:template", String.class);

            String expectedTemplate =
                    resource.getValueMap().get("templatePath", "");

            show = expectedTemplate.equals(template);

        }

        request.setAttribute(
                RenderCondition.class.getName(),
                new SimpleRenderCondition(show));

    }
}
