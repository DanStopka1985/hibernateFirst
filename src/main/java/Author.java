import javax.persistence.*;

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
}
