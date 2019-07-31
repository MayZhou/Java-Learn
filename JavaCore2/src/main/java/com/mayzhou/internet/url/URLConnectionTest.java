package com.mayzhou.internet.url;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import static java.lang.System.*;

/**
 * @author MayZhou
 */
public class URLConnectionTest {
    public static void main(String[] args) {

        try {
            String urlName;
            out.println(args.length);
            for (String arg : args) {
                out.println(arg);
            }
            if (args.length>0){
                urlName = args[0];
            }
            else {
                urlName = "http:horstmann.com";
            }
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            if (args.length>2){
                String username = args[1];
                String password = args[2];
                String input = urlName + ":" + password;
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
                connection.setRequestProperty("Authorization","Basic" + encoding);
            }
            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()){
                String key = entry.getKey();
                for (String value : entry.getValue()){
                    out.println(key + ":" + value);
                }

                out.println("______________________");
                out.println("content-type: " +connection.getContentType());
                out.println("getContentLength: " +connection.getContentLength());
                out.println("getContentEncoding: " +connection.getContentEncoding());
                out.println("getDate: " +connection.getDate());
                out.println("getExpiration: " +connection.getExpiration());
                out.println("getConnectTimeout" + connection.getConnectTimeout());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
