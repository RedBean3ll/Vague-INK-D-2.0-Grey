package com.softe.ris_team;

import com.softe.ris_team.TableObject.OrderObject;
import com.softe.ris_team.TableObject.SystemUserObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//PROGRAM IMPORTS
import com.softe.DBConnector;

//OBJECT IMPORTS
import com.softe.ris_team.TableObject.AppointmentObject;
import com.softe.ris_team.TableObject.InvoiceObject;
import com.softe.ris_team.TableObject.OrderObject;
import com.softe.ris_team.TableObject.PatientAlertObject;
import com.softe.ris_team.TableObject.SystemUserObject;
import com.softe.ris_team.TableObject.ModalityObject;
import com.softe.ris_team.TableObject.PatientObject;
import com.softe.ris_team.TableObject.FileUploadObject;
import com.softe.ris_team.TableObject.ReportObject;

//POPUP IMPORTS

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
    
    /*** HOMEPAGE TABLES ***/
    private TableView placedOrdersTable;
    private TableView checkedInAppointTable;
    private TableView todayAppointTable;
    private TableView unschedOrderTable;
    private TableView reviewImgOrdTable;
    private TableView patientAppointTable;
    
    /*** ADMINPAGE TABLES ***/
    private TableView systemUsersTable;
    private TableView modalityTable;
    private TableView patientAlertTable;
    private TableView patientTable;
    private TableView orderTable;
    private TableView appointTable;
    private TableView fileUploadTable;
    private TableView diagReportTable;
    
    /*** INVOICE TABLES ***/
    private TableView invoiceTable;
    
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
        Label user = new Label("Logged in: Admin -name-");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBarSub");
        
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
        HeaderOne.setAlignment(Pos.CENTER); 
        
        Button showAndHideOne = new Button("+");
        showAndHideOne.setId("buttonBar");
        showAndHideOne.setPrefHeight(48);
        showAndHideOne.setPrefWidth(48);
        
        BorderPane setOneHeadA = new BorderPane();
        setOneHeadA.setId("barHeader");
        setOneHeadA.setCenter(HeaderOne);
        setOneHeadA.setRight(showAndHideOne);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBarText");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER_LEFT);
        
        TextField searchOne = new TextField();
        searchOne.setId("searchBar");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));

        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        setOneHeadB.setId("headerBlockB");
        setOneHeadB.managedProperty().bind(setOneHeadB.visibleProperty());
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE ONE ***/
        placedOrdersTable = new TableView();
        
        /*** COLUMNS ***/
        TableColumn patientNameOne = new TableColumn("Patient");
        
        TableColumn modalityOne = new TableColumn("Modality");
        modalityOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.2));
        modalityOne.setReorderable(false);
        
        TableColumn notesOne = new TableColumn("Notes");
        notesOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.4));
        notesOne.setReorderable(false);
        
        TableColumn statusOne = new TableColumn("Status");
        statusOne.prefWidthProperty().bind(placedOrdersTable.widthProperty().multiply(0.1967));
        statusOne.setReorderable(false);
        
        placedOrdersTable.getColumns().setAll(patientNameOne, modalityOne, notesOne, statusOne);
        
        final ObservableList<OrderObject> tableDataOrderOne = FXCollections.observableArrayList();
        
        patientNameOne.setCellValueFactory(
        new PropertyValueFactory<OrderObject,String>("PATIENT_NAME")
        );
        
        modalityOne.setCellValueFactory(
        new PropertyValueFactory<OrderObject,String>("MODALITY")
        );
        
        notesOne.setCellValueFactory(
        new PropertyValueFactory<OrderObject,String>("NOTES")
        );
        
        statusOne.setCellValueFactory(
        new PropertyValueFactory<OrderObject,String>("STATUS")
        );
        
        //placedOrdersTable.setItems(tableDataOrderOne);
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(placedOrdersTable); //Holds table
        contentOneOrg.setId("barBody");
        contentOneOrg.setFitToWidth(true);
        contentOneOrg.managedProperty().bind(contentOneOrg.visibleProperty());
        contentOneOrg.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        placedOrdersTable.setId("table");
        placedOrdersTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityOne = new DisplayTable();
        
        showAndHideOne.setOnAction((ActionEvent e) -> {
            tableVisibilityOne.updateShowHide();
            
            setOneHeadB.setVisible(tableVisibilityOne.getVisibility());
            contentOneOrg.setVisible(tableVisibilityOne.getVisibility());
        });

        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(40, 80, 0, 80)); 
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Checked-In Appointments");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        
        Button showAndHideTwo = new Button("+");
        showAndHideTwo.setId("buttonBar");
        showAndHideTwo.setPrefHeight(48);
        showAndHideTwo.setPrefWidth(48);
        
        BorderPane setTwoHeadA = new BorderPane();
        setTwoHeadA.setId("barHeader");
        setTwoHeadA.setCenter(HeaderTwo);
        setTwoHeadA.setRight(showAndHideTwo);
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBarText");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 8, 0, 35));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        searchTwo.setId("searchBar");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        HBox.setMargin(searchTwo, new Insets(5, 0, 5, 0));
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().setAll(searchLabelTwo, searchTwo);
        setTwoHeadB.setId("headerBlockB");
        setTwoHeadB.managedProperty().bind(setTwoHeadB.visibleProperty());
        setTwoHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE TWO ***/
        checkedInAppointTable = new TableView();
        
        /*** COLUMNS ***/
        TableColumn patientTwo = new TableColumn("Patient");
        patientTwo.prefWidthProperty().bind(checkedInAppointTable.widthProperty().multiply(0.1));
        patientTwo.setReorderable(false);
        
        TableColumn modalityTwo = new TableColumn("Modality");
        modalityTwo.prefWidthProperty().bind(checkedInAppointTable.widthProperty().multiply(0.1));
        modalityTwo.setReorderable(false);
        
        TableColumn dateAndTimeTwo = new TableColumn("Date and Time");
        dateAndTimeTwo.prefWidthProperty().bind(checkedInAppointTable.widthProperty().multiply(0.1));
        dateAndTimeTwo.setReorderable(false);
        
        TableColumn radiologistTwo = new TableColumn("Radiologist");
        radiologistTwo.prefWidthProperty().bind(checkedInAppointTable.widthProperty().multiply(0.1));
        radiologistTwo.setReorderable(false);
        
        TableColumn technicianTwo = new TableColumn("Technician");
        technicianTwo.prefWidthProperty().bind(checkedInAppointTable.widthProperty().multiply(0.1));
        technicianTwo.setReorderable(false);
        
        checkedInAppointTable.getColumns().setAll(patientTwo, modalityTwo, dateAndTimeTwo, radiologistTwo, technicianTwo);

        final ObservableList<AppointmentObject> tableDataAppointmentTwo = FXCollections.observableArrayList();

        //column_name.setCellValueFactory(
        //new PropertyValueFactory<AppointmentObject,String>("object variable")
        //);
        
        checkedInAppointTable.setItems(tableDataAppointmentTwo);
        
        //SET TWO HUB
        ScrollPane contentTwoOrg = new ScrollPane(checkedInAppointTable); //Holds organizer buttons       
        contentTwoOrg.setId("barBody");
        contentTwoOrg.managedProperty().bind(contentTwoOrg.visibleProperty());
        contentTwoOrg.setFitToWidth(true);
        
        checkedInAppointTable.setId("table");
        checkedInAppointTable.prefWidthProperty().bind(contentTwoOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityTwo = new DisplayTable();
        
        showAndHideTwo.setOnAction((ActionEvent e) -> {
            tableVisibilityTwo.updateShowHide();
            
            setTwoHeadB.setVisible(tableVisibilityTwo.getVisibility());
            contentTwoOrg.setVisible(tableVisibilityTwo.getVisibility());
        });
        
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg);
        
        VBox.setMargin(setTwoBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET THREE
        Label HeaderThree = new Label("Today's Appointments");
        HeaderThree.setId("searchHeader");
        HeaderThree.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderThree, new Insets(0, 50, 0, 0));
        
        Button showAndHideThree = new Button("+");
        showAndHideThree.setId("buttonBar");
        showAndHideThree.setPrefHeight(48);
        showAndHideThree.setPrefWidth(48);
        
        BorderPane setThreeHeadA = new BorderPane();
        setThreeHeadA.setId("barHeader");
        setThreeHeadA.setCenter(HeaderThree);
        setThreeHeadA.setRight(showAndHideThree);
        
        Label searchLabelThree = new Label("Search:");
        searchLabelThree.setId("searchBarText");
        searchLabelThree.setMinHeight(30);
        searchLabelThree.setMinWidth(50);
        HBox.setMargin(searchLabelThree, new Insets(0, 8, 0, 35));
        searchLabelThree.setAlignment(Pos.CENTER);
        
        TextField searchThree = new TextField();
        searchThree.setId("searchBar");
        //searchThree.setPromptText("");
        searchThree.setMinHeight(25);
        searchThree.setMinWidth(184);
        HBox.setMargin(searchThree, new Insets(5, 0, 5, 0));
        
        HBox setThreeHeadB = new HBox();
        setThreeHeadB.getChildren().setAll(searchLabelThree, searchThree);
        setThreeHeadB.setId("headerBlockB");
        setThreeHeadB.managedProperty().bind(setThreeHeadB.visibleProperty());
        setThreeHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE THREE ***/
        todayAppointTable = new TableView();

        /*** COLUMNS ***/
        TableColumn patientThree = new TableColumn("Patient");
        patientThree.prefWidthProperty().bind(todayAppointTable.widthProperty().multiply(0.1));
        patientThree.setReorderable(false);
        
        TableColumn modalityThree = new TableColumn("Modality");
        modalityThree.prefWidthProperty().bind(todayAppointTable.widthProperty().multiply(0.1));
        modalityThree.setReorderable(false);
        
        TableColumn dateAndTimeThree = new TableColumn("Date and Time");
        dateAndTimeThree.prefWidthProperty().bind(todayAppointTable.widthProperty().multiply(0.1));
        dateAndTimeThree.setReorderable(false);
        
        TableColumn radiologistThree = new TableColumn("Radiologist");
        radiologistThree.prefWidthProperty().bind(todayAppointTable.widthProperty().multiply(0.1));
        radiologistThree.setReorderable(false);
        
        TableColumn technicianThree = new TableColumn("Technician");
        technicianThree.prefWidthProperty().bind(todayAppointTable.widthProperty().multiply(0.1));
        technicianThree.setReorderable(false);
        
        todayAppointTable.getColumns().setAll(patientThree, modalityThree, dateAndTimeThree, radiologistThree, technicianThree);

        final ObservableList<AppointmentObject> tableDataAppointThree = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //column_name.setCellValueFactory(
        //new PropertyValueFactory<AppointmentObject,String>("variable_name")
        //);
        
        todayAppointTable.setItems(tableDataAppointThree);

        //SET THREE HUB
        ScrollPane contentThreeOrg = new ScrollPane(todayAppointTable); //Holds organizer buttons
        contentThreeOrg.setId("barBody");
        contentThreeOrg.managedProperty().bind(contentThreeOrg.visibleProperty());
        contentThreeOrg.setFitToWidth(true);
        
        todayAppointTable.setId("table");
        todayAppointTable.prefWidthProperty().bind(contentThreeOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityThree = new DisplayTable();
        
        showAndHideThree.setOnAction((ActionEvent e) -> {
            tableVisibilityThree.updateShowHide();
            
            setThreeHeadB.setVisible(tableVisibilityThree.getVisibility());
            contentThreeOrg.setVisible(tableVisibilityThree.getVisibility());
        });
        
        //BODY HUB
        VBox setThreeBody = new VBox(setThreeHeadA, setThreeHeadB, contentThreeOrg);
        VBox.setMargin(setThreeBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET FOUR
        Label HeaderFour = new Label("Unschedualed Orders");
        HeaderFour.setId("searchHeader");
        HeaderFour.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFour, new Insets(0, 50, 0, 0));
        
        Button showAndHideFour = new Button("+");
        showAndHideFour.setId("buttonBar");
        showAndHideFour.setPrefHeight(48);
        showAndHideFour.setPrefWidth(48);
        
        BorderPane setFourHeadA = new BorderPane();
        setFourHeadA.setId("barHeader");
        setFourHeadA.setCenter(HeaderFour);
        setFourHeadA.setRight(showAndHideFour);
        
        Label searchLabelFour = new Label("Search:");
        searchLabelFour.setId("searchBarText");
        searchLabelFour.setMinHeight(30);
        searchLabelFour.setMinWidth(50);
        HBox.setMargin(searchLabelFour, new Insets(0, 8, 0, 35));
        searchLabelFour.setAlignment(Pos.CENTER);
        
        TextField searchFour = new TextField();
        searchFour.setId("searchBar");
        //searchFour.setPromptText("");
        searchFour.setMinHeight(25);
        searchFour.setMinWidth(184);
        HBox.setMargin(searchFour, new Insets(5, 0, 5, 0));
        
        HBox setFourHeadB = new HBox();
        setFourHeadB.getChildren().setAll(searchLabelFour, searchFour);
        setFourHeadB.setId("headerBlockB");
        setFourHeadB.managedProperty().bind(setFourHeadB.visibleProperty());
        setFourHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE FOUR ***/
        unschedOrderTable = new TableView();
        
        /*** COLUMNS ***/
        TableColumn patientFour = new TableColumn("Patient");
        patientFour.prefWidthProperty().bind(unschedOrderTable.widthProperty().multiply(0.1));
        patientFour.setReorderable(false);
        
        TableColumn referralMdFour = new TableColumn("Referral MD");
        referralMdFour.prefWidthProperty().bind(unschedOrderTable.widthProperty().multiply(0.1));
        referralMdFour.setReorderable(false);
        
        TableColumn modalityFour = new TableColumn("Modality");
        modalityFour.prefWidthProperty().bind(unschedOrderTable.widthProperty().multiply(0.1));
        modalityFour.setReorderable(false);
        
        TableColumn notesFour = new TableColumn("Notes");
        notesFour.prefWidthProperty().bind(unschedOrderTable.widthProperty().multiply(0.1));
        notesFour.setReorderable(false);
            
        unschedOrderTable.getColumns().setAll(patientFour, referralMdFour, modalityFour, notesFour);

        final ObservableList<OrderObject> tableDataOrderFour = FXCollections.observableArrayList();
        
        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //column_name.setCellValueFactory(
        //new PropertyValueFactory<OrderObject,String>("object variable")
        //);

        unschedOrderTable.setItems(tableDataOrderFour);
        
        //SET FOUR HUB
        ScrollPane contentFourOrg = new ScrollPane(unschedOrderTable); //Holds organizer buttons
        contentFourOrg.setId("barBody");
        contentFourOrg.managedProperty().bind(contentFourOrg.visibleProperty());
        contentFourOrg.setFitToWidth(true);
        
        unschedOrderTable.setId("table");
        unschedOrderTable.prefWidthProperty().bind(contentFourOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityFour = new DisplayTable();
        
        showAndHideFour.setOnAction((ActionEvent e) -> {
            tableVisibilityFour.updateShowHide();
            
            setFourHeadB.setVisible(tableVisibilityFour.getVisibility());
            contentFourOrg.setVisible(tableVisibilityFour.getVisibility());
        });
        
        //BODY HUB
        VBox setFourBody = new VBox(setFourHeadA, setFourHeadB, contentFourOrg);
        VBox.setMargin(setFourBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET SIX
        Label HeaderSix = new Label("To Be Reviewed Imaging Orders");
        HeaderSix.setId("searchHeader");
        HeaderSix.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSix, new Insets(0, 50, 0, 0));
        
        Button showAndHideSix = new Button("+");
        showAndHideSix.setId("buttonBar");
        showAndHideSix.setPrefHeight(48);
        showAndHideSix.setPrefWidth(48);
        
        BorderPane setSixHeadA = new BorderPane();
        setSixHeadA.setId("barHeader");
        setSixHeadA.setCenter(HeaderSix);
        setSixHeadA.setRight(showAndHideSix);
        
        Label searchLabelSix = new Label("Search:");
        searchLabelSix.setId("searchBarText");
        searchLabelSix.setMinHeight(30);
        searchLabelSix.setMinWidth(50);
        HBox.setMargin(searchLabelSix, new Insets(0, 8, 0, 35));
        searchLabelSix.setAlignment(Pos.CENTER);
        
        TextField searchSix = new TextField();
        searchSix.setId("searchBar");
        //searchSix.setPromptText("");
        searchSix.setMinHeight(25);
        searchSix.setMinWidth(184);
        HBox.setMargin(searchSix, new Insets(5, 0, 5, 0));
        
        HBox setSixHeadB = new HBox();
        setSixHeadB.getChildren().setAll(searchLabelSix, searchSix);
        setSixHeadB.setId("headerBlockB");
        setSixHeadB.managedProperty().bind(setSixHeadB.visibleProperty());
        setSixHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE SIX ***/
        reviewImgOrdTable = new TableView();

        /*** COLUMNS ***/
        TableColumn patientSix = new TableColumn("Patient");
        patientSix.prefWidthProperty().bind(reviewImgOrdTable.widthProperty().multiply(0.1));
        patientSix.setReorderable(false);
        
        TableColumn referralMdSix = new TableColumn("Referral MD");
        referralMdSix.prefWidthProperty().bind(reviewImgOrdTable.widthProperty().multiply(0.1));
        referralMdSix.setReorderable(false);
        
        TableColumn modalitySix = new TableColumn("Modality");
        modalitySix.prefWidthProperty().bind(reviewImgOrdTable.widthProperty().multiply(0.1));
        modalitySix.setReorderable(false);
        
        TableColumn notesSix = new TableColumn("Notes");
        notesSix.prefWidthProperty().bind(reviewImgOrdTable.widthProperty().multiply(0.1));
        notesSix.setReorderable(false);
            
        reviewImgOrdTable.getColumns().setAll(patientSix, referralMdSix, modalitySix, notesSix);

        final ObservableList<OrderObject> tableDataImageOrderSix = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //column_name.setCellValueFactory(
        //new PropertyValueFactory<class,String>("object variable")
        //);
        
        reviewImgOrdTable.setItems(tableDataImageOrderSix);
        
        //SET SIX HUB
        ScrollPane contentSixOrg = new ScrollPane(reviewImgOrdTable); //Holds organizer buttons
        contentSixOrg.setId("barBody");
        contentSixOrg.managedProperty().bind(contentSixOrg.visibleProperty());
        contentSixOrg.setFitToWidth(true);
        
        reviewImgOrdTable.setId("table");
        reviewImgOrdTable.prefWidthProperty().bind(contentSixOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilitySix = new DisplayTable();
        
        showAndHideSix.setOnAction((ActionEvent e) -> {
            tableVisibilitySix.updateShowHide();
            
            setSixHeadB.setVisible(tableVisibilitySix.getVisibility());
            contentSixOrg.setVisible(tableVisibilitySix.getVisibility());
        });
        
        //BODY HUB
        VBox setSixBody = new VBox(setSixHeadA, setSixHeadB, contentSixOrg);
        VBox.setMargin(setSixBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET SEVEN
        Label HeaderSeven = new Label("Patient Appointments");
        HeaderSeven.setId("searchHeader");
        HeaderSeven.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSeven, new Insets(0, 50, 0, 0));
        
        Button showAndHideSeven = new Button("+");
        showAndHideSeven.setId("buttonBar");
        showAndHideSeven.setPrefHeight(48);
        showAndHideSeven.setPrefWidth(48);
        
        BorderPane setSevenHeadA = new BorderPane();
        setSevenHeadA.setId("barHeader");
        setSevenHeadA.setCenter(HeaderSeven);
        setSevenHeadA.setRight(showAndHideSeven);
        
        Label searchLabelSeven = new Label("Search:");
        searchLabelSeven.setId("searchBarText");
        searchLabelSeven.setMinHeight(30);
        searchLabelSeven.setMinWidth(50);
        HBox.setMargin(searchLabelSeven, new Insets(0, 8, 0, 35));
        searchLabelSeven.setAlignment(Pos.CENTER);
        
        TextField searchSeven = new TextField();
        searchSeven.setId("searchBar");
        //searchSeven.setPromptText("");
        searchSeven.setMinHeight(25);
        searchSeven.setMinWidth(184);
        HBox.setMargin(searchSeven, new Insets(5, 0, 5, 0));
        
        HBox setSevenHeadB = new HBox();
        setSevenHeadB.getChildren().setAll(searchLabelSeven, searchSeven);
        setSevenHeadB.setId("headerBlockB");
        setSevenHeadB.managedProperty().bind(setSevenHeadB.visibleProperty());
        setSevenHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE SEVEN ***/
        patientAppointTable = new TableView();

        /*** COLUMNS ***/
        TableColumn patientSeven = new TableColumn("Patient");
        patientSeven.prefWidthProperty().bind(patientAppointTable.widthProperty().multiply(0.1));
        patientSeven.setReorderable(false);
        
        TableColumn modalitySeven = new TableColumn("Modality");
        modalitySeven.prefWidthProperty().bind(patientAppointTable.widthProperty().multiply(0.1));
        modalitySeven.setReorderable(false);
        
        TableColumn dateAndTimeSeven = new TableColumn("Date and Time");
        dateAndTimeSeven.prefWidthProperty().bind(patientAppointTable.widthProperty().multiply(0.1));
        dateAndTimeSeven.setReorderable(false);
        
        TableColumn radiologistSeven = new TableColumn("Radiologist");
        radiologistSeven.prefWidthProperty().bind(patientAppointTable.widthProperty().multiply(0.1));
        radiologistSeven.setReorderable(false);
        
        TableColumn technicianSeven = new TableColumn("Technician");
        technicianSeven.prefWidthProperty().bind(patientAppointTable.widthProperty().multiply(0.1));
        
        patientAppointTable.getColumns().setAll(patientSeven, modalitySeven, dateAndTimeSeven, radiologistSeven, technicianSeven);

        final ObservableList<AppointmentObject> tableDataAppointSeven = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //column_name.setCellValueFactory(
        //new PropertyValueFactory<class,String>("object variable")
        //);
        
        patientAppointTable.setItems(tableDataAppointSeven);
        
        //SET SEVEN HUB
        ScrollPane contentSevenOrg = new ScrollPane(patientAppointTable); //Holds organizer buttons       
        contentSevenOrg.setId("barBody");
        contentSevenOrg.managedProperty().bind(contentSevenOrg.visibleProperty());
        contentSevenOrg.setFitToWidth(true);
        
        patientAppointTable.setId("table");
        patientAppointTable.prefWidthProperty().bind(contentSevenOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilitySeven = new DisplayTable();
        
        showAndHideSeven.setOnAction((ActionEvent e) -> {
            tableVisibilitySeven.updateShowHide();
            
            setSevenHeadB.setVisible(tableVisibilitySeven.getVisibility());
            contentSevenOrg.setVisible(tableVisibilitySeven.getVisibility());
        });
        
        //BODY HUB
        VBox setSevenBody = new VBox(setSevenHeadA, setSevenHeadB, contentSevenOrg);
        VBox.setMargin(setSevenBody, new Insets(40, 80, 40, 80));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody, setTwoBody, setThreeBody, setFourBody, setSixBody, setSevenBody); 
        
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
        Label user = new Label("Logged in: Admin -name-");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBarSub");
        
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
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        
        Button showAndHideOne = new Button("+");
        showAndHideOne.setId("buttonBar");
        showAndHideOne.setPrefHeight(48);
        showAndHideOne.setPrefWidth(48);
        
        BorderPane setOneHeadA = new BorderPane();
        setOneHeadA.setId("barHeader");
        setOneHeadA.setCenter(HeaderOne);
        setOneHeadA.setRight(showAndHideOne);
        
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
        searchLabelOne.setId("searchBarText");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER_LEFT);
        
        TextField searchOne = new TextField();
        searchOne.setId("searchBar");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));

        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(newObjectOne, removeSelectedOne, modifySelectedOne, searchLabelOne, searchOne);
        setOneHeadB.setId("headerBlockB");
        setOneHeadB.managedProperty().bind(setOneHeadB.visibleProperty());
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE ONE ***/
        systemUsersTable = new TableView();
        
        /*** COLUMNS ONE ***/
        TableColumn userIdOne = new TableColumn("ID");
        userIdOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.05));
        userIdOne.setReorderable(false);
        
        TableColumn usernameOne = new TableColumn("Username");
        usernameOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.1));
        usernameOne.setReorderable(false);
        
        TableColumn displayNameOne = new TableColumn("Display Name");
        displayNameOne.prefWidthProperty().bind(systemUsersTable.widthProperty().multiply(0.1));
        displayNameOne.setReorderable(false);
        
        TableColumn emailOne = new TableColumn("Email");
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
        systemUsersTable.getColumns().setAll(userIdOne, usernameOne, displayNameOne, emailOne, systemRoleOne, activeOne);
        
        ObservableList<SystemUserObject> tableDataSUOOne = FXCollections.observableArrayList();
        
        /*** ADD, REMOVE, MODIFY ACTIONS ***/
        userIdOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("ACCOUNT_IDENTIFIER")
        );
        
        usernameOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("ACCOUNT_USERNAME")
        );
        
        displayNameOne.setCellValueFactory(
        new PropertyValueFactory<SystemUserObject,String>("SCREEN_NAME")
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
        
        //ADD NEW OBJECT
        newObjectOne.setOnAction((ActionEvent a) -> {
            new popupAdmin(this, rootBox, tableDataSUOOne);
            //popAddUser(rootBox, tableDataSUOOne);
        });
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(systemUsersTable); //Holds table
        contentOneOrg.setId("barBody");
        contentOneOrg.managedProperty().bind(contentOneOrg.visibleProperty());
        contentOneOrg.setFitToWidth(true);
        
        systemUsersTable.setId("table");
        systemUsersTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityOne = new DisplayTable();
        
        showAndHideOne.setOnAction((ActionEvent e) -> {
            tableVisibilityOne.updateShowHide();
            
            setOneHeadB.setVisible(tableVisibilityOne.getVisibility());
            contentOneOrg.setVisible(tableVisibilityOne.getVisibility());
        });
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Modalities");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderTwo, new Insets(0, 50, 0, 0));
        
        Button showAndHideTwo = new Button("+");
        showAndHideTwo.setId("buttonBar");
        showAndHideTwo.setPrefHeight(48);
        showAndHideTwo.setPrefWidth(48);
        
        BorderPane setTwoHeadA = new BorderPane();
        setTwoHeadA.setId("barHeader");
        setTwoHeadA.setCenter(HeaderTwo);
        setTwoHeadA.setRight(showAndHideTwo);
        
        /*** BUTTONS ***/
        Button newObjectTwo = new Button("New");
        newObjectTwo.setId("buttonSearch");
        HBox.setMargin(newObjectTwo, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedTwo = new Button("Remove Selected");
        removeSelectedTwo.setId("buttonSearch");
        HBox.setMargin(removeSelectedTwo, new Insets(0, 0, 0, 5));
        
        Button modifySelectedTwo = new Button("Modify Selected");
        modifySelectedTwo.setId("buttonSearch");
        HBox.setMargin(modifySelectedTwo, new Insets(0, 0, 0, 5));
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBarText");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 8, 0, 35));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        searchTwo.setId("searchBar");
        //searchTwo.setPromptText("");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        HBox.setMargin(searchTwo, new Insets(5, 0, 5, 0));
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().setAll(newObjectTwo, removeSelectedTwo, modifySelectedTwo, searchLabelTwo, searchTwo);
        setTwoHeadB.setId("headerBlockB");
        setTwoHeadB.managedProperty().bind(setTwoHeadB.visibleProperty());
        setTwoHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE TWO ***/
        modalityTable = new TableView();
        
        /*** COLUMNS TWO ***/
        //modalityIdTwo, modalityTwo, costTwo
        TableColumn modalityIdTwo = new TableColumn("Modality ID");
        modalityIdTwo.prefWidthProperty().bind(modalityTable.widthProperty().multiply(0.1));
        modalityIdTwo.setReorderable(false);
        
        TableColumn modalityTwo = new TableColumn("Modality");
        modalityTwo.prefWidthProperty().bind(modalityTable.widthProperty().multiply(0.1));
        modalityTwo.setReorderable(false);
        
        TableColumn costTwo = new TableColumn("Cost");
        costTwo.prefWidthProperty().bind(modalityTable.widthProperty().multiply(0.1));
        costTwo.setReorderable(false);
        
        modalityTable.getColumns().setAll(modalityIdTwo, modalityTwo, costTwo);
        
        final ObservableList<ModalityObject> tableDataModalityTwo = FXCollections.observableArrayList();

        //EX modalityTableof existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        modalityTable.setItems(tableDataModalityTwo);
        
        //SET TWO HUB
        ScrollPane contentTwoOrg = new ScrollPane(modalityTable); //Holds organizer buttons
        contentTwoOrg.setId("barBody");
        contentTwoOrg.managedProperty().bind(contentTwoOrg.visibleProperty());
        contentTwoOrg.setFitToWidth(true);
        
        modalityTable.setId("table");
        modalityTable.prefWidthProperty().bind(contentTwoOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityTwo = new DisplayTable();
        
        showAndHideTwo.setOnAction((ActionEvent e) -> {
            tableVisibilityTwo.updateShowHide();
            
            setTwoHeadB.setVisible(tableVisibilityTwo.getVisibility());
            contentTwoOrg.setVisible(tableVisibilityTwo.getVisibility());
        });
        
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg);
        VBox.setMargin(setTwoBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET THREE
        Label HeaderThree = new Label("Patient Alerts");
        HeaderThree.setId("searchHeader");
        HeaderThree.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderThree, new Insets(0, 50, 0, 0));
        
        Button showAndHideThree = new Button("+");
        showAndHideThree.setId("buttonBar");
        showAndHideThree.setPrefHeight(48);
        showAndHideThree.setPrefWidth(48);
        
        BorderPane setThreeHeadA = new BorderPane();
        setThreeHeadA.setId("barHeader");
        setThreeHeadA.setCenter(HeaderThree);
        setThreeHeadA.setRight(showAndHideThree);
        
        /*** BUTTONS ***/
        Button newObjectThree = new Button("New");
        newObjectThree.setId("buttonSearch");
        HBox.setMargin(newObjectThree, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedThree = new Button("Remove Selected");
        removeSelectedThree.setId("buttonSearch");
        HBox.setMargin(removeSelectedThree, new Insets(0, 0, 0, 5));
        
        Button modifySelectedThree = new Button("Modify Selected");
        modifySelectedThree.setId("buttonSearch");
        HBox.setMargin(modifySelectedThree, new Insets(0, 0, 0, 5));
        
        Label searchLabelThree = new Label("Search:");
        searchLabelThree.setId("searchBarText");
        searchLabelThree.setMinHeight(30);
        searchLabelThree.setMinWidth(50);
        HBox.setMargin(searchLabelThree, new Insets(0, 8, 0, 35));
        searchLabelThree.setAlignment(Pos.CENTER);
        
        TextField searchThree = new TextField();
        searchThree.setId("searchBar");
        //searchThree.setPromptText("");
        searchThree.setMinHeight(25);
        searchThree.setMinWidth(184);
        HBox.setMargin(searchThree, new Insets(5, 0, 5, 0));
        
        HBox setThreeHeadB = new HBox();
        setThreeHeadB.getChildren().setAll(newObjectThree, removeSelectedThree, modifySelectedThree, searchLabelThree, searchThree);
        setThreeHeadB.setId("headerBlockB");
        setThreeHeadB.managedProperty().bind(setThreeHeadB.visibleProperty());
        setThreeHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE THREE ***/
        patientAlertTable = new TableView();
        
        /*** COLUMNS THREE ***/
        TableColumn patientAlertIdThree = new TableColumn("Patient Alert ID");
        patientAlertIdThree.prefWidthProperty().bind(patientAlertTable.widthProperty().multiply(0.1));
        patientAlertIdThree.setReorderable(false);
        
        TableColumn patientAlertNameThree = new TableColumn("Patient Alert");
        patientAlertNameThree.prefWidthProperty().bind(patientAlertTable.widthProperty().multiply(0.1));
        patientAlertNameThree.setReorderable(false);
        
        patientAlertTable.getColumns().setAll(patientAlertIdThree, patientAlertNameThree);
        
        final ObservableList<PatientAlertObject> tablePatAlertThree = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        patientAlertTable.setItems(tablePatAlertThree);
        
        //SET THREE HUB
        ScrollPane contentThreeOrg = new ScrollPane(patientAlertTable); //Holds organizer buttons
        contentThreeOrg.setId("barBody");
        contentThreeOrg.managedProperty().bind(contentThreeOrg.visibleProperty());
        contentThreeOrg.setFitToWidth(true);
        
        patientAlertTable.setId("table");
        patientAlertTable.prefWidthProperty().bind(contentThreeOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityThree = new DisplayTable();
        
        showAndHideThree.setOnAction((ActionEvent e) -> {
            tableVisibilityThree.updateShowHide();
            
            setThreeHeadB.setVisible(tableVisibilityThree.getVisibility());
            contentThreeOrg.setVisible(tableVisibilityThree.getVisibility());
        });
        
        //BODY HUB
        VBox setThreeBody = new VBox(setThreeHeadA, setThreeHeadB, contentThreeOrg);
        VBox.setMargin(setThreeBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET FOUR
        Label HeaderFour = new Label("Patients");
        HeaderFour.setId("searchHeader");
        HeaderFour.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFour, new Insets(0, 50, 0, 0));
        
        Button showAndHideFour = new Button("+");
        showAndHideFour.setId("buttonBar");
        showAndHideFour.setPrefHeight(48);
        showAndHideFour.setPrefWidth(48);
        
        BorderPane setFourHeadA = new BorderPane();
        setFourHeadA.setId("barHeader");
        setFourHeadA.setCenter(HeaderFour);
        setFourHeadA.setRight(showAndHideFour);
        
        /*** BUTTONS ***/
        Button newObjectFour = new Button("New");
        newObjectFour.setId("buttonSearch");
        HBox.setMargin(newObjectFour, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedFour = new Button("Remove Selected");
        removeSelectedFour.setId("buttonSearch");
        HBox.setMargin(removeSelectedFour, new Insets(0, 0, 0, 5));
        
        Button modifySelectedFour = new Button("Modify Selected");
        modifySelectedFour.setId("buttonSearch");
        HBox.setMargin(modifySelectedFour, new Insets(0, 0, 0, 5));
        
        Label searchLabelFour = new Label("Search:");
        searchLabelFour.setId("searchBarText");
        searchLabelFour.setMinHeight(30);
        searchLabelFour.setMinWidth(50);
        HBox.setMargin(searchLabelFour, new Insets(0, 8, 0, 35));
        searchLabelFour.setAlignment(Pos.CENTER);
        
        TextField searchFour = new TextField();
        searchFour.setId("searchBar");
        //searchFour.setPromptText("");
        searchFour.setMinHeight(25);
        searchFour.setMinWidth(184);
        HBox.setMargin(searchFour, new Insets(5, 0, 5, 0));
        
        HBox setFourHeadB = new HBox();
        setFourHeadB.getChildren().setAll(newObjectFour, removeSelectedFour, modifySelectedFour, searchLabelFour, searchFour);
        setFourHeadB.setId("headerBlockB");
        setFourHeadB.managedProperty().bind(setFourHeadB.visibleProperty());
        setFourHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE FOUR ***/
        patientTable = new TableView();
        
        /*** COLUMNS FOUR ***/
        TableColumn patientIdFour = new TableColumn("Patient ID");
        patientIdFour.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        patientIdFour.setReorderable(false);
        
        TableColumn firstNameFour = new TableColumn("First Name");
        firstNameFour.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        firstNameFour.setReorderable(false);
        
        TableColumn lastNameFour = new TableColumn("Last Name");
        lastNameFour.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        lastNameFour.setReorderable(false);
        
        TableColumn dateOfBirthFour = new TableColumn("Date of Birth");
        dateOfBirthFour.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        dateOfBirthFour.setReorderable(false);
        
        //TableColumn sexFour = new TableColumn("Sex");
        //sexFour.prefWidthProperty().bind(patientTable.widthProperty());
        //sexFour.setReorderable(false);
        
        //TableColumn raceFour = new TableColumn("Race");
        //raceFour.prefWidthProperty().bind(patientTable.widthProperty());
        //raceFour.setReorderable(false);
        
        //TableColumn ethnicityFour = new TableColumn("Ethnicity");
        //ethnicityFour.prefWidthProperty().bind(patientTable.widthProperty());
        //ethnicityFour.setReorderable(false);
        
        //TableColumn patientAlertFour = new TableColumn("Patient Alerts");
        //patientAlertFour.prefWidthProperty().bind(patientTable.widthProperty());
        //patientAlertFour.setReorderable(false);
        
        patientTable.getColumns().setAll(patientIdFour, firstNameFour, lastNameFour, dateOfBirthFour);
        
        final ObservableList<PatientObject> tableDataPatientFour = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        patientTable.setItems(tableDataPatientFour);
        
        //SET FOUR HUB
        ScrollPane contentFourOrg = new ScrollPane(patientTable); //Holds organizer buttons       
        contentFourOrg.setId("barBody");
        contentFourOrg.managedProperty().bind(contentFourOrg.visibleProperty());
        contentFourOrg.setFitToWidth(true);
        
        patientTable.setId("table");
        patientTable.prefWidthProperty().bind(contentFourOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityFour = new DisplayTable();
        
        showAndHideFour.setOnAction((ActionEvent e) -> {
            tableVisibilityFour.updateShowHide();
            
            setFourHeadB.setVisible(tableVisibilityFour.getVisibility());
            contentFourOrg.setVisible(tableVisibilityFour.getVisibility());
        });
        
        //BODY HUB
        VBox setFourBody = new VBox(setFourHeadA, setFourHeadB, contentFourOrg);
        VBox.setMargin(setFourBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET FIVE
        Label HeaderFive = new Label("Orders");
        HeaderFive.setId("searchHeader");
        HeaderFive.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderFive, new Insets(0, 50, 0, 0));
        
        Button showAndHideFive = new Button("+");
        showAndHideFive.setId("buttonBar");
        showAndHideFive.setPrefHeight(48);
        showAndHideFive.setPrefWidth(48);
        
        BorderPane setFiveHeadA = new BorderPane();
        setFiveHeadA.setId("barHeader");
        setFiveHeadA.setCenter(HeaderFive);
        setFiveHeadA.setRight(showAndHideFive);
        
        /*** BUTTONS ***/
        Button newObjectFive = new Button("New");
        newObjectFive.setId("buttonSearch");
        HBox.setMargin(newObjectFive, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedFive = new Button("Remove Selected");
        removeSelectedFive.setId("buttonSearch");
        HBox.setMargin(removeSelectedFive, new Insets(0, 0, 0, 5));
        
        Button modifySelectedFive = new Button("Modify Selected");
        modifySelectedFive.setId("buttonSearch");
        HBox.setMargin(modifySelectedFive, new Insets(0, 0, 0, 5));
        
        Label searchLabelFive = new Label("Search:");
        searchLabelFive.setId("searchBarText");
        searchLabelFive.setMinHeight(30);
        searchLabelFive.setMinWidth(50);
        HBox.setMargin(searchLabelFive, new Insets(0, 8, 0, 35));
        searchLabelFive.setAlignment(Pos.CENTER);
        
        TextField searchFive = new TextField();
        searchFive.setId("searchBar");
        //searchFive.setPromptText("");
        searchFive.setMinHeight(25);
        searchFive.setMinWidth(184);
        HBox.setMargin(searchFive, new Insets(5, 0, 5, 0));
        
        HBox setFiveHeadB = new HBox();
        setFiveHeadB.getChildren().setAll(newObjectFive, removeSelectedFive, modifySelectedFive, searchLabelFive, searchFive);
        setFiveHeadB.setId("headerBlockB");
        setFiveHeadB.managedProperty().bind(setFiveHeadB.visibleProperty());
        setFiveHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE FIVE ***/
        orderTable = new TableView();
        
        /*** COLUMNS FIVE ***/
        TableColumn orderIdFive = new TableColumn("Order ID");
        orderIdFive.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        orderIdFive.setReorderable(false);
        
        TableColumn patientFive = new TableColumn("Patient");
        patientFive.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        patientFive.setReorderable(false);
        
        TableColumn referralMdFive = new TableColumn("Regerral MD");
        referralMdFive.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        referralMdFive.setReorderable(false);
        
        TableColumn modalityFive = new TableColumn("Modality");
        modalityFive.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        modalityFive.setReorderable(false);
        
        TableColumn notesFive = new TableColumn("Notes");
        notesFive.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        notesFive.setReorderable(false);
        
        TableColumn statusFive = new TableColumn("Status");
        statusFive.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        statusFive.setReorderable(false);
        
        orderTable.getColumns().setAll(orderIdFive, patientFive, referralMdFive, modalityFive, notesFive, statusFive);
        
        final ObservableList<OrderObject> tableDataOtderFive = FXCollections.observableArrayList();
        
        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        orderTable.setItems(tableDataOtderFive);
        
        //SET FIVE HUB
        ScrollPane contentFiveOrg = new ScrollPane(orderTable);
        contentFiveOrg.setId("barBody");
        contentFiveOrg.managedProperty().bind(contentFiveOrg.visibleProperty());
        contentFiveOrg.setFitToWidth(true);
        
        orderTable.setId("table");
        orderTable.prefWidthProperty().bind(contentFiveOrg.widthProperty());
      
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityFive = new DisplayTable();
        
        showAndHideFive.setOnAction((ActionEvent e) -> {
            tableVisibilityFive.updateShowHide();
            
            setFiveHeadB.setVisible(tableVisibilityFive.getVisibility());
            contentFiveOrg.setVisible(tableVisibilityFive.getVisibility());
        });
        
        //BODY HUB
        VBox setFiveBody = new VBox(setFiveHeadA, setFiveHeadB, contentFiveOrg);
        VBox.setMargin(setFiveBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET SIX
        Label HeaderSix = new Label("Appointments");
        HeaderSix.setId("searchHeader");
        HeaderSix.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSix, new Insets(0, 50, 0, 0));
        
        Button showAndHideSix = new Button("+");
        showAndHideSix.setId("buttonBar");
        showAndHideSix.setPrefHeight(48);
        showAndHideSix.setPrefWidth(48);
        
        BorderPane setSixHeadA = new BorderPane();
        setSixHeadA.setId("barHeader");
        setSixHeadA.setCenter(HeaderSix);
        setSixHeadA.setRight(showAndHideSix);
        
        /*** BUTTONS ***/
        Button newObjectSix = new Button("New");
        newObjectSix.setId("buttonSearch");
        HBox.setMargin(newObjectSix, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedSix = new Button("Remove Selected");
        removeSelectedSix.setId("buttonSearch");
        HBox.setMargin(removeSelectedSix, new Insets(0, 0, 0, 5));
        
        Button modifySelectedSix = new Button("Modify Selected");
        modifySelectedSix.setId("buttonSearch");
        HBox.setMargin(modifySelectedSix, new Insets(0, 0, 0, 5));
        
        Label searchLabelSix = new Label("Search:");
        searchLabelSix.setId("searchBarText");
        searchLabelSix.setMinHeight(30);
        searchLabelSix.setMinWidth(50);
        HBox.setMargin(searchLabelSix, new Insets(0, 8, 0, 35));
        searchLabelSix.setAlignment(Pos.CENTER);
        
        TextField searchSix = new TextField();
        searchSix.setId("searchBar");
        //searchSix.setPromptText("");
        searchSix.setMinHeight(25);
        searchSix.setMinWidth(184);
        HBox.setMargin(searchSix, new Insets(5, 0, 5, 0));
        
        HBox setSixHeadB = new HBox();
        setSixHeadB.getChildren().setAll(newObjectSix, removeSelectedSix, modifySelectedSix, searchLabelSix, searchSix);
        setSixHeadB.setId("headerBlockB");
        setSixHeadB.managedProperty().bind(setSixHeadB.visibleProperty());
        setSixHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE SIX ***/
        appointTable = new TableView();
        
        /*** COLUMNS SIX ***/
        TableColumn appointmentIdSix = new TableColumn("Appointment ID");
        appointmentIdSix.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        appointmentIdSix.setReorderable(false);
        
        TableColumn patientSix = new TableColumn("Patient");
        patientSix.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        patientSix.setReorderable(false);
        
        TableColumn orderSix = new TableColumn("Order");
        orderSix.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        orderSix.setReorderable(false);
        
        TableColumn dateAndTimeSix = new TableColumn("Date and Time");
        dateAndTimeSix.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        dateAndTimeSix.setReorderable(false);
        
        TableColumn technicianSix = new TableColumn("Technician");
        technicianSix.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        technicianSix.setReorderable(false);
        
        TableColumn radiologistSix = new TableColumn("Radiologist");
        radiologistSix.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        radiologistSix.setReorderable(false);
        
        appointTable.getColumns().setAll(appointmentIdSix, patientSix, orderSix, dateAndTimeSix, technicianSix, radiologistSix);
        
        final ObservableList<AppointmentObject> tableDataAppointmentSix = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        appointTable.setItems(tableDataAppointmentSix);
        
        //SET SIX HUB
        ScrollPane contentSixOrg = new ScrollPane(appointTable); //Holds organizer buttons      
        contentSixOrg.setId("barBody");
        contentSixOrg.managedProperty().bind(contentSixOrg.visibleProperty());
        contentSixOrg.setFitToWidth(true);
        
        appointTable.setId("table");
        appointTable.prefWidthProperty().bind(contentSixOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilitySix = new DisplayTable();
        
        showAndHideSix.setOnAction((ActionEvent e) -> {
            tableVisibilitySix.updateShowHide();
            
            setSixHeadB.setVisible(tableVisibilitySix.getVisibility());
            contentSixOrg.setVisible(tableVisibilitySix.getVisibility());
        });
        
        //BODY HUB
        VBox setSixBody = new VBox(setSixHeadA, setSixHeadB, contentSixOrg);
        VBox.setMargin(setSixBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET SEVEN
        Label HeaderSeven = new Label("File Uploads");
        HeaderSeven.setId("searchHeader");
        HeaderSeven.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderSeven, new Insets(0, 50, 0, 0));
        
        Button showAndHideSeven = new Button("+");
        showAndHideSeven.setId("buttonBar");
        showAndHideSeven.setPrefHeight(48);
        showAndHideSeven.setPrefWidth(48);
        
        BorderPane setSevenHeadA = new BorderPane();
        setSevenHeadA.setId("barHeader");
        setSevenHeadA.setCenter(HeaderSeven);
        setSevenHeadA.setRight(showAndHideSeven);
        
        /*** BUTTONS ***/
        Button newObjectSeven = new Button("New");
        newObjectSeven.setId("buttonSearch");
        HBox.setMargin(newObjectSeven, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedSeven = new Button("Remove Selected");
        removeSelectedSeven.setId("buttonSearch");
        HBox.setMargin(removeSelectedSeven, new Insets(0, 0, 0, 5));
        
        Button modifySelectedSeven = new Button("Modify Selected");
        modifySelectedSeven.setId("buttonSearch");
        HBox.setMargin(modifySelectedSeven, new Insets(0, 0, 0, 5));
        
        Button downloadSelectedSeven = new Button("Download Selected");
        downloadSelectedSeven.setId("buttonSearch");
        HBox.setMargin(downloadSelectedSeven, new Insets(0, 0, 0, 5));
        
        Label searchLabelSeven = new Label("Search:");
        searchLabelSeven.setId("searchBarText");
        searchLabelSeven.setMinHeight(30);
        searchLabelSeven.setMinWidth(50);
        HBox.setMargin(searchLabelSeven, new Insets(0, 8, 0, 35));
        searchLabelSeven.setAlignment(Pos.CENTER);
        
        TextField searchSeven = new TextField();
        searchSeven.setId("searchBar");
        //searchSeven.setPromptText("");
        searchSeven.setMinHeight(25);
        searchSeven.setMinWidth(184);
        HBox.setMargin(searchSeven, new Insets(5, 0, 5, 0));
        
        HBox setSevenHeadB = new HBox();
        setSevenHeadB.getChildren().setAll(newObjectSeven, removeSelectedSeven, modifySelectedSeven, downloadSelectedSeven, searchLabelSeven, searchSeven);
        setSevenHeadB.setId("headerBlockB");
        setSevenHeadB.managedProperty().bind(setSevenHeadB.visibleProperty());
        setSevenHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE SEVEN ***/
        fileUploadTable = new TableView();
        
        /*** COLUMNS SEVEN ***/
        TableColumn fileUploadIdSeven = new TableColumn("Upload ID");
        fileUploadIdSeven.prefWidthProperty().bind(fileUploadTable.widthProperty().multiply(0.1));
        fileUploadIdSeven.setReorderable(false);
        
        TableColumn fileNameSeven = new TableColumn("File Name");
        fileNameSeven.prefWidthProperty().bind(fileUploadTable.widthProperty().multiply(0.1));
        fileNameSeven.setReorderable(false);
        
        TableColumn fileTypeSeven = new TableColumn("File Type");
        fileTypeSeven.prefWidthProperty().bind(fileUploadTable.widthProperty().multiply(0.1));
        fileTypeSeven.setReorderable(false);
        
        TableColumn orderSeven = new TableColumn("Order");
        orderSeven.prefWidthProperty().bind(fileUploadTable.widthProperty().multiply(0.1));
        orderSeven.setReorderable(false);
        
        fileUploadTable.getColumns().setAll(fileUploadIdSeven, fileNameSeven, fileTypeSeven, orderSeven);
        
        final ObservableList<FileUploadObject> tableDatafileUploadSeven = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        fileUploadTable.setItems(tableDatafileUploadSeven);

        
        //SET SEVEN HUB
        ScrollPane contentSevenOrg = new ScrollPane(fileUploadTable); //Holds organizer buttons
        contentSevenOrg.setId("barBody");
        contentSevenOrg.managedProperty().bind(contentSevenOrg.visibleProperty());
        contentSevenOrg.setFitToWidth(true);
        
        fileUploadTable.setId("table");
        fileUploadTable.prefWidthProperty().bind(contentSevenOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilitySeven = new DisplayTable();
        
        showAndHideSeven.setOnAction((ActionEvent e) -> {
            tableVisibilitySeven.updateShowHide();
            
            setSevenHeadB.setVisible(tableVisibilitySeven.getVisibility());
            contentSevenOrg.setVisible(tableVisibilitySeven.getVisibility());
        });
        
        //BODY HUB
        VBox setSevenBody = new VBox(setSevenHeadA, setSevenHeadB, contentSevenOrg);
        VBox.setMargin(setSevenBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET EIGHT
        Label HeaderEight = new Label("Diagnostic Reports");
        HeaderEight.setId("searchHeader");
        HeaderEight.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderEight, new Insets(0, 50, 0, 0));
        
        Button showAndHideEight = new Button("+");
        showAndHideEight.setId("buttonBar");
        showAndHideEight.setPrefHeight(48);
        showAndHideEight.setPrefWidth(48);
        
        BorderPane setEightHeadA = new BorderPane();
        setEightHeadA.setId("barHeader");
        setEightHeadA.setCenter(HeaderEight);
        setEightHeadA.setRight(showAndHideEight);
        
        /*** BUTTONS ***/
        Button newObjectEight = new Button("New");
        newObjectEight.setId("buttonSearch");
        HBox.setMargin(newObjectEight, new Insets(0, 0, 0, 30));
        
        //NEW BUTTON BELOW VVV
        
        Button removeSelectedEight = new Button("Remove Selected");
        removeSelectedEight.setId("buttonSearch");
        HBox.setMargin(removeSelectedEight, new Insets(0, 0, 0, 5));
        
        Button modifySelectedEight = new Button("Modify Selected");
        modifySelectedEight.setId("buttonSearch");
        HBox.setMargin(modifySelectedEight, new Insets(0, 0, 0, 5));
        
        Label searchLabelEight = new Label("Search:");
        searchLabelEight.setId("searchBarText");
        searchLabelEight.setMinHeight(30);
        searchLabelEight.setMinWidth(50);
        HBox.setMargin(searchLabelEight, new Insets(0, 8, 0, 35));
        searchLabelEight.setAlignment(Pos.CENTER);
        
        TextField searchEight = new TextField();
        searchEight.setId("searchBar");
        //searchEight.setPromptText("");
        searchEight.setMinHeight(25);
        searchEight.setMinWidth(184);
        HBox.setMargin(searchEight, new Insets(5, 0, 5, 0));
        
        HBox setEightHeadB = new HBox();
        setEightHeadB.getChildren().setAll(newObjectEight, removeSelectedEight, modifySelectedEight, searchLabelEight, searchEight);
        setEightHeadB.setId("headerBlockB");
        setEightHeadB.managedProperty().bind(setEightHeadB.visibleProperty());
        setEightHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE EIGHT ***/
        diagReportTable = new TableView();
        
        /*** COLUMNS EIGHT ***/
        TableColumn diagnosReportIdEight = new TableColumn("Diangnostic Report ID");
        diagnosReportIdEight.prefWidthProperty().bind(diagReportTable.widthProperty().multiply(0.1));
        diagnosReportIdEight.setReorderable(false);
        
        TableColumn radiologistEight = new TableColumn("Radiologist");
        radiologistEight.prefWidthProperty().bind(diagReportTable.widthProperty().multiply(0.1));
        radiologistEight.setReorderable(false);
        
        TableColumn orderEight = new TableColumn("Order");
        orderEight.prefWidthProperty().bind(diagReportTable.widthProperty().multiply(0.1));
        orderEight.setReorderable(false);
        
        TableColumn reportEight = new TableColumn("Report");
        reportEight.prefWidthProperty().bind(diagReportTable.widthProperty().multiply(0.1));
        reportEight.setReorderable(false);
        
        diagReportTable.getColumns().setAll(diagnosReportIdEight, radiologistEight, orderEight, reportEight);
        
        final ObservableList<ReportObject> tableDataDiagReportEight = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        diagReportTable.setItems(tableDataDiagReportEight);
        
        //SET EIGHT HUB
        ScrollPane contentEightOrg = new ScrollPane(diagReportTable);    
        contentEightOrg.setId("barBody");
        contentEightOrg.managedProperty().bind(contentEightOrg.visibleProperty());
        contentEightOrg.setFitToWidth(true);
        
        diagReportTable.setId("table");
        diagReportTable.prefWidthProperty().bind(contentEightOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityEight = new DisplayTable();
        
        showAndHideEight.setOnAction((ActionEvent e) -> {
            tableVisibilityEight.updateShowHide();
            
            setEightHeadB.setVisible(tableVisibilityEight.getVisibility());
            contentEightOrg.setVisible(tableVisibilityEight.getVisibility());
        });
        
        //BODY HUB
        VBox setEightBody = new VBox(setEightHeadA, setEightHeadB, contentEightOrg);
        VBox.setMargin(setEightBody, new Insets(40, 80, 40, 80));
        /**************************************************/
        
        //BODY LAYER HUB
        VBox verticalHub = new VBox(setOneBody, setTwoBody, setThreeBody, setFourBody, setFiveBody, setSixBody, setSevenBody, setEightBody); 
        //SCENE LAYOUT
        rootBox.getChildren().setAll(toolBarHub, verticalHub);
        
        scrollPane.setId("barBody");
        scrollPane.setFitToWidth(true);
        
        home.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
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
        Label user = new Label("Logged in: Admin -name-");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBarSub");
        
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
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        Button showAndHideOne = new Button("+");
        showAndHideOne.setId("buttonBar");
        showAndHideOne.setPrefHeight(48);
        showAndHideOne.setPrefWidth(48);
        
        BorderPane setOneHeadA = new BorderPane();
        setOneHeadA.setId("barHeader");
        setOneHeadA.setCenter(HeaderOne);
        setOneHeadA.setRight(showAndHideOne);
        
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
        searchLabelOne.setId("searchBarText");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        searchOne.setId("searchBar");
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(newObjectOne, removeSelectedOne, modifySelectedOne, searchLabelOne, searchOne);
        setOneHeadB.setId("headerBlockB");
        setOneHeadB.managedProperty().bind(setOneHeadB.visibleProperty());
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE ONE ***/
        patientTable = new TableView();
        
        /*** COLUMNS ONE ***/
        patientTable.getItems().clear(); //REPLACE WITH setAll(columns);
        
        //TableColumn
        TableColumn firstNameOne = new TableColumn("First Name");
        firstNameOne.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        firstNameOne.setReorderable(false);
        
        TableColumn lastNameOne = new TableColumn("Last Name");
        lastNameOne.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        lastNameOne.setReorderable(false);
        
        TableColumn dateOfBirthOne = new TableColumn("Date of Birth");
        dateOfBirthOne.prefWidthProperty().bind(patientTable.widthProperty().multiply(0.1));
        dateOfBirthOne.setReorderable(false);
        
        patientTable.getColumns().setAll(firstNameOne, lastNameOne, dateOfBirthOne);
        
        final ObservableList<PatientObject> tableDataPatientOne = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        patientTable.setItems(tableDataPatientOne);
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(patientTable); 
        contentOneOrg.setId("barBody");
        contentOneOrg.managedProperty().bind(contentOneOrg.visibleProperty());
        contentOneOrg.setFitToWidth(true);
        
        patientTable.setId("table");
        patientTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityOne = new DisplayTable();
        
        showAndHideOne.setOnAction((ActionEvent e) -> {
            tableVisibilityOne.updateShowHide();
            
            setOneHeadB.setVisible(tableVisibilityOne.getVisibility());
            contentOneOrg.setVisible(tableVisibilityOne.getVisibility());
        });
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(40, 80, 40, 80));
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
        Label user = new Label("Logged in: Admin -name-");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBarSub");
        
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
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        Button showAndHideOne = new Button("+");
        showAndHideOne.setId("buttonBar");
        showAndHideOne.setPrefHeight(48);
        showAndHideOne.setPrefWidth(48);
        
        BorderPane setOneHeadA = new BorderPane();
        setOneHeadA.setId("barHeader");
        setOneHeadA.setCenter(HeaderOne);
        setOneHeadA.setRight(showAndHideOne);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBarText");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        searchOne.setId("searchBar");
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        setOneHeadB.setId("headerBlockB");
        setOneHeadB.managedProperty().bind(setOneHeadB.visibleProperty());
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE ONE ***/
        appointTable = new TableView();
        
        /*** COLUMNS ONE ***/
        appointTable.getItems().clear();
        
        //COLUMNS
        TableColumn patientOne = new TableColumn("Patient");
        patientOne.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        patientOne.setReorderable(false);
        
        TableColumn modalityOne = new TableColumn("Modality");
        modalityOne.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        modalityOne.setReorderable(false);
        
        TableColumn dateAndTimeOne = new TableColumn("Date and Time");
        dateAndTimeOne.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        dateAndTimeOne.setReorderable(false);
        
        TableColumn radiologistOne = new TableColumn("Radiologist");
        radiologistOne.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        dateAndTimeOne.setReorderable(false);
        
        TableColumn technicianOne = new TableColumn("Technician");
        technicianOne.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        technicianOne.setReorderable(false);
        
        appointTable.getColumns().setAll(patientOne, modalityOne, dateAndTimeOne, radiologistOne, technicianOne);
        
        final ObservableList<AppointmentObject> tableDataAppointmentOne = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        appointTable.setItems(tableDataAppointmentOne);
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(appointTable); 
        contentOneOrg.setId("barBody");
        contentOneOrg.managedProperty().bind(contentOneOrg.visibleProperty());
        contentOneOrg.setFitToWidth(true);
        
        appointTable.setId("table");
        appointTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityOne = new DisplayTable();
        
        showAndHideOne.setOnAction((ActionEvent e) -> {
            tableVisibilityOne.updateShowHide();
            
            setOneHeadB.setVisible(tableVisibilityOne.getVisibility());
            contentOneOrg.setVisible(tableVisibilityOne.getVisibility());
        });
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(40, 80, 40, 80));
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
        Label user = new Label("Logged in: Admin -name-");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBarSub");
        
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
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        Button showAndHideOne = new Button("+");
        showAndHideOne.setId("buttonBar");
        showAndHideOne.setPrefHeight(48);
        showAndHideOne.setPrefWidth(48);
        
        BorderPane setOneHeadA = new BorderPane();
        setOneHeadA.setId("barHeader");
        setOneHeadA.setCenter(HeaderOne);
        setOneHeadA.setRight(showAndHideOne);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBarText");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        searchOne.setId("searchBar");
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        setOneHeadB.setId("headerBlockB");
        setOneHeadB.managedProperty().bind(setOneHeadB.visibleProperty());
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE ONE ***/
        orderTable = new TableView();
        
        /*** COLUMNS ONE ***/
        orderTable.getItems().clear();
        
        TableColumn patientOne = new TableColumn("Patient");
        patientOne.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        patientOne.setReorderable(false);
        
        TableColumn modalityOne = new TableColumn("Modality");
        modalityOne.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        modalityOne.setReorderable(false);
        
        TableColumn notesOne = new TableColumn("Notes");
        notesOne.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        notesOne.setReorderable(false);
        
        TableColumn statusOne = new TableColumn("Status");
        statusOne.prefWidthProperty().bind(orderTable.widthProperty().multiply(0.1));
        statusOne.setReorderable(false);
        
        orderTable.getColumns().setAll(patientOne, modalityOne, notesOne, statusOne);
        
        final ObservableList<OrderObject> tableDataOrderOne = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        orderTable.setItems(tableDataOrderOne);
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(orderTable); //Holds organizer buttons
        contentOneOrg.setId("barBody");
        contentOneOrg.managedProperty().bind(contentOneOrg.visibleProperty());
        contentOneOrg.setFitToWidth(true);
        
        orderTable.setId("table");
        orderTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityOne = new DisplayTable();
        
        showAndHideOne.setOnAction((ActionEvent e) -> {
            tableVisibilityOne.updateShowHide();
            
            setOneHeadB.setVisible(tableVisibilityOne.getVisibility());
            contentOneOrg.setVisible(tableVisibilityOne.getVisibility());
        });
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(40, 80, 40, 80));
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
        Label user = new Label("Logged in: Admin -name-");
        user.setMaxHeight(25);
        user.setMinWidth(25);
        
        user.setId("buttonBarSub");
        
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
        HeaderOne.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderOne, new Insets(0, 50, 0, 0));
        
        Button showAndHideOne = new Button("+");
        showAndHideOne.setId("buttonBar");
        showAndHideOne.setPrefHeight(48);
        showAndHideOne.setPrefWidth(48);
        
        BorderPane setOneHeadA = new BorderPane();
        setOneHeadA.setId("barHeader");
        setOneHeadA.setCenter(HeaderOne);
        setOneHeadA.setRight(showAndHideOne);
        
        Label searchLabelOne = new Label("Search:");
        searchLabelOne.setId("searchBarText");
        searchLabelOne.setMinHeight(30);
        searchLabelOne.setMinWidth(50);
        HBox.setMargin(searchLabelOne, new Insets(0, 8, 0, 35));
        searchLabelOne.setAlignment(Pos.CENTER);
        
        TextField searchOne = new TextField();
        searchOne.setId("searchBar");
        //searchOne.setPromptText("");
        searchOne.setMinHeight(25);
        searchOne.setMinWidth(184);
        HBox.setMargin(searchOne, new Insets(5, 0, 5, 0));
        
        HBox setOneHeadB = new HBox();
        setOneHeadB.getChildren().setAll(searchLabelOne, searchOne);
        setOneHeadB.setId("headerBlockB");
        setOneHeadB.managedProperty().bind(setOneHeadB.visibleProperty());
        setOneHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE ONE ***/
        invoiceTable = new TableView();
        
        /*** COLUMNS ONE ***/
        invoiceTable.getItems().clear();
        
        TableColumn costOne = new TableColumn("Cost");
        costOne.prefWidthProperty().bind(invoiceTable.widthProperty().multiply(0.1));
        costOne.setReorderable(false);
        
        TableColumn modalityOne = new TableColumn("Modality");
        modalityOne.prefWidthProperty().bind(invoiceTable.widthProperty().multiply(0.1));
        modalityOne.setReorderable(false);
        
        TableColumn dateAndTimeOne = new TableColumn("Date and Time");
        dateAndTimeOne.prefWidthProperty().bind(invoiceTable.widthProperty().multiply(0.1));
        dateAndTimeOne.setReorderable(false);
        
        TableColumn radiologistOne = new TableColumn("Radiologist");
        radiologistOne.prefWidthProperty().bind(invoiceTable.widthProperty().multiply(0.1));
        radiologistOne.setReorderable(false);
        
        TableColumn technicianOne = new TableColumn("Technician");
        technicianOne.prefWidthProperty().bind(invoiceTable.widthProperty().multiply(0.1));
        technicianOne.setReorderable(false);
        
        TableColumn patientOne = new TableColumn("Patient");
        patientOne.prefWidthProperty().bind(invoiceTable.widthProperty().multiply(0.1));
        patientOne.setReorderable(false);
        
        invoiceTable.getColumns().setAll(costOne, modalityOne, dateAndTimeOne, radiologistOne, technicianOne, patientOne);
        
        final ObservableList<InvoiceObject> tableDataInvoiceOne = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        invoiceTable.setItems(tableDataInvoiceOne);
        
        //SET ONE HUB
        ScrollPane contentOneOrg = new ScrollPane(invoiceTable);
        contentOneOrg.setId("barBody");
        contentOneOrg.managedProperty().bind(contentOneOrg.visibleProperty());
        contentOneOrg.setFitToWidth(true);
        
        invoiceTable.setId("table");
        invoiceTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
      
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityOne = new DisplayTable();
        
        showAndHideOne.setOnAction((ActionEvent e) -> {
            tableVisibilityOne.updateShowHide();
            
            setOneHeadB.setVisible(tableVisibilityOne.getVisibility());
            contentOneOrg.setVisible(tableVisibilityOne.getVisibility());
        });
        
        //BODY HUB
        VBox setOneBody = new VBox(setOneHeadA, setOneHeadB, contentOneOrg);
        VBox.setMargin(setOneBody, new Insets(40, 80, 0, 80));
        /**************************************************/
        
        //HEAD OF SET TWO
        Label HeaderTwo = new Label("Appointments");
        HeaderTwo.setId("searchHeader");
        HeaderTwo.setAlignment(Pos.CENTER);
        HBox.setMargin(HeaderTwo, new Insets(0, 50, 0, 0));
        
        Button showAndHideTwo = new Button("+");
        showAndHideTwo.setId("buttonBar");
        showAndHideTwo.setPrefHeight(48);
        showAndHideTwo.setPrefWidth(48);
        
        BorderPane setTwoHeadA = new BorderPane();
        setTwoHeadA.setId("barHeader");
        setTwoHeadA.setCenter(HeaderTwo);
        setTwoHeadA.setRight(showAndHideTwo);
        
        Label searchLabelTwo = new Label("Search:");
        searchLabelTwo.setId("searchBarText");
        searchLabelTwo.setMinHeight(30);
        searchLabelTwo.setMinWidth(50);
        HBox.setMargin(searchLabelTwo, new Insets(0, 8, 0, 35));
        searchLabelTwo.setAlignment(Pos.CENTER);
        
        TextField searchTwo = new TextField();
        searchTwo.setId("searchBar");
        //searchTwo.setPromptText("");
        searchTwo.setMinHeight(25);
        searchTwo.setMinWidth(184);
        HBox.setMargin(searchTwo, new Insets(5, 0, 5, 0));
        
        HBox setTwoHeadB = new HBox();
        setTwoHeadB.getChildren().setAll(searchLabelTwo, searchTwo);
        setTwoHeadB.setId("headerBlockB");
        setTwoHeadB.managedProperty().bind(setTwoHeadB.visibleProperty());
        setTwoHeadB.setAlignment(Pos.CENTER_LEFT);
        
        /*** TABLE TWO ***/
        appointTable = new TableView();
        
        /*** COLUMNS TWO ***/
        appointTable.getItems().clear();
        
        TableColumn patientTwo = new TableColumn("Patient");
        patientTwo.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        patientTwo.setReorderable(false);
        
        TableColumn modalityTwo = new TableColumn("Modality");
        modalityTwo.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        modalityTwo.setReorderable(false);
        
        TableColumn dateAndTimeTwo = new TableColumn("Date and Time");
        dateAndTimeTwo.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        dateAndTimeTwo.setReorderable(false);
        
        TableColumn radiologistTwo = new TableColumn("Radiologist");
        radiologistTwo.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        radiologistTwo.setReorderable(false);
        
        TableColumn technicianTwo = new TableColumn("Technician");
        technicianTwo.prefWidthProperty().bind(appointTable.widthProperty().multiply(0.1));
        technicianTwo.setReorderable(false);
        
        appointTable.getColumns().setAll(patientTwo, modalityTwo, dateAndTimeTwo, radiologistTwo, technicianTwo);
        
        final ObservableList<AppointmentObject> tableDataAppointmentTwo = FXCollections.observableArrayList();

        //EX of existing column name (patientTwo). Make sure you use names of columns in the local set.
        //&-column_name-&.setCellValueFactory(
        //new PropertyValueFactory<class_name,String>("variable_name")
        //);

        appointTable.setItems(tableDataAppointmentTwo);
        
        //SET TWO HUB
        ScrollPane contentTwoOrg = new ScrollPane(appointTable);
        contentTwoOrg.setId("barBody");
        contentTwoOrg.managedProperty().bind(contentTwoOrg.visibleProperty());
        contentTwoOrg.setFitToWidth(true);
        
        appointTable.setId("table");
        appointTable.prefWidthProperty().bind(contentOneOrg.widthProperty());
        
        //SHOW-HIDE FUNCTION
        DisplayTable tableVisibilityTwo = new DisplayTable();
        
        showAndHideTwo.setOnAction((ActionEvent e) -> {
            tableVisibilityTwo.updateShowHide();
            
            setTwoHeadB.setVisible(tableVisibilityTwo.getVisibility());
            contentTwoOrg.setVisible(tableVisibilityTwo.getVisibility());
        });
        
        //BODY HUB
        VBox setTwoBody = new VBox(setTwoHeadA, setTwoHeadB, contentTwoOrg);
        VBox.setMargin(setTwoBody, new Insets(40, 80, 40, 80));
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
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        homeScene.setOnAction(null);
        homepageSceneCollection();
    }
    
    private void adminSceneAction(ActionEvent actionEvent) {
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        adminScene.setOnAction(null);
        adminSceneCollection();
    }
    
    private void referralSceneAction(ActionEvent actionEvent) {
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        referralScene.setOnAction(null);
        referralSceneCollection();
    }
    
    private void appointmentSceneAction(ActionEvent actionEvent) {
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        appointmentScene.setOnAction(null);
        appointmentSceneCollection();
    }
    
    private void orderSceneAction(ActionEvent actionEvent) {
        setSceneSize(super.getScene().getHeight(), super.getScene().getWidth());
        orderScene.setOnAction(null);
        orderSceneCollection();
    }
    
    private void invoiceSceneAction(ActionEvent actionEvent) {
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
    
    private void popupConfirm(VBox box2, Stage stage2) {
        VBox rootPopupConfirm = new VBox();
        rootPopupConfirm.setId("popUp");
        
        //ELEMENTS
        Label warningText = new Label("Are you sure about these changes? Select 'confirm' if yes.");
        Button confirmButtonPopConf = new Button("Confirm");
        Button cancelButtonPopConf = new Button("Cancel");
        
        rootPopupConfirm.getChildren().setAll(warningText, confirmButtonPopConf, cancelButtonPopConf);
        
        Scene scenePopupConfirm = new Scene(rootPopupConfirm, 500, 500);
        scenePopupConfirm.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cAdm.css");
        
        Stage stagePopupConfirm = new Stage();
        stagePopupConfirm.initOwner(stage2);
        stagePopupConfirm.initModality(Modality.WINDOW_MODAL);
        
        box2.disableProperty().bind(stagePopupConfirm.showingProperty());
        stagePopupConfirm.setScene(scenePopupConfirm);
        
        stagePopupConfirm.show();
        
        confirmButtonPopConf.setOnAction((ActionEvent e) -> {
            setConfirmation(true);    
            stagePopupConfirm.close();
                
        });
        
        cancelButtonPopConf.setOnAction((ActionEvent e) -> {
            setConfirmation(false);    
            stagePopupConfirm.close();
                
        });
        

    }
    
    private boolean confirmation;
    
    private void setConfirmation(boolean confirmationRes) {
        confirmation = confirmationRes;
    }
    
    private boolean getConfirmation() {
        return confirmation;
    }
    
    //TABLE TESTS FIXME: DELETE ME
    private void addTableTestSUO(ObservableList<SystemUserObject> B) {
        B.add(new SystemUserObject());
    }
    
    
    
}

class DisplayTable {
    
    private boolean displayTableValue;
            
    DisplayTable() {
        this.displayTableValue = true;
    }
    
    protected boolean updateShowHide() {
        this.displayTableValue = !displayTableValue;
        return this.displayTableValue;
    }
    
    protected boolean getVisibility() {
        return this.displayTableValue;
    }
}

class popupAdmin {
    
    popupAdmin(Stage ogStageAdm, VBox box, ObservableList<SystemUserObject> A) {
        AnchorPane rootAddPopupAdm = new AnchorPane();
        rootAddPopupAdm.setId("popup");
        
        //ELEMENTS
        Label bannerPopAdm = new Label("NEW SYSTEM USER");
        bannerPopAdm.setPrefHeight(33);
        bannerPopAdm.setLayoutX(0);
        bannerPopAdm.setLayoutY(0);
        bannerPopAdm.setId("popupLabel");
            
        Label firstNamePopAddAdmL = new Label("First Name:");
        firstNamePopAddAdmL.setLayoutX(51);
        firstNamePopAddAdmL.setLayoutY(56);
        
        TextField firstNamePopAddAdmF = new TextField();
        firstNamePopAddAdmF.setMaxWidth(150);
        firstNamePopAddAdmF.setLayoutX(120);
        firstNamePopAddAdmF.setLayoutY(52);
        firstNamePopAddAdmF.setId("popupField");
            
        Label lastNamePopAddAdmL = new Label("Last Name:");
        lastNamePopAddAdmL.setLayoutX(52);
        lastNamePopAddAdmL.setLayoutY(87);
        
        TextField lastNamePopAddAdmF = new TextField();
        lastNamePopAddAdmF.setMaxWidth(150);
        lastNamePopAddAdmF.setLayoutX(120);
        lastNamePopAddAdmF.setLayoutY(83);
        lastNamePopAddAdmF.setId("popupField");
            
        Label emailPopAddAdmL = new Label("Email:");
        emailPopAddAdmL.setLayoutX(79);
        emailPopAddAdmL.setLayoutY(118);
        
        TextField emailPopAddAdmF = new TextField();
        emailPopAddAdmF.setMaxWidth(150);
        emailPopAddAdmF.setLayoutX(120);
        emailPopAddAdmF.setLayoutY(114);
        emailPopAddAdmF.setId("popupField");
            
        Label usernamePopAddAdmL = new Label("Username:");
        usernamePopAddAdmL.setLayoutX(54);
        usernamePopAddAdmL.setLayoutY(171);
        
        TextField usernamePopAddAdmF = new TextField();
        usernamePopAddAdmF.setPromptText("Username...");
        usernamePopAddAdmF.setMaxWidth(150);
        usernamePopAddAdmF.setLayoutX(120);
        usernamePopAddAdmF.setLayoutY(167);
        usernamePopAddAdmF.setId("popupField");
            
        Label passwordPopAddAdmL = new Label("Password:");
        passwordPopAddAdmL.setLayoutX(56);
        passwordPopAddAdmL.setLayoutY(204);
        
        TextField passwordPopAddAdmF = new TextField();
        passwordPopAddAdmF.setPromptText("Password...");
        passwordPopAddAdmF.setMaxWidth(150);
        passwordPopAddAdmF.setLayoutX(120);
        passwordPopAddAdmF.setLayoutY(200);
        passwordPopAddAdmF.setId("popupField");
            
        Label systemRoleAddAdm = new Label("Role:");
        systemRoleAddAdm.setLayoutX(82);
        systemRoleAddAdm.setLayoutY(251);
        
        ComboBox comboBoxPopAddAdmB = new ComboBox();
        comboBoxPopAddAdmB.getItems().setAll("Admin", "Doctor", "Technician", "Radiologist", "Receptionist", "User", "Billing");
        comboBoxPopAddAdmB.setPromptText("Select Role");
        comboBoxPopAddAdmB.setMinWidth(150);
        comboBoxPopAddAdmB.setLayoutX(120);
        comboBoxPopAddAdmB.setLayoutY(247);
        comboBoxPopAddAdmB.setId("popupFieldB");
          
        Button buttonConfirmAddAdm = new Button("Confirm");
        buttonConfirmAddAdm.setId("popupFieldButton");
        buttonConfirmAddAdm.setLayoutX(82);
        buttonConfirmAddAdm.setLayoutY(294);
        
        Button buttonCancelAddAdm = new Button("Cancel");
        buttonCancelAddAdm.setId("popupFieldButton");
        buttonCancelAddAdm.setLayoutX(182);
        buttonCancelAddAdm.setLayoutY(294);
            
        rootAddPopupAdm.getChildren().setAll(bannerPopAdm, firstNamePopAddAdmL, firstNamePopAddAdmF, lastNamePopAddAdmL, lastNamePopAddAdmF
                , emailPopAddAdmL, emailPopAddAdmF, usernamePopAddAdmL, usernamePopAddAdmF
                , passwordPopAddAdmL, passwordPopAddAdmF, systemRoleAddAdm, comboBoxPopAddAdmB
                , buttonConfirmAddAdm, buttonCancelAddAdm);
            
        Scene scenePopupAdm = new Scene(rootAddPopupAdm, 338, 349);
        scenePopupAdm.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cPop.css");
        
        Stage stagePopupAdm = new Stage();
        stagePopupAdm.initStyle(StageStyle.UNDECORATED);
        stagePopupAdm.initOwner(ogStageAdm);
        stagePopupAdm.setResizable(false);
        stagePopupAdm.initModality(Modality.WINDOW_MODAL);
        
        /*** STAGE RELIANT CUSTOMIZATIONS ***/
        bannerPopAdm.prefWidthProperty().bind(stagePopupAdm.widthProperty());
        
        box.disableProperty().bind(stagePopupAdm.showingProperty());
        stagePopupAdm.setScene(scenePopupAdm);
        
        buttonConfirmAddAdm.setOnAction((ActionEvent e) -> {
            //addTableTestSUO(A);
            A.add(new SystemUserObject());
            stagePopupAdm.close();
        });
            
        buttonCancelAddAdm.setOnAction((ActionEvent e) -> {
            stagePopupAdm.close();
        });
        
        stagePopupAdm.show();
    }
    
}
