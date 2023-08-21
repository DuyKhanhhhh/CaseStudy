module com.example.casechat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.casechat to javafx.fxml;
    exports com.example.casechat;
}