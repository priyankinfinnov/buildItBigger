package com.nanodegree.builditbigger;

/**
 * Created by yogeshmadaan on 21/02/16.
 */
public class Constants {
    public enum Environment {
        DEBUG,
        PRODUCTION
    }

    /**
     * Debug or Production
     * Debug: link to local database
     * Production : link to the server
     */
    public static final Environment environment = Environment.PRODUCTION;

    /***
     * Define the local server IP
     */
    public static final String ENDPOINT_IP = "192.168.1.1";
    public static final String ENDPOINT_ROOT_URL = "http://" + ENDPOINT_IP + ":8888/_ah/api";

    public static final String PRODUCTION_URL = "rare-hull-122808.appspot.com";
    public static final String ENDPOINT_PRODUCTION_ROOT_URL = "https://" + PRODUCTION_URL + "/_ah/api";

    public static boolean isProduction() {
        return (environment == Environment.PRODUCTION);
    }
}
