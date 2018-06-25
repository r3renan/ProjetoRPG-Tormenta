package database;

import static database.Database.connect;
import java.sql.Connection;
import java.sql.Statement;

public class TABLE_Classes {
    
    public static void gerarTable(){
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
        }
    }
}
