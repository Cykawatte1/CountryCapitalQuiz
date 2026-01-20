module org.example.countrycapitalquiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.countrycapitalquiz to javafx.fxml;
    exports org.example.countrycapitalquiz;
}