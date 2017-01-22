package com.petcare.server.util;

import ratpack.handling.Context;

public class Helper {

    public static String getExampleIdFromQueryParams(Context ctx) {
        return ctx.getRequest().getQueryParams().get("example_id");
    }

    public static String getExampleIdFromPathTokens(Context ctx) {
        return ctx.getAllPathTokens().get("example_id");
    }

}
