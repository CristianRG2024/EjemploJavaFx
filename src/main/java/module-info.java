module com.mycompany.ejemplojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.ejemplojavafx to javafx.fxml;
    exports com.mycompany.ejemplojavafx;
}
