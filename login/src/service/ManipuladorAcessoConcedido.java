package service;

import model.Recurso;
import model.Usuario;

public class ManipuladorAcessoConcedido extends ManipuladorAutenticacaoBase {
    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        return "Acesso concedido ao recurso " + recurso.getNome();
    }
}

















