module org.example.countrycapitalquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.jsoup;
    requires java.net.http;


    opens org.example.countrycapitalquiz to javafx.fxml;
    exports org.example.countrycapitalquiz;
}