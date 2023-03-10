/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno
 */
public class Consultor {
    //Atributos
    private int idConsultor = 0;
    private String nome = "";
    private String email = "";
    
    //Métodos

    public Consultor() {
    }
    
    public Consultor(int idConsultor, String nome, String email) {
        this.idConsultor = idConsultor;
        this.nome = nome;
        this.email = email;
    }

    public int getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(int idConsultor) {
        this.idConsultor = idConsultor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Consultor{" + "idConsultor=" + idConsultor + ", nome=" + nome + ", email=" + email + '}';
    }
    
    
    
}
