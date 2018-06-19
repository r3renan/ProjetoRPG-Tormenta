package programa;

import static database.DB_Fichas.gerarTableFichas;
import static database.DB_Magias.gerarTableMagias;
import static database.DB_Racas.gerarTableRacas;
import static database.GerarDatabase.gerarDatabase;

public class Inicializacao {
    public static void inicializacao(){ //Modificar método para futuramente criar a database apenas em casos especificos, como caso não haja nenhum banco de dados criado
        gerarDatabase();
        gerarTableFichas();
        gerarTableMagias();
        gerarTableRacas();
    }
}
