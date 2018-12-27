import org.jsoup.nodes.Document;
import service.DocumentUtils;
import service.impl.DocumentUtilsImpl;
import service.impl.HTMLParser;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        for(String pathToHtml : args){
            Optional<Document> document = new HTMLParser().parse(new File(pathToHtml));
            DocumentUtils documentUtils = new DocumentUtilsImpl();
            List<String> path = documentUtils.getPathToElementById(document.get(),"make-everything-ok-button");
            if(path.isEmpty()) {
                System.out.println("Element with make-everything-ok-button id was not found");
            }
            path.forEach(System.out::print);
        }
    }
}
