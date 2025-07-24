/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.myproject.components.myComponents.demoService;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class demoService__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _dynamic_model = bindings.get("model");
Object _dynamic_pagetitle = bindings.get("pagetitle");
{
    String var_0 = (((((("<!--/*<h1> Demo Service <h1>\n\n<sly data-sly-test=\"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit"), "text"))) + "\">\n\t<div class=\"cq-placeholder\" data-emptyText=\" please configure Demo Service component\"></div>\n</sly>\n\n============================ Demo Service and Iterator ===========================\n<sly data-sly-use.model=\"com.myproject.aem.core.services.practiceOSGI.DemoService.DemoServiceModel\">\n\t<<ul>\n        <sly data-sly-list.pageTitle=\"") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_model, "pageTitles"), "text"))) + "\">\n            <li><b>") + renderContext.getObjectModel().toString(renderContext.call("xss", _dynamic_pagetitle, "text"))) + "</b></li>\n        </sly>\n    </ul>\n</sly> */--!>\n");
    out.write(renderContext.getObjectModel().toString(var_0));
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

