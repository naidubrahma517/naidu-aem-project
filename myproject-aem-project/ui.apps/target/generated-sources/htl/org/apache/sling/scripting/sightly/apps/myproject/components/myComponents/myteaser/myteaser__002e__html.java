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
package org.apache.sling.scripting.sightly.apps.myproject.components.myComponents.myteaser;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class myteaser__002e__html extends RenderUnit {

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
        out.write("\r\n\t<div class=\"cq-placeholder\" data-emptyText=\" please configure Teaser component\"></div>\r\n");
    }
}
out.write("\r\n");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
{
    Object var_templatevar1 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "css");
    {
        String var_templateoptions2_field$_categories = "your-app-id/components/my-custom-components/myteaser";
        {
            java.util.Map var_templateoptions2 = obj().with("categories", var_templateoptions2_field$_categories);
            callUnit(out, renderContext, var_templatevar1, var_templateoptions2);
        }
    }
}
out.write("\r\n     \r\n<div class=\"carousel\">\r\n \r\n  <div class=\"carousel-track\">\r\n    <div class=\"carousel-slide\"><a href=\"https://www.google.com/\"><img");
{
    Object var_attrvalue3 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "image2");
    {
        Object var_attrcontent4 = renderContext.call("xss", var_attrvalue3, "uri");
        {
            boolean var_shoulddisplayattr6 = (((null != var_attrcontent4) && (!"".equals(var_attrcontent4))) && ((!"".equals(var_attrvalue3)) && (!((Object)false).equals(var_attrvalue3))));
            if (var_shoulddisplayattr6) {
                out.write(" src");
                {
                    boolean var_istrueattr5 = (var_attrvalue3.equals(true));
                    if (!var_istrueattr5) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent4));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" alt=\"Italian Trulli\" width=\"100\" height=\"100\"/></div></a>\r\n    <div class=\"carousel-slide\"><a href=\"https://www.google.com/\"><img");
{
    Object var_attrvalue7 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "image1");
    {
        Object var_attrcontent8 = renderContext.call("xss", var_attrvalue7, "uri");
        {
            boolean var_shoulddisplayattr10 = (((null != var_attrcontent8) && (!"".equals(var_attrcontent8))) && ((!"".equals(var_attrvalue7)) && (!((Object)false).equals(var_attrvalue7))));
            if (var_shoulddisplayattr10) {
                out.write(" src");
                {
                    boolean var_istrueattr9 = (var_attrvalue7.equals(true));
                    if (!var_istrueattr9) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent8));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" alt=\"Italian Trulli\" width=\"100\" height=\"100\"/></div></a>\r\n    <div class=\"carousel-slide\"><a href=\"https://www.google.com/\"><img");
{
    Object var_attrvalue11 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "image3");
    {
        Object var_attrcontent12 = renderContext.call("xss", var_attrvalue11, "uri");
        {
            boolean var_shoulddisplayattr14 = (((null != var_attrcontent12) && (!"".equals(var_attrcontent12))) && ((!"".equals(var_attrvalue11)) && (!((Object)false).equals(var_attrvalue11))));
            if (var_shoulddisplayattr14) {
                out.write(" src");
                {
                    boolean var_istrueattr13 = (var_attrvalue11.equals(true));
                    if (!var_istrueattr13) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent12));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" alt=\"Italian Trulli\" width=\"100\" height=\"100\"/></div></a>\r\n  </div>\r\n  <button class=\"carousel-btn prev\" aria-label=\"Previous Slide\">\u276E</button>\r\n  <button class=\"carousel-btn next\" aria-label=\"Next Slide\">\u276F</button>\r\n</div>\r\n\r\n<img src=\"/content/dam/my-images/aurora-banner-mb.png\" alt=\"Italian Trulli\"/>\r\n\r\n");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
{
    Object var_templatevar15 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "js");
    {
        String var_templateoptions16_field$_categories = "your-app-id/components/my-custom-components/myteaser";
        {
            java.util.Map var_templateoptions16 = obj().with("categories", var_templateoptions16_field$_categories);
            callUnit(out, renderContext, var_templatevar15, var_templateoptions16);
        }
    }
}
out.write("\r\n     ");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

