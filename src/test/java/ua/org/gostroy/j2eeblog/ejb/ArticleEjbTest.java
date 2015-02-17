package ua.org.gostroy.j2eeblog.ejb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.org.gostroy.j2eeblog.model.entity.Article;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Panov Sergey on 2/16/2015.
 */
public class ArticleEjbTest {

//    @Inject
//    private ArticleEjb articleEjb;
    private static EJBContainer ec;
    private static Context ctx;

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
//        properties.put(EJBContainer.MODULES, new File("target/test-classes"));
        ec = EJBContainer.createEJBContainer(properties);
        ctx = ec.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null)
            ctx.close();
        if (ec != null)
            ec.close();
    }

    @Test
    public void shouldCreateAnArticle() throws NamingException {

        // Check JNDI dependencies
//        assertNotNull(ctx.lookup("java:global/jdbc/javasite"));
//        assertNotNull(ctx.lookup("java:comp/env/ua.org.gostroy.j2eeblog.ejb.ArticleEjb/ds"));
        assertNotNull(ctx.lookup("java:global/classes/ArticleEjb!ua.org.gostroy.j2eeblog.ejb.ArticleEjb"));
        assertNotNull(ctx.lookup("java:global/classes/ArticleEjb"));

        // Looks up the EJB
        ArticleEjb articleEjb = (ArticleEjb) ctx.lookup("java:global/classes/ArticleEjb!ua.org.gostroy.j2eeblog.ejb.ArticleEjb");

        // Persists the book to the database
        Article article = new Article();
        article.setTitle(this.toString());
        articleEjb.create(article);
        assertNotNull("ID should not be null", article.getId());
        assertNotNull(articleEjb.findAll());
    }
}
