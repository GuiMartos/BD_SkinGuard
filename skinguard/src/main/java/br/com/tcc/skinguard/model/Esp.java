package br.com.tcc.skinguard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "esp")
public class Esp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer esp;

    @JsonIgnore
    @OneToMany(mappedBy = "esp")
    private List<Usuario> usuarioesp = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEsp() {
        return esp;
    }

    public void setEsp(Integer esp) {
        this.esp = esp;
    }

    public List<Usuario> getUsuarioesp() {
        return usuarioesp;
    }

    public void setUsuarioesp(List<Usuario> usuarioesp) {
        this.usuarioesp = usuarioesp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esp esp = (Esp) o;
        return id.equals(esp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
