package log121.amandine;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GiftCard {

    // méthode qui renvoie le composant d'interface avec les champs d'informations
    // pour un paiement par carte cadeau
    public GridPane getView() {
        GridPane form = new GridPane();
        form.setPadding(new Insets(10, 0, 10, 0)); // Un peu d'espace haut/bas

        Label labelNum = new Label("Numéro de la carte cadeau");
        TextField textNum = new TextField();
        form.add(labelNum, 0, 0);
        form.add(textNum, 1, 0);

        return form;
    }
}
