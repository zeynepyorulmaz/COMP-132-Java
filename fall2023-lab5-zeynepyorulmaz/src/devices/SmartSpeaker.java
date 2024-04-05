package devices;

public class SmartSpeaker extends InteractiveDevice {
    private static final String id = "SmartSpeaker";
    private static int speakerCount = 0;

    public SmartSpeaker(String deviceName, double devicePrice, String interactionMode) {
        super(deviceName, devicePrice, interactionMode);
        speakerCount++;
    }

    @Override
    public void setDeviceConnectivity() {
    	super.setDeviceConnectivity("null");
    }

    @Override
    public String toString() {
        return  String.format("%s [ID= %s,%s]" , id, id, super.toString());
    }
	public static int getSpeakerCount() {
		return speakerCount;
	}

	public static void setSpeakerCount(int speakerCount) {
		SmartSpeaker.speakerCount = speakerCount;
	}

}
