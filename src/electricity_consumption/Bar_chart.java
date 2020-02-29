package electricity_consumption;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bar_chart {
	public void start(Stage primaryStage) throws Exception {
		// START OF DISPLAY
		primaryStage.setTitle("Electricity Consumption");
		
		//Instantiating the BorderPane class
		BorderPane root = new BorderPane();
		
		//GridPane for flexible layout of controls in rows and columns
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //Horizontal space between columns
        grid.setVgap(10); //Vertical space between rows
        grid.setPadding(new Insets(25, 50, 25, 50));
		
        
        File file = new File("U:\\OOP\\Electricity_consumption\\src\\DevicesConsumption.txt");
        
		//Reading from the file
		try (ObjectInputStream file_in = new ObjectInputStream(new FileInputStream(file))){
			@SuppressWarnings("unchecked")
			ArrayList<Insert_data> data = (ArrayList<Insert_data>)file_in.readObject();
			System.out.println("reading");
			
			// Creating axises and the bar chart
			final CategoryAxis xAxis = new CategoryAxis(); //String category
	        final NumberAxis yAxis = new NumberAxis();  
	        final BarChart<String, Number> barchart = new BarChart<>(xAxis,yAxis);
	        
	        // Labeling
	        barchart.setTitle("Electricity Consumption");
	        barchart.setLegendVisible(false); //Just one series, legend is not needed
	        xAxis.setLabel("Devices");
	        yAxis.setLabel("Consumption rate"); 
	        
	        // Creating new series
	        XYChart.Series<String, Number> series = new Series<>();
	 
	        /* This loop checks the repetition of devices and
	         * sum up the consumption value */
	        for(int i = 0; i < data.size(); i++) {
	        	for(int j = i + 1; j < data.size(); j++) {
	        		if(data.get(i).getDevice().equals(data.get(j).getDevice())) {
	        			double sum = data.get(i).getConsumption() + data.get(j).getConsumption();
	        			data.get(j).setConsumption(sum); 
	        		};
	        		series.getData().add(new Data<>(data.get(j).getDevice(), data.get(j).getConsumption()));
	        	}
	        }
	        
	        // Adding series to the bar chart
	        barchart.getData().add(series);
	        
	        // Positioning the bar chart
	        root.setCenter(barchart);
        }
		
        catch(Exception e) {
            System.out.println("Problems with input" + file);
            e.printStackTrace();
        }
					
        // Home button
        Button home = new Button("Home");
        root.setTop(home);
        
		//Scene is the container for all content 
        Scene scene = new Scene(root, 750, 600);
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
	}
}
