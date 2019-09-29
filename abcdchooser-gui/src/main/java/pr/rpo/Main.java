package pr.rpo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.util.*;


public class Main extends Application {

    Map<Integer, String> data = new LinkedHashMap<>();
    Integer no = Integer.parseInt("1");

    @Override
    public void start(Stage primaryStage) {


        try {
            primaryStage.setTitle("选择题工具");

            VBox root = new VBox();

            Text text = new Text(100, 100, "请输入题号");
            TextField inputField = new TextField(String.valueOf(no));

            Button buttonA = new Button("A");
            buttonA.setPrefSize(80,80);
            Button buttonB = new Button("B");
            buttonB.setPrefSize(80,80);
            Button buttonC = new Button("C");
            buttonC.setPrefSize(80,80);
            Button buttonD = new Button("D");
            buttonD.setPrefSize(80,80);

            Button buttonCan = new Button("clear");

            TextArea chooseLog = new TextArea();

            inputField.textProperty().addListener(e -> {
                String t = inputField.getText();
                if(t.isBlank()) {
                }else {
                    no = Integer.parseInt(inputField.getText());
                }
            });

            buttonA.setOnAction(e -> {
                Button b = (Button) e.getSource();
                no = Integer.parseInt(inputField.getText());
                data.put(Integer.parseInt(inputField.getText()), b.getText());
                inputField.setText(String.valueOf(no+1));
                chooseLog.setText(map2CSV(data));
            });

            buttonB.setOnAction(e -> {
                Button b = (Button) e.getSource();
                no = Integer.parseInt(inputField.getText());
                data.put(Integer.parseInt(inputField.getText()), b.getText());
                inputField.setText(String.valueOf(no+1));
                chooseLog.setText(map2CSV(data));
            });

            buttonC.setOnAction(e -> {
                Button b = (Button) e.getSource();
                no = Integer.parseInt(inputField.getText());
                data.put(Integer.parseInt(inputField.getText()), b.getText());
                inputField.setText(String.valueOf(no+1));
                chooseLog.setText(map2CSV(data));
            });

            buttonD.setOnAction(e -> {
                Button b = (Button) e.getSource();
                no = Integer.parseInt(inputField.getText());
                data.put(Integer.parseInt(inputField.getText()), b.getText());
                inputField.setText(String.valueOf(no+1));
                chooseLog.setText(map2CSV(data));
            });

            buttonCan.setOnAction(e -> {
                data.clear();
                no = Integer.parseInt("1");
                chooseLog.clear();
            });

            Button button = new Button();
            button.setText("确认");
            button.setOnAction(e -> {
                try {
                    FileWriter fw = new FileWriter("output.csv", false);
                    fw.write(chooseLog.getText());
                    fw.flush();
                    fw.close();
                    chooseLog.setText("output");
                }catch (Exception err) {
                    err.printStackTrace();
                }
            });


            root.getChildren().add(text);
            root.getChildren().add(inputField);

            HBox hBox = new HBox();

            hBox.getChildren().add(buttonA);
            hBox.getChildren().add(buttonB);
            hBox.getChildren().add(buttonC);
            hBox.getChildren().add(buttonD);
            root.getChildren().add(hBox);

            root.getChildren().add(button);
            root.getChildren().add(buttonCan);
            root.getChildren().add(chooseLog);

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private String map2CSV(Map m) {
        Set<Integer> l = new TreeSet<>();
        l = m.keySet();
        StringBuilder sb = new StringBuilder();
        for(Integer i : l) {
            sb.append(i);
            sb.append(",");
            sb.append(m.get(i));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
