module com.example.battlearena {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.battlearena to javafx.fxml;
    exports com.example.battlearena;
    exports com.example.battlearena.models;
    opens com.example.battlearena.models to javafx.fxml;
}