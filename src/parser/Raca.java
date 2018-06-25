package parser;

import java.sql.ResultSet;

public class Raca {
    
    private int ID;
    private String nome;
    private String resumo;
    private String personalidade;
    private String aparencia;
    private String relacoes;
    private String tendencia;
    private String terra;
    private String religiao;
    private String nomes;
    private String aventuras;
    private String idiomas;
    private int aj_forca;
    private int aj_destreza;
    private int aj_constituicao;
    private int aj_sabedoria;
    private int aj_inteligencia;
    private int aj_carisma;
    private int aj_distributivo;
    private int quant_status;
    
    public Raca(ResultSet dados) throws Exception {
        ID = dados.getInt("ID");
        nome = dados.getString("NOME");
        resumo = dados.getString("RESUMO");
        personalidade = dados.getString("PERSONALIDADE");
        aparencia = dados.getString("APARENCIA");
        relacoes = dados.getString("RELACOES");
        tendencia = dados.getString("TENDENCIA");
        terra = dados.getString("TERRA");
        religiao = dados.getString("RELIGIAO");
        nomes = dados.getString("NOMES");
        aventuras = dados.getString("AVENTURAS");
        idiomas = dados.getString("IDIOMAS");
        aj_forca = dados.getInt("AJ_FORCA");
        aj_destreza = dados.getInt("AJ_DESTREZA");
        aj_constituicao = dados.getInt("AJ_CONSTITUICAO");
        aj_sabedoria = dados.getInt("AJ_SABEDORIA");
        aj_inteligencia = dados.getInt("AJ_INTELIGENCIA");
        aj_carisma = dados.getInt("AJ_CARISMA");
        aj_distributivo = dados.getInt("AJ_DISTRIBUTIVO");
        quant_status = dados.getInt("QUANT_STATUS");
                
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getPersonalidade() {
        return personalidade;
    }

    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public String getRelacoes() {
        return relacoes;
    }

    public void setRelacoes(String relacoes) {
        this.relacoes = relacoes;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public String getTerra() {
        return terra;
    }

    public void setTerra(String terra) {
        this.terra = terra;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public String getAventuras() {
        return aventuras;
    }

    public void setAventuras(String aventuras) {
        this.aventuras = aventuras;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getAj_forca() {
        return aj_forca;
    }

    public void setAj_forca(int aj_forca) {
        this.aj_forca = aj_forca;
    }

    public int getAj_destreza() {
        return aj_destreza;
    }

    public void setAj_destreza(int aj_destreza) {
        this.aj_destreza = aj_destreza;
    }

    public int getAj_constituicao() {
        return aj_constituicao;
    }

    public void setAj_constituicao(int aj_constituicao) {
        this.aj_constituicao = aj_constituicao;
    }

    public int getAj_sabedoria() {
        return aj_sabedoria;
    }

    public void setAj_sabedoria(int aj_sabedoria) {
        this.aj_sabedoria = aj_sabedoria;
    }

    public int getAj_inteligencia() {
        return aj_inteligencia;
    }

    public void setAj_inteligencia(int aj_inteligencia) {
        this.aj_inteligencia = aj_inteligencia;
    }

    public int getAj_carisma() {
        return aj_carisma;
    }

    public void setAj_carisma(int aj_carisma) {
        this.aj_carisma = aj_carisma;
    }

    public int getAj_distributivo() {
        return aj_distributivo;
    }

    public void setAj_distributivo(int aj_distributivo) {
        this.aj_distributivo = aj_distributivo;
    }

    public int getQuant_status() {
        return quant_status;
    }

    public void setQuant_status(int quant_status) {
        this.quant_status = quant_status;
    }
}
