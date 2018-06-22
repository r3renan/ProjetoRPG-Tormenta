package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import parser.ParserJSON;

public class TelaInicialController implements Initializable {
    
    @FXML
    private Button btnCriarFicha, btnConsultaDB, btnCriaDB, btnCarregarFicha;
    
    @FXML
    private void telaCriarFicha(ActionEvent event) throws Exception {
        Stage stage = (Stage) btnCriarFicha.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/criarFicha/TelaCriarFicha.fxml"));
        Scene novaScene = new Scene(loader.load(), 800, 600);
        stage.setScene(novaScene);
    }
    
    @FXML
    private void consultaDB(ActionEvent event) throws Exception{
        Stage stage = (Stage) btnConsultaDB.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/consultarDB/TelaConsultarMagias.fxml"));
        
        Scene telaConsultarMagias = new Scene(loader.load(), 1000, 600);
        stage.setScene(telaConsultarMagias);
    }
    
    @FXML
    private void criarDB(ActionEvent event) throws Exception{
        try{
            ParserJSON.cadastrarMagias();
        } catch(Exception e){
            System.err.print(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
