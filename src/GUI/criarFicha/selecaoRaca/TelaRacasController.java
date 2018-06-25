package GUI.criarFicha.selecaoRaca;

import static database.Database.queryConsulta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import parser.Raca;
import static database.TABLE_Racas.consultar;
import javafx.scene.control.Label;

public class TelaRacasController implements Initializable {

    @FXML
    private Label nome, resumo;
    
    @FXML
    private ListView<String> lista;

    @FXML
    private void onMouseClick(){
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
        Raca raca = consultar("*", "NOME='" + itemSelecionado + "'");
        
        nome.setText(raca.getNome());
        resumo.setText(raca.getResumo());
        
    }
    
    private void listarRacas(ArrayList<String> racas){ //FUNÇÃO SEM UTILIDADE, ANALISAR E REMOVER OU NÃO ASSIM QUE POSSIVEL
        lista.getItems().clear();
        
        lista.getItems().addAll(racas);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String query = "SELECT NOME FROM RACAS";
        ArrayList<String> racas = queryConsulta(query);
        System.out.println(racas);
        listarRacas(racas);
        
    }    
    
}
