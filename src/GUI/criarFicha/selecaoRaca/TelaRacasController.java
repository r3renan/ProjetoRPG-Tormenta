package GUI.criarFicha.selecaoRaca;

import static database.Database.queryConsulta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class TelaRacasController implements Initializable {

    @FXML
    private ListView lista;
        
    private void listarRacas(ArrayList<String> racas){ //FUNÇÃO SEM UTILIDADE, ANALISAR E REMOVER OU NÃO ASSIM QUE POSSIVEL
        lista.getItems().clear();
        
        lista.getItems().addAll(racas);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String query = "SELECT NOME FROM RACAS";
        ArrayList<String> racas = queryConsulta(query);
        lista.getItems().addAll(racas);
        
    }    
    
}
