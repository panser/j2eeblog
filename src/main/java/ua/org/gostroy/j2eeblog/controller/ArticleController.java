package ua.org.gostroy.j2eeblog.controller;

import ua.org.gostroy.j2eeblog.ejb.ArticleEjb;
import ua.org.gostroy.j2eeblog.model.entity.Article;
import ua.org.gostroy.j2eeblog.model.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Panov Sergey on 2/16/2015.
 */
@Named
@RequestScoped
public class ArticleController {

    @Inject
    private ArticleEjb articleEjb;

    public Article find(Long id) {
        Article article = articleEjb.find(id);
        return article;
    }

    public List<Article> findByAuthor(User author) {
        List<Article> articles = articleEjb.findByAuthor(author);
        return articles;
    }

    public List<Article> findAll() {
        List<Article> articles = articleEjb.findAll();
        return articles;
    }

    public Article create(Article article) {
        Article articleNew = articleEjb.create(article);
        return articleNew;
    }

    public Article update(Article article) {
        Article articleNew = articleEjb.update(article);
        return articleNew;
    }

    public void delete(Article article) {
        articleEjb.delete(article);
    }

}
