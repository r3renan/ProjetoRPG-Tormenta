package database;

import java.sql.*;

public class DB_Fichas {
    public static void gerarTableFichas(){
        Connection c = null;
        Statement s = null;
      
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
            System.out.println("Banco de dados acessado com sucesso");
            
            s = c.createStatement();
            String sql = "CREATE TABLE FICHAS" +
                            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "ID_RACA INT," +
                            "FOREIGN KEY(ID_RACA) REFERENCES RACAS(ID)," +
                            "ID_CLASSE INT," +
                            "NOME TEXT NOT NULL," +
                            "NIVEL INTEGER NOT NULL," +
                            "FORCA INT," +
                            "DESTREZA INT," +
                            "CONSTITUICAO INT," +
                            "SABEDORIA INT," +
                            "INTELIGENCIA INT," +
                            "CARISMA INT)";
            
            s.executeUpdate(sql);
            s.close();
            c.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return;
        }
        
        System.out.println("Tabela FICHAS gerada com sucesso.");
    }
}
