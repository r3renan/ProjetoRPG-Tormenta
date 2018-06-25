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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TelaRacasController implements Initializable {

    @FXML
    private Label nome, resumo;
    
    @FXML
    private ListView<String> lista;
    
    @FXML
    private Button btnPersonalidade, btnAventuras, btnNomes, btnAparencia, btnRelacoes, btnReligiao, btnTendencia, btnTerra, btnIdiomas, btnSelecionar;
    
    @FXML
    private TextArea textArea;
    
    private Raca raca;

    @FXML
    private void onMouseClick(){
        textArea.clear();
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
        raca = consultar("*", "NOME='" + itemSelecionado + "'");
        
        nome.setText(raca.getNome());
        resumo.setText(raca.getResumo());
    }
    
    @FXML
    private void selecionarRaca(){
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void exibirPersonalidade(){
        textArea.clear();
        textArea.setText(raca.getPersonalidade());
    }
    
    @FXML
    private void exibirAventuras(){
        textArea.clear();
        textArea.setText(raca.getAventuras());
    }
    
    @FXML
    private void exibirNomes(){
        textArea.clear();
        textArea.setText(raca.getNomes());
    }
    
    @FXML
    private void exibirAparencia(){
        textArea.clear();
        textArea.setText(raca.getAparencia());
    }
    
    @FXML
    private void exibirRelacoes(){
        textArea.clear();
        textArea.setText(raca.getRelacoes());
    }
    
    @FXML
    private void exibirReligiao(){
        textArea.clear();
        textArea.setText(raca.getReligiao());
    }
    
    @FXML
    private void exibirTendencia(){
        textArea.clear();
        textArea.setText(raca.getTendencia());
    }
    
    @FXML
    private void exibirTerra(){
        textArea.clear();
        textArea.setText(raca.getTerra());
    }
    
    @FXML
    private void exibirIdiomas(){
        textArea.clear();
        textArea.setText(raca.getIdiomas());
    }
    
    private void listarRacas(ArrayList<String> racas){ //FUNÇÃO SEM UTILIDADE, ANALISAR E REMOVER OU NÃO ASSIM QUE POSSIVEL
        lista.getItems().clear();
        lista.getItems().addAll(racas);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista.setStyle("-fx-font-size: 1.5em;");
        String query = "SELECT NOME FROM RACAS";
        ArrayList<String> racas = queryConsulta(query);
        System.out.println(racas);
        listarRacas(racas);
        
    }    
    
}
