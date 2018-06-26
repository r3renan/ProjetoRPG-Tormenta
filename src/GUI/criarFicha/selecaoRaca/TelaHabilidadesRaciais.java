package GUI.criarFicha.selecaoRaca;

import static database.Database.queryConsulta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TelaHabilidadesRaciais implements Initializable {

    @FXML
    private ListView<String> lista;
    
    @FXML
    private Button btnRetornar;
    
    @FXML
    private TextArea textArea;
    
    private String raca;
    
    private int id_raca;
    public void setRaca(int id_raca){
        this.id_raca = id_raca;
    }
    
    private int ficha_id;
    public void setFicha_id(int ficha_id) {
        this.ficha_id = ficha_id;
    }

    @FXML
    private void onMouseClick(){
        textArea.clear();
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
    }
    
    public void listarHabilidades(ArrayList<String> habilidadesRaciais){
        lista.getItems().clear();
        lista.getItems().addAll(habilidadesRaciais);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista.setStyle("-fx-font-size: 1.5em;");
        String query = "SELECT NOME FROM TRACOS_RACIAIS WHERE RACA=" + raca;
        ArrayList<String> habilidadesRaciais = queryConsulta(query);
        
    }    
}
