package GUI.criarFicha.selecaoRaca;

import GUI.criarFicha.TelaCriarFichaController;
import static database.Database.executarQuery;
import static database.Database.executarUpdate;
import static database.Database.queryConsulta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import parser.Raca;
import static database.TABLE_Racas.consultar;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TelaRacasController implements Initializable {

    @FXML
    private Label nome, resumo;
    
    @FXML
    private ListView<String> lista;
    
    @FXML
    private Button btnPersonalidade, btnAventuras, btnNomes, btnAparencia, btnRelacoes, btnReligiao, btnTendencia, btnTerra, btnIdiomas, btnSelecionar, btnHabRacial, btnRetornar;
    
    @FXML
    private TextArea textArea;
    
    private Raca raca;
    
    private int ficha_id;
    public void setFicha_id(int ficha_id) {
        this.ficha_id = ficha_id;
    }

    @FXML
    private void onMouseClick(){
        textArea.clear();
        String itemSelecionado = lista.getSelectionModel().getSelectedItem();
        raca = consultar("*", "NOME='" + itemSelecionado + "'");
        
        nome.setText(raca.getNome());
        resumo.setText(raca.getResumo());
    }
    
    @FXML
    private void selecionarRaca() throws Exception{
        ResultSet result;
        String sql = "SELECT * FROM RACAS WHERE NOME='" + raca.getNome() + "'";
        result = executarQuery(sql);
        String sqlUpdateRaca = "UPDATE FICHAS SET ID_RACA=" + result.getInt("ID") + " WHERE ID=" + ficha_id;
        String sqlUpdateForca = "UPDATE FICHAS SET MOD_FORCA=" + result.getInt("AJ_FORCA") + " WHERE ID=" + ficha_id;
        String sqlUpdateDestreza = "UPDATE FICHAS SET MOD_DESTREZA=" + result.getInt("AJ_DESTREZA") + " WHERE ID=" + ficha_id;
        String sqlUpdateConstituticao = "UPDATE FICHAS SET MOD_CONSTITUICAO=" + result.getInt("AJ_CONSTITUICAO") + " WHERE ID=" + ficha_id;
        String sqlUpdateInteligencia = "UPDATE FICHAS SET MOD_INTELIGENCIA=" + result.getInt("AJ_INTELIGENCIA") + " WHERE ID=" + ficha_id;
        String sqlUpdateSabedoria = "UPDATE FICHAS SET MOD_SABEDORIA=" + result.getInt("AJ_SABEDORIA") + " WHERE ID=" + ficha_id;
        String sqlUpdateCarisma = "UPDATE FICHAS SET MOD_CARISMA=" + result.getInt("AJ_CARISMA") + " WHERE ID =" + ficha_id;
        
        result.getStatement().close();
        result.getStatement().getConnection().close();
               
        executarUpdate(sqlUpdateRaca);
        executarUpdate(sqlUpdateForca);
        executarUpdate(sqlUpdateDestreza);
        executarUpdate(sqlUpdateConstituticao);
        executarUpdate(sqlUpdateInteligencia);
        executarUpdate(sqlUpdateSabedoria);
        executarUpdate(sqlUpdateCarisma);
        
        Stage stage = (Stage) btnSelecionar.getScene().getWindow();
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/GUI/criarFicha/TelaCriarFicha.fxml"));
        Parent root = fxmlloader.load();
        
        TelaCriarFichaController controller = fxmlloader.getController();
        controller.setFicha_id(ficha_id);
        controller.preencherCampos();
        
        Scene novaScene = new Scene(root, 1000, 690);
        stage.setScene(novaScene);
    }
    
    @FXML
    private void exibirHabilidadeRacial() {
        textArea.clear();
        String query = "SELECT TRACO FROM TRACOS_RACIAIS WHERE RACA='" + raca.getNome() + "'";
        ArrayList<String> tracosRaciais = queryConsulta(query);
        for (String traco : tracosRaciais){
            textArea.appendText(traco);
            textArea.appendText("\n\n");
        }
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
    
    @FXML
    private void retornar() throws Exception{
        Stage stage = (Stage) btnRetornar.getScene().getWindow();
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/GUI/criarFicha/TelaCriarFicha.fxml"));
        Parent root = fxmlloader.load();
        
        TelaCriarFichaController controller = fxmlloader.getController();
        controller.setFicha_id(ficha_id);
        controller.preencherCampos();
        
        Scene novaScene = new Scene(root, 1000, 690);
        stage.setScene(novaScene);
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
        listarRacas(racas);
        
    }    
    
}
