package database;

import java.sql.*;
import parser.Magia;
import static database.Database.connect;
import static database.Database.executarUpdate;


public class TABLE_Magias {
    
    public static void gerarTable(){
        String sql = "CREATE TABLE MAGIAS (" +
                            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "NOME TEXT NOT NULL," +
                            "NIVEL TEXT NOT NULL," +
                            "TEMPO_EXECUCAO TEXT," +
                            "ALCANCE TEXT," +
                            "AREA TEXT," +
                            "EFEITO TEXT," +
                            "ALVO TEXT," +
                            "DURACAO TEXT," +
                            "TESTE_RESISTENCIA TEXT," +
                            "FONTE TEXT," +
                            "DESCRICAO TEXT)";
        
        executarUpdate(sql);
    }
    
    public static void inserir(Magia magia){
        String sql = "INSERT INTO MAGIAS VALUES("
                    + "NULL,"
                    + "'" + magia.getNome() + "',"
                    + "'" + magia.getNivel() + "',"
                    + "'" + magia.getTempoExecucao() + "',"
                    + "'" + magia.getAlcance() + "',"
                    + "'" + magia.getArea() + "',"
                    + "'" + magia.getEfeito() + "',"
                    + "'" + magia.getAlvo() + "',"
                    + "'" + magia.getDuracao() + "',"
                    + "'" + magia.getTesteResistencia() + "',"
                    + "'" + magia.getFonte() + "',"
                    + "'" + magia.getDescricao() + "')";

        executarUpdate(sql);
        System.out.println("Magia " + magia.getNome() + " inserida com sucesso");
    }
    
    public static Magia consultar(String coluna, String busca){
        Connection c = connect();
        String sql = "SELECT " + coluna + " FROM MAGIAS";
        if (busca != null){
            sql = sql + " WHERE " + busca;
        }
        
        Magia magia = null;
        
        try {
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            magia = new Magia(result);
            System.out.println("Nome: " + magia.getNome());
            s.close();
            c.close();
            
        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return magia;
    }
}
