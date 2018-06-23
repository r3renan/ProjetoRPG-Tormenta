package parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import database.DB_Magias;
import java.io.FileReader;
import java.util.ArrayList;

public class ParserJSON{
    public static void cadastrarMagias() throws Exception{
        JsonReader reader = new JsonReader(new FileReader("lib/magias_basico.json"));
        ArrayList<Magia> magias = new Gson().fromJson(reader, new TypeToken<ArrayList<Magia>>() {}.getType());
        
        for(Magia magia : magias){
            DB_Magias.inserirMagia(magia);
        }
    }
}
