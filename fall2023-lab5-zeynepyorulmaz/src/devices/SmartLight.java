package devices;

public  class SmartLight extends InteractiveDevice {
    private static final String id = "SmartLight";
    private static int lightCount = 0;

    public SmartLight(String deviceName, double devicePrice, String interactionMode) {
        super(deviceName, devicePrice, interactionMode);
        lightCount++;
    }



	@Override
    public void setDeviceConnectivity() {
    	super.setDeviceConnectivity("null");
    }



    @Override
    public String toString() {
        return  String.format("%s [ID= %s,%s]" , id, id, super.toString());
    }

	public static int getLightCount() {
		return lightCount;
	}

	public static void setLightCount(int lightCount) {
		SmartLight.lightCount = lightCount;
	}

}
