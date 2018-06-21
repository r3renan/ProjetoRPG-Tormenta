package database;

import java.sql.*;
import parser.Magia;


public class DB_Magias {
    public static void gerarTableMagias(){ //ATRIBUTOS: NOME, NIVEL, TEMPO DE EXECUÇÃO, ALCANCE, ALVOS, DURAÇÃO, TESTE DE RESISTENCIA, FONTE, DESCRIÇÃO
        Connection c = null;
        Statement s = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
            System.out.println("Banco de dados acessado com sucesso");

            s = c.createStatement();

            String sql = "CREATE TABLE MAGIAS (" +
                            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "NOME TEXT NOT NULL," +
                            "NIVEL TEXT NOT NULL," +
                            "TEMPO_EXECUÇÃO TEXT," +
                            "ALCANCE TEXT," +
                            "EFEITO TEXT," +
                            "ALVO TEXT," +
                            "DURACAO TEXT," +
                            "TESTE_RESISTENCIA TEXT," +
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
    
    public static void inserirMagia(Magia magia){ //TODO
        try{
            Connection c = null;
            Statement s = null;
        
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
        
            s = c.createStatement();
        
            String sql = "INSERT INTO MAGIAS VALUES("
                    + "NULL,"
                    + "\"" + magia.getNome() + "\","
                    + "\"" + magia.getNivel() + "\","
                    + "\"" + magia.getTempoExecucao() + "\","
                    + "\"" + magia.getAlcance() + "\","
                    + "\"" + magia.getEfeito() + "\","
                    + "\"" + magia.getAlvo() + "\","
                    + "\"" + magia.getDuracao() + "\","
                    + "\"" + magia.getTesteResistencia() + "\","
                    + "\"" + magia.getFonte() + "\","
                    + "\"" + magia.getDescricao() + "\")";
            
            s.executeUpdate(sql);
            s.close();
            c.close();
            
            System.out.println("Magia " + magia.getNome() + " inserida com sucesso");
                    
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void consultarMagia(){
        Connection c = null;
        Statement s = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
            
            s = c.createStatement();
            
            String sql = "SELECT * FROM MAGIAS";
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
