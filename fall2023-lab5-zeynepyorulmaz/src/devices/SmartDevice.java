package devices;

public abstract class SmartDevice {
	private static int deviceCount = 0;
    private String deviceName;
    private double devicePrice;
    private String deviceConnectivity;

    SmartDevice(String deviceName, double devicePrice){

        if (devicePrice > 0 && !deviceName.isEmpty()){
            this.deviceName = deviceName;
            this.devicePrice = devicePrice;
            deviceCount++;
            this.deviceConnectivity = "'null'";
        }
    }
    public static int getDeviceCount() {
    	return deviceCount;
    }
    abstract void setDeviceConnectivity();
    abstract void  operate();
    
    public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public double getDevicePrice() {
		return devicePrice;
	}
	public void setDevicePrice(double devicePrice) {
		this.devicePrice = devicePrice;
	}
	public String getDeviceConnectivity() {
		return deviceConnectivity;
	}
	public void setDeviceConnectivity(String deviceConnectivity) {
		this.deviceConnectivity = deviceConnectivity;
	}
    @Override
    public String toString() {
        return String.format(" InteractiveDevice{ deviceName: '%s', devicePrice: %.1f, deviceConnectivity: %s", deviceName, devicePrice, deviceConnectivity);
    }
}
