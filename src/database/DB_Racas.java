package database;

import java.sql.*;

public class DB_Racas {
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
    
    public static void gerarTableRacas(){
        Connection c = connect();
        String sql = "CREATE TABLE RACAS ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NOME TEXT NOT NULL,"
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
            return;
        }
    }
}
