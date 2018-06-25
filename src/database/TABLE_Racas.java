package database;

import static database.Database.executarUpdate;
import parser.Raca;

public class TABLE_Racas {
    
    public static void gerarTable(){
        String sql = "CREATE TABLE RACAS ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NOME TEXT NOT NULL,"
                    + "RESUMO TEXT NOT NULL,"
                    + "PERSONALIDADE TEXT NOT NULL,"
                    + "APARENCIA TEXT NOT NULL,"
                    + "RELACOES TEXT NOT NULL,"
                    + "TENDENCIA TEXT NOT NULL,"
                    + "TERRA TEXT NOT NULL,"
                    + "RELIGIAO TEXT NOT NULL,"
                    + "NOMES TEXT NOT NULL,"
                    + "AVENTURAS TEXT NOT NULL,"
                    + "IDIOMAS TEXT NOT NULL,"
                    + "AJ_FORCA INT,"
                    + "AJ_DESTREZA INT,"
                    + "AJ_CONSTITUICAO INT,"
                    + "AJ_SABEDORIA INT,"
                    + "AJ_INTELIGENCIA INT,"
                    + "AJ_CARISMA INT,"
                    + "AJ_DISTRIBUTIVO INT,"
                    + "QUANT_STATUS INT)";
        
        executarUpdate(sql);
        System.out.println("Tabela RACAS gerada com sucesso.");
        
    }
    
    public static void inserir(Raca raca){
        String sql = "INSERT INTO RACAS VALUES("
                + "NULL,"
                + "'" + raca.getNome() + "'"
                + "'" + raca.getResumo() + "'"
                + "'" + raca.getPersonalidade() + "'"
                + "'" + raca.getAparencia() + "'"
                + "'" + raca.getRelacoes() + "'"
                + "'" + raca.getTendencia() + "'"
                + "'" + raca.getTerra() + "'"
                + "'" + raca.getReligiao() + "'"
                + "'" + raca.getNomes() + "'"
                + "'" + raca.getAventuras() + "'"
                + "'" + raca.getIdiomas() + "'"
                + "'" + raca.getAj_forca() + "'"
                + "'" + raca.getAj_destreza() + "'"
                + "'" + raca.getAj_constituicao() + "'"
                + "'" + raca.getAj_sabedoria() + "'"
                + "'" + raca.getAj_inteligencia() + "'"
                + "'" + raca.getAj_carisma() + "'"
                + "'" + raca.getAj_distributivo() + "'"
                + "'" + raca.getQuant_status() + "')";
        
        executarUpdate(sql);
        System.out.println("Raca " + raca.getNome() + " cadastrada com sucesso.");
    
    }
}
