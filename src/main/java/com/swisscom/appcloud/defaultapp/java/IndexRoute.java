package com.swisscom.appcloud.defaultapp.java;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class IndexRoute {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World!");

        staticFiles.location("/public");

        get("/", (rq, rs) -> new ModelAndView(map, "index"), new JadeTemplateEngine());
    }
}
