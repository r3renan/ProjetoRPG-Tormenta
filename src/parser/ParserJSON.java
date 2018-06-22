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
        /*System.out.println("Magia atual: " + magia.getNome());
        System.out.println("Nivel: " + magia.getNivel());
        System.out.println("Tempo de Execução: " + magia.getTempoExecucao());
        System.out.println("Alcance: " + magia.getAlcance());
        System.out.println("Efeito: " + magia.getEfeito());
        System.out.println("Alvo: " + magia.getAlvo());
        System.out.println("Duração: " + magia.getDuracao());
        System.out.println("Teste de Resistencia: " + magia.getTesteResistencia());
        System.out.println("Fonte: " + magia.getFonte());
        System.out.println("Descrição: " + magia.getDescricao());*/
        
        
        
        for(Magia magia : magias){
            DB_Magias.inserirMagia(magia);
        }
    }
}
