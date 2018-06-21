package parser;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import database.DB_Magias;
import java.io.FileReader;

public class ParserJSON{ //ATRIBUTOS: NOME, NIVEL, TEMPO DE EXECUÇÃO, ALCANCE, ALVOS, DURAÇÃO, TESTE DE RESISTENCIA, FONTE, DESCRIÇÃO
    public static void cadastrarMagias() throws Exception{
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/resources/magias_basico.json"));
        Magia magia = gson.fromJson(reader, Magia.class);
        System.out.println("Magia atual: " + magia.getNome());
        System.out.println("Nivel: " + magia.getNivel());
        System.out.println("Tempo de Execução: " + magia.getTempoExecucao());
        System.out.println("Alcance: " + magia.getAlcance());
        System.out.println("Efeito: " + magia.getEfeito());
        System.out.println("Alvo: " + magia.getAlvo());
        System.out.println("Duração: " + magia.getDuracao());
        System.out.println("Teste de Resistencia: " + magia.getTesteResistencia());
        System.out.println("Fonte: " + magia.getFonte());
        System.out.println("Descrição: " + magia.getDescricao());
        
        DB_Magias.inserirMagia(magia);
    }
}
