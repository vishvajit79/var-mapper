package io.qhacks.var_mapper;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpsConnection {
    public static HttpsURLConnection getHttpsConnection (String connectingUrl) throws Exception {
        URL url = new URL(connectingUrl);

        HttpsURLConnection webRequest = (HttpsURLConnection) url.openConnection();

        return webRequest;

    }

}
