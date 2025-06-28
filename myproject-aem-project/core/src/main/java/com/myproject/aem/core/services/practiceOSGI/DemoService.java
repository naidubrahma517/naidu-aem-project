package com.myproject.aem.core.services.practiceOSGI;

import com.day.cq.wcm.api.Page;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.Iterator;

public interface DemoService {
    public Iterator<Page> getPages();
}
