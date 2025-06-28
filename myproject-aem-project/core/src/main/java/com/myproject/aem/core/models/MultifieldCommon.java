package com.myproject.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Iterator;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldCommon {

    @Inject
    public Resource data;

    private int listSize;

    @PostConstruct
    private  void init(){
        if(data != null){
            Iterator<Resource> iterator = data.listChildren();
            listSize = size(iterator);
        }
    }

    public int size(Iterator<?> iterator) {
        int size = 0;
        if(iterator !=null){
            while (iterator.hasNext()){
                iterator.next();
                ++size;
            }
        }
        return size;
    }
    public int getListSize() {
        return listSize;
    }
}


/*
multifield calling in HTL

     <sly data-sly-test="${wcmmode.edit}">
	<div class="cq-placeholder" data-emptyText=" please configure Employee List component"></div>
</sly>

<sly data-sly-use.model="com.myproject.aem.core.models.multifiled">
	<div class="companyName" >
${model.companyName}
	<sly data-sly-list.data="${model.data.listChildren}">
		<div class="empList" >
        ========== "${empList.count}" ==========</br>
${data.rollNumber} -- ${data.name} -- ${data.age}
		</div>
	</sly>
	</div>
</sly>   */
