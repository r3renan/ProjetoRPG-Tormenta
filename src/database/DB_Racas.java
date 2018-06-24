package database;

import static database.Database.connect;
import java.sql.*;
import parser.Raca;

public class DB_Racas {
    
    public static void gerarTableRacas(){
        Connection c = connect();
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
        
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
            System.out.println("Tabela RACAS gerada com sucesso.");
            
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    
    public static void inserir(Raca raca){
        Connection c = connect();
        
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
        
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
            
            System.out.println("Raca " + raca.getNome() + " cadastrada com sucesso.");
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
