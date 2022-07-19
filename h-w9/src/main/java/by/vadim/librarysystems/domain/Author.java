package by.vadim.librarysystems.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "location", nullable = false, unique = false)
    private String location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
