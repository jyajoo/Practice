package Controller;

import Util.Rq;

public class ArticleController {
    public void showList(Rq rq) {
        rq.appendBody("게시물 리스트");
    }
}
