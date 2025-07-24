package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

@Component(service = Servlet.class,
           property = {
            "sling.servlet.paths=/bin/tags",
            "sling.servlet.methods=GET"
        })

public class DynamicDropdownThroughDatasource extends SlingAllMethodsServlet{

    private static final Logger LOG = LoggerFactory.getLogger(DynamicDropdownThroughDatasource.class);

    String parentTag = null;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

                Resource resource = request.getResource();
                String stg = resource.getPath();
                ResourceResolver resourceResolver = request.getResourceResolver();
                Resource res = resourceResolver.getResource(stg);
                Resource dataSourceResource = null;
                if(res != null){
                    dataSourceResource = res.getChild("datasource");
                }
                if(dataSourceResource != null){
                    ValueMap valueMap = dataSourceResource.getValueMap();
                    parentTag = valueMap.get("parentTag", String.class);
                    parentTag = "/content/cq:tags/" + parentTag.replace(":","/");
                    if(parentTag != null){
                        Resource rootTag = resourceResolver.getResource(parentTag);
                        TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
                        if(rootTag != null){
                            LOG.info("when root tag null");
                        }
                        Tag rtTag = rootTag.adaptTo(Tag.class);
                        List<Resource> rsList = new ArrayList<>();

                        for(Iterator<Tag> it = rtTag.listChildren(); it.hasNext();){
                            Tag child = it.next();
                            Map<String, Object> map = new HashMap<>();
                            map.put("value", child.getTagID());
                            map.put("text", child.getTitle());
                            ValueMap vp = new ValueMapDecorator(map);
                            Resource rce = new ValueMapResource(resourceResolver, new ResourceMetadata(), JcrConstants.NT_UNSTRUCTURED, vp);
                            rsList.add(rce);
                        }
                        DataSource ds = new SimpleDataSource(rsList.iterator());
                        request.setAttribute(DataSource.class.getName(), ds);
                    }
                }
    }

}
