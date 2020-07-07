package hiberpackage;

import com.sun.tools.javac.util.Assert;
import hiberpackage.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Start {
    public static void main(String[] args) {
        Session session = HibernateUtil.getFactory().openSession();
//Author auth = new Author("Taras", "Svevchenko");

       /* AuthorHelper aut = new AuthorHelper();
        Author auth = new Author();
        auth = aut.getAuthorById(5);*/
//        aut.addAuthor(auth);
//        aut.getAuthorById(4);
//        System.out.println(auth.getId() + " " + auth.getName() + " " + auth.getSecondName());

        AuthorHelper autH = new AuthorHelper();
//        autH.deleteByCriteria();
        autH.deleteById(5);
        for (Author author : new AuthorHelper().getAuthorList()) {
            System.out.println(author);


        }
    }
}
