package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
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
        FileHandlerCustom.reArrangeOthers(pathtextfield.getText());
        System.out.println(pathtextfield.getText());
    }

    @FXML
    void browse(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        String path = directoryChooser.showDialog(null).getPath();
        pathtextfield.setText(path);
//        System.out.println(path);
    }


}
