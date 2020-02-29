package electricity_consumption;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Search_data_display extends Application {
	
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
        Text tilte = new Text("Search a date");
        tilte.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        grid.add(tilte, 0, 1);
        
        Text txt = new Text("Write down the date you want to search");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        // In column 0, row 0, column span 2 and row span 1
        grid.add(txt, 0, 2);
        
        // TextField
        TextField date = new TextField();
        grid.add(date, 0, 3);
        
        // Insert Button
        Button search = new Button("Search");
        grid.add(search, 1, 3);
        
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
        Scene scene = new Scene(root, 450, 450);
        primaryStage.setScene(scene);

        primaryStage.show();
        
        // END OF DISPLAY
        
        
        // Event handling for buttons
        // Home button handler
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            Homepage homepg = new Homepage();
            homepg.start(primaryStage);
            }
        });
        
        File file = new File("U:\\OOP\\Electricity_consumption\\src\\DevicesConsumption.txt");
        
        // Search button handler
        search.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent arg0) {
        		
        		//Reading from the file
				try (ObjectInputStream file_in = new ObjectInputStream(new FileInputStream(file))){
					
					@SuppressWarnings("unchecked")
					ArrayList<Insert_data> data = (ArrayList<Insert_data>)file_in.readObject();
					System.out.println("reading");
					
					String d = date.getText();
					
					//Print data to text area
					TextArea TA = new TextArea();
					textArea.setEditable(false);
					for(Insert_data print : data) {
						System.out.println(print.getDevice());
						if( d.equals(print.getDate())) {
							TA.appendText(print.getDevice() + "\t" + print.getConsumption() + " \n");
						}
					}
					root.setBottom(TA);
					
					
		        }
		        catch(Exception e) {
		            System.out.println("Problems with input" + file);
		            e.printStackTrace();
		        }
				
        	}
        });
   
    }
}
