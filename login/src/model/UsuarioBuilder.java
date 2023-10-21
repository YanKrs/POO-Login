package model;

public class UsuarioBuilder {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;

    public UsuarioBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioBuilder setPerfil(String perfil) {
        this.perfil = perfil;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, nome, email, senha, perfil);
    }
}
