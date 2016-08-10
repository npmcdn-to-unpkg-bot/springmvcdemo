package me.ele.pmo.servlet;

import com.fh.util.QuartzManager;
import me.ele.pmo.job.JobExecution;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kimi on 8/10/16.
 */
public class Startup extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        QuartzManager.addJob("print", JobExecution.class, "0/30 * * * * ?");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
    }
}
