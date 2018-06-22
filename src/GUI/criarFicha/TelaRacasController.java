package GUI.criarFicha;

import static database.DB_Magias.consultarMagiaNome;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class TelaRacasController implements Initializable {

    @FXML
    private ListView<String> lista;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> nomeMagias = consultarMagiaNome();
        for (String magia : nomeMagias){
            lista.getItems().add(magia);
        }
    }
}
