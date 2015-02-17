package ua.org.gostroy.j2eeblog.ejb;

import ua.org.gostroy.j2eeblog.model.entity.Article;
import ua.org.gostroy.j2eeblog.model.entity.Comment;
import ua.org.gostroy.j2eeblog.model.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Panov Sergey on 2/15/2015.
 */
@Stateless
public class CommentEjb {

    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Comment find(Long id) {
        Comment comment = em.find(Comment.class, id);
        return comment;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Comment> findByAuthor(User author) {
        Query query = em.createNamedQuery("Comment.findByAuthor");
        query.setParameter("author", author);
        List<Comment> comments = (List<Comment>)query.getResultList();
        return comments;
    }
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Comment> findByArticle(Article article) {
        Query query = em.createNamedQuery("Comment.findByArticle");
        query.setParameter("article", article);
        List<Comment> comments = (List<Comment>)query.getResultList();
        return comments;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Comment> findAll() {
        Query query = em.createNamedQuery("Comment.findAll");
        List<Comment> comments = (List<Comment>) query.getResultList();
        return comments;
    }

    @Transactional
    public Long create(Comment comment) {
        em.merge(comment);
        return comment.getId();
    }

    @Transactional
    public Long update(Comment comment) {
        em.merge(comment);
        return comment.getId();
    }

    @Transactional
    public void delete(Comment comment) {
        em.remove(em.contains(comment) ? comment : em.merge(comment));
    }

}
