package service;

import model.Recurso;
import model.Usuario;

public abstract class ManipuladorAutenticacaoBase implements ManipuladorAutenticacao {
    private ManipuladorAutenticacao proximoManipulador;

    @Override
    public void setProximoManipulador(ManipuladorAutenticacao proximoManipulador) {
        this.proximoManipulador = proximoManipulador;
    }

    protected String tratarProximaAutenticacao(Usuario usuario, String senha, Recurso recurso) {
        if (proximoManipulador != null) {
            return proximoManipulador.autenticar(usuario, senha, recurso);
        }
        return "Nenhum manipulador disponível para tratar a solicitação.";
    }
}
