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
package org.apache.sling.scripting.sightly.apps.myproject.components.myComponents.contactForm;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class contactForm__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _global_recaptchamodel = null;
Object _global_clientlib = null;
Object _global_model = null;
{
    Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit");
    if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
        out.write("\r\n\t<div class=\"cq-placeholder\" data-emptyText=\" please configure contactForm component\"></div>\r\n");
    }
}
out.write("\r\n");
_global_recaptchamodel = renderContext.call("use", com.myproject.aem.core.models.RecaptchaModel.class.getName(), obj());
out.write("\r\n");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
{
    Object var_templatevar1 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "all");
    {
        String var_templateoptions2_field$_categories = "myproject.components.myComponents.contactForm";
        {
            java.util.Map var_templateoptions2 = obj().with("categories", var_templateoptions2_field$_categories);
            callUnit(out, renderContext, var_templatevar1, var_templateoptions2);
        }
    }
}
out.write("\r\n\r\n");
_global_model = renderContext.call("use", com.myproject.aem.core.models.ContactFormModel.class.getName(), obj());
out.write("\r\n<div class=\"containerWrapper\">\r\n<div class=\"container\">\r\n  <form>\r\n    <label for=\"companyName\">");
{
    Object var_3 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "companyName"), "text");
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</label>\r\n    <input type=\"text\" id=\"companyName\" name=\"companyName\" placeholder=\"company name..\"/> </br>\r\n\r\n    <label for=\"name\">");
{
    Object var_4 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "name"), "text");
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</label>\r\n    <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Your name..\"/></br>\r\n\r\n    <label for=\"phoneNumber\">");
{
    Object var_5 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "phoneNumber"), "text");
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</label>\r\n    <input type=\"text\" id=\"phoneNumber\" name=\"phoneNumber\" placeholder=\"Your number..\"/></br>\r\n\r\n    <label for=\"country\">");
{
    Object var_6 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "country"), "text");
    out.write(renderContext.getObjectModel().toString(var_6));
}
out.write("</label>\r\n    <select id=\"country\" name=\"country\">\r\n      <option value=\"australia\">Australia</option>\r\n      <option value=\"canada\">Canada</option>\r\n      <option value=\"usa\">USA</option>\r\n      <option value=\"india\">INDIA</option>\r\n    </select>\r\n\t</br>\r\n    <label for=\"eMail\">");
{
    Object var_7 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "eMail"), "text");
    out.write(renderContext.getObjectModel().toString(var_7));
}
out.write("</label>\r\n    <input type=\"text\" id=\"eMail\" name=\"eMail\" placeholder=\"Write your mail\"/></br>\r\n\r\n    <==============************{Captcha}*************=================>\r\n\r\n    <div class=\"captchaStart\">\r\n    <input type=\"hidden\" id=\"siteKey\" name=\"sitekey\"");
{
    Object var_attrvalue8 = renderContext.getObjectModel().resolveProperty(_global_recaptchamodel, "siteKey");
    {
        Object var_attrcontent9 = renderContext.call("xss", var_attrvalue8, "attribute");
        {
            boolean var_shoulddisplayattr11 = (((null != var_attrcontent9) && (!"".equals(var_attrcontent9))) && ((!"".equals(var_attrvalue8)) && (!((Object)false).equals(var_attrvalue8))));
            if (var_shoulddisplayattr11) {
                out.write(" value");
                {
                    boolean var_istrueattr10 = (var_attrvalue8.equals(true));
                    if (!var_istrueattr10) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent9));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" disabled=\"disabled\"/>\r\n    <div class=\"large-6 medium-6 small-12 columns captcha\">\r\n    <div id=\"g-recaptcha\"></div>\r\n    <input type=\"hidden\" id=\"captchaCheck\" value=\"\" name=\"captcha\"/>\r\n    <input type=\"hidden\" disabled=\"disabled\" id=\"captchaAlert\" data-message=\"Field Required\" name=\"captcha\"/>\r\n    </div>\r\n    </div>\r\n    <button class=\"button\" type=\"button\">Click Me!</button>\r\n  </form>\r\n</div>\r\n<script src=\"https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit\" async defer>\r\n    </script>\r\n</div>\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

