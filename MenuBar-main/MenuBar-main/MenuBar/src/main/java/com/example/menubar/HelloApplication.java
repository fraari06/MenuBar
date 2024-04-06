package com.example.menubar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Applicazione con Menu Bar");

        MenuBar menuBar = new MenuBar();

        VBox vBox = new VBox(menuBar);

        TextArea textArea = new TextArea();
        textArea.setEditable(false); // rendiamo l'area di testo non modificabile

        vBox.getChildren().add(textArea);

        Scene scene = new Scene(vBox, 960, 600);

        // Menu File
        Menu fileMenu = new Menu("File");
        MenuItem nuovoItem = createMenuItem("Nuovo", textArea);
        MenuItem apriItem = createMenuItem("Apri", textArea);
        MenuItem salvaItem = createMenuItem("Salva", textArea);
        MenuItem chiudiItem = createMenuItem("Chiudi", textArea);
        Menu esportaMenu = new Menu("Esporta");
        MenuItem pdfItem = createMenuItem("pdf", textArea);
        MenuItem csvItem = createMenuItem("csv", textArea);
        MenuItem stampaItem = createMenuItem("Stampa", textArea);
        MenuItem esciItem = new MenuItem("Esci");
        esciItem.setOnAction(event -> {
            textArea.appendText("Esci selezionato\n");
            primaryStage.close();
        });

        fileMenu.getItems().addAll(nuovoItem, apriItem, salvaItem, chiudiItem,
                esportaMenu, stampaItem, esciItem);
        esportaMenu.getItems().addAll(pdfItem, csvItem);

        // Menu Modifica
        Menu modificaMenu = new Menu("Modifica");
        MenuItem annullaItem = createMenuItem("Annulla", textArea);

        modificaMenu.getItems().add(annullaItem);

        // Menu Informazioni
        Menu informazioniMenu = new Menu("Informazioni");
        MenuItem versioneItem = createMenuItem("Versione", textArea);
        MenuItem creditsItem = createMenuItem("Credits", textArea);

        informazioniMenu.getItems().addAll(versioneItem, creditsItem);

        menuBar.getMenus().addAll(fileMenu, modificaMenu, informazioniMenu);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuItem createMenuItem(String label, TextArea textArea) {
        MenuItem menuItem = new MenuItem(label);
        menuItem.setOnAction(event -> textArea.appendText(label + " selezionato\n"));
        return menuItem;
    }
}