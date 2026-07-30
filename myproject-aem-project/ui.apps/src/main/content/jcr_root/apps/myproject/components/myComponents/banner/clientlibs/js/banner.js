(function ($, document) {

    "use strict";

    $(document).on("foundation-contentloaded", function () {

        var editable = Granite.author.DialogFrame.currentDialog.editable;
        console.log(Granite.author);

        if (!editable) {
            return;
        }

        var componentPath = editable.path;

        // Remove component name to get page path
        var pagePath = componentPath.substring(
            0,
            componentPath.indexOf("/jcr:content") + 12
        );

        $.get(pagePath + ".json", function (pageData) {

            var template = pageData["cq:template"];

            if (template === "/conf/myproject/settings/wcm/templates/landing-page-template") {

                $(".templateAField").closest(".coral-Form-fieldwrapper").show();
                $(".templateBField").closest(".coral-Form-fieldwrapper").hide();

            }
            else if (template === "/conf/myproject/settings/wcm/templates/content-page-template") {

                $(".templateAField").closest(".coral-Form-fieldwrapper").hide();
                $(".templateBField").closest(".coral-Form-fieldwrapper").show();

            }

        });

    });

})(Granite.$, document);