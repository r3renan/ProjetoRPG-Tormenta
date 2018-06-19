package database;

import java.sql.*;

public class GerarDatabase {

    public static void gerarDatabase() {
        Connection c = null;
      
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
            c.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Banco de dados gerado com sucesso.");
    }
    
}
