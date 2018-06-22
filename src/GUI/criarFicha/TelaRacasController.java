package GUI.criarFicha;

import static database.DB_Magias.consultarMagia;
import static database.DB_Magias.consultarMagiaNome;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import parser.Magia;

public class TelaRacasController implements Initializable {

    @FXML
    private ListView<String> lista;
    
    @FXML
    private void onMouseClick(){
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
        Magia magia = consultarMagia(itemSelecionado);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> nomeMagias = consultarMagiaNome();
        for (String magia : nomeMagias){
            lista.getItems().add(magia);
        }
    }
}
