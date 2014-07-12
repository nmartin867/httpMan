package model;

import java.net.ContentHandler;
import java.net.ContentHandlerFactory;

/**
 * Created by nick.martin on 7/3/14.
 */
public class ResponseHandlerFactory implements ContentHandlerFactory {

    public ContentHandler createContentHandler(String mimetype) {
        if (mimetype.equalsIgnoreCase("application/json")) {
            return new JsonResponseHandler();
        }
        return new DefaultResponseHandler();
    }
}
