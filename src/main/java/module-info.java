module com.example.sp3gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.sp3gui to javafx.fxml;
    exports com.example.sp3gui;
}