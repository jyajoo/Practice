package Repository;

import Dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private static List<ArticleDto> articleDtoList;
    private static long lastId;

    public ArticleRepository() {
        articleDtoList = new ArrayList<>();
        lastId = 0;
    }

    public long write(String title, String body) {
        long id = ++lastId;
        ArticleDto articleDto = new ArticleDto(id, title, body);
        articleDtoList.add(articleDto);
        return id;
    }
}
