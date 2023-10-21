package service;


import model.Recurso;
import model.Usuario;

public class ManipuladorPerfilNecessario extends ManipuladorAutenticacaoBase {
    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!usuario.getPerfil().equals(recurso.getPerfilNecessario())) {
            return "Acesso negado ao recurso " + recurso.getNome();
        }
        return tratarProximaAutenticacao(usuario, senha, recurso);
    }
}
