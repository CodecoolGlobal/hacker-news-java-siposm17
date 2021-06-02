package com.codecool.hackernews.api;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="newestNewsServlet", urlPatterns = {"/api/newest"}, loadOnStartup = 5)
public class NewestNewsServlet extends NewsServlet{
    public NewestNewsServlet() {
        this.setHackerURL("newest");
    }
}
