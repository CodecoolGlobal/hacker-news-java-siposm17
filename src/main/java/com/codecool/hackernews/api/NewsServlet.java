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
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String page = req.getParameter("page");
        URL url;
        if(page != null){
            url = new URL("https://api.hnpwa.com/v0/" + hackerURL + "/" + page + ".json");
        } else {
            url = new URL("https://api.hnpwa.com/v0/" + hackerURL + "/1.json");
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        PrintWriter out = resp.getWriter();

        out.println(content.toString());
        out.flush();


    }
    public String getHackerURL() {
        return hackerURL;
    }

    public void setHackerURL(String hackerURL) {
        this.hackerURL = hackerURL;
    }
}
