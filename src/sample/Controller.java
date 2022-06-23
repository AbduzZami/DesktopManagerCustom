package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField pathtextfield;

    @FXML
    void organizeDesktop(ActionEvent event) throws IOException {
        FileHandlerCustom.rearrangedesktop();
    }

    @FXML
    void organizeCustom(ActionEvent event) throws IOException {
        FileHandlerCustom.rearrange(pathtextfield.getText());
        System.out.println(pathtextfield.getText());
    }


}
