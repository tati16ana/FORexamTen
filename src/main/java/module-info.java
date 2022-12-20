module com.example.forexamten {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.forexamten to javafx.fxml;
    exports com.example.forexamten;
}