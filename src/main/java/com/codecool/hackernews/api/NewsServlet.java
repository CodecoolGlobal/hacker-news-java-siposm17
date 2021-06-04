package com.codecool.hackernews.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class NewsServlet extends HttpServlet {

    private String hackerURL;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Setting respone content type
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        // Asking for query parameter
        String page = req.getParameter("page");
        URL url;
        // Checking if there was any query parameter
        if(page != null){
            url = new URL("https://api.hnpwa.com/v0/" + hackerURL + "/" + page + ".json");
        } else {
            url = new URL("https://api.hnpwa.com/v0/" + hackerURL + "/1.json");
        }
        // Setting up connection with the hacker api
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        // getting the input Buffer from the connection
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        // Adding the lines to the string builder to build the json response as a string
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // returning the string we got from the hacker api
        PrintWriter out = resp.getWriter();

        out.println(content);
        out.flush();


    }
    public String getHackerURL() {
        return hackerURL;
    }

    public void setHackerURL(String hackerURL) {
        this.hackerURL = hackerURL;
    }
}
