package persistence;

import model.Projeto;
import tools.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO implements IProjetoDAO{

    private Connection con = null;

    public ProjetoDAO() throws Exception {
        this.con = ConexaoBD.getConexao();
    }

    @Override
    public void cadastrarProjeto(Projeto projeto) throws Exception {
        try {
            String sql = "INSERT INTO projetos (descricao,endereco,valor_projeto) VALUES (? , ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // Parameters iniciar os elementos
            //preparedStatement.setInt(1, projeto.getId());
            preparedStatement.setString(1, projeto.getDescricao());
            preparedStatement.setString(2, projeto.getEndereco());
            preparedStatement.setFloat(3, projeto.getValorProjeto());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao executar o SQL: " + erro.getMessage());
        } catch (Exception e) {
            throw new Exception("Nao foi possível obter a lista de projetos : "+e.getMessage());
        }
    }

    @Override
    public ArrayList<Projeto> listarProjetos() throws Exception{
        ArrayList<Projeto> lista = new ArrayList<>();
        String sql = "SELECT * FROM projetos";

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
        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao executar o SQL: " + erro.getMessage());
        } catch (Exception e) {
            throw new Exception("Nao foi possível obter a lista de projetos : "+e.getMessage());
        }

        return lista;
    }

    @Override
    public void alterarProjeto(Projeto projeto) throws Exception {
        try{
            String sql = "UPDATE projetos SET descricao = ?, endereco = ?, valor_projeto = ?  where id = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1,projeto.getDescricao());
            prep.setString(2,projeto.getEndereco());
            prep.setFloat(3,projeto.getValorProjeto());
            prep.setInt(4,projeto.getId());
            prep.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao executar o SQL: " + erro.getMessage());
        }catch (Exception e){
            throw new Exception("Nao foi possível alterar o projeto Id: "+projeto.getId()+" : "+e.getMessage());
        }
    }

    @Override
    public void deletarProjeto(int id) throws Exception{
        try{
            String sql = "DELETE FROM projetos where id = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1,id);
            prep.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao executar o SQL: " + erro.getMessage());
        } catch (Exception e){
            throw new Exception("Nao foi possível deletar o projeto Id: "+id+" : "+e.getMessage());
        }
    }


    @Override
    public List<Projeto> consultarProjeto(Projeto projeto) throws Exception{
        try{
            List<Projeto> lista = new ArrayList<Projeto>();
            String sql = "SELECT * FROM tabela WHERE 1=1 ";
            int index = 1;

            if(projeto.getId() != null || projeto.getId() > 0){
                sql += " AND id = ? ";
            }
            if(projeto.getDescricao() != null){
                sql += " AND descricao = ? ";
            }
            if(projeto.getEndereco() != null){
                sql += " AND endereco = ? ";
            }
            if(projeto.getValorProjeto() != null){
                sql += " AND valor_projeto = ? ";
            }

            PreparedStatement prep = con.prepareStatement(sql);

            if(projeto.getId() != null || projeto.getId() > 0){
                prep.setInt(index++, projeto.getId());
            }
            if(projeto.getDescricao() != null){
                prep.setString(index++, projeto.getDescricao());
            }
            if(projeto.getEndereco() != null){
                prep.setString(index++, projeto.getEndereco());
            }
            if (projeto.getValorProjeto() != null){
                prep.setFloat(index++, projeto.getValorProjeto());
            }

            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                Projeto proj = new Projeto();
                proj.setId(rs.getInt("id"));
                proj.setDescricao(rs.getString("descricao"));
                proj.setEndereco(rs.getString("endereco"));
                proj.setValorProjeto(rs.getFloat("valor_projeto"));
                lista.add(proj);
            }

            return lista;
        }catch (SQLException erro){
            throw new Exception("Ocorreu um erro ao executar o SQL: " + erro.getMessage());
        }catch (Exception e){
            throw new Exception("Nao foi possível realizar a consulta: "+e.getMessage());
        }
    }
}
