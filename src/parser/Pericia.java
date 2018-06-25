package parser;

import java.sql.ResultSet;

public class Pericia {
    private int ID;
    private String nome;
    private String descricao;
    private String habilidade_chave;
    private String penalidade_armadura;
    private String treinada;
    
    public Pericia(ResultSet dados) throws Exception {
        ID = dados.getInt("ID");
        nome = dados.getString("NOME");
        descricao = dados.getString("DESCRICAO");
        habilidade_chave = dados.getString("HABILIDADE_CHAVE");
        penalidade_armadura = dados.getString("PENALIDADE_ARMADURA");
        treinada = dados.getString("TREINADA");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHabilidade_chave() {
        return habilidade_chave;
    }

    public void setHabilidade_chave(String habilidade_chave) {
        this.habilidade_chave = habilidade_chave;
    }

    public String getPenalidade_armadura() {
        return penalidade_armadura;
    }

    public void setPenalidade_armadura(String penalidade_armadura) {
        this.penalidade_armadura = penalidade_armadura;
    }

    public String getTreinada() {
        return treinada;
    }

    public void setTreinada(String treinada) {
        this.treinada = treinada;
    }
    
}
