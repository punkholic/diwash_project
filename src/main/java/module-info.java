module com.example.diwash {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports com.example.Controller;
    opens com.example.Controller to javafx.fxml;


    opens com.example.database.TableClasses to javafx.fxml, javafx.base;
    exports com.example.database.TableClasses;
}