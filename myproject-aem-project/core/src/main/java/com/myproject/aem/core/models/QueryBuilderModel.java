package com.myproject.aem.core.models;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public class QueryBuilderModel {

    @SlingObject
    ResourceResolver resourceResolver;

    @Inject
    private String pagePath;

    List<Hit> latestPageDetails = new ArrayList<>();

    @PostConstruct
    public void init(){
        setLatestPageDetails();
    }

    private void setLatestPageDetails(){
        QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
        Session session = resourceResolver.adaptTo(Session.class);
        Map<String, String> map = new HashMap<>();
        map.put("path", pagePath);
        map.put("type", "cq:Page");
        map.put("p.limit", "-1");
        Query query = queryBuilder.createQuery(PredicateGroup.create(map),session);
        SearchResult searchResult = query.getResult();
        latestPageDetails = searchResult.getHits();
    }

    public List<Hit> getLatestPageDetails() {
        return latestPageDetails;
    }
}
