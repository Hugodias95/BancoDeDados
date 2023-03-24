package persistence;

import model.Projeto;

import java.util.ArrayList;

public interface IProjetoDAO {
    void cadastrarProjeto(Projeto projeto) throws Exception;

    ArrayList<Projeto> listarProjetos() throws Exception;
}
