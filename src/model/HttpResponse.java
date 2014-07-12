package model;

import java.util.List;
import java.util.Map;

public class HttpResponse {
    private int httpStatus;
    private Map<String, List<String>> headers;

    private String responseBody;

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setHeaders(Map<String, List<String>> headers){
        this.headers = headers;
    }

    public Map<String, List<String>> getHeaders(){
        return this.headers;
    }

    public String getReponseBody() {
        return responseBody;
    }

    public void setReponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

}
