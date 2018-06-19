package database;

import java.sql.*;

public class DB_Racas {
    public static void gerarTableRacas(){
        Connection c = null;
        Statement s = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
            System.out.println("Banco de dados acessado com sucesso");
            
            s = c.createStatement();
            String sql = "CREATE TABLE RACAS"
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NOME TEXT NOT NULL,"
                    + "AJ_FORCA INT,"
                    + "AJ_DESTREZA INT,"
                    + "AJ_CONSTITUICAO INT,"
                    + "AJ_SABEDORIA INT,"
                    + "AJ_INTELIGENCIA INT,"
                    + "AJ_CARISMA INT,"
                    + "AJ_DISTRIBUTIVO INT,"
                    + "QUANT_STATUS INT)";
            
            s.executeUpdate(sql);
            s.close();
            c.close();
            
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return;
        }
        
        System.out.println("Tabela RACAS gerada com sucesso.");
    }
}
