package com.codecool.hackernews.api;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="jobNewsServlet", urlPatterns = {"/api/jobs"}, loadOnStartup = 6)
public class JobNewsServlet extends NewsServlet{

    public JobNewsServlet() {
        this.setHackerURL("jobs");
    }

}
