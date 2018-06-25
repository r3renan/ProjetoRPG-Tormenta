package database;

import static database.Database.executarUpdate;


public class TABLE_Fichas {
    
    public static void gerarTable(){
        String sql = "CREATE TABLE FICHAS (" +
                            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "ID_RACA INTEGER," +
                            "ID_CLASSE INTEGER," +
                            "NOME TEXT," +
                            "NIVEL INTEGER," +
                            "FORCA INTEGER," +
                            "DESTREZA INTEGER," +
                            "CONSTITUICAO INTEGER," +
                            "SABEDORIA INTEGER," +
                            "INTELIGENCIA INTEGER," +
                            "CARISMA INTEGER," +
                            "FOREIGN KEY(ID_RACA) REFERENCES RACAS(ID)," +
                            "FOREIGN KEY(ID_CLASSE) REFERENCES CLASSES(ID)" +
                            ")";
        
        executarUpdate(sql);
        System.out.println("Tabela FICHAS gerada com sucesso.");
    }
    
    public static void inserir(){
        
    }
}
