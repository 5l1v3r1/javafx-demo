package org.chabug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.chabug.util.ClassUtil;

public class Main extends Application {

    Pane root;
    FXMLLoader loader;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("常见漏洞利用工具  By:Y4er@ChaBug");
        loader.setLocation(Main.class.getResource("view/main.fxml"));
        root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        // 漏洞类型
        ChoiceBox vulType = (ChoiceBox) root.lookup("#vulType");
        ChoiceBox vulId = (ChoiceBox) root.lookup("#vulId");
        vulType.setItems(ClassUtil.getVulnType());
        vulType.getSelectionModel().selectFirst();


    }

    @Override
    public void init() throws Exception {
        loader = new FXMLLoader();
//        ChoiceBox vulId = (ChoiceBox) root.lookup("#vulId");
//        vulId.setItems((ObservableList) ClassUtil.getVulnID(""));

    }
}
