package log121.amandine;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FormMediator implements InterfaceMediator {

    private VBox container;
    private Object currentForm;
    private String selection = "Carte de crédit";

    public FormMediator(VBox container) {
        this.container = container;
    }

    // méthode pour afficher les champs de formulaire selon le type de paiement
    // sélectionné
    @Override
    public void onPaymentModeChanged(String mode) {
        container.getChildren().clear();
        this.selection = mode;
        switch (mode) {
            case "Carte de crédit":
                CreditCard credit = new CreditCard();
                this.currentForm = credit;
                container.getChildren().add(credit.getView());
                break;
            case "Carte cadeau":
                GiftCard gift = new GiftCard();
                this.currentForm = gift;
                container.getChildren().add(gift.getView());
                break;
            case "Paiement à la livraison":
                UponDelivery delivery = new UponDelivery();
                this.currentForm = delivery;
                container.getChildren().add(delivery.getView());
                break;
        }
    }

    // méthode pour fournir une liste de méthodes de livraison valides, en fonction
    // du choix de paiement de l'utilisateur précédemmment
    public String[] availableMethods() {
        String[] methods;
        if (selection.equals("Paiement à la livraison")) {
            methods = new String[] { "Livraison en main propre", "Se retrouver à l’extérieur" };
        } else {
            methods = new String[] { "Livraison en main propre", "Se retrouver à l’extérieur", "Laisser à la porte" };
        }
        return methods;
    }

    // méthode pour afficher le composant concernant les informations de livraison
    // se met à jour selon les choix de l'utilsateur
    public GridPane delivery() {
        container.getChildren().clear();
        GridPane addressesPane = new GridPane();

        Label deliveryAddr = new Label("Adresse de livraison :");
        TextField textAddr = new TextField();
        addressesPane.add(deliveryAddr, 0, 0);
        addressesPane.add(textAddr, 1, 0);

        RadioButton buttonDelivery = new RadioButton("L'adresse de facturation est la même que l'adresse de livraison");
        addressesPane.add(buttonDelivery, 0, 1, 2, 1);

        Label billingLabel = new Label("Adresse de facturation :");
        TextField billingText = new TextField();
        addressesPane.add(billingLabel, 0, 2);
        addressesPane.add(billingText, 1, 2);
        container.getChildren().add(addressesPane);

        buttonDelivery.setOnAction(event -> {
            boolean isSelected = buttonDelivery.isSelected();
            billingText.setDisable(isSelected);
            if (isSelected) {
                billingText.setText(textAddr.getText());
            } else {
                billingText.clear();
            }
        });

        return addressesPane;
    }

}
