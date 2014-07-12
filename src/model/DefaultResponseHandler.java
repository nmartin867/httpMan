package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ContentHandler;
import java.net.HttpURLConnection;
import java.net.URLConnection;

/**
 * Created by nick.martin on 7/4/14.
 */
public class DefaultResponseHandler extends ContentHandler {

    public Object getContent(URLConnection urlc) throws IOException {
        InputStream is = urlc.getInputStream();
        return getContentBodyFromInputStream(is);
    }

    private String getContentBodyFromInputStream(InputStream is){
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
