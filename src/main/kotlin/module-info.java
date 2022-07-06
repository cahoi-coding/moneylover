module app.moneylover {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.java;
    requires java.prefs;

    opens app.moneylover to javafx.fxml;
    opens app.moneylover.services to java.base, javafx.base, javafx.fxml;
    opens app.moneylover.controllers to java.base, javafx.base, javafx.fxml;
    opens app.moneylover.models to java.base, javafx.base, javafx.fxml;
    opens app.moneylover.repositories to java.base, javafx.base, javafx.fxml;
//    opens app.moneylover.router to java.base, javafx.base, javafx.fxml, java.compiler, javafx.controls, javafx.graphics, javafx.web;
    exports app.moneylover;
}