package GUI.criarFicha;

import static database.DB_Magias.consultarMagia;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import parser.Magia;
import static database.DB_Magias.gerarArrayMagias;
import javafx.scene.control.Label;

public class TelaRacasController implements Initializable {

    @FXML
    private ListView<String> lista;
    
    @FXML
    private Label nome, nivel, tempoExecucao, alcance, efeito, alvo, duracao, testeResistencia, fonte, descricao;
    
    @FXML
    private void onMouseClick(){
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
        Magia magia = consultarMagia("*", "NOME=\"" + itemSelecionado +"\"");
        
        nome.setText(magia.getNome());
        nivel.setText(magia.getNivel());
        tempoExecucao.setText(magia.getTempoExecucao());
        alcance.setText(magia.getAlcance());
        efeito.setText(magia.getEfeito());
        alvo.setText(magia.getAlvo());
        duracao.setText(magia.getDuracao());
        testeResistencia.setText(magia.getTesteResistencia());
        fonte.setText(magia.getFonte());
        descricao.setText(magia.getDescricao());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> nomeMagias = gerarArrayMagias();
        for (String magia : nomeMagias){
            lista.getItems().add(magia);
        }
    }
}
