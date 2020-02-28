package electricity_consumption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Insert_data_display extends Application {
	
    @Override
    public void start(Stage primaryStage) {
    	
    	// START OF DISPLAY
        primaryStage.setTitle("Electricity Consumption");
        
        //Instantiating the BorderPane class
        BorderPane root = new BorderPane();

        // Start of grid
        //GridPane for flexible layout of controls in rows and columns
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //Horizontal space between columns
        grid.setVgap(10); //Vertical space between rows
        grid.setPadding(new Insets(25, 50, 25, 50));

        // Text control
        Text tilte = new Text("Insert Data");
        tilte.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        // In column 0, row 1, column span 2 and row span 1
        grid.add(tilte, 0, 1, 2, 1);

        // Label Date
        Label label0 = new Label("Date: ");
        grid.add(label0, 0, 2);
        // TextField
        TextField date = new TextField();
        grid.add(date, 1, 2);
        
        Text devices = new Text("Devices");
        devices.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(devices, 0, 3);
        
        Text hours = new Text("Hours");
        hours.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(hours, 1, 3);

        // Devices Option
        ObservableList<String> options = FXCollections.observableArrayList(
        		"Dishwasher", 
        		"Fridge", 
        		"Freezer",
        		"Laptop",
        		"Stove",
        		"Oven",
        		"Sauna",
        		"TV",
        		"Washing machine (40 degree)",
        		"Washing machine (60 degree)"
        		);
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setStyle("-fx-font: bold 12pt \"Arial\"");
        grid.add(comboBox, 0, 4);
        // TextField
        TextField hour = new TextField();
        grid.add(hour, 1, 4);

        // Insert Button
        Button insert = new Button("Insert");
        grid.add(insert, 2, 4);
        
        // End of grid
        
        // Start of root
        // Home button
        Button home = new Button("Home");
        root.setTop(home);
        
        // Setting grid on left of BorderPane
        root.setLeft(grid);
        
        //TextArea in the center fills the available space
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        root.setBottom(textArea);
        
        // End of root
        
        //Scene is container for all content 
        Scene scene = new Scene(root, 650, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
        
        //END OF DISPLAY
        
        
        // Event handling for buttons
        // Home button handler
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	Homepage homepg = new Homepage();
            	homepg.start(primaryStage);
            }
        });
        
        
        ArrayList<Insert_data> data = new ArrayList<>();	//ArrayList for insert data
        File file = new File("U:\\OOP\\Electricity_consumption\\src\\DevicesConsumption.txt");
		
		
        // Insert button handler
        insert.setOnAction(new EventHandler<ActionEvent>() {
			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent arg0) {
				
				
		        
				String d = date.getText();
				String option = comboBox.getValue();
				double h = Double.parseDouble(hour.getText());
				
				double power = 0;
				
				switch(option) {
					case "Dishwasher": power = 1600; break;
					case "Fridge": power = 200; break;
					case "Freezer": power = 400; break;
					case "Laptop": power = 50; break;
					case "Stove": power = 1000; break;
					case "Oven": power = 800; break;
					case "Sauna": power = 2000; break;
					case "TV": power = 70; break;
					case "Washing machine (40 degree)": power = 2000; break;
					case "Washing machine (60 degree)": power = 2500; break;
				}
				
				double c = (power * h) / 1000;
				
				data.add(new Insert_data(d, option, c));
				
				//Writing to the file
				try (ObjectOutputStream file_out = new ObjectOutputStream(new FileOutputStream(file))){
					System.out.println("writing");
		            	file_out.writeObject(data);
		            	
		        }
		        catch(Exception e) {
		            System.out.println("Problems with output" + file);
		            e.printStackTrace();
		        }
				
				//Reading from the file
				try (ObjectInputStream file_in = new ObjectInputStream(new FileInputStream(file))){
					
					ArrayList<Insert_data> data = (ArrayList<Insert_data>)file_in.readObject();
					System.out.println("reading");
		        }
		        catch(Exception e) {
		            System.out.println("Problems with input" + file);
		            e.printStackTrace();
		        }
			    
				
				
				
				//Print data to text area
				TextArea TA = new TextArea();
				textArea.setEditable(false);
				for(Insert_data print: data) {
					TA.appendText(" " + print);
				}
				root.setBottom(TA);
				
	
			}
        });
        
        
    }
}
