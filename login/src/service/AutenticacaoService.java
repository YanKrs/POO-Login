package service;

import model.Recurso;
import model.RecursoBuilder;
import model.Usuario;
import model.UsuarioBuilder;

public class AutenticacaoService extends AutenticacaoTemplate {
    private ManipuladorAutenticacao manipuladorAutenticacao;
    @Override
    protected boolean validarSenha(Usuario usuario, String senha) {
        return usuario.getSenha().equals(senha);
    }

    @Override
    protected boolean validarPerfil(Usuario usuario, Recurso recurso) {
        return usuario.getPerfil().equals(recurso.getPerfilNecessario());
    }

    @Override
    protected boolean validarAtividade(Recurso recurso) {
        return recurso.isAtivo();
    }

    @Override
    protected String concederAcesso(Recurso recurso) {
        return "Acesso concedido ao recurso " + recurso.getNome();
    }



    private static void runTest() {
        var usuario = new UsuarioBuilder().setId(1).setNome("João").setEmail("joao@gmail.com").setSenha("123").setPerfil("usuario").build();
        var adm = new UsuarioBuilder().setId(2).setNome("Maria").setEmail("maria@gmail.com").setSenha("456").setPerfil("adm").build();
        var cadastro = new RecursoBuilder().setNome("Cadastrar usuário").setPerfilNecessario("adm").setAtivo(true).build();
        var consulta = new RecursoBuilder().setNome("Consultar usuário").setPerfilNecessario("usuario").setAtivo(true).build();
        var excluir = new RecursoBuilder().setNome("Excluir usuário").setPerfilNecessario("adm").setAtivo(false).build();
        var login = new RecursoBuilder().setNome("Logar").setPerfilNecessario("usuario").setAtivo(false).build();
        var service = new AutenticacaoService();
    }

    public AutenticacaoService() {
        inicializarCadeiaDeManipuladores();
    }

    private void inicializarCadeiaDeManipuladores() {
        ManipuladorAutenticacao senhaInvalida = new ManipuladorSenhaInvalida();
        ManipuladorAutenticacao perfilNecessario = new ManipuladorPerfilNecessario();
        ManipuladorAutenticacao recursoInativo = new ManipuladorRecursoInativo();
        ManipuladorAutenticacao acessoConcedido = new ManipuladorAcessoConcedido();

        senhaInvalida.setProximoManipulador(perfilNecessario);
        perfilNecessario.setProximoManipulador(recursoInativo);
        recursoInativo.setProximoManipulador(acessoConcedido);

        manipuladorAutenticacao = senhaInvalida;
    }

    public String aut;
}

