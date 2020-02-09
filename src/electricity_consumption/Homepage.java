package electricity_consumption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Homepage extends Application {
    //start method is main entry point for application. 
    //Stage is top-level container.
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Electricity Consumption");

        //GridPane for flexible layout of controls in rows and columns
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //Horizontal space between columns
        grid.setVgap(10); //Vertical space between rows
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btn1 = new Button("Insert Data");
        grid.add(btn1, 0, 0);
        
        Button btn2 = new Button("Search a date");
        grid.add(btn2, 0, 1);
        
        Button btn3 = new Button("See total bar chart");
        grid.add(btn3, 0, 2);
        
        // Event handling for button
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Insert_data_display insertdata = new Insert_data_display();
                insertdata.start(primaryStage);
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Search_data_display searchdate = new Search_data_display();
                searchdate.start(primaryStage);
            }
        });

        //Scene is container for all content 
        
        Scene scene = new Scene(grid, 500, 475);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
