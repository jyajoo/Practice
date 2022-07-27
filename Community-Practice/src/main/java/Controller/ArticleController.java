package Controller;

import Dto.ArticleDto;
import Util.Rq;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq) {
        rq.appendBody("게시물 리스트");
        List<ArticleDto> articleDtoList = new ArrayList<>();
        articleDtoList.add(new ArticleDto(5, "제목 5", "내용 5"));
        articleDtoList.add(new ArticleDto(4, "제목 4", "내용 4"));
        articleDtoList.add(new ArticleDto(3, "제목 3", "내용 3"));
        articleDtoList.add(new ArticleDto(2, "제목 2", "내용 2"));
        articleDtoList.add(new ArticleDto(1, "제목 1", "내용 1"));

        rq.setAttribute("articleList", articleDtoList);
        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        rq.appendBody("<div>title : %s</div>".formatted(title));
        rq.appendBody("<div>body : %s</div>".formatted(body));
    }
}
