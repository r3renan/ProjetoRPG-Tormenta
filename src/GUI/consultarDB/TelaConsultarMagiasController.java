package GUI.consultarDB;

import static database.DB_Magias.consultarMagia;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import parser.Magia;
import static database.DB_Magias.gerarArrayMagias;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class TelaConsultarMagiasController implements Initializable {

    @FXML
    private ListView<String> lista;
    
    @FXML
    private Label nome, nivel, tempoExecucao, alcance, efeito, alvo, duracao, testeResistencia, fonte, descricao;
    
    @FXML
    private TextField fieldBusca;
    
    @FXML
    private ComboBox boxEscola, boxNivel, boxTempoExecucao, boxAlcance, boxEfeito, boxAlvo, boxDuracao, boxTesteResistencia, boxFonte;
    
    @FXML
    private Button btnBuscar;
    
    @FXML
    private TextFlow textoDescricao;
    
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
        //textoDescricao.setText(magia.getDescricao());
        textoDescricao.getChildren().clear();
        textoDescricao.getChildren().add(new Text(magia.getDescricao()));
        
    }
    
    @FXML
    private void buscar(ActionEvent event) throws Exception{
        String query = "SELECT NOME FROM MAGIAS WHERE NOME LIKE '%" + fieldBusca.getText() + "%'";
        
        if (boxEscola.getValue() != null){
            query = query + " AND NIVEL LIKE '%" + boxEscola.getValue() + "%'";
        }
        
        if (boxNivel.getValue() != null){
            String nivel = boxNivel.getValue().toString();
            query = query + " AND NIVEL LIKE '%" + (nivel.substring(nivel.indexOf(" "), nivel.length()))+ "%'";
        }
        
        listarMagias(gerarArrayMagias(query));
        
    }
    
    public void listarMagias(ArrayList<String> nomeMagias){
        lista.getItems().clear();
        
        for (String magia : nomeMagias){
            lista.getItems().add(magia);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Inicializar lista com todas as magias
        String query = "SELECT NOME FROM MAGIAS";
        ArrayList<String> nomeMagias = gerarArrayMagias(query);
        listarMagias(nomeMagias);
        
        //Popular opções nas caixas de seleção de busca e definir valor padrão como nulo
        boxEscola.getItems().addAll(null, "Arcana", "Divina");
        boxEscola.setValue(null);

        boxNivel.getItems().addAll(null, "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5", "Nivel 6", "Nivel 7", "Nivel 8", "Nivel 9", "Nivel 10");
        boxNivel.setValue(null);
        
        boxTempoExecucao.getItems().addAll();
        boxTempoExecucao.setValue(null);
        
        boxAlcance.getItems().addAll(null, "Toque", "Pessoal", "3m - 10m", "> 10m");
        boxAlcance.setValue(null);
        
        boxEfeito.getItems().addAll();
        boxEfeito.setValue(null);
        
        boxAlvo.getItems().addAll();
        boxAlvo.setValue(null);
        
        boxDuracao.getItems().addAll();
        boxDuracao.setValue(null);
        
        boxTesteResistencia.getItems().addAll();
        boxTesteResistencia.setValue(null);
        
        boxFonte.getItems().addAll();
        boxFonte.setValue(null);
    }
}
