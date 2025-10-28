module ALee_Assignment4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires junit;
    opens application to javafx.fxml, org.junit.platform.commons, junit;
}
