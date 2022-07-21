package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
        
        try {
            // 들어오는 파라미터를 UTF-8로 인코딩한다.
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // 서블릿이 HTML 파일을 생성할 때, UTF-8을 이용하도록 한다.
        resp.setCharacterEncoding("UTF-8");
        
        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
        resp.setContentType("text/html; charset=utf-8");
    }

    /*
    parameter 구하기
    - parameter가 존재하지 않거나, Integer로 변환이 불가능하다면 defaultVaule 리턴.
     */
    public int getIntParam(String paramName, int defaultValue) {
        String value = req.getParameter(paramName);
        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void appendBody(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
