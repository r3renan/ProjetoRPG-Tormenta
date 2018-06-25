package database;

import static database.Database.connect;
import static database.Database.executarUpdate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import parser.Ficha;


public class TABLE_Fichas {
    
    public static void gerarTable(){
        String sql = "CREATE TABLE FICHAS ("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "ID_RACA INTEGER,"
                + "ID_CLASSE INTEGER,"
                + "NOME TEXT,"
                + "NIVEL INTEGER,"
                + "FORCA INTEGER,"
                + "DESTREZA INTEGER,"
                + "CONSTITUICAO INTEGER,"
                + "SABEDORIA INTEGER,"
                + "INTELIGENCIA INTEGER,"
                + "CARISMA INTEGER,"
                + "MOD_FORCA INTEGER,"
                + "MOD_DESTREZA INTEGER,"
                + "MOD_CONSTITUICAO INTEGER,"
                + "MOD_INTELIGENCIA INTEGER,"
                + "MOD_SABEDORIA INTEGER,"
                + "MOD_CARISMA INTEGER,"
                + "FOREIGN KEY(ID_RACA) REFERENCES RACAS(ID),"
                + "FOREIGN KEY(ID_CLASSE) REFERENCES CLASSES(ID)"
                + ")";

        executarUpdate(sql);
    }
    
    public static void inserir(Ficha ficha){
        String sql = "INSERT INTO FICHAS VALUES("
                + "NULL,"
                + "'" + ficha.getId_raca() + "',"
                + "'" + ficha.getId_classe() + "',"
                + "'" + ficha.getNome() + "',"
                + "'" + ficha.getNivel() + "',"
                + "'" + ficha.getForca() + "',"
                + "'" + ficha.getDestreza() + "',"
                + "'" + ficha.getConstituicao() + "',"
                + "'" + ficha.getSabedoria() + "',"
                + "'" + ficha.getInteligencia() + "',"
                + "'" + ficha.getCarisma() + "',"
                + "'" + ficha.getModForca() + "',"
                + "'" + ficha.getModDestreza() + "',"
                + "'" + ficha.getModConstituicao() + "',"
                + "'" + ficha.getModInteligencia() + "',"
                + "'" + ficha.getModSabedoria() + "',"
                + "'" + ficha.getModCarisma() + "')";
        
        executarUpdate(sql);
    }
    
    public Ficha consultar(String coluna, String busca){
        Connection c = connect();
        String sql = "SELECT " + coluna + " FROM FICHAS";
        if (busca != null){
            sql = sql + " WHERE " + busca;
        }
        
        Ficha ficha = null;
        
        try{
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            ficha = new Ficha(result);
            s.close();
            c.close();
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return ficha;
    }
}
