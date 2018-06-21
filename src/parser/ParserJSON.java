package parser;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;

public class ParserJSON{ //ATRIBUTOS: NOME, NIVEL, TEMPO DE EXECUÇÃO, ALCANCE, ALVOS, DURAÇÃO, TESTE DE RESISTENCIA, FONTE, DESCRIÇÃO
    public void cadastrarMagias() throws Exception{
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("magias_basico.json"));
        Magia magia = gson.fromJson(reader, Magia.class);
    }
}
