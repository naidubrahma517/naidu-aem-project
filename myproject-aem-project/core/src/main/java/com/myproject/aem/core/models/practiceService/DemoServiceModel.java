package com.myproject.aem.core.models.practiceService;

import com.day.cq.wcm.api.Page;
import com.myproject.aem.core.services.practiceOSGI.DemoService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoServiceModel {
    private static final Logger LOG = LoggerFactory.getLogger(DemoServiceModel.class);

    private List<String> pageTitles;

    @OSGiService
    DemoService demoService;

    protected void init(){
        pageTitles = new ArrayList<>();
        Iterator<Page> pages = demoService.getPages();
        LOG.info("======= pages ======== {}", pages);
        if (pages != null) {
            while (pages.hasNext()) {
                Page page = pages.next();
                pageTitles.add(page.getTitle());
                LOG.info("======= pageTitles ========");
            }
        }
    }

    public List<String> getPageTitles() {
        return pageTitles;
    }

}
