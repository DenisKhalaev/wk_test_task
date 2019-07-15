package com.wk.task2spring.servlet;


import com.wk.task2spring.config.SpringConfig;
import com.wk.task2spring.thread.Interrogator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class ClientServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        if (context.getBean(Interrogator.class).getStatus() == 0) {
            context.getBean(Interrogator.class).start();
        }

        request.getRequestDispatcher("view/client.html")
                .forward(request, response);
    }
}
