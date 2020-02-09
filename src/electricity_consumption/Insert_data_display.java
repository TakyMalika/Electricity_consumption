package electricity_consumption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Insert_data_display extends Application {
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
        grid.setPadding(new Insets(5, 5, 5, 5));

        // Text control for instructions
        Text insrtText = new Text("Insert Data");
        insrtText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        // In column 0, row 0, column span 2 and row span 1
        grid.add(insrtText, 0, 0, 2, 1);

        // Label Date
        Label label0 = new Label("Date: ");
        grid.add(label0, 0, 1);
        // TextField
        TextField date = new TextField();
        grid.add(date, 1, 1);
        
        Text devices = new Text("Devices");
        devices.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(devices, 0, 2);
        
        Text hours = new Text("Hours");
        hours.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(hours, 1, 2);

        // Label dishwasher
        Label label1 = new Label("1. Dishwasher ");
        grid.add(label1, 0, 3);
        // TextField
        TextField dishwasher = new TextField();
        grid.add(dishwasher, 1, 3);
        
        // Label Fridge
        Label label2 = new Label("2. Fridge ");
        grid.add(label2, 0, 4);
        // TextField
        TextField fridge = new TextField();
        grid.add(fridge, 1, 4);
        
        // Label Freezer
        Label label3 = new Label("3. Freezer ");
        grid.add(label3, 0, 5);
        // TextField
        TextField freezer = new TextField();
        grid.add(freezer, 1, 5);
        
        // Label Laptop
        Label label4 = new Label("4. Laptop ");
        grid.add(label4, 0, 6);
        // TextField
        TextField laptop = new TextField();
        grid.add(laptop, 1, 6);
        
        // Label Stove
        Label label5 = new Label("5. Stove ");
        grid.add(label5, 0, 7);
        // TextField
        TextField stove = new TextField();
        grid.add(stove, 1, 7);
        
        // Label Oven
        Label label6 = new Label("6. Oven ");
        grid.add(label6, 0, 8);
        // TextField
        TextField oven = new TextField();
        grid.add(oven, 1, 8);
        
        // Label Sauna
        Label label7 = new Label("7. Sauna ");
        grid.add(label7, 0, 9);
        // TextField
        TextField sauna = new TextField();
        grid.add(sauna, 1, 9);
        
        // Label TV
        Label label8 = new Label("8. TV ");
        grid.add(label8, 0, 10);
        // TextField
        TextField tv = new TextField();
        grid.add(tv, 1, 10);
        
        // Label washing machine 40
        Label label9 = new Label("9. Washing machine (40 degree) ");
        grid.add(label9, 0, 11);
        // TextField
        TextField wm40 = new TextField();
        grid.add(wm40, 1, 11);
        
        // Label washing machine 60
        Label label10 = new Label("9. Washing machine (60 degree) ");
        grid.add(label10, 0, 12);
        // TextField
        TextField wm60 = new TextField();
        grid.add(wm60, 1, 12);

        Button btn = new Button("Insert");
        grid.add(btn, 1, 13);

        Text resultText = new Text();
        grid.add(resultText, 0, 6, 2, 1);
        resultText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

        
        // Event handling for button
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
            }
        });

        //Scene is container for all content 
        Scene scene = new Scene(grid, 700,675);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
