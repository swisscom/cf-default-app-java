package com.swisscom.appcloud.defaultapp.java;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.exception;
import static spark.Spark.staticFiles;

public class IndexRoute {
    public static void main(String[] args) {
        staticFiles.location("/public");

        get("/", (req, res) -> {
          Map<String, Object> map = new HashMap<>();
          map.put("envVariables", System.getenv());
          map.put("reqHeaders", req.headers());
          map.put("reqParams", req.queryParams());

          return new ModelAndView(map, "index");
        }, new JadeTemplateEngine());

        exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
    }
}
