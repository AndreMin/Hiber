package hiberpackage;

import hiberpackage.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getFactory();
    }

    public List<Author> getAuthorList() {
        Session session = sessionFactory.openSession();
//        session.get(Author.class, 1L);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        Selection[] ses = {root.get("id"), root.get("secondName")};

//        cq.select(cb.construct(Author.class,ses));
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();

        return authorList;
    }

    public Author addAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction();
        session.close();

        return author;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        session.close();
        return author;
    }

    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, id);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteByCriteria(Author name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);
        cd.where(cb.like(root.<String>get("name"), "%ara%"));

        /*cd.where(cb.or(
                cb.and(
                        cb.like(root.<String>get("name"), "%ara%"),
                        cb.like(root.<String>get("secondName"), "%ush%")
                ),
                cb.equal(root.<String>get("secondName"), "Shevchenko")
                )
        );*/

        Query query = session.createQuery(cd);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


}
