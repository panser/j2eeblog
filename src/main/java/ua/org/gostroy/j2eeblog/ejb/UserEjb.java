package ua.org.gostroy.j2eeblog.ejb;

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
public class UserEjb {

    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public User find(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public User findByEmail(String email) {
        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);
        User user = (User)query.getSingleResult();
        return user;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public User findByLogin(String login) {
        Query query = em.createNamedQuery("User.findByLogin");
        query.setParameter("login", login);
        User user = (User)query.getSingleResult();
        return user;
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<User> findAll() {
        Query query = em.createNamedQuery("User.findAll");
        List<User> users = (List<User>) query.getResultList();
        return users;
    }

    @Transactional
    public Long create(User user) {
        em.merge(user);
        return user.getId();
    }

    @Transactional
    public Long update(User user) {
        em.merge(user);
        return user.getId();
    }

    @Transactional
    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

}
