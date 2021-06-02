package com.codecool.hackernews.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name="topNewsServlet", urlPatterns = {"/api/top"}, loadOnStartup = 4)
public class TopNewsServlet extends NewsServlet {

    public TopNewsServlet() {
        this.setHackerURL("news");
    }
}
