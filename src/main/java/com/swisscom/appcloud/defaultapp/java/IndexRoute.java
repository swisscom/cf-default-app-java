package com.swisscom.appcloud.defaultapp.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.exception;
import static spark.Spark.staticFiles;

public class IndexRoute {
    public static void main(String[] args) {

        port(getCloudAssignedPort());

        staticFiles.location("/public");

        get("/", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("envVariables", System.getenv());
            map.put("reqHeaders", req.headers().stream().collect(Collectors.toMap(e -> e, e -> req.headers(e))));
            map.put("reqParams", req.queryParams().stream().collect(Collectors.toMap(e -> e, e -> req.queryParams(e))));

            return new ModelAndView(map, "index");
        }, new JadeTemplateEngine());

        exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
    }

    private static int getCloudAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if cloud port isn't set (i.e. on localhost)
    }
}
