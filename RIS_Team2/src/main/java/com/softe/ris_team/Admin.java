package com.softe.ris_team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matthew Clark, Cesar Cruz, Kevin Martinez, Brandon Williams, Peter Tran
 */
public class Admin extends Stage {
    
    /*** Constructor Instance Variables ***/
    private int currentId;
    private ImageView imageViewA;
    
    Admin(int currentIdentifier) {
        
        this.setTitle("R. I. S. - " + SystemInfo.programVersion());
        this.setMaximized(true);
        
        setSceneSize(this.getHeight(), this.getWidth()); //Set base switch size
        
        try {
            FileInputStream fileIStream = new FileInputStream("../RIS_Team2/src/main/java/com/softe/resources/profile.png");
            Image image = new Image(fileIStream);
            imageViewA = new ImageView(image);
            imageViewA.setFitHeight(20);
            imageViewA.setFitWidth(18);
            imageViewA.setCache(true);
            
            setImageView(imageViewA);   
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        
        currentId = currentIdentifier;
        
        homepageSceneCollection();  
    }
    
    /*** Page Instance Variables ***/
    private Button homeScene = new Button("Home");
    private Button adminScene = new Button("Admin");
    private Button referralScene = new Button("Referrals");
    private Button appointmentScene = new Button("Appointments");
    private Button orderScene = new Button("Orders");
    private Button invoiceScene = new Button("Invoices");
    
    private TableView placedOrdersTable = new TableView();
    
    private TableView systemUsersTable;
    
    
    private void homepageSceneCollection() {

    //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        //homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        //Button adminScene = new Button("Admin");
        adminScene.setId("buttonBar");
        adminScene.setMinHeight(25);
        adminScene.setMinWidth(90);
        //Button referralScene = new Button("Referrals");
        referralScene.setId("buttonBar");
        referralScene.setMinHeight(25);
        referralScene.setMinWidth(90);
        //Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        //Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        //Button invoiceScene = new Button("Invoices");
        invoiceScene.setId("buttonBar");
        invoiceScene.setMinHeight(25);
        invoiceScene.setMinWidth(90);
        
        /*** BUTTON CONTROLLERS ***/
        //homeScene --------------------------------------------------
        adminScene.setOnAction((ActionEvent a) -> {
            adminSceneAction(a); });
        referralScene.setOnAction((ActionEvent a) -> {
            referralSceneAction(a); });
        appointmentScene.setOnAction((ActionEvent a) -> {
            appointmentSceneAction(a); });
        orderScene.setOnAction((ActionEvent a) -> {
            orderSceneAction(a); });
        invoiceScene.setOnAction((ActionEvent a) -> {
            invoiceSceneAction(a); });
        
        //Left toolbar
        sceneBar.getItems().setAll(homeScene, adminScene, referralScene, appointmentScene, orderScene, invoiceScene);
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
        stageBar.getItems().setAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Placed Orders");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.setId("barHeader");
        setOneHeadA.getChildren().add(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        /*** BUTTONS ***/
        Button newObjectOne = new Button("New");
        newObjectOne.setId("buttonSearch");
        HBox.setMargin(newObjectOne, new Insets(0, 0, 0, 30));
        
        Button removeSelectedOne = new Button("Remove Selected");
        removeSelectedOne.setId("buttonSearch");
        HBox.setMargin(removeSelectedOne, new Insets(0, 0, 0, 5));
        
        Button modifySelectedOne = new Button("Modify Selected");
        modifySelectedOne.setId("buttonSearch");
        HBox.setMargin(modifySelectedOne, new Insets(0, 0, 0, 5));
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER_LEFT);
        
        TextField searchOne = new TextField();
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));

        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(newObjectOne, removeSelectedOne, modifySelectedOne, searchLabelOne, searchOne);
        setOneHeadB.setId("blockA");
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(setOneHeadB, new Insets(0, 65, 0, 0));
        
