/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author david_5i3asud
 */
public class ProjektAI2 extends Application {
    public static int[] vyhry=new int[4];
    public static int[] vyhryPoradi=new int[5];
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Prvni.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println("typ hracu");
        for(int i=0;i<vyhry.length;i++){
            System.out.print(vyhry[i]+" ");
        }
        System.out.println("poradi");
        for(int i=0;i<vyhryPoradi.length;i++){
            System.out.print(vyhryPoradi[i]+" ");
        }
    }
    
}
