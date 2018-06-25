package database;

import static database.Database.executarUpdate;
import parser.Manobra;

public class TABLE_Manobras {
    public static void gerarTable(){
        String sql = "CREATE TABLE MANOBRAS("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "PERICIA_REF TEXT NOT NULL,"
                + "NOME TEXT NOT NULL,"
                + "DESCRICAO TEXT NOT NULL,"
                + "CLASSE_DIFICULDADE TEXT,"
                + "FOREIGN KEY(PERICIA_REF) REFERENCES PERICIAS(NOME))";
        
        executarUpdate(sql);
    }
    
    public static void inserir(Manobra manobra){
        String sql = "INSERT INTO MANOBRAS VALUES("
                + "NULL,"
                + "'" + manobra.getPericia_ref() + "',"
                + "'" + manobra.getNome() + "',"
                + "'" + manobra.getDescricao() + "',"
                + "'" + manobra.getClasse_dificuldade() + "')";
        
        executarUpdate(sql);
        System.out.println("Manobra " + manobra.getNome() + " inserida com sucesso.");
    }
}
