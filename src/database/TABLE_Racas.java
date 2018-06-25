package database;

import static database.Database.connect;
import static database.Database.executarUpdate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
                    + "AJ_FORCA INTEGER,"
                    + "AJ_DESTREZA INTEGER,"
                    + "AJ_CONSTITUICAO INTEGER,"
                    + "AJ_SABEDORIA INTEGER,"
                    + "AJ_INTELIGENCIA INTEGER,"
                    + "AJ_CARISMA INTEGER,"
                    + "AJ_DISTRIBUTIVO INTEGER,"
                    + "QUANT_STATUS INTEGER)";
        
        executarUpdate(sql);
    }
    
    public static void inserir(Raca raca){
        String sql = "INSERT INTO RACAS VALUES("
                + "NULL,"
                + "'" + raca.getNome() + "',"
                + "'" + raca.getResumo() + "',"
                + "'" + raca.getPersonalidade() + "',"
                + "'" + raca.getAparencia() + "',"
                + "'" + raca.getRelacoes() + "',"
                + "'" + raca.getTendencia() + "',"
                + "'" + raca.getTerra() + "',"
                + "'" + raca.getReligiao() + "',"
                + "'" + raca.getNomes() + "',"
                + "'" + raca.getAventuras() + "',"
                + "'" + raca.getIdiomas() + "',"
                + "'" + raca.getAj_forca() + "',"
                + "'" + raca.getAj_destreza() + "',"
                + "'" + raca.getAj_constituicao() + "',"
                + "'" + raca.getAj_sabedoria() + "',"
                + "'" + raca.getAj_inteligencia() + "',"
                + "'" + raca.getAj_carisma() + "',"
                + "'" + raca.getAj_distributivo() + "',"
                + "'" + raca.getQuant_status() + "')";
        
        executarUpdate(sql);
        System.out.println("Raca " + raca.getNome() + " cadastrada com sucesso.");
    
    }
    
    public static Raca consultar(String coluna, String busca){
        Connection c = connect();
        String sql = "SELECT " + coluna + " FROM RACAS";
        if (busca != null){
            sql = sql + " WHERE " + busca;
        }
        
        Raca raca = null;
        
        try {
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            raca = new Raca(result);
            System.out.println("Nome: " + raca.getNome());
            s.close();
            c.close();
            
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return raca;
    }
}
