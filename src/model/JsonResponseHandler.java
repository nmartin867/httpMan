package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

/**
 * Created by nick.martin on 7/3/14.
 */
public class JsonResponseHandler extends ContentHandler {

    public Object getContent(URLConnection urlc) throws IOException {
        return getContentBodyFromInputStream(urlc.getInputStream());
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //return gson.toJson(responseBody);
    }

    private String getContentBodyFromInputStream(InputStream is){
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
