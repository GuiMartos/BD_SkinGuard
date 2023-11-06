package br.com.tcc.skinguard.repository.filter;

public class UsuarioFilter {

    private String login;
    private String Senha;
    private String Pele;
    private Integer Fps;
    private Integer Clima;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getPele() {
        return Pele;
    }

    public void setPele(String pele) {
        Pele = pele;
    }

    public Integer getFps() {
        return Fps;
    }

    public void setFps(Integer fps) {
        Fps = fps;
    }

    public Integer getClima() {
        return Clima;
    }

    public void setClima(Integer clima) {
        Clima = clima;
    }
}
