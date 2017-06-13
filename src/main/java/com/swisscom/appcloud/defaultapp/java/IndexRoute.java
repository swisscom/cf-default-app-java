package com.swisscom.appcloud.defaultapp.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

/**
 * Render an index page.
 */
public class IndexRoute {

    public static void main(String[] args) {
        // Use correct port
        port(getPort());

        // Serve static files
        staticFiles.location("/public");

        // Render index template
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("envVariables", System.getenv());
            model.put("reqHeaders", req.headers().stream().collect(Collectors.toMap(e -> e, e -> req.headers(e))));
            model.put("reqParams", req.queryParams().stream().collect(Collectors.toMap(e -> e, e -> req.queryParams(e))));

            return new ModelAndView(model, "templates/index.vm");
        }, new VelocityTemplateEngine());
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }

        // Default port
        return 4567;
    }

}
