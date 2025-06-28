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
Object _global_model = null;
Collection var_collectionvar1_list_coerced$ = null;
out.write("<h1> Demo Service <h1>\n\n");
{
    Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit");
    if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
        out.write("\n\t<div class=\"cq-placeholder\" data-emptyText=\" please configure Demo Service component\"></div>\n");
    }
}
out.write("\n\n============================ Demo Service and Iterator ===========================\n");
_global_model = renderContext.call("use", "com.myproject.aem.core.services.practiceOSGI.DemoService.DemoServiceModel", obj());
out.write("\n\t<<ul>\n        ");
{
    Object var_collectionvar1 = renderContext.getObjectModel().resolveProperty(_global_model, "pageTitles");
    {
        long var_size2 = ((var_collectionvar1_list_coerced$ == null ? (var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1)) : var_collectionvar1_list_coerced$).size());
        {
            boolean var_notempty3 = (var_size2 > 0);
            if (var_notempty3) {
                {
                    long var_end6 = var_size2;
                    {
                        boolean var_validstartstepend7 = (((0 < var_size2) && true) && (var_end6 > 0));
                        if (var_validstartstepend7) {
                            if (var_collectionvar1_list_coerced$ == null) {
                                var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1);
                            }
                            long var_index8 = 0;
                            for (Object pagetitle : var_collectionvar1_list_coerced$) {
                                {
                                    boolean var_traversal10 = (((var_index8 >= 0) && (var_index8 <= var_end6)) && true);
                                    if (var_traversal10) {
                                        out.write("\n            <li><b>");
                                        {
                                            Object var_11 = renderContext.call("xss", pagetitle, "text");
                                            out.write(renderContext.getObjectModel().toString(var_11));
                                        }
                                        out.write("</b></li>\n        ");
                                    }
                                }
                                var_index8++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar1_list_coerced$ = null;
}
out.write("\n    </ul>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

