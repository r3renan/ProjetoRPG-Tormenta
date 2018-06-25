package database;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    
    public static Connection connect(){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Tormenta.db");
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return c;
    }
    
    public static void executarUpdate(String sql){
        Connection c1 = connect();
        System.out.println("QUERY UPDATE: " + sql);
        
        try {
            Statement s1 = c1.createStatement();
            s1.executeUpdate(sql);
            s1.close();
            c1.close();
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static ResultSet executarQuery(String sql){
        Connection c2 = connect();
        System.out.println("QUERY: " + sql);
        ResultSet result = null;
        
        try {
            Statement s2 = c2.createStatement();
            result = s2.executeQuery(sql);
            //System.out.println("Dentro da query: " + result.isClosed());
            //s2.close();
            //c2.close();
            
        } catch(Exception e){
            System.out.println("QUERY: " + sql);
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        
        return result;
    }
    
    public static ArrayList<String> queryConsulta(String query){
        Connection c = connect();
        ArrayList<String> saida = new ArrayList<>();
        
        try{
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(query);
            
            int resultSize = result.getMetaData().getColumnCount();
            
            while(result.next()){
                int i = 1;
                while(i <= resultSize){
                    saida.add(result.getString(i++));
                }
            }
            
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return saida;
    }
}
