import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by RTLabs on 01.12.2015.
 */
public class A {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();

        //creating transaction object
        Transaction t = session.beginTransaction();
        Temp e1=new Temp();
//        e1.setId(115);
        e1.setName("sonoo");
        session.persist(e1); //persisting the object
        t.commit(); //transaction is commited session.close();
        System.out.println("successfully saved");
    }
}
