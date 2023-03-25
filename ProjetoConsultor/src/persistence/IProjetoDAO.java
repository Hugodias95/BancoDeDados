package persistence;

import model.Projeto;

import java.util.ArrayList;
import java.util.List;

public interface IProjetoDAO {
    void cadastrarProjeto(Projeto projeto) throws Exception;

    ArrayList<Projeto> listarProjetos() throws Exception;

    void alterarProjeto(Projeto projeto) throws Exception;

    void deletarProjeto(int id) throws Exception;

    List<Projeto> consultarProjeto(Projeto projeto) throws Exception;
}