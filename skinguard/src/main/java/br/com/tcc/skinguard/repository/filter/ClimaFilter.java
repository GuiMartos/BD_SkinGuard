package br.com.tcc.skinguard.repository.filter;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClimaFilter {

    private LocalTime hora;
    private LocalDate dia;
    private Integer uvindex;
    private LocalTime sol1;
    private LocalTime sol2;

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
}
