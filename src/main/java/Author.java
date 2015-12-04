import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by RTLabs on 02.12.2015.
 */

@Entity(name =  "author")
@Table
public class Author {
    @Id
    @GeneratedValue
    private int id;
    @Column (name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    //    @OneToMany/*(mappedBy = "author", fetch = FetchType.LAZY)*/
//    private Set<Book> bookList;
//
//    public Set<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(Set<Book> bookList) {
//        this.bookList = bookList;
//    }
}
