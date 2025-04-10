package com.myproject.aem.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleModel {

    private static final Logger LOG = LoggerFactory.getLogger(TitleModel.class);

    @Inject
    private String title ;

    @Inject
    private boolean checkbox ;

    @Inject
    private int number ;

    public String getTitle() {
        return title;     
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public int getNumber() {
        return number;
    }


}
