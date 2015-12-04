import org.hibernate.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

        //creating transaction object 1
        Transaction t = session.beginTransaction();
//        Temp e1 = new Temp();
//        e1.setName("sonoo");
//        session.persist(e1); //persisting the object
//        t.commit(); //transaction is commited session.close();
//        System.out.println("successfully saved");

        //creating transaction object 1
        Author author1 = new Author();
        author1.setName("Pushkin");

        Author author2 = new Author();
        author2.setName("A Tolstoy");


        Book book1 = new Book();
        book1.setName("Gold fish");
        book1.setAuthor(author1);
        book1.setPrice(100);
        session.persist(book1);

        Book book2 = new Book();
        book2.setName("Saltan");
        book2.setAuthor(author1);
        book2.setPrice(300);
        session.persist(book2);

        Book book3 = new Book();
        book3.setName("Gold key");
        book3.setAuthor(author2);
        book3.setPrice(200);
        session.persist(book3);



        t.commit();

        System.out.println("successfully saved");

//        Query q = session.createQuery("From Book order by id desc");
//        List<Book> resultList = q.list();
//        System.out.println("num of book:" + resultList.size());
//        for (Book next : resultList) {
//            System.out.println("next book: " + next.getName());
//        }

        Criteria crit = session.createCriteria(Book.class);
        crit = crit.createAlias("author", "a");
        crit = crit.add(Restrictions.eq("a.name", "Pushkin"));
        crit = crit.add(Restrictions.like("name", "%Gold%"));


        List<Book> resultList = crit.list();
        System.out.println("num of book:" + resultList.size());
        for (Book next : resultList) {
            System.out.println("next book: " + next.getName());
        }
//
//        crit = session.createCriteria(Author.class);
//        crit = crit.createAlias("book","b");
//        List<Author> authorList = crit.list();
//        for (Author next : authorList) {
//            System.out.println("next author: " + next.getName());
//        }

        //simple JPQLs
        Query query = session.createQuery("select b from Book b where b.author.name = 'Pushkin'");
        List<Book> books = query.list();

        for (Book next : books) {
            System.out.println("! next book: " + next.getName());
        }

        query = session.createQuery("select b from Book b where b.price between 0 and 250");
        books = query.list();

        for (Book next : books) {
            System.out.println("! next book: " + next.getName());
        }


        query = session.createQuery("select a.name from Author a join a.books b where b.name = 'Gold fish'");
        List<String> authors = query.list();

        for (String next : authors) {
            System.out.println("! next author: " + next);
        }


        if (!t.wasCommitted())
            t.commit();

        t = session.beginTransaction();
        query = session.createQuery("delete from Book");
        query.executeUpdate();
        t.commit();



        session.close();
        System.out.println("123");
    }
}
