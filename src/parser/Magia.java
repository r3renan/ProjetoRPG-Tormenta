package parser;

import java.sql.ResultSet;

public class Magia {
    private int ID;
    private String nome;
    private String nivel;
    private String tempoExecucao;
    private String alcance;
    private String efeito;
    private String alvo;
    private String duracao;
    private String testeResistencia;
    private String fonte;
    private String descricao;
    
   public Magia(){
       this.nome = "NAO INICIALIZADO";
   }
   
   public Magia(ResultSet dados) throws Exception{
       ID = dados.getInt("ID");
       nome = dados.getString("NOME");
       nivel = dados.getString("NIVEL");
       tempoExecucao = dados.getString("TEMPO_EXECUCAO");
       alcance = dados.getString("ALCANCE");
       efeito = dados.getString("EFEITO");
       alvo = dados.getString("ALVO");
       duracao = dados.getString("DURACAO");
       testeResistencia = dados.getString("TESTE_RESISTENCIA");
       fonte = dados.getString("FONTE");
       descricao = dados.getString("DESCRICAO");
       
       /*if (alcance == null) alcance = "-";
       if (efeito == null) efeito = "-";
       if (alvo == null) alvo = "-";
       if (duracao == null) duracao = "-";
       if (testeResistencia == null) testeResistencia = "-";
       if (fonte == null) fonte = "-";*/
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(String tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
       this.alcance = alcance;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public String getAlvo() {
        return alvo;
    }

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getTesteResistencia() {
        return testeResistencia;
    }

    public void setTesteResistencia(String testeResistencia) {
        this.testeResistencia = testeResistencia;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
