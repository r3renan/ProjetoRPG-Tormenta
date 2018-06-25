package parser;

import java.sql.ResultSet;

public class TracoRacial {
    private int ID;
    private String raca;
    private String traco;
    
    TracoRacial(ResultSet dados) throws Exception {
        ID = dados.getInt("ID");
        raca = dados.getString("RACA");
        traco = dados.getString("TRACO");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTraco() {
        return traco;
    }

    public void setTraco(String traco) {
        this.traco = traco;
    }
    
    
}
