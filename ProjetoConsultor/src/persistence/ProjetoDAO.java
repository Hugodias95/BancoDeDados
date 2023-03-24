package persistence;

import model.Projeto;
import tools.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;

public class ProjetoDAO implements IProjetoDAO{

    private Connection con = null;

    public ProjetoDAO() throws Exception {
        this.con = ConexaoBD.getConexao();
    }

    @Override
    public void cadastrarProjeto(Projeto projeto) throws Exception {
        try {
            String sql = "INSERT INTO projeto VALUES (? , ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // Parameters iniciar os elementos
            preparedStatement.setString(1, projeto.getDescricao());
            preparedStatement.setString(2, projeto.getEndereco());
            preparedStatement.setFloat(3, projeto.getValorProjeto());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Projeto> listarProjetos() throws Exception{
        ArrayList<Projeto> lista = new ArrayList<>();
        String sql = "SELECT * FROM projeto";

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Projeto proj = new Projeto();
                proj.setId(rs.getInt("id"));
                proj.setDescricao(rs.getString("descricao"));
                proj.setEndereco(rs.getString("endereco"));
                proj.setValorProjeto(rs.getFloat("valor_projeto"));
                lista.add(proj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }



}
