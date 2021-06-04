package com.codecool.hackernews.api;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="topNewsServlet", urlPatterns = {"/api/top"}, loadOnStartup = 4)
public class TopNewsServlet extends NewsServlet {

    public TopNewsServlet() {
        this.setHackerURL("news");
    }

}
