package database;

import static database.Database.executarUpdate;

public class TABLE_Classes {
    
    public static void gerarTable(){
        String sql = "CREATE TABLE CLASSES ("
        + "ID INTEGER PRIMARY KEY AUTOINCREMENT)";
        
        executarUpdate(sql);
    }
}
