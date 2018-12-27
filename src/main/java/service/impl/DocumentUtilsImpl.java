package service.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import service.DocumentUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DocumentUtilsImpl implements DocumentUtils {


    public List<String> getPath(Document document, String id) {
        Optional<Element> targetElement = Optional.ofNullable(document.getElementById(id));
        List<String> paths = targetElement.isPresent() ? targetElement.get().parents()
                .stream()
                .map(Element::nodeName)
                .collect(Collectors.toList()) : Collections.EMPTY_LIST;
        if(!paths.isEmpty()) {
            paths.add(0, targetElement.get().nodeName());
        }
        return paths;
    }

    @Override
    public List<String> getPathToElementById(Document document, String elementId){
        List<String> pathToElement = getPath(document, elementId);
        Collections.reverse(pathToElement);
        return addedArrowForPath(pathToElement);
    }

    private List<String> addedArrowForPath(List<String> pathToElement) {
        List<String> pathWithArrow = pathToElement.stream()
                .map(path -> path + ">").collect(Collectors.toList());
        if(!pathWithArrow.isEmpty()){
            String lastElement = pathWithArrow.get(pathWithArrow.size() - 1);
            pathWithArrow.set(pathWithArrow.size() - 1, lastElement.replace(">", ""));
        }
        return pathWithArrow;
    }
}
