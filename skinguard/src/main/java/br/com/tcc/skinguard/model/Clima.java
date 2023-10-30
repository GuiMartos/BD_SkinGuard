package br.com.tcc.skinguard.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clima")
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalTime hora;
    private LocalDate dia;
    private Integer uvindex;
    private LocalTime sol1;

    private LocalTime sol2;

    @OneToMany(mappedBy = "clima")
    private List<Usuario> usuarioclima = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Integer getUvindex() {
        return uvindex;
    }

    public void setUvindex(Integer uvindex) {
        this.uvindex = uvindex;
    }

    public LocalTime getSol1() {
        return sol1;
    }

    public void setSol1(LocalTime sol1) {
        this.sol1 = sol1;
    }

    public LocalTime getSol2() {
        return sol2;
    }

    public void setSol2(LocalTime sol2) {
        this.sol2 = sol2;
    }

    public List<Usuario> getUsuarioclima() {
        return usuarioclima;
    }

    public void setUsuarioclima(List<Usuario> usuarioclima) {
        this.usuarioclima = usuarioclima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clima clima = (Clima) o;
        return Objects.equals(id, clima.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
