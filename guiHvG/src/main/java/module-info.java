module com.example.guihvg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guihvg to javafx.fxml;
    exports com.example.guihvg;
}