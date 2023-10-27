package br.com.tcc.skinguard.repository.projections;

public class ResumoUsuario {
    private Integer id;

    private String login;

    private String senha;

    private Integer fps;

    private String pele;

    private Integer esp;

    public ResumoUsuario(Integer id, String senha, String login, Integer fps, String pele, Integer esp){

        this.id=id;
        this.login=login;
        this.senha=senha;
        this.fps=fps;
        this.pele=pele;
        this.esp=esp;
    }

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

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public Integer getEsp() {
        return esp;
    }

    public void setEsp(Integer esp) {
        this.esp = esp;
    }
}
