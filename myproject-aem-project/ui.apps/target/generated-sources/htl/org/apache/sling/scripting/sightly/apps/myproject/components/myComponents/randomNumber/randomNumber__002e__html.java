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
package org.apache.sling.scripting.sightly.apps.myproject.components.myComponents.randomNumber;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class randomNumber__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _dynamic_properties = bindings.get("properties");
Object _global_clientlib = null;
{
    Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit");
    if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
        out.write("\n\t<div class=\"cq-placeholder\" data-emptyText=\" please configure Random Number component\"></div>\n");
    }
}
out.write("\n\n\n<div class=\"body\">\n<div class=\"container\">\n        <h1>Random Number Generator</h1>\n        <div class=\"input-section\">\n            <label for=\"min\">Minimum:</label>\n            <input type=\"number\" id=\"min\"");
{
    Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "minNum");
    {
        Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
        {
            boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
            if (var_shoulddisplayattr4) {
                out.write(" value");
                {
                    boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                    if (!var_istrueattr3) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\n            <label for=\"max\">Maximum:</label>\n            <input type=\"number\" id=\"max\"");
{
    Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "maxNum");
    {
        Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
        {
            boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
            if (var_shoulddisplayattr8) {
                out.write(" value");
                {
                    boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                    if (!var_istrueattr7) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\n        </div>\n        <button id=\"generate\">");
{
    Object var_9 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "generateBtn"), "text");
    out.write(renderContext.getObjectModel().toString(var_9));
}
out.write("</button>\n        <div class=\"result\">\n            <p id=\"randomNumber\">Click the button to  generate</p>\n        </div>\n        <button id=\"reset\">");
{
    Object var_10 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "resetBtn"), "text");
    out.write(renderContext.getObjectModel().toString(var_10));
}
out.write("</button>\n</div>\n</div>\n\n");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
{
    Object var_templatevar11 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "all");
    {
        String var_templateoptions12_field$_categories = "myproject.components.myComponents.randomNumber";
        {
            java.util.Map var_templateoptions12 = obj().with("categories", var_templateoptions12_field$_categories);
            callUnit(out, renderContext, var_templatevar11, var_templateoptions12);
        }
    }
}
out.write("\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

