package br.com.semeru.restclient;

import br.com.semeru.restclient.bean.Book;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.IOException;

public class RecoveryBookFromXMLFile {

    private static String file = "D:\\Projects\\NetbeansProjects\\erudio-client-web\\erudio-client-web\\RestClient\\src\\main\\java\\br\\com\\semeru\\restclient\\teste.xml";
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readXMLFile(file);
    }

    private static void readXMLFile(String file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        parserXMLToObject(reader);
    }

    private static void parserXMLToObject(FileReader reader) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(Book.class);
        Book book = (Book) xStream.fromXML(reader);
                System.out.println("O id é: " + book.getId()+ " - do autor " + book.getAuthor()+ "\n"
                + "e o titulo é: " + book.getTitle() + ":->");
    }

}
