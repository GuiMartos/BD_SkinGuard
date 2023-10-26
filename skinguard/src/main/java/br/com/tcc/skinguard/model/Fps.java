package br.com.tcc.skinguard.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fps")
public class Fps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer fps;

    @OneToMany(mappedBy = "fps")
    private List<Usuario> usuariofps = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fps fps = (Fps) o;
        return id.equals(fps.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
