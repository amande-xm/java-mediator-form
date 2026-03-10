package log121.amandine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {

        // création de la fenêtre sous forme d'un tableau
        GridPane window = new GridPane();
        window.setPadding(new Insets(20));
        window.setHgap(10);
        window.setVgap(15);

        // création du titre du formulaire
        Label title = new Label("Paramètres pour la visualisation d'un tri");
        title.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        window.add(title, 0, 0, 2, 1);

        // création de la sélection du mode de paiement
        Label paymentMode = new Label("Mode de paiement :");
        ComboBox<String> comboMode = new ComboBox<>();
        comboMode.getItems().addAll("Carte de crédit", "Carte cadeau", "Paiement à la livraison");

        // sélection par défaut du premier mode de paiement
        comboMode.getSelectionModel().selectFirst();

        // ajout du mode de paiement à la fenêtre
        window.add(paymentMode, 0, 1);
        window.add(comboMode, 1, 1);

        // création du conteneur pour afficher les infos selon le mode de paiement
        // choisi
        VBox content = new VBox();
        window.add(content, 0, 2, 2, 1);

        // création du mediator
        FormMediator mediator = new FormMediator(content);

        Label deliveryMode = new Label("Option de livraison :");
        ComboBox<String> comboDelivery = new ComboBox<>();
        comboDelivery.getItems().addAll("Livraison en main propre", "Se retrouver à l’extérieur", "Laisser à la porte");
        window.add(deliveryMode, 0, 7);
        window.add(comboDelivery, 1, 7);

        // création de l'action listener sur le choix du mode de paiement
        comboMode.setOnAction(event -> {

            // appel du mediator pour gérer l'affichage du formulaire selon le mode de
            // paiement choisi
            mediator.onPaymentModeChanged(comboMode.getValue());
            comboDelivery.getItems().setAll(mediator.availableMethods());
        });

        // affichage du formulaire pour la première sélection avant que l'utilisateur ne
        // clique dessus
        comboMode.fireEvent(new javafx.event.ActionEvent());

        // création d'une VBox pour contenir les informations de livraison
        VBox addrVBox = new VBox();
        window.add(addrVBox, 0, 3, 2, 1);

        // création d'un deuxième médiateur pour gérer les informations de livraison
        FormMediator addrMediator = new FormMediator(addrVBox);

        // appel de la fonction d'affichage dynamique des informations de livraison du
        // médiateur
        addrMediator.delivery();

        // ajout de chaque composant à la scène et affichage
        Scene scene = new Scene(window, 500, 400);
        primaryStage.setTitle("Paiement de la commande");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}