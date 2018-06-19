package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static programa.Inicializacao.inicializacao;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        inicializacao();
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
