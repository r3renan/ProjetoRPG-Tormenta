package parser;

import java.sql.ResultSet;

public class Manobra {
    private int ID;
    private String pericia_ref;
    private String nome;
    private String descricao;
    private String classe_dificuldade;
    
    public Manobra(ResultSet dados) throws Exception {
        ID = dados.getInt("ID");
        pericia_ref = dados.getString("PERICIA_REF");
        nome = dados.getString("NOME");
        descricao = dados.getString("DESCRICAO");
        classe_dificuldade = dados.getString("CLASSE_DIFICULDADE");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPericia_ref() {
        return pericia_ref;
    }

    public void setPericia_ref(String pericia_ref) {
        this.pericia_ref = pericia_ref;
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

    public String getClasse_dificuldade() {
        return classe_dificuldade;
    }

    public void setClasse_dificuldade(String classe_dificuldade) {
        this.classe_dificuldade = classe_dificuldade;
    }
    
    
}
