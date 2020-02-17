package electricity_consumption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Homepage extends Application {
    //start method is main entry point for application. 
    //Stage is top-level container.
    @Override
    public void start(Stage primaryStage) {
    	
    	// START OF DISPLAY
        primaryStage.setTitle("Electricity Consumption");

        //GridPane for flexible layout of controls in rows and columns
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //Horizontal space between columns
        grid.setVgap(10); //Vertical space between rows
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Text control
        Text tilte = new Text("ELECTRICITY \nCONSUMPTION");
        tilte.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        grid.add(tilte, 0, 0);

        Button btn1 = new Button("Insert Data");
        grid.add(btn1, 0, 5);
        
        Button btn2 = new Button("Search a date");
        grid.add(btn2, 0, 6);
        
        Button btn3 = new Button("See total bar chart");
        grid.add(btn3, 0, 7);
        
        //Scene is container for all content 
        Scene scene = new Scene(grid, 400, 425);
        primaryStage.setScene(scene);

        primaryStage.show();
        
        //END OF DISPLAY
        
        // Event handling for buttons
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

        
    }
    
    // Main method
    public static void main(String[] args) {
        launch(args);
    }
}
