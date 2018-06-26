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
                + "TREINADA TEXT,"
                + "CONSTRAINT NOME_UNIQUE UNIQUE(NOME))";
        
        executarUpdate(sql);
    }
    
    public static void inserir(Pericia pericia){
        String sql = "INSERT INTO PERICIAS VALUES("
                + "NULL,"
                + "'" + pericia.getNome() + "',"
                + "'" + pericia.getDescricao() + "',"
                + "'" + pericia.getHabilidade_chave() + "',"
                + "'" + pericia.getPenalidade_armadura() + "',"
                + "'" + pericia.getTreinada() + ")";
        
        executarUpdate(sql);
        System.out.println("Pericia " + pericia.getNome() + " inserida com sucesso.");
    }
}
