package br.com.semeru.restclient;

import br.com.semeru.restclient.bean.Book;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RecoveryBook {

    private static String url = "http://187.72.233.87:8080/spring-rest/rest/book/2";
        
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readXMLURL(url);
        //parserXMLToObject
    }

    private static void readXMLURL(String url) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet method = new HttpGet(url);
        HttpResponse httpResponse = client.execute(method);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        //if (statusCode == HttpStatus.SC_OK) {
            System.out.println("Tentando");
            InputStream inputStream = httpResponse.getEntity().getContent();
            parserXMLToObject(inputStream);
        //}
    }
    
    private static void parserXMLToObject(InputStream inputStream) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(Book.class);
        Book book = (Book) xStream.fromXML(inputStream);
        System.out.println("O id é: " + book.getId()+ " - do autor " + book.getAuthor()+ "\n"
                + "e o titulo é: " + book.getTitle() + ":->");
    }

}
