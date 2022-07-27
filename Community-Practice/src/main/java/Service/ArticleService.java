package Service;

import Repository.ArticleRepository;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }
}