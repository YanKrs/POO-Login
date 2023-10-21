package service;

import model.Recurso;
import model.Usuario;

public abstract class AutenticacaoTemplate {
    public final String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!validarSenha(usuario, senha)) {
            return "Senha inválida";
        }

        if (!validarPerfil(usuario, recurso)) {
            return "Acesso negado ao recurso " + recurso.getNome();
        }

        if (!validarAtividade(recurso)) {
            return "Recurso " + recurso.getNome() + " inativo";
        }

        return concederAcesso(recurso);
    }

    protected abstract boolean validarSenha(Usuario usuario, String senha);
    protected abstract boolean validarPerfil(Usuario usuario, Recurso recurso);
    protected abstract boolean validarAtividade(Recurso recurso);
    protected abstract String concederAcesso(Recurso recurso);
}
