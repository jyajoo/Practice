package Util;

import Dto.ArticleDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
    }

    public void appendBody(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAttribute(String name, Object value) {
        req.setAttribute(name, value);
    }

    public void view(String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    getRequestURI
    : http://localhost:8080/usr/article/list/free?page=1 에서
    /usr/article/list/free 부분만 가져온다.
     */
    public String getPath() {
        return req.getRequestURI();
    }

    public String getMethod() {
        return req.getMethod();
    }

    public String getParam(String paramName, String defaultValue) {
        String value = req.getParameter(paramName);

        if (value == null || value.trim().length() == 0) {
            return defaultValue;
        }
        return value;
    }
}
