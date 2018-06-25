package GUI.criarFicha;

import GUI.criarFicha.selecaoRaca.TelaRacasController;
import static database.Database.connect;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import parser.Ficha;

public class TelaCriarFichaController implements Initializable {
        
    @FXML
    private Label textoDado, textoRolagens, raca, classe, modForca, modDestreza, modConstituicao, modInteligencia, modSabedoria, modCarisma;
    
    @FXML
    private Button btnClasses, btnRacas, btnDado, btnNext;
    
    @FXML
    private TextField campoNome, campoForca, campoDestreza, campoConstituicao, campoInteligencia, campoSabedoria, campoCarisma;
    
    private int ficha_id;
    public void setFicha_id(int ficha_id) {
        this.ficha_id = ficha_id;
    }
    
    private Ficha ficha;
    
    @FXML
    public void escolherClasse() throws Exception{
        Stage stage = (Stage) btnClasses.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/criarFicha/selecaoClasse/TelaClasses.fxml"));
        
        Scene telaEscolherClasse = new Scene(loader.load(), 1000, 690);
        stage.setScene(telaEscolherClasse);
    }
    
    @FXML
    public void escolherRaca() throws Exception{
        Stage stage = (Stage) btnRacas.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/criarFicha/selecaoRaca/TelaRacas.fxml"));
        Parent root = loader.load();
        TelaRacasController controller = loader.getController();
        controller.setFicha_id(ficha_id);
        
        Scene telaEscolherRaca = new Scene(root, 1000, 690);
        stage.setScene(telaEscolherRaca);
    }
    
    @FXML
    public void rolarDado() throws Exception{
        Random random = new Random();
        ArrayList<Integer> rolagens = new ArrayList<>();
        int resultado = 0;
        
        for (int i = 0; i < 4; i++){ rolagens.add(random.nextInt(6) + 1); }
        
        int menor = Collections.min(rolagens);
        for (int x : rolagens){ resultado += x; }
        resultado -= menor;
        
        textoDado.setText("Resultado: " + Integer.toString(resultado));
        textoRolagens.setText("Rolagens: " + rolagens);
    }
    
    @FXML
    public void prosseguir() throws Exception{
        
        /*Scene scene = btnNext.getScene();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaNext.fxml"));
        
        scene.setRoot(loader.load());    */
    }
    
    public void preencherCampos(){
        Connection c = connect();
        String sql = "SELECT * FROM FICHAS WHERE ID=" + ficha_id;
        
        try{
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            ficha = new Ficha(result);
            campoForca.setText(Integer.toString(ficha.getForca()));
            campoDestreza.setText(Integer.toString(ficha.getDestreza()));
            campoConstituicao.setText(Integer.toString(ficha.getConstituicao()));
            campoInteligencia.setText(Integer.toString(ficha.getInteligencia()));
            campoSabedoria.setText(Integer.toString(ficha.getSabedoria()));
            campoCarisma.setText(Integer.toString(ficha.getCarisma()));
            
            raca.setText(Integer.toString(ficha.getId_raca()));
            classe.setText(Integer.toString(ficha.getId_classe()));
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*try {
            preencherCampos();
        } catch(Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }*/
            
    }    
}
