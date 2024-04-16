module edu.uwi.soscai {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens edu.uwi.soscai to javafx.fxml;
    exports edu.uwi.soscai;
    opens edu.uwi.soscai.component to javafx.fxml;
    exports edu.uwi.soscai.component;
    opens edu.uwi.soscai.model to javafx.fxml;
    exports edu.uwi.soscai.model;
    opens edu.uwi.soscai.controller to javafx.fxml;
    exports edu.uwi.soscai.controller;
}
