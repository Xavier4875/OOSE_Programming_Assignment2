module org.example.programming_assignment_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.programming_assignment_2 to javafx.fxml;
    exports org.example.programming_assignment_2;
}