        /*** TABLE ONE ***/
        TableColumn firstNameOne = new TableColumn("First Name");
        firstNameOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.1)); //Multiply must combine to _
        firstNameOne.setReorderable(false);
        
        TableColumn lastNameOne = new TableColumn("Last Name");
        lastNameOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.1));
        lastNameOne.setReorderable(false);
        
        TableColumn modalityOne = new TableColumn("Modality");
        modalityOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.2));
        modalityOne.setReorderable(false);
        
        TableColumn notesOne = new TableColumn("Notes");
        notesOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.4));
        notesOne.setReorderable(false);
        
        TableColumn statusOne = new TableColumn("Status");
        statusOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.1967));
        statusOne.setReorderable(false);
        
        placedOrdersTable.getColumns().setAll(firstNameOne, lastNameOne, modalityOne, notesOne, statusOne);
        placedOrdersTable.setId("blockA");
        
        //final ObservableList<placeholder> tableDataOrderOne = FXCollections.observableArrayList();
             
        //column_name.setCellValueFactory(
        //new PropertyValueFactory<class,String>("ID")
        //);
        
        //tableViewOne.setItems(tableDataOrderOne);

        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(placedOrdersTable); //Holds table
        contentOneOrg.setId("barBody");
        contentOneOrg.setFitToWidth(true);
        
        placedOrdersTable.setId("table");
        placedOrdersTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(20, 25, 0, 25)); 
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Checked-In Appointments");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderTwo, new Insets(0, 50, 0, 0));
        
        HBox setTwoHeadA = new HBox();
        setTwoHeadA.setId("barHeader");
        setTwoHeadA.getChildren().add(HeaderTwo);
        setTwoHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBar");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 8, 0, 0));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        //searchTwo.setPromptText("");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        HBox.setMargin(searchTwo, new Insets(0, 65, 0, 0));
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().setAll(searchLabelTwo, searchTwo);
        setTwoHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET TWO HUB
        HBox contentTwoOrg = new HBox(); //Holds organizer buttons
        VBox contentTwoArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg, contentTwoArea);
        VBox.setMargin(setTwoBody, new Insets(20, 25, 0, 25));
        
        /**************************************************/
        
        //HEAD OF SET THREE
        Label HeaderThree = new Label("Today's Appointments");
        HeaderThree.setId("searchHeader");
        HeaderThree.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderThree, new Insets(0, 50, 0, 0));
        
        HBox setThreeHeadA = new HBox();
        setThreeHeadA.setId("barHeader");
        setThreeHeadA.getChildren().add(HeaderThree);
        setThreeHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelThree = new Label("Search:");
        searchLabelThree.setId("searchBar");
        searchLabelThree.setMinHeight(30);
        searchLabelThree.setMinWidth(50);
        HBox.setMargin(searchLabelThree, new Insets(0, 8, 0, 0));
        searchLabelThree.setAlignment(Pos.CENTER);
        
        TextField searchThree = new TextField();
        //searchThree.setPromptText("");
        searchThree.setMinHeight(25);
        searchThree.setMinWidth(184);
        
        HBox setThreeHeadB = new HBox();
        setThreeHeadB.getChildren().setAll(searchLabelThree, searchThree);
        HBox.setMargin(searchThree, new Insets(0, 65, 0, 0));
        setThreeHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET THREE HUB
        HBox contentThreeOrg = new HBox(); //Holds organizer buttons
        VBox contentThreeArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setThreeBody = new VBox(setThreeHeadA, setThreeHeadB, contentThreeOrg, contentThreeArea);
        VBox.setMargin(setThreeBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET FOUR
        Label HeaderFour = new Label("Unschedualed Orders");
        HeaderFour.setId("searchHeader");
        HeaderFour.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFour, new Insets(0, 50, 0, 0));
        
        HBox setFourHeadA = new HBox();
        setFourHeadA.setId("barHeader");
        setFourHeadA.getChildren().add(HeaderFour);
        setFourHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelFour = new Label("Search:");
        searchLabelFour.setId("searchBar");
        searchLabelFour.setMinHeight(30);
        searchLabelFour.setMinWidth(50);
        HBox.setMargin(searchLabelFour, new Insets(0, 8, 0, 0));
        searchLabelFour.setAlignment(Pos.CENTER);
        
        TextField searchFour = new TextField();
        //searchFour.setPromptText("");
        searchFour.setMinHeight(25);
        searchFour.setMinWidth(184);
        
        HBox setFourHeadB = new HBox();
        setFourHeadB.getChildren().setAll(searchLabelFour, searchFour);
        HBox.setMargin(searchFour, new Insets(0, 65, 0, 0));
        setFourHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET FOUR HUB
        HBox contentFourOrg = new HBox(); //Holds organizer buttons
        VBox contentFourArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setFourBody = new VBox(setFourHeadA, setFourHeadB, contentFourOrg, contentFourArea);
        VBox.setMargin(setFourBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET FIVE
        Label HeaderFive = new Label("Checked-In Appointments");
        HeaderFive.setId("searchHeader");
        HeaderFive.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFive, new Insets(0, 50, 0, 0));
        
        HBox setFiveHeadA = new HBox();
        setFiveHeadA.setId("barHeader");
        setFiveHeadA.getChildren().add(HeaderFive);
        setFiveHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelFive = new Label("Search:");
        searchLabelFive.setId("searchBar");
        searchLabelFive.setMinHeight(30);
        searchLabelFive.setMinWidth(50);
        HBox.setMargin(searchLabelFive, new Insets(0, 8, 0, 0));
        searchLabelFive.setAlignment(Pos.CENTER);
        
        TextField searchFive = new TextField();
        //searchFive.setPromptText("");
        searchFive.setMinHeight(25);
        searchFive.setMinWidth(184);
        
        HBox setFiveHeadB = new HBox();
        setFiveHeadB.getChildren().setAll(searchLabelFive, searchFive);
        HBox.setMargin(searchFive, new Insets(0, 65, 0, 0));
        setFiveHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET FIVE HUB
        HBox contentFiveOrg = new HBox(); //Holds organizer buttons
        VBox contentFiveArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setFiveBody = new VBox(setFiveHeadA, setFiveHeadB, contentFiveOrg, contentFiveArea);
        VBox.setMargin(setFiveBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET SIX
        Label HeaderSix = new Label("To Be Reviewed Imaging Orders");
        HeaderSix.setId("searchHeader");
        HeaderSix.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSix, new Insets(0, 50, 0, 0));
        
        HBox setSixHeadA = new HBox();
        setSixHeadA.setId("barHeader");
        setSixHeadA.getChildren().add(HeaderSix);
        setSixHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelSix = new Label("Search:");
        searchLabelSix.setId("searchBar");
        searchLabelSix.setMinHeight(30);
        searchLabelSix.setMinWidth(50);
        HBox.setMargin(searchLabelSix, new Insets(0, 8, 0, 0));
        searchLabelSix.setAlignment(Pos.CENTER);
        
        TextField searchSix = new TextField();
        //searchSix.setPromptText("");
        searchSix.setMinHeight(25);
        searchSix.setMinWidth(184);
        
        HBox setSixHeadB = new HBox();
        setSixHeadB.getChildren().setAll(searchLabelSix, searchSix);
        HBox.setMargin(searchSix, new Insets(0, 65, 0, 0));
        setSixHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentSixOrg = new HBox(); //Holds organizer buttons
        VBox contentSixArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setSixBody = new VBox(setSixHeadA, setSixHeadB, contentSixOrg, contentSixArea);
        VBox.setMargin(setSixBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET SEVEN
        Label HeaderSeven = new Label("Patient Appointments");
        HeaderSeven.setId("searchHeader");
        HeaderSeven.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSeven, new Insets(0, 50, 0, 0));
        
        HBox setSevenHeadA = new HBox();
        setSevenHeadA.setId("barHeader");
        setSevenHeadA.getChildren().add(HeaderSeven);
        setSevenHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelSeven = new Label("Search:");
        searchLabelSeven.setId("searchBar");
        searchLabelSeven.setMinHeight(30);
        searchLabelSeven.setMinWidth(50);
        HBox.setMargin(searchLabelSeven, new Insets(0, 8, 0, 0));
        searchLabelSeven.setAlignment(Pos.CENTER);
        
        TextField searchSeven = new TextField();
        //searchSeven.setPromptText("");
        searchSeven.setMinHeight(25);
        searchSeven.setMinWidth(184);
        
        HBox setSevenHeadB = new HBox();
        setSevenHeadB.getChildren().setAll(searchLabelSeven, searchSeven);
        HBox.setMargin(searchSeven, new Insets(0, 65, 0, 0));
        setSevenHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentSevenOrg = new HBox(); //Holds organizer buttons
        VBox contentSevenArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setSevenBody = new VBox(setSevenHeadA, setSevenHeadB, contentSevenOrg, contentSevenArea);
        VBox.setMargin(setSevenBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody, setTwoBody, setThreeBody, setFourBody, setFiveBody, setSixBody, setSevenBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        Scene home = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        home.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        super.setScene(home);
        this.show();
       }
    
    private void adminSceneCollection() {
        VBox rootBox = new VBox();
        ScrollPane scrollPane = new ScrollPane(rootBox);
        
        Scene home = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        //homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        //Button adminScene = new Button("Admin");
        adminScene.setId("buttonBar");
        adminScene.setMinHeight(25);
        adminScene.setMinWidth(90);
        //Button referralScene = new Button("Referrals");
        referralScene.setId("buttonBar");
        referralScene.setMinHeight(25);
        referralScene.setMinWidth(90);
        //Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        //Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        //Button invoiceScene = new Button("Invoices");
        invoiceScene.setId("buttonBar");
        invoiceScene.setMinHeight(25);
        invoiceScene.setMinWidth(90);
        
        /*** BUTTON CONTROLLERS ***/
        homeScene.setOnAction((ActionEvent b) -> {
            //systemUsersTable.getItems().clear();
            //systemUsersTable.getColumns().clear();
            homepageSceneAction(b);
        });
        //adminScene()
        referralScene.setOnAction((ActionEvent b) -> {
            //systemUsersTable.getItems().clear();
            //systemUsersTable.getColumns().clear();
            referralSceneAction(b);
        });
        appointmentScene.setOnAction((ActionEvent b) -> {
            //systemUsersTable.getItems().clear();
            //systemUsersTable.getColumns().clear();
            appointmentSceneAction(b);
        });
        orderScene.setOnAction((ActionEvent b) -> {
            //systemUsersTable.getItems().clear();
            //systemUsersTable.getColumns().clear();
            orderSceneAction(b);
        });
        invoiceScene.setOnAction((ActionEvent b) -> {
            //systemUsersTable.getItems().clear();
            //systemUsersTable.getColumns().clear();
            invoiceSceneAction(b);
        });
        
        //Left toolbar
        sceneBar.getItems().setAll(homeScene, adminScene, referralScene, appointmentScene, orderScene, invoiceScene);
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
        stageBar.getItems().setAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("System Users");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.setId("barHeader");
        setOneHeadA.getChildren().add(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        /*** BUTTONS ***/
        Button newObjectOne = new Button("New");
        newObjectOne.setId("buttonSearch");
        HBox.setMargin(newObjectOne, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedOne = new Button("Remove Selected");
        removeSelectedOne.setId("buttonSearch");
        HBox.setMargin(removeSelectedOne, new Insets(0, 0, 0, 5));
        
        Button modifySelectedOne = new Button("Modify Selected");
        modifySelectedOne.setId("buttonSearch");
        HBox.setMargin(modifySelectedOne, new Insets(0, 0, 0, 5));
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER_LEFT);
        
        TextField searchOne = new TextField();
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));

        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(newObjectOne, removeSelectedOne, modifySelectedOne, searchLabelOne, searchOne);
        setOneHeadB.setId("blockA");
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(setOneHeadB, new Insets(0, 65, 0, 0));
        
        systemUsersTable = new TableView();
        
        TableColumn userIdOne = new TableColumn("ID");
        userIdOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.05));
        userIdOne.setReorderable(false);
        
        TableColumn usernameOne = new TableColumn("Username");
        usernameOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.1));
        usernameOne.setReorderable(false);
        
        TableColumn firstNameOne = new TableColumn("First Name");
        firstNameOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.1));
        firstNameOne.setReorderable(false);
        
        TableColumn middleNameOne = new TableColumn("Middle Name");
        middleNameOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.05));
        
        TableColumn lastNameOne = new TableColumn("Last Name");
        lastNameOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.2));
        lastNameOne.setReorderable(false);
        
        TableColumn emailOne = new TableColumn("email");
        emailOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.2));
        emailOne.setReorderable(false);
        
        TableColumn systemRoleOne = new TableColumn("Role");
        systemRoleOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.2));
        systemRoleOne.setReorderable(false);
        
        TableColumn activeOne = new TableColumn("Active");
        activeOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.0967));
        activeOne.setReorderable(false);
        
        /*** CLEAR TABLE OF PREVIOUS ITEMS ***/
        //systemUsersTable.getItems().clear();
        systemUsersTable.getColumns().setAll(userIdOne, usernameOne, firstNameOne, middleNameOne, lastNameOne, emailOne, systemRoleOne, activeOne);
        systemUsersTable.setId("blockA");
        
        
        ObservableList<SystemUserObject> tableDataSUOOne = FXCollections.observableArrayList();
        
        /*** ADD, REMOVE, MODIFY ACTIONS ***/
        userIdOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("ACCOUNT_IDENTIFIER")
        );
        
        usernameOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("ACCOUNT_USERNAME")
        );
        
        firstNameOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("USER_FIRST_NAME")
        );
        
        middleNameOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("USER_MIDDLE_NAME")
        );
        
        lastNameOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("USER_LAST_NAME")
        );
        
        emailOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("USER_EMAIL")
        );
        
        systemRoleOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("USER_ROLE")
        );
        
        activeOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("ACCOUNT_ACTIVE")
        );
        
        systemUsersTable.setItems(tableDataSUOOne);
        
        newObjectOne.setOnAction((ActionEvent a) -> {
            popAddUser(rootBox);
        });
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(systemUsersTable); //Holds table
        contentOneOrg.setFitToWidth(true);
        
        systemUsersTable.setId("table");
        systemUsersTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Modalities");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderTwo, new Insets(0, 50, 0, 0));
        
        HBox setTwoHeadA = new HBox();
        setTwoHeadA.setId("barHeader");
        setTwoHeadA.getChildren().add(HeaderTwo);
        setTwoHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBar");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 8, 0, 0));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        //searchTwo.setPromptText("");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().setAll(searchLabelTwo, searchTwo);
        HBox.setMargin(searchTwo, new Insets(0, 65, 0, 0));
        setTwoHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET TWO HUB
        HBox contentTwoOrg = new HBox(); //Holds organizer buttons
        VBox contentTwoArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg, contentTwoArea);
        VBox.setMargin(setTwoBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET THREE
        Label HeaderThree = new Label("Patient Alerts");
        HeaderThree.setId("searchHeader");
        HeaderThree.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderThree, new Insets(0, 50, 0, 0));
        
        HBox setThreeHeadA = new HBox();
        setThreeHeadA.setId("barHeader");
        setThreeHeadA.getChildren().add(HeaderThree);
        setThreeHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelThree = new Label("Search:");
        searchLabelThree.setId("searchBar");
        searchLabelThree.setMinHeight(30);
        searchLabelThree.setMinWidth(50);
        HBox.setMargin(searchLabelThree, new Insets(0, 8, 0, 0));
        searchLabelThree.setAlignment(Pos.CENTER);
        
        TextField searchThree = new TextField();
        //searchThree.setPromptText("");
        searchThree.setMinHeight(25);
        searchThree.setMinWidth(184);
        
        HBox setThreeHeadB = new HBox();
        setThreeHeadB.getChildren().setAll(searchLabelThree, searchThree);
        HBox.setMargin(searchThree, new Insets(0, 65, 0, 0));
        setThreeHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET THREE HUB
        HBox contentThreeOrg = new HBox(); //Holds organizer buttons
        VBox contentThreeArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setThreeBody = new VBox(setThreeHeadA, setThreeHeadB, contentThreeOrg, contentThreeArea);
        VBox.setMargin(setThreeBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET FOUR
        Label HeaderFour = new Label("Patients");
        HeaderFour.setId("searchHeader");
        HeaderFour.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFour, new Insets(0, 50, 0, 0));
        
        HBox setFourHeadA = new HBox();
        setFourHeadA.setId("barHeader");
        setFourHeadA.getChildren().add(HeaderFour);
        setFourHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelFour = new Label("Search:");
        searchLabelFour.setId("searchBar");
        searchLabelFour.setMinHeight(30);
        searchLabelFour.setMinWidth(50);
        HBox.setMargin(searchLabelFour, new Insets(0, 8, 0, 0));
        searchLabelFour.setAlignment(Pos.CENTER);
        
        TextField searchFour = new TextField();
        //searchFour.setPromptText("");
        searchFour.setMinHeight(25);
        searchFour.setMinWidth(184);
        HBox.setMargin(searchFour, new Insets(0, 65, 0, 0));
        
        HBox setFourHeadB = new HBox();
        setFourHeadB.getChildren().setAll(searchLabelFour, searchFour);
        setFourHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET FOUR HUB
        HBox contentFourOrg = new HBox(); //Holds organizer buttons
        VBox contentFourArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setFourBody = new VBox(setFourHeadA, setFourHeadB, contentFourOrg, contentFourArea);
        VBox.setMargin(setFourBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET FIVE
        Label HeaderFive = new Label("Orders");
        HeaderFive.setId("searchHeader");
        HeaderFive.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFive, new Insets(0, 50, 0, 0));
        
        HBox setFiveHeadA = new HBox();
        setFiveHeadA.setId("barHeader");
        setFiveHeadA.getChildren().add(HeaderFive);
        setFiveHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelFive = new Label("Search:");
        searchLabelFive.setId("searchBar");
        searchLabelFive.setMinHeight(30);
        searchLabelFive.setMinWidth(50);
        HBox.setMargin(searchLabelFive, new Insets(0, 8, 0, 0));
        searchLabelFive.setAlignment(Pos.CENTER);
        
        TextField searchFive = new TextField();
        //searchFive.setPromptText("");
        searchFive.setMinHeight(25);
        searchFive.setMinWidth(184);
        HBox.setMargin(searchFive, new Insets(0, 65, 0, 0));
        
        HBox setFiveHeadB = new HBox();
        setFiveHeadB.getChildren().setAll(searchLabelFive, searchFive);
        setFiveHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET FIVE HUB
        HBox contentFiveOrg = new HBox(); //Holds organizer buttons
        VBox contentFiveArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setFiveBody = new VBox(setFiveHeadA, setFiveHeadB, contentFiveOrg, contentFiveArea);
        VBox.setMargin(setFiveBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET SIX
        Label HeaderSix = new Label("Appointments");
        HeaderSix.setId("searchHeader");
        HeaderSix.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSix, new Insets(0, 50, 0, 0));
        
        HBox setSixHeadA = new HBox();
        setSixHeadA.setId("barHeader");
        setSixHeadA.getChildren().add(HeaderSix);
        setSixHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelSix = new Label("Search:");
        searchLabelSix.setId("searchBar");
        searchLabelSix.setMinHeight(30);
        searchLabelSix.setMinWidth(50);
        HBox.setMargin(searchLabelSix, new Insets(0, 8, 0, 0));
        searchLabelSix.setAlignment(Pos.CENTER);
        
        TextField searchSix = new TextField();
        //searchSix.setPromptText("");
        searchSix.setMinHeight(25);
        searchSix.setMinWidth(184);
        HBox.setMargin(searchSix, new Insets(0, 65, 0, 0));
        
        HBox setSixHeadB = new HBox();
        setSixHeadB.getChildren().setAll(searchLabelSix, searchSix);
        setSixHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentSixOrg = new HBox(); //Holds organizer buttons
        VBox contentSixArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setSixBody = new VBox(setSixHeadA, setSixHeadB, contentSixOrg, contentSixArea);
        VBox.setMargin(setSixBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET SEVEN
        Label HeaderSeven = new Label("File Uploads");
        HeaderSeven.setId("searchHeader");
        HeaderSeven.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSeven, new Insets(0, 50, 0, 0));
        
        HBox setSevenHeadA = new HBox();
        setSevenHeadA.setId("barHeader");
        setSevenHeadA.getChildren().add(HeaderSeven);
        setSevenHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelSeven = new Label("Search:");
        searchLabelSeven.setId("searchBar");
        searchLabelSeven.setMinHeight(30);
        searchLabelSeven.setMinWidth(50);
        HBox.setMargin(searchLabelSeven, new Insets(0, 8, 0, 0));
        searchLabelSeven.setAlignment(Pos.CENTER);
        
        TextField searchSeven = new TextField();
        //searchSeven.setPromptText("");
        searchSeven.setMinHeight(25);
        searchSeven.setMinWidth(184);
        
        HBox setSevenHeadB = new HBox();
        setSevenHeadB.getChildren().setAll(searchLabelSeven, searchSeven);
        HBox.setMargin(searchSeven, new Insets(0, 65, 0, 0));
        setSevenHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentSevenOrg = new HBox(); //Holds organizer buttons
        VBox contentSevenArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setSevenBody = new VBox(setSevenHeadA, setSevenHeadB, contentSevenOrg, contentSevenArea);
        VBox.setMargin(setSevenBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET EIGHT
        Label HeaderEight = new Label("Diagnostic Reports");
        HeaderEight.setId("searchHeader");
        HeaderEight.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderEight, new Insets(0, 50, 0, 0));
        
        HBox setEightHeadA = new HBox();
        setEightHeadA.setId("barHeader");
        setEightHeadA.getChildren().add(HeaderEight);
        setEightHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelEight = new Label("Search:");
        searchLabelEight.setId("searchBar");
        searchLabelEight.setMinHeight(30);
        searchLabelEight.setMinWidth(50);
        HBox.setMargin(searchLabelEight, new Insets(0, 8, 0, 0));
        searchLabelEight.setAlignment(Pos.CENTER);
        
        TextField searchEight = new TextField();
        //searchEight.setPromptText("");
        searchEight.setMinHeight(25);
        searchEight.setMinWidth(184);
        
        HBox setEightHeadB = new HBox();
        setEightHeadB.getChildren().setAll(searchLabelEight, searchEight);
        HBox.setMargin(searchEight, new Insets(0, 65, 0, 0));
        setEightHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET ONE HUB
        HBox contentEightOrg = new HBox(); //Holds organizer buttons
        VBox contentEightArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setEightBody = new VBox(setEightHeadA, setEightHeadB, contentEightOrg, contentEightArea);
        VBox.setMargin(setEightBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody, setTwoBody, setThreeBody, setFourBody, setFiveBody, setSixBody, setSevenBody, setEightBody); 
        
        //SCENE LAYOUT
        
        rootBox.getChildren().setAll(toolBarHub, verticalHub);
        
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        home.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        
        //POPUPS
        newObjectOne.setOnAction((ActionEvent e) -> {
            
            VBox addPopupOne = new VBox();
            addPopupOne.setStyle("-fx-background-color: red");
            
            
            Scene scenePopupOne = new Scene(addPopupOne, 300, 300);
            
            
            Stage stagePopupOne = new Stage();
            //stagePopupOne.initStyle(StageStyle.UNDECORATED);
            stagePopupOne.initOwner(this);
            stagePopupOne.initModality(Modality.WINDOW_MODAL);
            
            
            rootBox.disableProperty().bind(stagePopupOne.showingProperty());
            stagePopupOne.setScene(scenePopupOne);
            
            stagePopupOne.showAndWait();
            //stagePopupOne.show();
            
            
        });
        
        super.setScene(home);    
    }
    
    private void referralSceneCollection() {
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        //Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        
        //Button adminScene = new Button("Admin");
        adminScene.setId("buttonBar");
        adminScene.setMinHeight(25);
        adminScene.setMinWidth(90);
        
        //Button referralScene = new Button("Referrals");
        referralScene.setId("buttonBar");
        referralScene.setMinHeight(25);
        referralScene.setMinWidth(90);
        
        //Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        
        //Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        
        //Button invoiceScene = new Button("Invoices");
        invoiceScene.setId("buttonBar");
        invoiceScene.setMinHeight(25);
        invoiceScene.setMinWidth(90);
        
        /*** BUTTON CONTROLLERS ***/
        homeScene.setOnAction((ActionEvent r) -> { homepageSceneAction(r); });
        adminScene.setOnAction((ActionEvent r) -> { adminSceneAction(r); });
        //referralScene -----------------------------------------------------
        appointmentScene.setOnAction((ActionEvent r) -> { appointmentSceneAction(r); });
        orderScene.setOnAction((ActionEvent r) -> { orderSceneAction(r); });
        invoiceScene.setOnAction((ActionEvent r) -> { invoiceSceneAction(r); });
        
        //Left toolbar
        sceneBar.getItems().setAll(homeScene, adminScene, referralScene, appointmentScene, orderScene, invoiceScene);
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
        stageBar.getItems().setAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Patients");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.setId("barHeader");
        setOneHeadA.getChildren().add(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        VBox.setMargin(setOneBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        Scene referr = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        referr.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        super.setScene(referr);
    }
    
    //APPOINTMENT SCENE
    private void appointmentSceneCollection() {
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        //Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        //Button adminScene = new Button("Admin");
        adminScene.setId("buttonBar");
        adminScene.setMinHeight(25);
        adminScene.setMinWidth(90);
        //Button referralScene = new Button("Referrals");
        referralScene.setId("buttonBar");
        referralScene.setMinHeight(25);
        referralScene.setMinWidth(90);
        //Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        //Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        //Button invoiceScene = new Button("Invoices");
        invoiceScene.setId("buttonBar");
        invoiceScene.setMinHeight(25);
        invoiceScene.setMinWidth(90);
        
        /*** BUTTON CONTROLLERS ***/
        homeScene.setOnAction((ActionEvent r) -> {homepageSceneAction(r); });
        adminScene.setOnAction((ActionEvent r) -> {adminSceneAction(r);} );
        referralScene.setOnAction((ActionEvent r) -> {referralSceneAction(r);} );
        //appointmentScene ------------------------------------------------------
        orderScene.setOnAction((ActionEvent r) -> {orderSceneAction(r); });
        invoiceScene.setOnAction((ActionEvent r) -> {invoiceSceneAction(r); });
        
        //Left toolbar
        sceneBar.getItems().setAll(homeScene, adminScene, referralScene, appointmentScene, orderScene, invoiceScene);
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
        stageBar.getItems().setAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Appointments");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.setId("barHeader");
        setOneHeadA.getChildren().add(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        VBox.setMargin(setOneBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody);
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        Scene appt = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        appt.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        super.setScene(appt);
    }
    
    //ORDER SCENE
    private void orderSceneCollection() {
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        //Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        //Button adminScene = new Button("Admin");
        adminScene.setId("buttonBar");
        adminScene.setMinHeight(25);
        adminScene.setMinWidth(90);
        //Button referralScene = new Button("Referrals");
        referralScene.setId("buttonBar");
        referralScene.setMinHeight(25);
        referralScene.setMinWidth(90);
        //Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        //Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        //Button invoiceScene = new Button("Invoices");
        invoiceScene.setId("buttonBar");
        invoiceScene.setMinHeight(25);
        invoiceScene.setMinWidth(90);
        
        /*** BUTTON CONTROLLERS ***/
        homeScene.setOnAction((ActionEvent r) -> {homepageSceneAction(r); });
        adminScene.setOnAction((ActionEvent r) -> {adminSceneAction(r); });
        referralScene.setOnAction((ActionEvent r) -> {referralSceneAction(r); });
        appointmentScene.setOnAction((ActionEvent r) -> {appointmentSceneAction(r); });
        //orderScene -----------------------------------------------------------------
        invoiceScene.setOnAction((ActionEvent r) -> {invoiceSceneAction(r); });
        
        //Left toolbar
        sceneBar.getItems().setAll(homeScene, adminScene, referralScene, appointmentScene, orderScene, invoiceScene);
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
        stageBar.getItems().setAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Orders");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.setId("barHeader");
        setOneHeadA.getChildren().add(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        VBox.setMargin(setOneBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        Scene ordo = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        ordo.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        super.setScene(ordo);
    }
    
    //INVOICE SCENE
    private void invoiceSceneCollection() {
        //Toolbar
        ToolBar sceneBar = new ToolBar();
        
        HBox.setHgrow(sceneBar, Priority.ALWAYS);
        
        //Left toolbar contents
        //Button homeScene = new Button("Home");
        homeScene.setId("buttonBar");
        homeScene.setMinHeight(25);
        homeScene.setMinWidth(90);
        //Button adminScene = new Button("Admin");
        adminScene.setId("buttonBar");
        adminScene.setMinHeight(25);
        adminScene.setMinWidth(90);
        //Button referralScene = new Button("Referrals");
        referralScene.setId("buttonBar");
        referralScene.setMinHeight(25);
        referralScene.setMinWidth(90);
        //Button appointmentScene = new Button("Appointments");
        appointmentScene.setId("buttonBar");
        appointmentScene.setMinHeight(25);
        appointmentScene.setMinWidth(90);
        //Button orderScene = new Button("Orders");
        orderScene.setId("buttonBar");
        orderScene.setMinHeight(25);
        orderScene.setMinWidth(90);
        //Button invoiceScene = new Button("Invoices");
        invoiceScene.setId("buttonBar");
        invoiceScene.setMinHeight(25);
        invoiceScene.setMinWidth(90);
        
        /*** BUTTON CONTROLLERS ***/
        homeScene.setOnAction((ActionEvent r) -> {homepageSceneAction(r); });
        adminScene.setOnAction((ActionEvent r) -> {adminSceneAction(r); });
        referralScene.setOnAction((ActionEvent r) -> {referralSceneAction(r); });
        appointmentScene.setOnAction((ActionEvent r) -> {appointmentSceneAction(r); });
        orderScene.setOnAction((ActionEvent r) -> {orderSceneAction(r); });
        //invoiceSceneAction -------------------------------------------------
        
        //Left toolbar
        sceneBar.getItems().setAll(homeScene, adminScene, referralScene, appointmentScene, orderScene, invoiceScene);
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
        stageBar.getItems().setAll(getImageView(), user, separatorBar, logoutMain);
        stageBar.setId("menuBar");
        
        //TOOLBAR HUB       
        HBox toolBarHub = new HBox(sceneBar, stageBar);
        HBox.setHgrow(toolBarHub, Priority.SOMETIMES);
        toolBarHub.setMinHeight(42);
        toolBarHub.setMinWidth(500);
        
        /**************************************************/
        
        //HEAD OF SET ONE
        Label HeaderOne = new Label("Invoices");
        HeaderOne.setId("searchHeader");
        //HeaderOne.setMinHeight(48);
        //HeaderOne.setMinWidth(152);
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        HBox setOneHeadA = new HBox();
        setOneHeadA.setId("barHeader");
        setOneHeadA.getChildren().add(HeaderOne);
        setOneHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBar");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 0));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        HBox.setMargin(searchOne, new Insets(0, 65, 0, 0));
        setOneHeadB.setAlignment(Pos.CENTER_RIGHT);
        
        //SET ONE HUB
        HBox contentOneOrg = new HBox(); //Holds organizer buttons
        VBox contentOneArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg, contentOneArea);
        VBox.setMargin(setOneBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Appointments");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderTwo, new Insets(0, 50, 0, 0));
        
        HBox setTwoHeadA = new HBox();
        setTwoHeadA.setId("barHeader");
        setTwoHeadA.getChildren().add(HeaderTwo);
        setTwoHeadA.setAlignment(Pos.CENTER);
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBar");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 8, 0, 0));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        //searchTwo.setPromptText("");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().setAll(searchLabelTwo, searchTwo);
        HBox.setMargin(searchTwo, new Insets(0, 65, 0, 0));
        setTwoHeadB.setAlignment(Pos.BOTTOM_RIGHT);
        
        //SET TWO HUB
        HBox contentTwoOrg = new HBox(); //Holds organizer buttons
        VBox contentTwoArea = new VBox(); //Holds primary content        
      
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg, contentTwoArea);
        VBox.setMargin(setTwoBody, new Insets(20, 25, 0, 25));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody, setTwoBody); 
        
        //SCENE LAYOUT
        VBox rootBox = new VBox(toolBarHub, verticalHub);
        ScrollPane scrollPane = new ScrollPane(rootBox);
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        Scene invo = new Scene(scrollPane, getSceneWidth(), getSceneHeight());
        invo.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        super.setScene(invo);
    }
    
    //RETURN TO LOGIN
    private void returnButton() {
        this.close();
        new Login();
    }
    
    /*** BUTTON CONTROLLEER ACTIONS ***/
    private void homepageSceneAction(ActionEvent actionEvent) {
        System.out.println("HOME");
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        homeScene.setOnAction(null);
        homepageSceneCollection();
    }
    
    private void adminSceneAction(ActionEvent actionEvent) {
        System.out.println("ADMIN");
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        adminScene.setOnAction(null);
        adminSceneCollection();
    }
    
    private void referralSceneAction(ActionEvent actionEvent) {
        System.out.println("REFERRAL");
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        referralScene.setOnAction(null);
        referralSceneCollection();
    }
    
    private void appointmentSceneAction(ActionEvent actionEvent) {
        System.out.println("APPOINTMENT");
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        appointmentScene.setOnAction(null);
        appointmentSceneCollection();
    }
    
    private void orderSceneAction(ActionEvent actionEvent) {
        System.out.println("ORDER");
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        orderScene.setOnAction(null);
        orderSceneCollection();
    }
    
    private void invoiceSceneAction(ActionEvent actionEvent) {
        System.out.println("INVOICE");
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        invoiceScene.setOnAction(null);
        invoiceSceneCollection();
    }
    
    /*** SCENE SIZE CONSERVATION ***/
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
    /*** END OF SCENE SIZE CONSERVATION ***/
    
    /*** IMAGE VIEW SETTERS AND GETTERS ***/
    private ImageView imageView = new ImageView();
    
    private void setImageView(ImageView setIA) {
        imageView = setIA;
    }
    
    private ImageView getImageView() {
        return imageView;
    }
    
    /*** Empty Tables ***/
    private void emptyTableHomescreen() {
        
    }
    
    private void emptyTableAdmin() {
        
    }
    
    private void popAddUser(VBox box) {
        VBox addPopupOne = new VBox();
            addPopupOne.setStyle("-fx-background-color: red");
            
            
            Scene scenePopupOne = new Scene(addPopupOne, 300, 300);
            
            
            Stage stagePopupOne = new Stage();
            //stagePopupOne.initStyle(StageStyle.UNDECORATED);
            stagePopupOne.initOwner(this);
            stagePopupOne.initModality(Modality.WINDOW_MODAL);
            
            
            box.disableProperty().bind(stagePopupOne.showingProperty());
            stagePopupOne.setScene(scenePopupOne);
            
            stagePopupOne.showAndWait();
            
    }
    
    //TABLE TESTS FIXME: DELETE ME
    private void addTableTestSUO(ActionEvent A, ObservableList<SystemUserObject> B) {
        B.add(new SystemUserObject());
    }
    
    
    
}
