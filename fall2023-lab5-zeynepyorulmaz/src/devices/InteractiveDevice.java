package devices;

public abstract class InteractiveDevice extends SmartDevice {
    private String interactionMode;
    public String getInteractionMode() {
		return interactionMode;
	}

	public void setInteractionMode(String interactionMode) {
		this.interactionMode = interactionMode;
	}

	public boolean isConfigurationStatus() {
		return configurationStatus;
	}

	public void setConfigurationStatus(boolean configurationStatus) {
		this.configurationStatus = configurationStatus;
	}

	private boolean configurationStatus;

    public InteractiveDevice(String deviceName, double devicePrice, String interactionMode) {
        super(deviceName, devicePrice);

        if (devicePrice > 0 && !deviceName.isEmpty()){
        this.interactionMode = interactionMode;
        this.configurationStatus = false;
        }
        }
    void setDeviceConnectivity() {

        
    }
    public void configure() {

        configurationStatus = true;
        System.out.println(getDeviceName() + " is configured");
    }

    @Override
    public void operate() {
        if (configurationStatus) {
            System.out.println(getDeviceName() + " operated in " + interactionMode + " mode.");
        } else {
            System.out.println(getDeviceName() + " failed to operate, requires configuration.");
        }
    }
    
    @Override
    public String toString() {
    	//A toString() method that returns information about the InteractiveDevice’s deviceName, price, connectivity,interaction mode and configurationStatus.
        return super.toString() + ", interactionMode='" + interactionMode + "', configurationStatus=" + configurationStatus + "}]";
    }



}
