package database;

import static database.Database.executarUpdate;
import parser.Pericia;

public class TABLE_Pericias {
    public static void gerarTable(){
        String sql = "CREATE TABLE PERICIAS("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NOME TEXT NOT NULL,"
                + "DESCRICAO TEXT NOT NULL,"
                + "HABILIDADE_CHAVE TEXT NOT NULL,"
                + "PENALIDADE_ARMADURA TEXT,"
                + "TREINADA TEXT)";
        
        executarUpdate(sql);
    }
    
    public static void inserir(Pericia pericia){
        
    }
}
