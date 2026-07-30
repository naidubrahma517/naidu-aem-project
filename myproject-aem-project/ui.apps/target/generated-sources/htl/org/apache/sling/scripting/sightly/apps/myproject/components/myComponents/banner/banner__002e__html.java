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
package org.apache.sling.scripting.sightly.apps.myproject.components.myComponents.banner;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class banner__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _global_clientlib = null;
Object _dynamic_properties = bindings.get("properties");
{
    Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit");
    if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
        out.write("\n\t<div class=\"cq-placeholder\" data-emptyText=\" please configure Banner component\"></div>\n");
    }
}
out.write("\n");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
{
    Object var_templatevar1 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "css");
    {
        String var_templateoptions2_field$_categories = "myproject.components.myComponents.banner";
        {
            java.util.Map var_templateoptions2 = obj().with("categories", var_templateoptions2_field$_categories);
            callUnit(out, renderContext, var_templatevar1, var_templateoptions2);
        }
    }
}
out.write("\n     \n<div class=\"banner\">\n    <h1>");
{
    String var_3 = ("Landing Page = " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "bannerName"), "text")));
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</h1>\n    <h1>");
{
    String var_4 = ("Landing Page = " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "bannerPhoneNumber"), "text")));
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</h1>\n    <h1>");
{
    String var_5 = ("Content Page = " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "bannerEMail"), "text")));
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</h1>\n    <h1>");
{
    String var_6 = ("Content Page = " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "bannerCountry"), "text")));
    out.write(renderContext.getObjectModel().toString(var_6));
}
out.write("</h1>\n</div>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

