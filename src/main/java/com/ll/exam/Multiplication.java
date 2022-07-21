package com.ll.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/multi")
public class Multiplication extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 들어오는 파라미터를 UTF-8로 인코딩한다.
        req.setCharacterEncoding("UTF-8");

        // 서블릿이 HTML 파일을 생성할 때, UTF-8을 이용하도록 한다.
        resp.setCharacterEncoding("UTF-8");

        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
        resp.setContentType("text/html; charset=utf-8");

        int number = Integer.parseInt(req.getParameter("number"));
        int limit = Integer.parseInt(req.getParameter("limit"));

        resp.getWriter().append("<h1>%d단</h1>\n".formatted(number));

        for (int i = 1; i <= limit; i++) {
            resp.getWriter().append("<div>%d x %d = %d</div>\n".formatted(number, i, number*i));
        }
    }
}
