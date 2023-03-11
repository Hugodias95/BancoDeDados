/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import model.Consultor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tools.ConexaoBD;
import java.util.ArrayList;
import tools.ConexaoBD;

/**
 *
 * @author aluno
 */
public class ConsultorDAO implements IConsultorDAO {

    //Atributos
    private Connection conexao = null; //instância de conexão com o banco

    //Métodos
    public ConsultorDAO() throws Exception {

        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void createConsultor(Consultor pessoa) throws Exception {
        try {
            String sql = "INSERT INTO consultor(nome,email) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            // Parameters iniciar os elementos
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: " + erro.getMessage());
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Consultor> listaDeConsultores() throws Exception {
        ArrayList<Consultor> listaDosConsultores = new ArrayList<Consultor>();
        String sql = "SELECT * FROM consultor";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Consultor pessoa = new Consultor();
                pessoa.setIdConsultor(rs.getInt("idConsultor"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                listaDosConsultores.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDosConsultores;
    }

}
