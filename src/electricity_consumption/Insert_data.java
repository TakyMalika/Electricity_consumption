package electricity_consumption;

import java.io.Serializable;

public class Insert_data implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String date, device;
	private double consumption;

	// Constructor
	public Insert_data(String date, String device, double consumption) {
		super();
		this.date = date;
		this.device = device;
		this.consumption = consumption;
	}
	
	// Getter/Setter
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
	
	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	// toString method
	public String toString() {
        return device + "\t" + consumption + "\n";
    }

}
