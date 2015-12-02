import javax.persistence.*;

/**
 * Created by RTLabs on 01.12.2015.
 */
@Entity(name =  "TESTTABLE")
@Table
public class Temp {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "INAME")
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
