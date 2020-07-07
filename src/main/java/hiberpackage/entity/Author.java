package hiberpackage.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long id;

    private String name;

    @Column(name = "second_name")
    private String secondName;

    public Author() {
    }

    public Author(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public Author(long id, String secondName) {
        this.id = id;
        this.secondName = secondName;
    }




    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
