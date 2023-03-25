package persistence;

import model.Projeto;

import java.util.ArrayList;

public interface IProjetoDAO {
    void cadastrarProjeto(Projeto projeto) throws Exception;

    ArrayList<Projeto> listarProjetos() throws Exception;

    void alterarProjeto(Projeto projeto) throws Exception;

    void deletarProjeto(int id) throws Exception;

    ArrayList<Projeto> consultarProjeto(Projeto projeto) throws Exception;
}