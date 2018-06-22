package GUI.criarFicha;

import static database.DB_Magias.consultarMagiaNome;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaCriarFichaController implements Initializable {
        
    @FXML
    private Label textoDado, textoRolagens;
    
    @FXML
    private Button btnClasses, btnRacas, btnDado, btnNext;
    
    @FXML
    private TextField campoNome, campoForca, campoDestreza, campoConstituicao, campoInteligencia, campoSabedoria, campoCarisma;
    
    @FXML
    public void escolherClasse() throws Exception{
        Scene scene = btnClasses.getScene();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaClasse.fxml"));
        
        scene.setRoot(loader.load());
    }
    
    @FXML
    public void escolherRaca() throws Exception{
        Scene scene = btnRacas.getScene();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaRacas.fxml"));
        
        scene.setRoot(loader.load());
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
