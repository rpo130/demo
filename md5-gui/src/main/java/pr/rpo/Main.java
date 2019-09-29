package pr.rpo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("MD5工具");

            VBox root = new VBox();

            Text text = new Text(100, 100, "请输入文件名");
            Text md5Text = new Text(100,300,"");
            Button button = new Button();
            button.setText("确认");
            button.setOnAction(e -> {
                System.out.println("click button");

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("文件选择");
                File file = fileChooser.showOpenDialog(primaryStage);
                text.setText(file.toString());
                try {
                    md5Text.setText(MD5Helper.getMD5CheckSum(file));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });


            root.getChildren().add(text);
            root.getChildren().add(md5Text);
            root.getChildren().add(button);

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
