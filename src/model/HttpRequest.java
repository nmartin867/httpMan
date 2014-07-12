package model;

import java.net.URL;

public class HttpRequest {
    private URL url;
    private HttpMethods method;

    public HttpRequest(URL url, HttpMethods method){
        this.url = url;
        this.method = method;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public HttpMethods getMethod() {
        return method;
    }

    public void setMethod(HttpMethods method) {
        this.method = method;
    }

}
