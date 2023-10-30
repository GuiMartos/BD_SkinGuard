package br.com.tcc.skinguard.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String senha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idfps")
    private Fps fps;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idpele")
    private Pele pele;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idclima")
    private Clima clima;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Fps getFps() {
        return fps;
    }

    public void setFps(Fps fps) {
        this.fps = fps;
    }

    public Pele getPele() {
        return pele;
    }

    public void setPele(Pele pele) {
        this.pele = pele;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
