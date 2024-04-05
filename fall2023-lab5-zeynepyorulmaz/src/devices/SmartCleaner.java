package devices;

public class SmartCleaner extends InteractiveDevice {
    private static final String id = "SmartCleaner";
    private static int cleanerCount = 0;
    private int batteryPercentage = 100;
    boolean automateStatus;

    public SmartCleaner(String deviceName, double devicePrice, String interactionMode) {
        super(deviceName, devicePrice, interactionMode);
        cleanerCount++;
    }

    @Override
    public void setDeviceConnectivity() {
    	super.setDeviceConnectivity("null");
    }

    @Override
    public String toString() {
    	String msg = 
    			"Device Type: " + id + "\n" +
    			"Interactive Device Name: "+ getDeviceName() + "\n" +
    			"Device Price: " + getDevicePrice() +" $" + "\n" +
    			"Device Connectivity: null" + "\n" +
    			"Interaction Mode: " + getInteractionMode()+ "\n" ; 
        return  msg;
    }
	public static int getSpeakerCount() {
		return cleanerCount;
	}

	public static void setSpeakerCount(int cleanerCount) {
		SmartCleaner.cleanerCount = cleanerCount;
	}

	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	

	public void automate(int hour) {
		
		if (getBatteryPercentage()> hour*20) {
			System.out.println(getDeviceName()+ " automated in " + getInteractionMode() + " for " + hour + " hours. " );
			batteryPercentage -= 20*hour;

			
		}
		else {
			System.out.println(getDeviceName()+ "failed to automate, requires charging");
			
		}
		
	}

}
