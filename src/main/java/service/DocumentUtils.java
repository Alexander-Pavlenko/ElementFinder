package service;

import org.jsoup.nodes.Document;

import java.util.List;

public interface DocumentUtils {
    List<String> getPathToElementById(Document document, String id);
}
