package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB_Classes {
    
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
    
    public static void gerarTableClasses(){
        Connection c = connect();
        String sql = "CREATE TABLE CLASSES ("
        + "ID INTEGER PRIMARY KEY AUTOINCREMENT)";
        
        try {
            Statement s = c.createStatement();
            s = c.createStatement();            
            s.executeUpdate(sql);            
            s.close();
            c.close();            
            System.out.println("Tabela temporaria CLASSES gerada com sucesso.");
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return;
        }
    }
}
