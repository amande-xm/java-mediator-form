module log121.amandine {
    requires javafx.controls;
    requires javafx.fxml;

    opens log121.amandine to javafx.fxml;
    exports log121.amandine;
}
