package com.WebCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    HashSet<String> urlSet; // hashset that will contain all the urls post parsing the html
    int MAX_DEPTH = 2;
    int count =0;
    Crawler() {
        urlSet = new HashSet<>();
    }
    public void getPageTextandLinks(String url, int depth) throws IOException {
        if (urlSet.contains(url)) { // base condition
            return;
        }
        if (depth > MAX_DEPTH) {
            count++;// base condition
            return;
        }

        depth++;

        Document document = null;

            document = Jsoup.connect(url).timeout(5000).get();
            // the above line will convert HTML objects to JAVA objects

        System.out.println(document.title());

        //Indexer function will be here
        Indexer indexer = new Indexer(document, url);

        Elements availableLinksOnPage = document.select("a[href]");
        // the above line will only select the a[href] tags from the html page
        //i.e. the links present in the HTML page

        for (Element currentLink : availableLinksOnPage) {

            if(count>100000){
                break;
            }
            //         System.out.println(currentLink.attr("abs:href"));
            getPageTextandLinks(currentLink.attr("abs:href"), depth);
            // .attr is used to convert from Elements objects to string object
            // the parameter abs:href will fetch us the links
        }

    }
}
