package ua.org.gostroy.j2eeblog.ejb;

import ua.org.gostroy.j2eeblog.model.entity.Article;
import ua.org.gostroy.j2eeblog.model.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Panov Sergey on 2/16/2015.
 */
@Stateless
public class ArticleEjb {

    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Article find(Long id) {
        Article article = em.find(Article.class, id);
        return article;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Article> findByAuthor(User author) {
        Query query = em.createNamedQuery("Article.findByAuthor");
        query.setParameter("author", author);
        List<Article> articles = (List<Article>)query.getResultList();
        return articles;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Article> findAll() {
        Query query = em.createNamedQuery("Article.findAll");
        List<Article> articles = (List<Article>) query.getResultList();
        return articles;
    }

    @Transactional
    public Article create(Article article) {
        Article newArticle = em.merge(article);
        return newArticle;
    }

    @Transactional
    public Article update(Article article) {
        em.merge(article);
        return article;
    }

    @Transactional
    public void delete(Article article) {
        em.remove(em.contains(article) ? article : em.merge(article));
    }

}
