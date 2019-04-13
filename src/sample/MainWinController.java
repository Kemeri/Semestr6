package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWinController {
    String msg = "Редактируется поле: ";
    @FXML TextField item1;
    @FXML TextField item2;
    @FXML TextField itogo;
    @FXML TextField sredn;
    @FXML Label rdp;
    @FXML
    private void handleReset(){
        item1.setText("0");
        item2.setText("0");
        itogo.setText("0");
        sredn.setText("0");
        rdp.setText(msg);
    }

    public void itogoUpdate(){
        Float sum = new Float(0);
        try{    // если поле пустое или пользователь вводит нечисловое значение
            sum += Float.parseFloat(item1.getText());
        } catch (NumberFormatException e){
            sum += 0;   // пустое поле и любое нечисловое значение приводится к нулю
        }
        try {
            sum += Float.parseFloat(item2.getText());
        } catch (NumberFormatException e){
            sum += 0;
        }
        itogo.setText(sum.toString());
        sredn.setText(new Float(sum/2).toString());
    }

    public void labelUpdate(String pole){
        rdp.setText(msg+pole);
    }

    public void init(){
        item1.setOnMouseClicked(event -> labelUpdate("Товар1"));
        item2.setOnMouseClicked(event -> labelUpdate("Товар2"));
        sredn.setOnMouseClicked(event -> labelUpdate("Среднее"));
        itogo.setOnMouseClicked(event -> labelUpdate("Всего"));
    }
}
