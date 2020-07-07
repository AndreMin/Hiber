package hiberpackage;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();;



    public static SessionFactory getFactory() {
        return sessionFactory;
    }

//one more example

  /*  private static SessionFactory factory;
    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }*/
}
