// module-info.java
module jdojo.javafx {
    requires javafx.controls;
    
    requires javafx.fxml;
    
    // Must export this package to at least javafx.graphics module
    // Otherwise, your JavaFX application will not run
    exports com.jdojo.javafx;
}
