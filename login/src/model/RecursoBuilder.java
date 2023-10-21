package model;


public class RecursoBuilder {
    private String nome;
    private String perfilNecessario;
    private boolean ativo = true;

    public RecursoBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public RecursoBuilder setPerfilNecessario(String perfilNecessario) {
        this.perfilNecessario = perfilNecessario;
        return this;
    }

    public RecursoBuilder setAtivo(boolean ativo) {
        this.ativo = ativo;
        return this;
    }

    public Recurso build() {
        return new Recurso(nome, perfilNecessario, ativo);
    }
}

