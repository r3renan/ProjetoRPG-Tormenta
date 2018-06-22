package database;

import java.sql.*;
import java.util.ArrayList;
import parser.Magia;


public class DB_Magias {
    
    private static Connection connect(){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return c;
    }
    
    public static void gerarTableMagias(){
        Connection c = connect();
        
        String sql = "CREATE TABLE MAGIAS (" +
                            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "NOME TEXT NOT NULL," +
                            "NIVEL TEXT NOT NULL," +
                            "TEMPO_EXECUCAO TEXT," +
                            "ALCANCE TEXT," +
                            "EFEITO TEXT," +
                            "ALVO TEXT," +
                            "DURACAO TEXT," +
                            "TESTE_RESISTENCIA TEXT," +
                            "FONTE TEXT," +
                            "DESCRICAO TEXT)";
        
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
            System.out.println("Tabela MAGIAS gerada com sucesso.");
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void inserirMagia(Magia magia){ //TODO
        Connection c = connect();
        
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
        
        try{
            Statement s = c.createStatement();            
            s.executeUpdate(sql);
            s.close();
            c.close();
            
            System.out.println("Magia " + magia.getNome() + " inserida com sucesso");
                    
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static ArrayList<String> gerarArrayMagias(){
        Connection c = connect();
        ArrayList<String> saida = new ArrayList<>();
        
        String sql = "SELECT NOME FROM MAGIAS";
        
        try{
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            
            int resultSize = result.getMetaData().getColumnCount();
            
            while(result.next()){
                int i = 1;
                while(i <= resultSize){
                    saida.add(result.getString(i++));
                }
            }
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return saida;
    }
    
    public static Magia consultarMagia(String nome){
        Connection c = connect();
        String sql = "SELECT * FROM MAGIAS WHERE NOME=\"" + nome + "\"";
        Magia magia = null;
        
        try {
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            magia = new Magia(result);
            System.out.println("Nome: " + magia.getNome());
            
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return magia;
    }
}
