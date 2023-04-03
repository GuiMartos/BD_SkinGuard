package br.com.tcc.skinguard.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pele")
public class Pele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tom;

    @OneToMany(mappedBy = "pele")
    private List<Usuario> usuariopele = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTom() {
        return tom;
    }

    public void setTom(Integer tom) {
        this.tom = tom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pele pele = (Pele) o;
        return id.equals(pele.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
