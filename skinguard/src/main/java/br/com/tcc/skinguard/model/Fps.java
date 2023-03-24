package br.com.tcc.skinguard.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pele")
public class Fps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer fps;

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
