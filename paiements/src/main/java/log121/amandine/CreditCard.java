package log121.amandine;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreditCard {

    // méthode qui renvoie le composant d'interface avec les champs d'informations
    // pour un paiement par carte de crédit
    public GridPane getView() {
        GridPane form = new GridPane();
        form.setPadding(new Insets(10, 0, 10, 0)); // Un peu d'espace haut/bas

        Label labelNum = new Label("Numéro de carte de crédit :");
        TextField textNum = new TextField();
        form.add(labelNum, 0, 0);
        form.add(textNum, 1, 0);

        Label labelDate = new Label("Date d'expiration :");
        TextField textDate = new TextField();
        // textDate.setPromptText("MM/AA"); // Petit texte d'aide gris
        form.add(labelDate, 0, 1);
        form.add(textDate, 1, 1);

        Label labelCode = new Label("Code de sécurité :");
        TextField textCode = new TextField();
        form.add(labelCode, 0, 2);
        form.add(textCode, 1, 2);

        return form;
    }

}
