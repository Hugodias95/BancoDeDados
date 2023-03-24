package model;

public class Projeto {

    private int id;

    private String descricao;

    private String endereco;

    private float valorProjeto;

    public Projeto() {
    }

    public Projeto(String descricao, String endereco, float valorProjeto) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.valorProjeto = valorProjeto;
    }

    public Projeto(int id, String descricao, String endereco, float valorProjeto) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
        this.valorProjeto = valorProjeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getValorProjeto() {
        return valorProjeto;
    }

    public void setValorProjeto(float valorProjeto) {
        this.valorProjeto = valorProjeto;
    }
}
