package es.ull.patrones.data;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class HTTPFileDownloader {

    HTTPFileDownloader() {}

    public static String downloadFromURL(String link) {
        String myURLContent = "";
        try {
            BufferedInputStream in = new BufferedInputStream(new URL(link).openStream());
            int bytesRead = 0;
            int BUFFER_SIZE = 1024;
            byte[] byteContents = new byte[BUFFER_SIZE];
            while((bytesRead = in.read(byteContents)) != -1) {
                myURLContent += new String(byteContents, 0, bytesRead);
            }

            return myURLContent;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("There is a malformed URL in " + HTTPFileDownloader.class.getClass() );
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There is an IO error for the Stream opened in " + HTTPFileDownloader.class.getClass());
            System.exit(1);
        }
        return "I AM NOT SUPPOSED TO ARRIVE HERE";
    }
}
