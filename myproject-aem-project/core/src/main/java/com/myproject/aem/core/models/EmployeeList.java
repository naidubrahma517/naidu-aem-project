package com.myproject.aem.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.aem.core.models.bean.Multifield;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeList {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeList.class);

    @Inject
    private String companyName;

    @Inject
    private List<Multifield> multifield;

    public String getCompanyName() {
        return companyName;
    }

    public List<Multifield> getMultifield() {
        return multifield;
    }

}
