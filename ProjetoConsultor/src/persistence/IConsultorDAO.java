/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence;
import model.Consultor;
import java.util.ArrayList;

/**
 *
 * @author aluno
 * INTERFACE DE CRUD
 */
public interface IConsultorDAO {

    void createConsultor(Consultor pessoa) throws Exception;
        
    ArrayList<Consultor> listaDeConsultores() throws Exception;
}
