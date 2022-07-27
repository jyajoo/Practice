import Controller.ArticleController;
import Controller.MemberController;
import Util.Rq;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        /*
        getRequestURI
        : http://localhost:8080/usr/article/list/free?page=1 에서
        /usr/article/list/free 부분만 가져온다.
         */
        String url = req.getRequestURI();

        switch (url) {
            case "/usr/member/login":
                memberController.showLogin(rq);
                break;
            case "/usr/article/list/free":
                articleController.showList(rq);
                break;
            case "/usr/article/write/free":
                articleController.showWrite(rq);
                break;
        }
    }
}
