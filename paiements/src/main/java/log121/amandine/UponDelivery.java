package log121.amandine;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UponDelivery {

    // méthode qui renvoie le composant d'interface avec les champs d'informations
    // pour un paiement à la livraison
    public GridPane getView() {

        GridPane form = new GridPane();
        form.setPadding(new Insets(10, 0, 10, 0)); // Un peu d'espace haut/bas

        Label reminder = new Label("Vous avez sélectionné le paiment à la livraison");
        form.add(reminder, 0, 0);

        return form;
    }
}
