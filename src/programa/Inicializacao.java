package programa;

import database.TABLE_Classes;
import database.TABLE_Fichas;
import database.TABLE_Magias;
import database.TABLE_Manobras;
import database.TABLE_Pericias;
import database.TABLE_Racas;
import database.TABLE_TracosRaciais;

public class Inicializacao {
    public static void inicializacao(){ //Modificar método para futuramente criar a database apenas em casos especificos, como caso não haja nenhum banco de dados criado
        TABLE_Classes.gerarTable();
        TABLE_Magias.gerarTable();
        TABLE_Racas.gerarTable();
        TABLE_Fichas.gerarTable();
        TABLE_TracosRaciais.gerarTable();
        TABLE_Pericias.gerarTable();
        TABLE_Manobras.gerarTable();
    }
}
