/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Matthew C, Cesar Cruz, Kevin Martinez, Brandon Williams, Peter Tran
 */
public class Desk extends Stage {
    
    Desk(int identifier) {
        
        this.setTitle("R. I. S. - " + SystemInfo.programVersion());
        this.setMaximized(true);
        
        setSceneSize(this.getHeight(), this.getWidth()); //Set base switch size
        
        try {
            FileInputStream fileIStream = new FileInputStream("../RIS_Team2/src/main/java/com/softe/resources/profile.png");
            Image image = new Image(fileIStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(18);
            
            setImageView(imageView);   
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        
        homepage();  
    }
    
    private void homepage() {

        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        
        Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        
        appointmentScene.setOnAction((ActionEvent r) -> {
            setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
            appointments();
        });
        
        Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        
        orderScene.setOnAction((ActionEvent r) -> {
            setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
            orders();
        });
        
        //Left toolbar
        sceneBar.getItems().addAll(homeScene, appointmentScene, orderScene);
        sceneBar.setId("menuBar");
        
        //Right toolbar contents
        Label user = new Label("Logged in:");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBar");
        
        Separator separatorBar = new Separator();
        separatorBar.setOrientation(Orientation.VERTICAL);
        
        Button logoutMain = new Button("Logout");
        logoutMain.setId("buttonBar");
        logoutMain.setOnAction(event -> returnButton()); //BUTTON ACTION
        
        //RIGHT TOOLBAR
        ToolBar stageBar = new ToolBar();
        stageBar.getItems().addAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Checked-In Appointments");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.getChildren().addAll(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 3, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().addAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Today's Appointments");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderTwo, new Insets(0, 50, 0, 0));
        
        HBox setTwoHeadA = new HBox();
        setTwoHeadA.getChildren().addAll(HeaderTwo);
        setTwoHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBar");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 3, 0, 0));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        //searchTwo.setPromptText("");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().addAll(searchLabelTwo, searchTwo);
        HBox.setMargin(searchTwo, new Insets(0, 65, 0, 0));
        setTwoHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentTwoOrg = new HBox(); //Holds organizer buttons
        VBox contentTwoArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg, contentTwoArea);
        /**************************************************/
        
        //HEAD OF SET THREE
        Label HeaderThree = new Label("Unschedualed Orders");
        HeaderThree.setId("searchHeader");
        HeaderThree.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderThree, new Insets(0, 50, 0, 0));
        
        HBox setThreeHeadA = new HBox();
        setThreeHeadA.getChildren().addAll(HeaderThree);
        setThreeHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelThree = new Label("Search:");
        searchLabelThree.setId("searchBar");
        searchLabelThree.setMinHeight(30);
        searchLabelThree.setMinWidth(50);
        HBox.setMargin(searchLabelThree, new Insets(0, 3, 0, 0));
        searchLabelThree.setAlignment(Pos.CENTER);
        
        TextField searchThree = new TextField();
        //searchThree.setPromptText("");
        searchThree.setMinHeight(25);
        searchThree.setMinWidth(184);
        
        HBox setThreeHeadB = new HBox();
        setThreeHeadB.getChildren().addAll(searchLabelThree, searchThree);
        HBox.setMargin(searchThree, new Insets(0, 65, 0, 0));
        setThreeHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentThreeOrg = new HBox(); //Holds organizer buttons
        VBox contentThreeArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setThreeBody = new VBox(setThreeHeadA, setThreeHeadB, contentThreeOrg, contentThreeArea);
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody, setTwoBody, setThreeBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setFitToWidth(true);
        
        Scene home = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        home.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cDesk.css");
        
        super.setScene(home);
        this.show();
        
    }
    
    private void appointments() {
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        
        homeScene.setOnAction((ActionEvent r) -> {
            setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
            homepage();
        });
        
        Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        
        Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        
        orderScene.setOnAction((ActionEvent r) -> {
            setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
            orders();
        });
        
        //Left toolbar
        sceneBar.getItems().addAll(homeScene, appointmentScene, orderScene);
        sceneBar.setId("menuBar");
        
        //Right toolbar contents
        Label user = new Label("Logged in:");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBar");
        
        Separator separatorBar = new Separator();
        separatorBar.setOrientation(Orientation.VERTICAL);
        
        Button logoutMain = new Button("Logout");
        logoutMain.setId("buttonBar");
        logoutMain.setOnAction(event -> returnButton()); //BUTTON ACTION
        
        //RIGHT TOOLBAR
        ToolBar stageBar = new ToolBar();
        stageBar.getItems().addAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Appointments");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.getChildren().addAll(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 3, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().addAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setFitToWidth(true);
        
        Scene appo = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        appo.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cDesk.css");
        
        super.setScene(appo);
    }
    
    private void orders() {
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        
        homeScene.setOnAction((ActionEvent r) -> {
            setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
            homepage();
        });
        
        Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        
        appointmentScene.setOnAction((ActionEvent r) -> {
            setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
            appointments();
        });
        
        Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        
        //Left toolbar
        sceneBar.getItems().addAll(homeScene, appointmentScene, orderScene);
        sceneBar.setId("menuBar");
        
        //Right toolbar contents
        Label user = new Label("Logged in:");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBar");
        
        Separator separatorBar = new Separator();
        separatorBar.setOrientation(Orientation.VERTICAL);
        
        Button logoutMain = new Button("Logout");
        logoutMain.setId("buttonBar");
        logoutMain.setOnAction(event -> returnButton()); //BUTTON ACTION
        
        //RIGHT TOOLBAR
        ToolBar stageBar = new ToolBar();
        stageBar.getItems().addAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Orders");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.getChildren().addAll(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 3, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().addAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setFitToWidth(true);
        
        Scene ord = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        ord.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cDesk.css");
        
        super.setScene(ord);
    }
    
    private void returnButton() {
        this.close();
        new Login();
    }
    
    //Conserve scene size
    private double currSceneHeight;
    private double currSceneWidth;
    
    private void setSceneSize(double dub1, double dub2) {
        currSceneHeight = dub1;
        currSceneWidth = dub2;
    }
    
    protected double getSceneHeight() {
        return currSceneHeight;
    }
    private double getSceneWidth() {
        return currSceneWidth;
    }
    
    //Image info
    private ImageView imageView = new ImageView();
    
    private void setImageView(ImageView setIA) {
        imageView = setIA;
    }
    
    private ImageView getImageView() {
        return imageView;
    }
}
