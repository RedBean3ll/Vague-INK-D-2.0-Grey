package com.softe.ris_team;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage core) {
        new Login();
    }

    public static void main(String[] args)  {
        launch();
    }

}