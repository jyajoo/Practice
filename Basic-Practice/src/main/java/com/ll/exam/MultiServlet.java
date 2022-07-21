package com.ll.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/multi")
public class MultiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req, resp);

        int number = rq.getIntParam("number", 0);
        int limit = rq.getIntParam("limit", 0);

        /*
        rq.appendBody("<h1>%d단</h1>\n".formatted(number));

        for (int i = 1; i <= limit; i++) {
            rq.appendBody("<div>%d * %d = %d</div>\n".formatted(number, i, number * i));
        }
         */

        /*
        Request에 정보 담기
         */
        req.setAttribute("number", number);
        req.setAttribute("limit", limit);

        // multi2.jsp 에게 정보 전달
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/multi2.jsp");
        requestDispatcher.forward(req, resp);
    }
}
