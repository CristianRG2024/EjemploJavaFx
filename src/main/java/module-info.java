module com.mycompany.ejemplojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
   requires org.json;
    

    opens com.mycompany.ejemplojavafx to javafx.fxml;
    exports Modelo;
    exports com.mycompany.ejemplojavafx;
}
    