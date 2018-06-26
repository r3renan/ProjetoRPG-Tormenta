package database;

import static database.Database.executarUpdate;
import parser.TracoRacial;

public class TABLE_TracosRaciais {
    
    public static void gerarTable(){
        String sql = "CREATE TABLE TRACOS_RACIAIS("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "RACA TEXT NOT NULL,"
                + "TRACO TEXT NOT NULL,"
                + "FOREIGN KEY(RACA) REFERENCES RACAS(NOME),"
                + "CONSTRAINT TRACO_UNIQUE UNIQUE(TRACO))";
        
        executarUpdate(sql);
    }
    
    public static void inserir(TracoRacial traco){
        String sql = "INSERT INTO TRACOS_RACIAIS VALUES("
                + "NULL,"
                + "'" + traco.getRaca() + "',"
                + "'" + traco.getTraco() + "')";
        
        executarUpdate(sql);
        System.out.println("Traco da raca " + traco.getRaca() + " cadastrado com sucesso.");
    }
}
