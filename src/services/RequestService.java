package services;


import model.HttpRequest;
import model.HttpResponse;
import model.ResponseHandlerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public class RequestService{

    public HttpResponse processRequest(HttpRequest request) {
        HttpResponse httpResponse = null;
        try {
            HttpURLConnection connection = (HttpURLConnection)request.getUrl().openConnection();
            connection.setRequestMethod(request.getMethod().toString());
            connection.connect();
            httpResponse = new HttpResponse();
            httpResponse.setHttpStatus(connection.getResponseCode());
            httpResponse.setHeaders(connection.getHeaderFields());
            httpResponse.setReponseBody((String) connection.getContent());

        } catch (IOException ioException) {
            //Handle IO exception
            System.out.println("IO: " + ioException.getMessage());
        }
        return httpResponse;
    }
}
