package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Component(service = Servlet.class, immediate = true,  property = {
    // "sling.servlet.paths=/bin/queryBuilder",
    // "sling.servlet.methods=GET"
    ServletResolverConstants.SLING_SERVLET_PATHS + "=" +"/bin/queryBuilder",
    //ServletResolverConstants.SLING_SERVLET_METHODS + "=" + "HttpConstants.METHOD_GET"
    })
public class QueryBuilderServlet extends SlingAllMethodsServlet{

    private static final long serialVersionUID = 1L;
    
    @Reference
    QueryBuilder queryBuilder;

    // @Reference
    // ResourceResolver resourceResolver;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
                ResourceResolver resourceResolver = request.getResourceResolver();
                Session session = resourceResolver.adaptTo(Session.class);
                StringBuilder stringBuilder = new StringBuilder();
                Map<String, String> map = new HashMap<>();
                map.put("path", "/content/myproject");
                map.put("type", "cq:Page");
                map.put("p.limit", "-1");
               Query  query = queryBuilder.createQuery(PredicateGroup.create(map), session);
               SearchResult searchResult = query.getResult();
               List<Hit> hits = searchResult.getHits();
               int count = 1;
               for (Hit hit : hits) {
                try {
                   String title = hit.getTitle();
                   String path = hit.getPath();
                   stringBuilder.append(count + ". " + title + "--->" + path + "<br/>");
                   count++;
                } catch (RepositoryException e) {
                }
               }
                response.getWriter().write("Servlet Calling.. + <br/>");
                response.getWriter().write(stringBuilder.toString());
                response.setContentType("text/html");
    }
} 
