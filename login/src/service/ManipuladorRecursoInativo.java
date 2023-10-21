package service;


import model.Recurso;
import model.Usuario;

public class ManipuladorRecursoInativo extends ManipuladorAutenticacaoBase {
    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!recurso.isAtivo()) {
            return "Recurso " + recurso.getNome() + " inativo";
        }
        return tratarProximaAutenticacao(usuario, senha, recurso);
    }
}
