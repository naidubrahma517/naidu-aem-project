package com.myproject.aem.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactFormModel {

    @Inject
    private String companyName;

    @Inject
    private String name;

    @Inject
    private String phoneNumber;

    @Inject
    private String eMail;

    @Inject
    private String country;

    public String getCompanyName() {
        return companyName;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public String getCountry() {
        return country;
    }


}
