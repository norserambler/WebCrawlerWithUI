package com.WebCrawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet("/WebCrawler")
public class WebCrawler extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String url =request.getParameter("url");
        Crawler crawler = new Crawler();
        try {
            crawler.getPageTextandLinks(url,1);
        } catch (IOException e) {
            response.setContentType("text/html");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }

         // setting content type to html since need to print output in a html page
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}
