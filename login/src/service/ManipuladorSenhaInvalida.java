package service;

import model.Recurso;
import model.Usuario;

public class ManipuladorSenhaInvalida extends ManipuladorAutenticacaoBase {
    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!usuario.getSenha().equals(senha)) {
            return "Senha inválida";
        }
        return tratarProximaAutenticacao(usuario, senha, recurso);
    }
}





