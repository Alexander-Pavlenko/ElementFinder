package service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import service.Parser;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HTMLParser implements Parser <Optional<Document>, File> {
    private static final String CHARSET_NAME = "utf8";

    private static Logger LOGGER = LoggerFactory.getLogger(HTMLParser.class);

    @Override
    public Optional<Document> parse(File file) {
        try {
            Document doc = Jsoup.parse(
                    file,
                    CHARSET_NAME,
                    file.getAbsolutePath());
            return Optional.of(doc);
        } catch (IOException e) {
            LOGGER.error("Can not parse [{}] file", file.getAbsolutePath());
            return Optional.empty();
        }
    }
}
