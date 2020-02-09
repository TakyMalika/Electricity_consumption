package electricity_consumption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Search_data_display extends Application {
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

        // Text control
        Text tilte = new Text("Search a date");
        tilte.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        // In column 0, row 0, column span 2 and row span 1
        grid.add(tilte, 0, 1);
        
        Text txt = new Text("Write down the date you want to search");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        // In column 0, row 0, column span 2 and row span 1
        grid.add(txt, 0, 2);
        
        // TextField
        TextField date = new TextField();
        grid.add(date, 0, 3);
        
        
        Button btn = new Button("Search");
        grid.add(btn, 0, 4);
        
        // Event handling for button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
            }
        });

        //Scene is container for all content 
        
        Scene scene = new Scene(grid, 500, 475);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
