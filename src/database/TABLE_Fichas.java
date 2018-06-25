package database;

import static database.Database.connect;
import java.sql.*;

public class TABLE_Fichas {
    
    public static void gerarTable(){
        Connection c = connect();
        String sql = "CREATE TABLE FICHAS (" +
                            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "ID_RACA INTEGER," +
                            "ID_CLASSE INTEGER," +
                            "NOME TEXT NOT NULL," +
                            "NIVEL INTEGER NOT NULL," +
                            "FORCA INTEGER," +
                            "DESTREZA INTEGER," +
                            "CONSTITUICAO INTEGER," +
                            "SABEDORIA INTEGER," +
                            "INTELIGENCIA INTEGER," +
                            "CARISMA INTEGER," +
                            "FOREIGN KEY(ID_RACA) REFERENCES RACAS(ID)," +
                            "FOREIGN KEY(ID_CLASSE) REFERENCES CLASSES(ID)" +
                            ")";
        
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
            System.out.println("Tabela FICHAS gerada com sucesso.");
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
