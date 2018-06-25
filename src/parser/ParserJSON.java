package parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import database.TABLE_Magias;
import database.TABLE_Racas;
import database.TABLE_TracosRaciais;
import java.io.FileReader;
import java.util.ArrayList;

public class ParserJSON{
    public static void cadastrarMagias() throws Exception{
        JsonReader reader = new JsonReader(new FileReader("lib/magias_basico.json"));
        ArrayList<Magia> magias = new Gson().fromJson(reader, new TypeToken<ArrayList<Magia>>() {}.getType());
        
        for(Magia magia : magias){
            TABLE_Magias.inserir(magia);
        }
    }
    
    public static void cadastrarRacas() throws Exception{
        JsonReader reader = new JsonReader(new FileReader("lib/racas.json"));
        ArrayList<Raca> racas = new Gson().fromJson(reader, new TypeToken<ArrayList<Raca>>() {}.getType());
        
        for (Raca raca : racas){
            TABLE_Racas.inserir(raca);
        }
    }
    
    public static void cadastrarTracosRaciais() throws Exception{
        JsonReader reader = new JsonReader(new FileReader("lib/tracos_raciais.json"));
        ArrayList<TracoRacial> tracosRaciais = new Gson().fromJson(reader, new TypeToken<ArrayList<TracoRacial>>() {}.getType());
        
        for (TracoRacial tracoRacial : tracosRaciais){
            TABLE_TracosRaciais.inserir(tracoRacial);
        }
    }
}
