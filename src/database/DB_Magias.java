package database;

import java.sql.*;


public class DB_Magias {
    public static void gerarTableMagias(){ //ATRIBUTOS: NOME, NIVEL, TEMPO DE EXECUÇÃO, ALCANCE, ALVOS, DURAÇÃO, TESTE DE RESISTENCIA, FONTE, DESCRIÇÃO
        Connection c = null;
        Statement s = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:rpg.db");
            System.out.println("Banco de dados acessado com sucesso");

            s = c.createStatement();

            String sql = "CREATE TABLE MAGIAS" +
                            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "NOME TEXT NOT NULL," +
                            "NIVEL TEXT NOT NULL," +
                            "TEMPO DE EXECUÇÃO TEXT," +
                            "ALCANCE TEXT," +
                            "ALVO TEXT," +
                            "DURACAO TEXT," +
                            "TESTE_DE_RESISTENCIA TEXT," +
                            "FONTE TEXT," +
                            "DESCRICAO TEXT)";
            
            s.executeUpdate(sql);
            s.close();
            c.close();
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return;
        }
        
        System.out.println("Tabela MAGIAS gerada com sucesso.");
        
    }
    
    public static void inserirMagia(String NOME){ //TODO
        
    }            
}
