package service;

import model.Recurso;
import model.Usuario;

public interface ManipuladorAutenticacao {
    String autenticar(Usuario usuario, String senha, Recurso recurso);
    void setProximoManipulador(ManipuladorAutenticacao proximoManipulador);
}

