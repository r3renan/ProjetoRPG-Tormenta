package GUI.consultarDB;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import parser.Magia;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import static database.TABLE_Magias.consultar;
import static database.Database.queryConsulta;

public class TelaConsultarMagiasController implements Initializable {

    @FXML
    private ListView<String> lista;
    
    @FXML
    private Label nome, nivel, tempoExecucao, alcance, area, efeito, alvo, duracao, testeResistencia, fonte;
    
    @FXML
    private TextField fieldBusca;
    
    @FXML
    private ComboBox boxDominio, boxDescritor, boxNivel, boxTempoExecucao, boxAlcance, boxArea, boxEfeito, boxAlvo, boxDuracao, boxTesteResistencia, boxFonte;
    
    @FXML
    private Button btnBuscar;
    
    @FXML
    private TextFlow textoDescricao;
    
    @FXML
    private void onMouseClick(){
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
        Magia magia = consultar("*", "NOME='" + itemSelecionado +"'");
        
        nome.setText(magia.getNome());
        nivel.setText(magia.getNivel());
        tempoExecucao.setText(magia.getTempoExecucao());
        alcance.setText(magia.getAlcance());
        area.setText(magia.getArea());
        efeito.setText(magia.getEfeito());
        alvo.setText(magia.getAlvo());
        duracao.setText(magia.getDuracao());
        testeResistencia.setText(magia.getTesteResistencia());
        fonte.setText(magia.getFonte());
        textoDescricao.getChildren().clear();
        textoDescricao.getChildren().add(new Text(magia.getDescricao()));
        
    }
    
    @FXML
    private void buscar(ActionEvent event) throws Exception{
        String query = "SELECT NOME FROM MAGIAS WHERE NOME LIKE '%" + fieldBusca.getText() + "%'";
        
        if (boxDominio.getValue() != null){
            query = query + " AND NIVEL LIKE '%" + boxDominio.getValue() + "%'";
        }
        
        if (boxDescritor.getValue() != null){
            query = query + " AND (NIVEL LIKE '%(%' AND NIVEL LIKE '%" + boxDescritor.getValue().toString().toLowerCase() + "%')";
        }
        
        if (boxNivel.getValue() != null){
            String nivel = boxNivel.getValue().toString();
            query = query + " AND NIVEL LIKE '%" + (nivel.substring(nivel.indexOf(" "), nivel.length()))+ "%'";
        }
        
        if (boxTempoExecucao.getValue() != null){
            if (boxTempoExecucao.getValue().toString().equals("Tempo")){
                query = query + " AND (TEMPO_EXECUCAO LIKE '%minuto%' OR '%dia%' OR '%hora%')";
            } else {
                query = query + " AND TEMPO_EXECUCAO='" + boxTempoExecucao.getValue() + "'";
            }
        }
        
        if (boxAlcance.getValue() != null){
            if (boxAlcance.getValue().toString().equals("Metros")){
                query = query + " AND ALCANCE LIKE '%m'";
            } else {
                query = query + " AND ALCANCE='" + boxAlcance.getValue() +"'";
            }
        }
        
        if (boxArea.getValue() != null){
            String efeito = boxArea.getValue().toString();
            if (efeito.equals("Possui")){
                query = query + " AND AREA NOT LIKE '%null%'";
            } else {
                query = query + " AND AREA LIKE '%null%'";
            }
        }
        
        if (boxEfeito.getValue() != null){
            String efeito = boxEfeito.getValue().toString();
            if (efeito.equals("Possui")){
                query = query + " AND EFEITO NOT LIKE '%null%'";
            } else {
                query = query + " AND EFEITO LIKE '%null%'";
            }
        }
        
        if (boxAlvo.getValue() != null){
            String alvo = boxAlvo.getValue().toString();
            if (alvo.equals("Jogador"))
                query = query + " AND ALVO='Você'";
            if (alvo.equals("Criatura"))
                query = query + " AND ALVO LIKE '%criatura%'";
            if (alvo.equals("Objeto"))
                query = query + " AND (ALVO NOT LIKE '%criatura%' AND ALVO NOT LIKE '%Você%' AND ALVO NOT LIKE '%null%')";
        }
        
        if (boxDuracao.getValue() != null){
            String duracao = boxDuracao.getValue().toString();
            if (duracao.equals("Tempo")){
                query = query + " AND (DURACAO LIKE '%minuto%' OR DURACAO LIKE '%hora%' OR DURACAO LIKE '%dia%' OR DURACAO LIKE '%semana%')";
            } else if (duracao.equals("Rodada")){
                query = query + " AND DURACAO LIKE '%rodada%'";
            } else {
                query = query + "AND DURACAO LIKE '%" + duracao + "%'";
            }
        }
        
        if (boxTesteResistencia.getValue() != null){
            query = query + "AND TESTE_RESISTENCIA LIKE '%" + boxTesteResistencia.getValue() + "%'";
        }
        
        if (boxFonte.getValue() != null){
            query = query + "AND FONTE LIKE '%" + boxFonte.getValue() + "%'";
        }
        
        listarMagias(queryConsulta(query));
        
    }
    
    public void listarMagias(ArrayList<String> nomeMagias){
        lista.getItems().clear();
        
        lista.getItems().addAll(nomeMagias);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Inicializar lista com todas as magias
        String query = "SELECT NOME FROM MAGIAS";
        ArrayList<String> nomeMagias = queryConsulta(query);
        listarMagias(nomeMagias);
        
        //Popular opções nas caixas de seleção de busca e definir valor padrão como nulo
        boxDominio.getItems().addAll(null, "Arcana", "Divina");
        boxDescritor.getItems().addAll(null, "Abjuração", "Adivinhação", "Água", "Ar", "Bem", "Caos", "Cura", "Eletricidade", "Encantamento", "Escuridão", "Essência", "Fogo", "Frio", "Ilusão", "Invocação", "Luz", "Mal", "Medo", "Necromancia", "Ordem", "Tempo", "Terra", "Transmutação", "Sônico");
        boxNivel.getItems().addAll(null, "Nivel 0", "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5", "Nivel 6", "Nivel 7", "Nivel 8", "Nivel 9", "Nivel 10");
        boxTempoExecucao.getItems().addAll(null, "Ação padrão", "Ação completa", "Tempo");
        boxAlcance.getItems().addAll(null, "Toque", "Pessoal", "Metros", "Ilimitado");
        boxArea.getItems().addAll(null, "Possui", "Não possui");
        boxEfeito.getItems().addAll(null, "Possui", "Não possui");
        boxAlvo.getItems().addAll(null, "Criatura", "Objeto", "Jogador");
        boxDuracao.getItems().addAll(null, "Concentração", "Instantânea", "Permanente", "Tempo", "Rodada");
        boxTesteResistencia.getItems().addAll(null, "Fortitude anula", "Fortitude parcial", "Fortitude reduz à metade", "Vontade anula", "Vontade parcial", "Vontade reduz à metade", "Nenhum");
        boxFonte.getItems().addAll(null, "Módulo básico");
    }
}
