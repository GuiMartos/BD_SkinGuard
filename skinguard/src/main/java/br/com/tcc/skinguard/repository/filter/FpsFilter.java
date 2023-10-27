package br.com.tcc.skinguard.repository.filter;

import br.com.tcc.skinguard.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FpsFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer fps;

    @JsonIgnore
    @OneToMany(mappedBy = "fps")
    private List <Usuario> fpsusuario = new ArrayList<>();

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Usuario> getFpsusuario() {
        return fpsusuario;
    }

    public void setFpsusuario(List<Usuario> fpsusuario) {
        this.fpsusuario = fpsusuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FpsFilter fpsFilter = (FpsFilter) o;
        return id.equals(fpsFilter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
