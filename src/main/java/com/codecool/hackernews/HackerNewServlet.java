package com.codecool.hackernews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hackerNewsServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class HackerNewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println(
                "<html>\n" +
                        "<head>" +
                        "  <link rel=\"stylesheet\" type=\"text/css\" href='/static/css/site.css' />" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">" +
                        "   <script src='/static/js/main.js' defer></script>" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div id=\"buttons\" style=\"margin-bottom: 50px; margin-top: 50px\" >" +
                        "<button type=\"button\" class=\"btn btn-light\" id=\"hackson_news\" style=\"margin-left: 75px;\"><a href=\"/\">Hackson news</a></button>" +
                        "<button type=\"button\" class=\"btn btn-light\" id=\"top_news\"><a href=#>Top news</a></button>" +
                        "<button type=\"button\" class=\"btn btn-light\" id=\"newest_news\"><a href=#>Newest</a></button>" +
                        "<button type=\"button\" class=\"btn btn-light\" id=\"jobs\"><a href=#>Jobs</a></button>" +
                        "</div>" +
                        "<div id=\"inner_content\">" +
                        "</div>" +
                        "</body></html>"
        );
    }
}
